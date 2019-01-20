package Ventanas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Personalizados.JPanelBackground;
import Usuarios.UsuariosValidar;
import control.BaseDeDatos;
import control.MouseAdapters.MouseAdapterBotonesMenus;
import control.Sonidos;
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
		setUndecorated(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		
		//Creación de paneles
		JPanel pbackground = new JPanelBackground("src/RockBackground.jpg");
		
		JPanel pPrincipal = new JPanel(new GridLayout(3, 1));
			JPanel pRelleno1 = new JPanel();
			JPanel pRelleno2 = new JPanel();
			JPanel pNickContra = new JPanel(new GridLayout(2, 1));
				JPanel pPrincipalNick = new JPanel();
					JPanel pLabelNick = new JPanel();
					JPanel pTfNick = new JPanel();
				JPanel pPrincipalContrasenya = new JPanel();
					JPanel pLabelContra = new JPanel();
					JPanel pTfContra = new JPanel();
		JPanel pInferior = new JPanel(new GridLayout(2, 1));
			JPanel pInferiorUltimoUser = new JPanel();
			JPanel pInferiorAceptar = new JPanel();
		
		//Creacion de contenedores
			
		JLabel lLogintexto= new JLabel("Nick");
		tfNombre = new JTextField(13);
		JLabel lPasswordtexto = new JLabel("Pass");
		JPasswordField tfPassword = new JPasswordField(13);
		JButton bConfirmar = new JButton("Aceptar");
		JButton bCancelar = new JButton("Cancelar");
		cbUltimoUsuario = new JCheckBox("  Guardar usuario");
		
		//Modificacion de peneles
		pLabelNick.setPreferredSize(new Dimension(150, 55));
		pLabelContra.setPreferredSize(new Dimension(140, 55));
		
		pPrincipal.setOpaque(false);
		pRelleno1.setOpaque(false);
		pRelleno2.setOpaque(false);
		pNickContra.setOpaque(false);
		pInferior.setOpaque(false);
		pInferiorUltimoUser.setOpaque(false);
		pInferiorAceptar.setOpaque(false);
		pPrincipalNick.setOpaque(false);
		pLabelNick.setOpaque(false);
		pTfNick.setOpaque(false);
		pPrincipalContrasenya.setOpaque(false);
		pLabelContra.setOpaque(false);
		pTfContra.setOpaque(false);
		
		
		//Modifcacion de contenedores
		
		//Login y Password
		lLogintexto.setFont(new Font("Play Pretend", Font.TRUETYPE_FONT, 30));
		lPasswordtexto.setFont(new Font("Play Pretend", Font.TRUETYPE_FONT, 30));
		
		lLogintexto.setForeground(Color.orange);
		lPasswordtexto.setForeground(Color.orange);
		
		tfNombre.setFont(new Font("Play Pretend", Font.TRUETYPE_FONT, 20));
		tfNombre.setForeground(Color.orange);
		tfNombre.setHorizontalAlignment(SwingConstants.CENTER);
		tfPassword.setFont(new Font("Play Pretend", Font.TRUETYPE_FONT, 20));
		tfPassword.setForeground(Color.orange);
		tfPassword.setHorizontalAlignment(SwingConstants.CENTER);
		tfNombre.setBackground(Color.BLACK);
		tfNombre.setBorder(BorderFactory.createLineBorder(Color.lightGray, 3));
		tfNombre.setPreferredSize(new Dimension(500, 35));
		tfPassword.setBackground(Color.BLACK);
		tfPassword.setBorder(BorderFactory.createLineBorder(Color.lightGray, 3));
		tfPassword.setPreferredSize(new Dimension(500, 35));
		
		//Check Box
		cbUltimoUsuario.setOpaque(false);
		cbUltimoUsuario.setFocusable(false);
		
		cbUltimoUsuario.setFont(new Font("Play Pretend", Font.TRUETYPE_FONT, 18));
		
		ImageIcon chSinPulsar = new ImageIcon("src/unchecked-checkbox.png"); // load the image to a imageIcon
		chSinPulsar = new ImageIcon(chSinPulsar.getImage().getScaledInstance(20, 20,  java.awt.Image.SCALE_SMOOTH));
		
		cbUltimoUsuario.setIcon(chSinPulsar);
		
		ImageIcon chPulsado = new ImageIcon("src/checked-checkbox.png"); 
		chPulsado = new ImageIcon(chPulsado.getImage().getScaledInstance(20, 20,  java.awt.Image.SCALE_SMOOTH));
		
		cbUltimoUsuario.setSelectedIcon(chPulsado);
		cbUltimoUsuario.setForeground(Color.orange);
		
		//Botones
		bConfirmar.setFont(new Font("Play Pretend", Font.TRUETYPE_FONT, 20));
		bConfirmar.setForeground(Color.ORANGE);
		bConfirmar.setPreferredSize(new Dimension(150, 50));
		bConfirmar.setFocusable(false);
		bConfirmar.setBackground(Color.black);
		bConfirmar.setBorder(BorderFactory.createLineBorder(Color.lightGray, 3));
		
		bCancelar.setFont(new Font("Play Pretend", Font.TRUETYPE_FONT, 20));
		bCancelar.setForeground(Color.ORANGE);
		bCancelar.setPreferredSize(new Dimension(150, 50));
		bCancelar.setFocusable(false);
		bCancelar.setBackground(Color.black);
		bCancelar.setBorder(BorderFactory.createLineBorder(Color.lightGray, 3));
		
		//Inserción de paneles
		add(pbackground, BorderLayout.CENTER);
		pbackground.add(pPrincipal, BorderLayout.CENTER);
			pPrincipal.add(pRelleno1);
			pPrincipal.add(pNickContra);
				pNickContra.add(pPrincipalNick);
					pPrincipalNick.add(pLabelNick); pPrincipalNick.add(pTfNick);
						pLabelNick.add(lLogintexto);
						pTfNick.add(tfNombre);
				pNickContra.add(pPrincipalContrasenya);
					pPrincipalContrasenya.add(pLabelContra); pPrincipalContrasenya.add(pTfContra);
						pLabelContra.add(lPasswordtexto);
						pTfContra.add(tfPassword);
			pPrincipal.add(pRelleno2);
		
		pbackground.add(pInferior, BorderLayout.SOUTH);
			pInferior.add(pInferiorUltimoUser);
				pInferiorUltimoUser.add(cbUltimoUsuario);
			pInferior.add(pInferiorAceptar);
				pInferiorAceptar.add(bConfirmar);
				pInferiorAceptar.add(bCancelar);
	
		//Carga de properties
		propiedades = new Properties();
		cargarProperties(codigo);
					
		//Eventos
		
		bConfirmar.addMouseListener(new MouseAdapterBotonesMenus(bConfirmar));
		
		bConfirmar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
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
						pj.setPuntosMejora(puntosMejora);
						
						VentanaPrincipal.venPrincip = new VentanaPrincipal(0, estado, pj, nivelesCompletados, victorias1v1);
						VentanaPrincipal.venPrincip.setVisible(true);
						logger.log(Level.INFO, "Usuario:"+estado.getNombre()+" Se ha loggueado");
						
						VentanaValidacion.ventanaVal.dispose();
						
						//Sonidos
						Sonidos.mainTheme.loop(Clip.LOOP_CONTINUOUSLY);
						FloatControl volume =(FloatControl)Sonidos.mainTheme.getControl(FloatControl.Type.MASTER_GAIN);
						volume.setValue(4);
					}
				}else {
					estado =usuario.leer(tfNombre, tfPassword);
					if(estado==null) {
						System.out.println( "A ver: " + lLogintexto.getText());
					usuario.setNombre(tfNombre.getText());
					usuario.setPassword(String.valueOf(tfPassword.getPassword()));
					usuario.guardar(usuario);
					VentanaPrincipal.venPrincip = new VentanaPrincipal(1,usuario, null, 0, 0);
					VentanaPrincipal.venPrincip.setVisible(true);
					logger.log(Level.INFO,"Usuario:"+ usuario.getNombre()+" Se ha registrado");
					
					VentanaValidacion.ventanaVal.dispose();
					
					//Sonidos
					Sonidos.mainTheme.loop(Clip.LOOP_CONTINUOUSLY);
					FloatControl volume =(FloatControl)Sonidos.mainTheme.getControl(FloatControl.Type.MASTER_GAIN);
					volume.setValue(4);
					
					}else {
						JOptionPane.showMessageDialog(null,"Ya existe un usuario con ese nombre");
						tfNombre.setText("");
						tfPassword.setText("");
						VentanaValidacion.ventanaVal.setEnabled(true);
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
		
		bCancelar.addMouseListener(new MouseAdapterBotonesMenus(bCancelar));
		
		bCancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaValidacion.ventanaVal.setEnabled(true);
				VentanaValidacionUsuarios.this.dispose();
			}
		});
		
		addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosed(WindowEvent e) {
				VentanaValidacion.ventanaVal.setEnabled(true);
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
