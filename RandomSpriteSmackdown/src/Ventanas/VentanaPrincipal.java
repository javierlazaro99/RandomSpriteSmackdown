package Ventanas;



import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.*;
import javax.swing.border.Border;


import Personalizados.Fondo;
import Personalizados.FondoSwing;
import Personalizados.JLabelGraficoAjustado;
import Personalizados.JPanelBackground;
import Usuarios.UsuariosValidar;
import control.BaseDeDatos;
import control.ControlHistoria;
import personaje.personajeJugable.PersonajeJugable;




public class VentanaPrincipal extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private static Connection con=null;
	private static Statement s;
	private static ResultSet rs;
	JPanel panel;
	JButton botonHoistoria;
	JButton botonPractica;
	JButton boton1VS1;
	JButton botonAyuda;
	
	boolean sigue = true;
	public VentanaPrincipal(int codigo, UsuariosValidar user, PersonajeJugable pPrincipal, int nivelesCompletados, int victorias1v1) {
		// TODO Auto-generated constructor stub
		//Settings
		setTitle("RandomSprite Smackdown");
		setSize(1024, 768);
		setLocationRelativeTo(null);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(new FlowLayout());
		//Contenedores
		JPanelBackground sticman = new JPanelBackground("src/Stickman2.gif");
		JPanelBackground fondo = new JPanelBackground("src/Fondo.gif");//Fondo
		JLabelGraficoAjustado titulo = new JLabelGraficoAjustado("", 650, 137);
		JPanel paneliz= new  JPanel();
		JPanel panelde = new JPanel();
		JPanel panelinf = new JPanel(); //Añadido de Javi
		JPanel panelinterior = new JPanel();
		JButton botonHistoria= new JButton(new ImageIcon("src/Historia1.gif"));
		JButton botonPractica = new JButton(new ImageIcon("src/Practica1.gif"));
		JButton boton1VS1= new JButton(new ImageIcon("src/1VS11.gif"));
		JButton botonAyuda = new JButton(new ImageIcon("src/Ayuda1.gif"));
		JButton bSalir = new JButton("GUARDAR Y SALIR");
		JButton B =  new  JButton();
		B.add(new JLabelGraficoAjustado("src/Titulo.PNG", B.getSize().width, B.getSize().height));
		//Modificaciones
		//LAYAOUT
		this.setLayout(new BorderLayout());
		paneliz.setLayout(new GridLayout(0,1,0,2));
		fondo.setLayout(new BoxLayout(fondo,BoxLayout.X_AXIS));
		panelde.setLayout(new BorderLayout());
		//Añadir imagen
		titulo.setImagen("src/Titulo.PNG");
		//Opaques
		titulo.setOpaque(false);
		panelde.setOpaque(false);
		paneliz.setOpaque(false);
		panelinf.setOpaque(false); // Añadido de Javi
		botonHistoria.setOpaque(false);
		botonPractica.setOpaque(false);
		botonAyuda.setOpaque(false);
		panelinterior.setOpaque(false);
		boton1VS1.setOpaque(false);
		sticman.setOpaque(false);
		//Border
		titulo.setBorder(null);
		botonHistoria.setBorder(null);
		botonPractica.setBorder(null);
		boton1VS1.setBorder(null);
		botonAyuda.setBorder(null);
		//Contenedor a null
		botonHistoria.setContentAreaFilled(false);
		botonPractica.setContentAreaFilled(false);
		boton1VS1.setContentAreaFilled(false);
		botonAyuda.setContentAreaFilled(false);
		//Cambios de tamaño
		sticman.setMaximumSize(new Dimension(600, 600));;
		
		//Meter contenedores
		this.add(fondo, BorderLayout.CENTER);
		//Estructura principal
		fondo.add(paneliz);
		fondo.add(panelde);
		panelde.add(titulo,BorderLayout.NORTH);
		panelde.add(sticman,BorderLayout.CENTER);
		panelde.add(panelinf, BorderLayout.SOUTH);// Añadido de Javi
		panelinf.add(bSalir); // Añadido de Javi
		paneliz.add(panelinterior);
		paneliz.add(botonHistoria);
		paneliz.add(botonPractica);
		paneliz.add(boton1VS1);
		paneliz.add(botonAyuda);
		
		//Eventos
		
		//Boton historia activa pagina principal
		botonHistoria.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//Creamos el control de la historia nada más dar al botón
				//Así guardamos el personaje y los niveles completados en una única variable
				ControlHistoria ch = new ControlHistoria(pPrincipal, nivelesCompletados); 
				if(codigo==0) {
					VentanaSeleccionNivel ventana = new VentanaSeleccionNivel(user, ch, victorias1v1);
					ventana.setVisible(true);
					VentanaPrincipal.this.dispose();
				}else {
					VentanaCreacionPersonaje ventana = new VentanaCreacionPersonaje(user, ch, victorias1v1);
					ventana.setVisible(true);
					VentanaPrincipal.this.dispose();
				}
				
			}
		});
		//Boton Practica activa stage personalizado
		botonPractica.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		//Boton 1VS1 
		boton1VS1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		//Boton Ayuda
		botonAyuda.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		//Boton Salir
		bSalir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
//				BaseDeDatos.guardarPartidaBD(user);
				
//				// Parte en la que se guarda la partida hasta el momento en la BD
//				String query = "";
//				try {
//					con = DriverManager.getConnection("jdbc:sqlite:randomspritesmackdown.db");
//					s = con.createStatement();
//					try {
//						query = "SELECT * FROM Partida WHERE NICK='" + user.getNombre() + "'";
//						ResultSet rs = s.executeQuery(query);
//						VentanaValidacionUsuarios.logger.log(Level.INFO, "Comando: " + query + " ejecutado correctamente");
//						if(rs.wasNull()) { //Si el result set es null significa que el usuario no tiene una partida creada
//							//Le creamos una partida al jugador
//							query = "SELECT MAX(cod_partida) FROM Partida"; // query para saber el valor del mayor indice existente
//							ResultSet rs2 = s.executeQuery(query);
//							VentanaValidacionUsuarios.logger.log(Level.INFO, "Comando: " + query + " ejecutado correctamente");
//							if(rs2.wasNull()) { //Metemos el valor 1 en el codigo
//								query = "INSERT INTO Partida(cod_partida, niveles_comp, victorias1v1, nick)"
//										+ "VALUES(1, 0, 0," + user.getNombre() + ")";
//								s.executeUpdate(query);
//								VentanaValidacionUsuarios.logger.log(Level.INFO, "Comando: " + query + " ejecutado correctamente");
//							}else {
//								int codigo = rs2.getInt("cod_partida");
//								codigo += 1; // El codigo que le toca será el siguiente al máximo
//								query = "INSERT INTO Partida(cod_partida, niveles_comp, victorias1v1, nick)"
//										+ "VALUES(" + codigo + ", 0, 0," + user.getNombre() + ")";
//								s.executeUpdate(query);
//								VentanaValidacionUsuarios.logger.log(Level.INFO, "Comando: " + query + " ejecutado correctamente");
//							}
//						}else { //El usuario ya existe así que sólo hay que actualizar su información
//							int codigo = rs.getInt("cod_partida");
//							query = "UPDATE Partida SET niveles_comp=" +  ""
//									+ "VALUES(" + codigo + ", 0, 0," + user.getNombre() + ")";
//						}
//								
//					} catch (SQLException e2) {
//						VentanaValidacionUsuarios.logger.log(Level.INFO, "Comando: " + query + " fallido");
//					}
//				} catch (SQLException e1) {
//					VentanaValidacionUsuarios.logger.log(Level.SEVERE, "Error al conectarse a la BD");
//					
//				}
			}
		});	
	}
}
