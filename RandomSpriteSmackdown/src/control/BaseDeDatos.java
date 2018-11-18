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
	
	public static void crearBD() {
		//Si la tabla ya se ha creado no hace nada, trabaja con la existente
		String comando = "";
		try {
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection("jdbc:sqlite:randomspritesmackdown.db");
			s = con.createStatement();
			try {
				//Creación de la tabla Usuario en nuestra BD
				comando = "create table Usuario(nick STRING, password STRING)";
				logger.log(Level.INFO, comando);
				s.executeUpdate(comando);
			} catch (SQLException e) {
				logger.log(Level.INFO, "Tabla T1 ya existente");
			}
			
			try {
				//Creación de la tabla Partida en nuestra BD
				comando = "create table Partida("
						+ "cod_partida NUMERIC PRIMARY KEY NOT NULL,"
						+ "niveles_comp NUMERIC CHECK(niveles_comp >= 0),"
						+ "victorias1v1 NUMERIC,"
						+ "nick STRING REFERENCES Usuario(nick))";
				logger.log(Level.INFO, comando);
				s.executeUpdate(comando);
			} catch (SQLException e) {
				logger.log(Level.INFO, "Tabla T2 ya existente");
			}
			try {
				//Creación de la tabla Personaje en nuestra BD
				comando = "create table Personaje("
						+ "nom_personaje STRING,"
						+ "fuerza NUMERIC,"
						+ "vida NUMERIC,"
						+ "velocidad NUMERIC,"
						+ "puntos_mejora NUMERIC,"
						+ "cod_partida NUMERIC REFERENCES Partida(cod_partida) ON DELETE CASCADE)";
				logger.log(Level.INFO, comando);
				s.executeUpdate(comando);
			} catch (SQLException e) {
				logger.log(Level.INFO, "Tabla T3 ya existente");
			}
		}	catch (SQLException|ClassNotFoundException e) {
			logger.log(Level.SEVERE, "Error en la clase, último comando: " + comando);
			e.printStackTrace();
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
	
	public static UsuariosValidar leerUsuarioBD(JTextField usuarioTexto,JPasswordField passwordTexto) {
		try {
			con= DriverManager.getConnection( "jdbc:sqlite:randomspritesmackdown.db") ;
			s=con.createStatement();
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
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.log(Level.SEVERE, "Usuario cargado erroneamente");
		}
		return null;
	}
	
	//Este método por ahora no funciona, mirar abajo el otro método
	public static void guardarPartidaBD(UsuariosValidar user, ControlHistoria ch) {
		// Parte en la que se guarda la partida hasta el momento en la BD
		String query = "";
		int codigo = 0;
		try {
			con = DriverManager.getConnection("jdbc:sqlite:randomspritesmackdown.db");
			s = con.createStatement();
			try {
				System.out.println(user.getNombre());
				query = "SELECT * FROM Partida WHERE NICK='" + user.getNombre() + "'";
				ResultSet rs = s.executeQuery(query);
				System.out.println(rs.toString());
				VentanaValidacionUsuarios.logger.log(Level.INFO, "Comando: " + query + " ejecutado correctamente");
				
				if(rs.next()) {
					codigo = rs.getInt(1);
					System.out.println(codigo);
				}
				
				if(codigo == 0) { // si el result set devuelve 0 en un int significa que ha sido null el valor, por tanto no hay tupla creada
					//Le creamos una partida al jugador
					query = "SELECT MAX(cod_partida) FROM Partida"; // query para saber el valor del mayor indice existente
					ResultSet rs2 = s.executeQuery(query);
					VentanaValidacionUsuarios.logger.log(Level.INFO, "Comando: " + query + " ejecutado correctamente");
					int maxCod = rs2.getInt("cod_partida");
		
					if(maxCod == 0) { //Primera partida metida en la base de datos
						query = "INSERT INTO Partida(cod_partida, niveles_comp, victorias1v1, nick)"
								+ "VALUES(1, 0, 0," + user.getNombre() + ")";
						s.executeUpdate(query);
						VentanaValidacionUsuarios.logger.log(Level.INFO, "Comando: " + query + " ejecutado correctamente");
					}else { //Partida cualquiera en BD
						query = "INSERT INTO Partida(cod_partida, niveles_comp, victorias1v1, nick)"
								+ "VALUES("+ maxCod + 1 + "," + ch.getNivelesCompletados() + ", 0," + user.getNombre() + ")";
						s.executeUpdate(query);
						VentanaValidacionUsuarios.logger.log(Level.INFO, "Comando: " + query + " ejecutado correctamente");
					}
				}else { // El código no es 0 por lo que tiene una partida ya guardada
					query = "UPDATE Partida SET niveles_comp=" +  ""
							+ "VALUES(" + codigo + ", 0, 0," + user.getNombre() + ")";
					s.executeUpdate(query);
					VentanaValidacionUsuarios.logger.log(Level.INFO, "Comando: " + query + " ejecutado correctamente");
				}		
			} catch (SQLException e2) {
				VentanaValidacionUsuarios.logger.log(Level.INFO, "Comando: " + query + " fallido");
			}
		} catch (SQLException e1) {
			VentanaValidacionUsuarios.logger.log(Level.SEVERE, "Error al conectarse a la BD");
		}
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
		PersonajeJugable personaje;
		try {
			con = DriverManager.getConnection("jdbc:sqlite:randomspritesmackdown.db");
			s = con.createStatement();
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
				ResultSet rs = s.executeQuery(query);
				if(rs.next()) {
					nombrePersonaje = rs.getString("nom_personaje");
					fuerza = rs.getInt("fuerza");
					vida = rs.getInt("vida");
					velocidad = rs.getInt("velocidad");
					puntosMejora = rs.getInt("puntos_mejora");
				}
				
				listaRespuestas.add(puntosMejora);
				personaje = new PersonajeJugable(nombrePersonaje, new Point(0, 0), fuerza, vida, velocidad);
				listaRespuestas.add(personaje);

			} catch (SQLException e) {
				logger.log(Level.SEVERE, "Error de ejecución en: " + query);
			}
		} catch (SQLException e) {
			logger.log(Level.SEVERE, "Error al conectarse con la BD");
		}
		
		return listaRespuestas;	
	}
	
	public static void guardarPartidaBD2(UsuariosValidar user, ControlHistoria ch) {
		String query = "";
		int maxCod = 0;
		try {
			con = DriverManager.getConnection("jdbc:sqlite:randomspritesmackdown.db");
			s = con.createStatement();
			try {
				query = "SELECT MAX(cod_partida) FROM Partida"; // query para saber el valor del mayor indice existente
				ResultSet rs = s.executeQuery(query);
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
						+ "," + codigo + ")";
				s.executeUpdate(query);
				VentanaValidacionUsuarios.logger.log(Level.INFO, "Comando: " + query + " ejecutado correctamente");
				
			} catch (SQLException e) {
				logger.log(Level.SEVERE, "Error de ejecución en: " + query);
			}
			
			
		}catch (SQLException e) {
			logger.log(Level.SEVERE, "Error al conectarse con la BD");
		}
	}
	
}