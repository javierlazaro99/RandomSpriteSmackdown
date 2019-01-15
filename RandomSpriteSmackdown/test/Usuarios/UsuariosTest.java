package Usuarios;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Before;
import org.junit.Test;

public class UsuariosTest {
	
	@Test
	public void testUsuario() {
		try {
			try {
				Class.forName("org.sqlite.JDBC");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Connection con = DriverManager.getConnection("jdbc:sqlite:randomspritesmackdown.db");
			Statement s= con.createStatement();
			String query="INSERT INTO USUARIO VALUES('Prueba','Prueba');";
			s.executeUpdate(query);
			query="SELECT * FROM USUARIO WHERE NICK='Prueba';";
			 ResultSet  srt=s.executeQuery(query);
			while(srt.next()) {
				String nick =srt.getString("NICK");
				assertEquals("Prueba", nick);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
