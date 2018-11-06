package Ventanas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Usuarios.UsuariosValidar;


public class VentanaValidacionUsuarios extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private UsuariosValidar usuario = new UsuariosValidar("", "");  
	private static Properties propiedades;
	private static Connection con=null;
	private static Statement s;
	private static ResultSet rs;
	private static Logger logger = Logger.getLogger("Loggerjuego");
	private boolean cbActivado;
	private JTextField tfNombre;
	private JCheckBox cbUltimoUsuario;
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
		//Ventana 
		setTitle("Registro de inicio");
		setSize(400, 600);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		
		//Creación de paneles
		JPanel pPrincipal = new JPanel(new GridLayout(5, 1));
			JPanel pRelleno1 = new JPanel();
			JPanel pRelleno2 = new JPanel();
			JPanel pNickContra = new JPanel(new GridLayout(2, 1));
				JPanel pPrincipalNick = new JPanel();
				JPanel pPrincipalContraseña = new JPanel();
			JPanel pRelleno3 = new JPanel();
			JPanel pRelleno4 = new JPanel();
		JPanel pInferior = new JPanel(new GridLayout(2, 1));
			JPanel pInferiorUltimoUser = new JPanel();
			JPanel pInferiorAceptar = new JPanel();
		
		//Creacion de contenedores
			
		JLabel lLogintexto= new JLabel("Nombre");
		tfNombre = new JTextField(10);
		JLabel lPasswordtexto = new JLabel("Password");
		JPasswordField tfPassword = new JPasswordField(10);
		JButton bConfirmar = new JButton("Aceptar");
		cbUltimoUsuario = new JCheckBox("Quiere que se guarde su usuario para la proxima vez");
		
		
		//Modificaciones
		add(pPrincipal, BorderLayout.CENTER);
			pPrincipal.add(pRelleno1);
			pPrincipal.add(pNickContra);
				pNickContra.add(pPrincipalNick);
					pPrincipalNick.add(lLogintexto); pPrincipalNick.add(tfNombre);
				pNickContra.add(pPrincipalContraseña);
					pPrincipalContraseña.add(lPasswordtexto); pPrincipalContraseña.add(tfPassword);
			pPrincipal.add(pRelleno2);
			pPrincipal.add(pRelleno3);
			pPrincipal.add(pRelleno4);
		
		add(pInferior, BorderLayout.SOUTH);
			pInferior.add(pInferiorUltimoUser);
				pInferiorUltimoUser.add(cbUltimoUsuario);
			pInferior.add(pInferiorAceptar);
				pInferiorAceptar.add(bConfirmar);
		
		//Carga de properties
		cargarProperties();
					
		//Eventos
		bConfirmar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				UsuariosValidar estado ;
				if(codigo == 0) {//Login
					 estado =usuario.leer(tfNombre, tfPassword);
					if(estado==null) {
						JOptionPane.showMessageDialog(null, "Datos erroneos");
					}else {
						
						//Ventana general
						VentanaPrincipal ventana = new VentanaPrincipal(0,null);//Aqui habria que leer los datos para conseguir el personaje
						ventana.setVisible(true);
						logger.log(Level.INFO, "Usuario:"+estado.getNombre()+" Se ha loggueado");
					}
				}else {
					estado =usuario.leer(tfNombre, tfPassword);
					if(estado==null) {
						System.out.println( "A ver: " + lLogintexto.getText());
					usuario.setNombre(tfNombre.getText());
					usuario.setPassword(String.valueOf(tfPassword.getPassword()));
					usuario.guardar(usuario);
					VentanaPrincipal ventana = new VentanaPrincipal(1,null);
					ventana.setVisible(true);
					logger.log(Level.INFO,"Usuario:"+usuario.getNombre()+" Se ha registrado");
						
					}else {
						JOptionPane.showMessageDialog(null,"Ya existe un usuario con ese nombre");
						tfNombre.setText("");
						tfPassword.setText("");
					}
				}
				VentanaValidacionUsuarios.this.dispose();
			}
		});
		cbUltimoUsuario.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		//Las Propiedades deberían guardarse cuando se de a aceptar, pero por ahora así que está roto el botón
		addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent arg0) {
				if(cbUltimoUsuario.isSelected()) {
					propiedades.setProperty("Nick", tfNombre.getText());
					propiedades.setProperty("cbGuardarUsuario", "ON");
					guardarProperties();
					logger.log(Level.INFO, "Guardadas nuevas propiedades");
				}
				
			}
		});
		
	}
	
	private void guardarProperties() {
		try {
			propiedades.storeToXML( new PrintStream( "propiedadesInicioSesion.xml" ), "Propiedades de inicio sesion" );
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void cargarProperties() {
		propiedades = new Properties();
		try {
			propiedades.loadFromXML( new FileInputStream( "propiedadesInicioSesion.xml" ) );
			logger.log(Level.INFO, "Archivo Properties Cargado");
			try {
				tfNombre.setText(propiedades.getProperty("Nick"));
				if(propiedades.getProperty("cbGuardarUsuario").equals("ON")) {
					cbUltimoUsuario.setSelected(true);
				}
			} catch (Exception e) {
				
			}
		} catch (Exception e) {
			logger.log(Level.INFO, "No existe archivo properties");
		} //No hay fichero Properties
	}
	
	public static void main(String[] args) {
		VentanaValidacionUsuarios ventana = new VentanaValidacionUsuarios(0);
		ventana.setVisible(true);
		
		//Creación de la tabla Usuario en nuestra BD
		//Si la tabla ya se ha creado no hace nada, trabaja con la existente
		String comando = "";
		try {
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection("jdbc:sqlite:randomspritesmackdown.db");
			s = con.createStatement();
			try {
				comando = "create table Usuario(nick STRING, password STRING)";
				logger.log(Level.INFO, comando);
				s.executeUpdate(comando);
			} catch (SQLException e) {
				logger.log(Level.INFO, "Tabla ya existente");
			}
		}	catch (SQLException|ClassNotFoundException e) {
			logger.log(Level.SEVERE, "Error en la clase, último comando: " + comando);
			e.printStackTrace();
		}
	}
}
