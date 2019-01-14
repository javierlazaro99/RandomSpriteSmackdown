package Ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;

import Personalizados.JLabelGraficoAjustado;
import Personalizados.JPanelBackground;
import Usuarios.UsuariosValidar;
import control.BaseDeDatos;
import control.ControlHistoria;
import control.MouseAdapters.MouseAdapterBotonesVentanaPrincipal;
import personaje.personajeJugable.PersonajeJugable;


public class VentanaPrincipal extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private static Connection con=null;
	private static Statement s;
	private static ResultSet rs;
	public static VentanaPrincipal venPrincip;
	JPanel panel;
	JButton botonHoistoria;
	JButton botonPractica;
	JButton boton1VS1;
	JButton botonAyuda;
	
	boolean sigue = true;
	public VentanaPrincipal(int codigo, UsuariosValidar user, PersonajeJugable pPrincipal, int nivelesCompletados, int victorias1v1) {
		
		//Settings
		setTitle("RandomSprite Smackdown");
		setUndecorated(true);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setLocationRelativeTo(null);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(new FlowLayout());
		
		//Contenedores
		JPanelBackground sticman = new JPanelBackground("src/Stickman2.gif");
		JPanelBackground fondo = new JPanelBackground("src/Fondo.gif");//Fondo
		JLabelGraficoAjustado titulo = new JLabelGraficoAjustado("", 1000, 150);
		JPanel pTitulo = new JPanel();
		JPanel paneliz= new  JPanel();
		JPanel panelde = new JPanel();
		JPanel panelinterior = new JPanel();
		JPanel panelVacio = new JPanel();
		JPanel panelVacio2 = new JPanel();
		JButton botonHistoria= new JButton("Historia");
		JButton botonPractica = new JButton("Practica");
		JButton boton1VS1= new JButton("Versus");
		JButton botonAyuda = new JButton("Ayuda");
		JButton bSalir = new JButton("<html><p>Guardar</p><p>y Salir</p></html>");
		
		//Modificaciones
		//LAYAOUT
		this.setLayout(new BorderLayout());
		paneliz.setLayout(new GridLayout(0,1,0,2));
		fondo.setLayout(new BoxLayout(fondo,BoxLayout.X_AXIS));
		panelde.setLayout(new BorderLayout());
		
		//Añadir imagen
		titulo.setImagen("src/Titulo.PNG");
		
		//Paneles
		pTitulo.setPreferredSize(new Dimension(1200, 250));
		panelVacio2.setPreferredSize(new Dimension(1000, 70));
		
		//Opaques
		titulo.setOpaque(false);
		panelde.setOpaque(false);
		paneliz.setOpaque(false);
		botonHistoria.setOpaque(false);
		botonPractica.setOpaque(false);
		botonAyuda.setOpaque(false);
		panelinterior.setOpaque(false);
		boton1VS1.setOpaque(false);
		sticman.setOpaque(false);
		panelVacio.setOpaque(false);
		pTitulo.setOpaque(false);
		panelVacio2.setOpaque(false);
		
		//Font
		botonHistoria.setFont(new Font("Unreal Tournament", Font.PLAIN, 60));
		botonHistoria.setForeground(Color.ORANGE);
		botonHistoria.setPreferredSize(new Dimension(500, 100));
		
		botonPractica.setFont(new Font("Unreal Tournament", Font.TRUETYPE_FONT, 60));
		botonPractica.setForeground(Color.ORANGE);
		botonPractica.setPreferredSize(new Dimension(500, 100));
		
		boton1VS1.setFont(new Font("Unreal Tournament", Font.TRUETYPE_FONT, 60));
		boton1VS1.setForeground(Color.ORANGE);
		boton1VS1.setPreferredSize(new Dimension(500, 100));
		
		botonAyuda.setFont(new Font("Unreal Tournament", Font.TRUETYPE_FONT, 60));
		botonAyuda.setForeground(Color.ORANGE);
		botonAyuda.setPreferredSize(new Dimension(500, 100));
		
		bSalir.setFont(new Font("Unreal Tournament", Font.TRUETYPE_FONT, 50));
		bSalir.setForeground(Color.ORANGE);
		bSalir.setPreferredSize(new Dimension(500, 150));
		
		//Focusable
		botonHistoria.setFocusable(false);
		botonPractica.setFocusable(false);
		boton1VS1.setFocusable(false);
		botonAyuda.setFocusable(false);	
		bSalir.setFocusable(false);
		
		//Border
		titulo.setBorder(null);
		botonHistoria.setBorder(null);
		botonPractica.setBorder(null);
		boton1VS1.setBorder(null);
		botonAyuda.setBorder(null);
		bSalir.setBorder(null);
		
		//Contenedor a null
		botonHistoria.setContentAreaFilled(false);
		botonPractica.setContentAreaFilled(false);
		boton1VS1.setContentAreaFilled(false);
		botonAyuda.setContentAreaFilled(false);
		bSalir.setContentAreaFilled(false);
		
		//Cambios de tamaño
		sticman.setMaximumSize(new Dimension(600, 600));;
		
		//Meter contenedores
		this.add(fondo, BorderLayout.CENTER);
		
		//Estructura principal
		fondo.add(paneliz);
		fondo.add(panelde);
		panelde.add(pTitulo,BorderLayout.NORTH);
			pTitulo.add(panelVacio2, BorderLayout.NORTH);
			pTitulo.add(titulo, BorderLayout.CENTER);
		panelde.add(sticman,BorderLayout.CENTER);
		paneliz.add(panelinterior);
		paneliz.add(botonHistoria);
		paneliz.add(botonPractica);
		paneliz.add(boton1VS1);
		paneliz.add(botonAyuda);
		paneliz.add(bSalir);
		paneliz.add(panelVacio);
		
		//Eventos
		//Boton historia activa pagina principal
		botonHistoria.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//Creamos el control de la historia nada más dar al botón
				//Así guardamos el personaje y los niveles completados en una única variable
				ControlHistoria ch = new ControlHistoria(pPrincipal, nivelesCompletados); 
				if(codigo==0) { 
					///////// Mirar esto del código que da error si te has registrado pero no has creado personaje
					VentanaSeleccionNivel ventana = new VentanaSeleccionNivel(user, ch, victorias1v1);
					ventana.setVisible(true);
					VentanaPrincipal.this.dispose();
				}else {
					VentanaCreacionPersonaje ventana = new VentanaCreacionPersonaje(codigo,user,pPrincipal,ch,victorias1v1,nivelesCompletados);
					ventana.setVisible(true);
					VentanaPrincipal.this.setEnabled(false);
				}
				
			}
		});
		botonHistoria.addMouseListener(new MouseAdapterBotonesVentanaPrincipal(botonHistoria)); 
		
		//Boton Practica activa stage personalizado
		botonPractica.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ControlHistoria ch = new ControlHistoria(pPrincipal, nivelesCompletados);
				VentanaSeleccionOponente ventana = new VentanaSeleccionOponente(codigo, user, pPrincipal, nivelesCompletados, victorias1v1,ch, false);
				ventana.setVisible(true);
				VentanaPrincipal.this.dispose();
			}
		});
		botonPractica.addMouseListener(new MouseAdapterBotonesVentanaPrincipal(botonPractica));
		
		//Boton 1VS1 
		boton1VS1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				ControlHistoria ch = new ControlHistoria(pPrincipal, nivelesCompletados);
				VentanaSeleccionOponente ventana = new VentanaSeleccionOponente(codigo, user, pPrincipal, nivelesCompletados, victorias1v1,ch,true);
				ventana.setVisible(true);
				VentanaPrincipal.this.dispose();
				
			}
		});
		boton1VS1.addMouseListener(new MouseAdapterBotonesVentanaPrincipal(boton1VS1)); 
		
		//Boton Ayuda
		botonAyuda.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		botonAyuda.addMouseListener(new MouseAdapterBotonesVentanaPrincipal(botonAyuda)); 
		
		//Boton Salir
		bSalir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(pPrincipal != null) {
					ControlHistoria ch = new ControlHistoria(pPrincipal, nivelesCompletados);
					BaseDeDatos.guardarPartidaBD2(user, ch);
				}
				
				BaseDeDatos.cerrarBD();
				dispose();
			}
		});
		
		
		bSalir.addMouseListener(new MouseAdapterBotonesVentanaPrincipal(bSalir)); 
		
		addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent arg0) {
				BaseDeDatos.cerrarBD();
				
			}
		});
	}
}
