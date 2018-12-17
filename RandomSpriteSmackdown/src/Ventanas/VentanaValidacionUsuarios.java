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
import java.util.ArrayList;
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
import control.BaseDeDatos;
import personaje.personajeJugable.PersonajeJugable;


public class VentanaValidacionUsuarios extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private UsuariosValidar usuario = new UsuariosValidar("", "");  
	private static Properties propiedades;
	public static Logger logger = Logger.getLogger("Loggerjuego");
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
		propiedades = new Properties();
		cargarProperties(codigo);
					
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
						//Parte de BD para conseguir el personaje y los datos de la partida
						ArrayList<Object> listaObjetos = new ArrayList<Object>();
						BaseDeDatos.cargarPartidaBD(estado, listaObjetos);
						
						
						//Esto probablemente sea mejor hacerlo con un for, por si queremos ampliar, pero por ahora vale
						int nivelesCompletados = (int) listaObjetos.get(0);
						int victorias1v1 = (int) listaObjetos.get(1);
						int puntosMejora = (int)listaObjetos.get(2);
						PersonajeJugable pj = (PersonajeJugable) listaObjetos.get(3);
						System.out.println("		"+pj.getTipoPersonaje());
						pj.setPuntosMejora(puntosMejora);
						
						VentanaPrincipal ventana = new VentanaPrincipal(0, usuario, pj, nivelesCompletados, victorias1v1);
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
					VentanaPrincipal ventana = new VentanaPrincipal(1,usuario, null, 0, 0);
					ventana.setVisible(true);
					logger.log(Level.INFO,"Usuario:"+ usuario.getNombre()+" Se ha registrado");
					
					System.out.println(usuario.getNombre());
					}else {
						JOptionPane.showMessageDialog(null,"Ya existe un usuario con ese nombre");
						tfNombre.setText("");
						tfPassword.setText("");
					}
				}
				
				//Creamos las Properties
				if(cbUltimoUsuario.isSelected()) {
					propiedades.setProperty("Nick", tfNombre.getText());
					propiedades.setProperty("cbGuardarUsuario", "ON");
					guardarProperties();
					logger.log(Level.INFO, "Guardadas nuevas propiedades");
				}
				
				VentanaValidacionUsuarios.this.dispose();
			}
		});
		
	}
	
	/**
	 * Metodo para guardar las properties de la clase en un archivo .xml
	 */
	private void guardarProperties() {
		try {
			propiedades.storeToXML( new PrintStream( "propiedadesInicioSesion.xml" ), "Propiedades de inicio sesion" );
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Metodo para cargar las properties desde archivo
	 * @param codigo codigo de la ventana (login o register) Si es de login (0) se cargaran las properties, si no, no
	 */
	private void cargarProperties(int codigo) {
		if(codigo == 0) {//Si la ventana no es de login no cargamos properties
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
				logger.log(Level.SEVERE, "No existe archivo properties");
			} //No hay fichero Properties
		}
	}
	

}
