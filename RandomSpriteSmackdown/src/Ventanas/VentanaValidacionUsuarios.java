package Ventanas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Properties;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Usuarios.UsuariosValidar;


public class VentanaValidacionUsuarios extends JFrame{
	private UsuariosValidar usuario;
	private static Properties propiedades;
	private static Logger logger = Logger.getLogger("Loggerjuego");
	static {
			 try {
			
			FileHandler h = new FileHandler(
					 "JUEGO.log.xml", true );
			logger.addHandler( h);
			 logger.setLevel(Level.FINEST);
			 h.setLevel(Level.FINEST);
			 } catch (SecurityException | IOException e) {
			 logger.log( Level.SEVERE, "Error en creación fichero log" );
			 }
		}
	
	public static Logger getLogger() {
		return logger;
	}
	
	public VentanaValidacionUsuarios(int codigo) {
		//LOGGER
		
		propiedades = new Properties();
		
		InputStream dato;
		
			
		
	
		// TODO Auto-generated constructor stub
		//Ventana 
		setTitle("Usuarios");
		setSize(400, 600);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(new GridLayout(0, 1));
		
		//Creacion de contenedores
		JLabel logintexto= new JLabel("Nombre");
		JTextField nombre = new JTextField();
		JLabel passwordtexto = new JLabel("Password");
		JPasswordField password = new JPasswordField();
		JButton confirmar = new JButton("Aceptar");
		JCheckBox ultimoUsuario = new JCheckBox("Quiere que se guarde su usuario para la proxima vez");
		//Modificaciones
		add(logintexto);
		add(nombre);
		add(passwordtexto);
		add(password);
		add(ultimoUsuario);
		add(confirmar);
		//Eventos
		
		confirmar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				UsuariosValidar estado ;
				if(codigo == 0) {//Login
					 estado =usuario.leer(nombre, password);
					if(estado==null) {
						JOptionPane.showMessageDialog(null, "Datos erroneos");
					}else {
						
						//Ventana general
						VentanaPrincipal ventana = new VentanaPrincipal(0,null);//Aqui habria que leer los datos para conseguir el personaje
						ventana.setVisible(true);
						logger.log(Level.INFO, "Usuario:"+estado.getNombre()+" Se ha loggueado");
					}
				}else {
					estado =usuario.leer(nombre, password);
					if(estado==null) {
					usuario.setNombre(logintexto.getText());
					usuario.setPassword(password.getText());
					usuario.guardar(usuario);
					VentanaPrincipal ventana = new VentanaPrincipal(1,null);
					ventana.setVisible(true);
					logger.log(Level.INFO,"Usuario:"+usuario.getNombre()+" Se ha registrado");
						
					}else {
						JOptionPane.showMessageDialog(null,"Ya existe un usuario con ese nombre");
						nombre.setText("");
						password.setText("");
					}
				}
				
			}
		});
		ultimoUsuario.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				propiedades.setProperty("Nombre", usuario.getNombre());
				OutputStream fichero;
				try {
					fichero = new FileOutputStream("Usuarioultimo");
					propiedades.storeToXML(fichero,"Usuario guardado" );
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				
				
			}
		});
		
		
	}
	public static void main(String[] args) {
		VentanaValidacionUsuarios ventana = new VentanaValidacionUsuarios(1);
		ventana.setVisible(true);
	}
}
