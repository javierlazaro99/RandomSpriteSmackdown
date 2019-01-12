package Ventanas;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.sound.sampled.Clip;
import javax.swing.*;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.TitlePaneLayout;

import Personalizados.JLabelGraficoAjustado;
import Personalizados.JPanelBackground;
import control.BaseDeDatos;
import control.Sonidos;

public class VentanaValidacion extends JFrame {
	int codigo;
	
	public static VentanaValidacion ventanaVal;
	private Clip punch;
	
	public VentanaValidacion() {
		//Creacion de font
		
		try {
		     GraphicsEnvironment ge = 
		         GraphicsEnvironment.getLocalGraphicsEnvironment();
		     ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("fonts/SoulCalibur.ttf")));
		} catch (IOException|FontFormatException e) {
		     //Handle exception
		}
		
		
		
		//Creacion de ventana basica
		setTitle("Panel login/register");
		setUndecorated(true);
		
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		
		//Creacion de componentes
		JPanel pNorte = new JPanel();
		JPanel pCentral = new JPanel();
		JPanel pTitulo = new JPanel(new BorderLayout());
		JPanel pVacio = new JPanel();
		JPanel pLogin = new JPanel();
		JPanel pRegister = new JPanel();
		JPanel pExit = new JPanel();
		
		
		//JLabelGraficoAjustado titulo = new JLabelGraficoAjustado("src/Titulo.PNG", 864, 128);
		JLabel titulo = new JLabel("Ramndom Sprite Smackdown");
		JPanelBackground background = new JPanelBackground("src/Fondo.gif");
		JButton login = new JButton("Login");
		JButton register = new JButton("Register");
		JButton exit = new JButton("Exit");
		
		
		//Modificación de componentes
		login.setFont(new Font("SoulCalibur", Font.TRUETYPE_FONT, 80));
			login.setForeground(Color.ORANGE);
			login.setPreferredSize(new Dimension(500, 100));
			login.setFocusable(false);
		register.setFont(new Font("SoulCalibur", Font.TRUETYPE_FONT, 80));
			register.setForeground(Color.ORANGE);
			register.setPreferredSize(new Dimension(500, 100));
			register.setFocusable(false);
		exit.setFont(new Font("SoulCalibur", Font.TRUETYPE_FONT, 80));
			exit.setForeground(Color.ORANGE);
			exit.setPreferredSize(new Dimension(500, 100));
			exit.setFocusable(false);

		titulo.setFont(new Font("SoulCalibur", Font.TRUETYPE_FONT, 150));
			titulo.setForeground(Color.orange);
		
		login.setOpaque(false);
		login.setContentAreaFilled(false);
		login.setBorderPainted(false);
		
		register.setOpaque(false);
		register.setContentAreaFilled(false);
		register.setBorderPainted(false);
		
		exit.setOpaque(false);
		exit.setContentAreaFilled(false);
		exit.setBorderPainted(false);
		
		
		
		//Modificaciones paneles
		background.setOpaque(false);
		pCentral.setOpaque(false);
		pNorte.setOpaque(false);
		pTitulo.setOpaque(false);
			pTitulo.setPreferredSize(new Dimension(1100, 400));
		pVacio.setOpaque(false);
		pLogin.setOpaque(false);
		pRegister.setOpaque(false);
		pExit.setOpaque(false);
		
		pCentral.setLayout(new GridLayout(5, 0));
		background.setLayout(new BorderLayout());
		//Meter en contenedores
		
		add(background);
		background.add(pNorte,BorderLayout.NORTH);
			pNorte.add(pTitulo, BorderLayout.CENTER);
				pTitulo.add(titulo, BorderLayout.CENTER);
				titulo.setAlignmentY(CENTER_ALIGNMENT);
			
		background.add(pCentral,BorderLayout.CENTER);
			pCentral.add(pVacio);
			pCentral.add(pLogin);
				pLogin.add(login);
			pCentral.add(pRegister);
				pRegister.add(register);
			pCentral.add(pExit);
				pExit.add(exit);
		//Eventos
		
		login.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//Sonidos
				punch = Sonidos.punch1Sonido.cargarSonido("sounds/punch_2.wav");
				punch.start();
				
				//Ventanas
				VentanaValidacionUsuarios ventana = new VentanaValidacionUsuarios(0);
				ventana.setVisible(true);
				VentanaValidacion.this.setEnabled(false);
			}
		});
		
		register.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//Sonidos
				punch = Sonidos.punch1Sonido.cargarSonido("sounds/punch_1.wav");
				punch.start();
				
				//Ventanas
				VentanaValidacionUsuarios ventana = new VentanaValidacionUsuarios(1);
				ventana.setVisible(true);
				VentanaValidacion.this.setEnabled(false);
				
			}
		});
		
		exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
}
