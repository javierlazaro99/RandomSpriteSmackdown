package control;

import java.awt.Point;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Usuarios.UsuariosValidar;
import Ventanas.VentanaValidacionUsuarios;
import personaje.personajeJugable.PersonajeJugable;

public class BaseDeDatos {
	
	private static Connection con=null;
	private static Statement s;
	private static ResultSet rs;
	public static Logger logger = Logger.getLogger("Loggerjuego");
	 
	public BaseDeDatos() {
	}
	
	/**Creamos una conexion a BD
	 * @return La connect de la BD
	 */
	public static Connection crearConexion() {
		try {
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection("jdbc:sqlite:randomspritesmackdown.db");
			s = con.createStatement();
			return con;
		}catch (SQLException|ClassNotFoundException e) {
			logger.log(Level.SEVERE, "Error al conectarse con BD");
			e.printStackTrace();
			return null;
		}
	}
	
	/**Crear tablas basicas
	 * Las tablas son Usuario,Partida y Personaje
	 */
	public static void crearBD() {
		//Si la tabla ya se ha creado no hace nada, trabaja con la existente
		String comando = "";
		try {
			//Creación de la tabla Usuario en nuestra BD
			comando = "create table if not exists Usuario(nick STRING, password STRING)";
			logger.log(Level.INFO, comando);
			s.executeUpdate(comando);
			logger.log(Level.INFO, "Tabla T1 creada");
		} catch (SQLException e) {
			logger.log(Level.SEVERE, "Error en T1");
		}
		
		try {
			//Creación de la tabla Partida en nuestra BD
			comando = "create table if not exists Partida("
					+ "cod_partida NUMERIC PRIMARY KEY NOT NULL,"
					+ "niveles_comp NUMERIC CHECK(niveles_comp >= 0),"
					+ "victorias1v1 NUMERIC,"
					+ "nick STRING REFERENCES Usuario(nick))";
			logger.log(Level.INFO, comando);
			s.executeUpdate(comando);
			logger.log(Level.INFO, "Tabla T2 creada");
		} catch (SQLException e) {
			logger.log(Level.SEVERE, "Error en T2");
		}
		try {
			//Creación de la tabla Personaje en nuestra BD
			comando = "create table if not exists Personaje("
					+ "nom_personaje STRING,"
					+ "fuerza NUMERIC,"
					+ "vida NUMERIC,"
					+ "velocidad NUMERIC,"
					+ "puntos_mejora NUMERIC,"
					+ "cod_partida NUMERIC REFERENCES Partida(cod_partida) ON DELETE CASCADE,"
					+ "tipoPersonaje STRING)";
			logger.log(Level.INFO, comando);
			s.executeUpdate(comando);
			logger.log(Level.INFO, "Tabla T3 creada");
		} catch (SQLException e) {
			logger.log(Level.SEVERE, "Error en T3");
		}
	}
	
	public static void guardarUsuarioBD(UsuariosValidar usuario) {
		try {
			con= DriverManager.getConnection( "jdbc:sqlite:randomspritesmackdown.db") ;
			s=con.createStatement();
			String query= "INSERT INTO USUARIO VALUES('" + usuario.getNombre() + "','"+usuario.getPassword()+"')";
			s.executeUpdate(query);
			logger.log(Level.INFO, "Usuario guardado correctamente en la BD");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.log(Level.SEVERE, "Error usuario no se ha guardado");
		}
	}
	
	/** Comprobacion de existencia de usuario
	 * @param usuarioTexto Valor del JTextfield
	 * @param passwordTexto Valor del JPasswordField
	 * @return
	 */
	public static UsuariosValidar leerUsuarioBD(JTextField usuarioTexto,JPasswordField passwordTexto) {
		try {
			String query= "SELECT NICK,PASSWORD FROM USUARIO";
			ResultSet str =s.executeQuery(query);
			while(str.next()) {
				String nick=str.getString("NICK");
				String password = str.getString("PASSWORD");
				if(usuarioTexto.getText().equals(nick) && passwordTexto.getText().equals(password)) {
					UsuariosValidar usuario = new UsuariosValidar(nick, password);
					logger.log(Level.INFO, "Usuario cargado");
					return usuario;
				}
			}
			logger.log(Level.INFO, "Usuario no existia");
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			logger.log(Level.SEVERE, "Usuario cargado erroneamente");
		}
		return null;
	}
	
	public static ArrayList<Object> cargarPartidaBD(UsuariosValidar user , ArrayList<Object> listaRespuestas) {
		String query = "";
		int codPartida = 0;
		int nivelesCompletados = 0;
		int victorias1v1 = 0;
		String nombrePersonaje = "";
		int fuerza = 0;
		int vida = 0;
		int velocidad = 0;
		int puntosMejora = 0;
		String tipoPersonaje="";
		PersonajeJugable personaje;
		try {//Parte de obtención de datos de Partida
			query = "SELECT * FROM Partida WHERE nick=" + "'" + user.getNombre() + "'";
			ResultSet rs = s.executeQuery(query);
			logger.log(Level.INFO, "Ejecutado correctamente: " + query);
			if(rs.next()) {
				codPartida = rs.getInt("cod_partida");
				nivelesCompletados = rs.getInt("niveles_comp");
				victorias1v1 = rs.getInt("victorias1v1");
			}
			
			listaRespuestas.add(nivelesCompletados);
			listaRespuestas.add(victorias1v1);
		} catch (SQLException e) {
			logger.log(Level.SEVERE, "Error de ejecución en: " + query);
		}
		
		try {//Parte de obtención de datos de Personaje
			query = "SELECT * FROM Personaje WHERE cod_partida=" + "'" + codPartida + "'";
			rs = s.executeQuery(query);
			if(rs.next()) {
				nombrePersonaje = rs.getString("nom_personaje");
				fuerza = rs.getInt("fuerza");
				vida = rs.getInt("vida");
				velocidad = rs.getInt("velocidad");
				puntosMejora = rs.getInt("puntos_mejora");
				tipoPersonaje=rs.getString("tipoPersonaje");
			}
			
			listaRespuestas.add(puntosMejora);
			personaje = new PersonajeJugable(nombrePersonaje, new Point(0, 0), fuerza, vida, velocidad, tipoPersonaje);
			listaRespuestas.add(personaje);

		} catch (SQLException e) {
			logger.log(Level.SEVERE, "Error de ejecución en: " + query);
		}
		
		return listaRespuestas;	
	}
	
	/**Guardado inicial de Partida
	 * @param user Usuario del programa
	 * @param ch Control de historia
	 */
	public static void guardarPartidaBD2(UsuariosValidar user, ControlHistoria ch) {
		String query = "";
		int maxCod = 0;
		
		try {
			query = "SELECT MAX(cod_partida) FROM Partida"; // query para saber el valor del mayor indice existente
			rs = s.executeQuery(query);
			if(rs.next()) { // Recogemos el resultado
				maxCod = rs.getInt(1);
			}
			VentanaValidacionUsuarios.logger.log(Level.INFO, "Comando: " + query + " ejecutado correctamente");
		
			// Una vez sabemos el maximo valor en la tabla hacemos el insert
			int codigo = maxCod + 1;
			query = "INSERT INTO Partida VALUES("+ codigo + "," + ch.getNivelesCompletados() + ", 0,'" + user.getNombre() + "')";
			s.executeUpdate(query);
			VentanaValidacionUsuarios.logger.log(Level.INFO, "Comando: " + query + " ejecutado correctamente");
			
			// Una vez creada la partida hacemos el insert del personaje
			
			query = "INSERT INTO Personaje VALUES('" + ch.getPersonajePrincipal().getNombre() + "'," 
					+ ch.getPersonajePrincipal().getFuerza() + "," + ch.getPersonajePrincipal().getVida() 
					+  "," + ch.getPersonajePrincipal().getVelocidad() + "," + ch.getPersonajePrincipal().getPuntosMejora()
					+ "," + codigo + ","+"'"+ch.getPersonajePrincipal().getTipoPersonaje()+"'"+")";
			System.out.println(ch.getPersonajePrincipal().getTipoPersonaje());
			s.executeUpdate(query);
			VentanaValidacionUsuarios.logger.log(Level.INFO, "Comando: " + query + " ejecutado correctamente");
			
		} catch (SQLException e) {
			logger.log(Level.SEVERE, "Error de ejecución en: " + query);
		}
	}
	
	/** Metodo para la actalizacion de la partida
	 * @param user
	 * @param ch
	 */
	public static void updatePartidaBD2(UsuariosValidar user, ControlHistoria ch) {
		String query = "";
		
		try {
			//Se busca el código de partida por usuario
			int codigo = 0;
			
			query = "SELECT cod_partida FROM Partida WHERE nick='" + user.getNombre() + "'";
			rs = s.executeQuery(query);
			if(rs.next()) { // Recogemos el resultado
				codigo = rs.getInt(1);
			}
			VentanaValidacionUsuarios.logger.log(Level.INFO, "Comando: " + query + " ejecutado correctamente");
			
			//Se hace Update a la partida
			query = "UPDATE Partida SET niveles_comp =" + ch.getNivelesCompletados() + 
					",victorias1v1 = 0 WHERE cod_partida=" + codigo;	
			s.executeUpdate(query);
			VentanaValidacionUsuarios.logger.log(Level.INFO, "Comando: " + query + " ejecutado correctamente");
			
			// Se hace el Update al personaje
			query = "UPDATE Personaje SET fuerza ="+ ch.getPersonajePrincipal().getFuerza() + ",vida =" 
					+ ch.getPersonajePrincipal().getVida() + ",velocidad =" + ch.getPersonajePrincipal().getVelocidad() +
					",puntos_mejora =" + ch.getPersonajePrincipal().getPuntosMejora() + " WHERE cod_partida ='" + codigo + "'";
			
			s.executeUpdate(query);
			VentanaValidacionUsuarios.logger.log(Level.INFO, "Comando: " + query + " ejecutado correctamente");
			
		}catch (SQLException e) {
			VentanaValidacionUsuarios.logger.log(Level.SEVERE, "Error de ejecución en: " + query);
		}
		
	}
	
	public static void cerrarBD() {
		try {
			if(s!= null) {
				s.close();
				logger.log(Level.INFO, "Statement cerrado");
			}
			if(rs!= null) {
				rs.close();
				logger.log(Level.INFO, "ResultSet cerrado");
			}
			if(con!= null) {
				con.close();
				logger.log(Level.INFO, "Connection cerrado");
			}
		}catch(SQLException e) {
			logger.log(Level.INFO, "No habia nada que cerrar");
		}
	}
	
}