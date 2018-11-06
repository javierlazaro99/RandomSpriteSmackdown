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

import javax.swing.*;
import javax.swing.border.Border;


import Personalizados.Fondo;
import Personalizados.FondoSwing;
import Personalizados.JLabelGraficoAjustado;
import Personalizados.JPanelBackground;
import personaje.personajeJugable.PersonajeJugable;




public class VentanaPrincipal extends JFrame{
	JPanel panel;
	JButton botonHoistoria;
	JButton botonPractica;
	JButton boton1VS1;
	JButton botonAyuda;
	
	boolean sigue = true;
	public VentanaPrincipal(int codigo,PersonajeJugable pPrincipal) {
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
		JPanel panelinterior = new JPanel();
		JButton botonHistoria= new JButton(new ImageIcon("src/Historia1.gif"));
		JButton botonPractica = new JButton(new ImageIcon("src/Practica1.gif"));
		JButton boton1VS1= new JButton(new ImageIcon("src/1VS11.gif"));
		JButton botonAyuda = new JButton(new ImageIcon("src/Ayuda1.gif"));
		
		
		//Modificaciones
		//LAYAOUT
		this.setLayout(new BorderLayout());
		paneliz.setLayout(new GridLayout(0,1,0,2));
		fondo.setLayout(new BoxLayout(fondo,BoxLayout.X_AXIS));
		panelde.setLayout(new BorderLayout());
		//A�adir imagen
		titulo.setImagen("src/Titulo.PNG");
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
		//Cambios de tama�o
		sticman.setMaximumSize(new Dimension(600, 600));;
		
		//Meter contenedores
		this.add(fondo, BorderLayout.CENTER);
		//Estructura principal
		fondo.add(paneliz);
		fondo.add(panelde);
		panelde.add(titulo,BorderLayout.NORTH);
		panelde.add(sticman,BorderLayout.CENTER);
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
				if(codigo==0) {
					VentanaSeleccionNivel ventana = new VentanaSeleccionNivel(pPrincipal);
					ventana.setVisible(true);
					VentanaPrincipal.this.dispose();
				}else {
					VentanaCreacionPersonaje ventana = new VentanaCreacionPersonaje();
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
		
		
	}
	
	public static void main(String[] args) {
		VentanaPrincipal ventana = new VentanaPrincipal(0,null);
		ventana.setVisible(true);
	}
}
