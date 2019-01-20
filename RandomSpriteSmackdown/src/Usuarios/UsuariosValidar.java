package Usuarios;

import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Logger;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Ventanas.VentanaValidacionUsuarios;
import control.BaseDeDatos;

public class UsuariosValidar {
	private String nombre;
	private String password;
	private Connection con =null;
	private Statement s;
	private String path = "Usuario.txt";
	private Logger logger=VentanaValidacionUsuarios.getLogger();
	ArrayList<String> datos = new ArrayList<>();
	
	public UsuariosValidar(String nombre,String passwod) {
		
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
		BaseDeDatos.guardarUsuarioBD(usuario);
		
	}
	public UsuariosValidar leer(JTextField usuarioTexto,JPasswordField passwordTexto) {
		return BaseDeDatos.leerUsuarioBD(usuarioTexto, passwordTexto);
		
		
	
		
	}
	
		

	
}
