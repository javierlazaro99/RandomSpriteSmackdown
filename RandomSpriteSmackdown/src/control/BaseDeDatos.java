package control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Usuarios.UsuariosValidar;
import Ventanas.VentanaValidacionUsuarios;

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
	
	public static void guardarPartidaBD(UsuariosValidar user) {
		// Parte en la que se guarda la partida hasta el momento en la BD
		String query = "";
		try {
			con = DriverManager.getConnection("jdbc:sqlite:randomspritesmackdown.db");
			s = con.createStatement();
			try {
				query = "SELECT * FROM Partida WHERE NICK='" + user.getNombre() + "'";
				ResultSet rs = s.executeQuery(query);
				VentanaValidacionUsuarios.logger.log(Level.INFO, "Comando: " + query + " ejecutado correctamente");
				if(rs.wasNull()) { //Si el result set es null significa que el usuario no tiene una partida creada
					//Le creamos una partida al jugador
					query = "SELECT MAX(cod_partida) FROM Partida"; // query para saber el valor del mayor indice existente
					ResultSet rs2 = s.executeQuery(query);
					VentanaValidacionUsuarios.logger.log(Level.INFO, "Comando: " + query + " ejecutado correctamente");
					if(rs2.wasNull()) { //Metemos el valor 1 en el codigo
						query = "INSERT INTO Partida(cod_partida, niveles_comp, victorias1v1, nick)"
								+ "VALUES(1, 0, 0," + user.getNombre() + ")";
						s.executeUpdate(query);
						VentanaValidacionUsuarios.logger.log(Level.INFO, "Comando: " + query + " ejecutado correctamente");
					}else {
						int codigo = rs2.getInt("cod_partida");
						codigo += 1; // El codigo que le toca será el siguiente al máximo
						query = "INSERT INTO Partida(cod_partida, niveles_comp, victorias1v1, nick)"
								+ "VALUES(" + codigo + ", 0, 0," + user.getNombre() + ")";
						s.executeUpdate(query);
						VentanaValidacionUsuarios.logger.log(Level.INFO, "Comando: " + query + " ejecutado correctamente");
					}
				}else { //El usuario ya existe así que sólo hay que actualizar su información
					int codigo = rs.getInt("cod_partida");
					query = "UPDATE Partida SET niveles_comp=" +  ""
							+ "VALUES(" + codigo + ", 0, 0," + user.getNombre() + ")";
				}
						
			} catch (SQLException e2) {
				VentanaValidacionUsuarios.logger.log(Level.INFO, "Comando: " + query + " fallido");
			}
		} catch (SQLException e1) {
			VentanaValidacionUsuarios.logger.log(Level.SEVERE, "Error al conectarse a la BD");
		}
	}
}