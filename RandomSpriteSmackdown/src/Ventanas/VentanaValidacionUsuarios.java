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
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Usuarios.UsuariosValidar;


public class VentanaValidacionUsuarios extends JFrame{
	
	private static final long serialVersionUID = 1L;
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
			//Guille tío se ponen letras delante de los componentes para organizarte!!!! NULO
		JLabel lLogintexto= new JLabel("Nombre");
		JTextField tfNombre = new JTextField(10);
		JLabel lPasswordtexto = new JLabel("Password");
		JPasswordField tfPassword = new JPasswordField(10);
		JButton bConfirmar = new JButton("Aceptar");
		JCheckBox cbUltimoUsuario = new JCheckBox("Quiere que se guarde su usuario para la proxima vez");
		
		
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
					usuario.setNombre(lLogintexto.getText());
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
				
			}
		});
		cbUltimoUsuario.addActionListener(new ActionListener() {
			
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
		VentanaValidacionUsuarios ventana = new VentanaValidacionUsuarios(0);
		ventana.setVisible(true);
	}
}
