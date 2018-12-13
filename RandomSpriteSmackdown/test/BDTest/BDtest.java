package BDTest;

import static org.junit.Assert.*;

import java.awt.Point;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Before;
import org.junit.Test;

import Usuarios.UsuariosValidar;
import control.BaseDeDatos;
import control.ControlHistoria;
import personaje.personajeJugable.PersonajeJugable;

public class BDtest {
	Connection con=null;
	String query=""	;
	Statement s;
	ResultSet srt;
	
	
	@Test
	public void Creacion_Usuario() throws ClassNotFoundException {
		try {
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection("jdbc:sqlite:randomspritesmackdown.db");
			s= con.createStatement();
			query="INSERT INTO USUARIO VALUES('Prueba','Prueba');";
			s.executeUpdate(query);
			query="SELECT * FROM USUARIO WHERE NICK='Prueba';";
			srt=s.executeQuery(query);
			while(srt.next()) {
				String nick =srt.getString("NICK");
				assertEquals("Prueba", nick);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void Creacion_Partida() throws SQLException {
		BaseDeDatos bd = new BaseDeDatos();
		UsuariosValidar user = new UsuariosValidar("Prueba","Prueba");
		ControlHistoria ch = new ControlHistoria(new PersonajeJugable("PersonajePrueba", new Point(0, 0), 0, 0, 0," "), 0);
		bd.guardarPartidaBD2(user, ch);
		
		
	}
		
	
	
}
