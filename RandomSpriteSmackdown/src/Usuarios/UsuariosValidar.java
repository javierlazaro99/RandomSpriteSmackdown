package Usuarios;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class UsuariosValidar {
	private String nombre;
	private String password;
	private String path = "Usuario.txt";
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
		
		File fi = new File(path);
		FileWriter fw	 = new FileWriter(fi);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write("Usuario:"+usuario.nombre+";"+"Password:"+usuario.password);
		bw.newLine();
		bw.flush();
		bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public UsuariosValidar leer(JTextField usuarioTexto,JPasswordField passwordTexto) {
		
		try {
			File fi = new File(path);
			FileReader fr = new FileReader(fi);
			BufferedReader br = new BufferedReader(fr);
			String line=br.readLine();
			while(line!= null) {
				String[] division=line.split(";");
				
				for(int a = 0;a<division.length;a++) {
					String[] usuarioleido= division[0].split(":");
					
					datos.add(usuarioleido[1]);
					//Falta lo de los espacios
				}
				if(validacion(datos, usuarioTexto, passwordTexto)) {
					UsuariosValidar usuario = new UsuariosValidar(usuarioTexto.getText(), passwordTexto.getText());
					br.close();
					return usuario;
				}else {
					datos.removeAll(datos);
				}
				
				
			}
			JOptionPane.showMessageDialog(null, "No has introducido los datos correctamente o el usuario no existe");	
		return null;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
		
	}
	public boolean validacion(ArrayList<String> datos,JTextField usuarioTexto,JPasswordField passwordTexto) {
		if(datos.get(0).equals(usuarioTexto.getText()) && datos.get(1).equals(passwordTexto.getPassword()) ) {
			return true;
		}else {
			return false;
		}
		
	}
	//Falta por hacer 
	public void guardarDatos() {
		 
	 }
	 public void cargarDatos() {
		 
	 }
}
