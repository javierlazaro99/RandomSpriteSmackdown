package Usuarios;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Ventanas.VentanaValidacionUsuarios;

public class UsuariosValidar {
	private String nombre;
	private String password;
	private Connection con =null;
	private Statement s;
	private String path = "Usuario.txt";
	private Logger logger=VentanaValidacionUsuarios.getLogger();
	ArrayList<String> datos = new ArrayList<>();
	public UsuariosValidar(String nombre,String passwod) {
		// TODO Auto-generated constructor stub
		this.nombre = nombre;
		this.password = password;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public String getNombre() {
		return nombre;
	}

	public String getPassword() {
		return password;
	}

	public void guardar(UsuariosValidar usuario) {
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
	public UsuariosValidar leer(JTextField usuarioTexto,JPasswordField passwordTexto) {
		
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
	
		
	
	//Falta por hacer 
	public void guardarDatos() {
		 
	 }
	 public void cargarDatos() {
		 
	 }
}
