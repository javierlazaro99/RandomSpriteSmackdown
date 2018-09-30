package Ventanas;



import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.*;
import javax.swing.border.Border;


import Personalizados.Fondo;
import Personalizados.FondoSwing;
import Personalizados.JLabelGraficoAjustado;
import Personalizados.JPanelBackground;




public class VentanaPrincipal extends JFrame{
	JPanel panel;
	JButton botonHoistoria;
	JButton botonPractica;
	JButton boton1VS1;
	JButton botonAyuda;
	
	boolean sigue = true;
	public VentanaPrincipal() {
		// TODO Auto-generated constructor stub
		//Settings
		setTitle("RandomSprite Smackdown");
		setSize(1024, 768);
		setLocationRelativeTo(null);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(new FlowLayout());
		//Contenedores
		
		JPanelBackground fondo = new JPanelBackground("src/Fondo.gif");
		
		
		
		JLabelGraficoAjustado titulo = new JLabelGraficoAjustado("", 750, 137);
		JPanel paneliz= new  JPanel();
		JPanel panelde = new JPanel();
		JPanel panelinterior = new JPanel();
		
		
		JButton botonHistoria= new JButton(new ImageIcon("src/Historia1.gif"));
		JButton botonPractica = new JButton(new ImageIcon("src/Practica1.gif"));
		JButton boton1VS1= new JButton(new ImageIcon("src/1VS11.gif"));
		JButton botonAyuda = new JButton(new ImageIcon("src/Ayuda1.gif"));
		
		//Modificaciones
		
		
		titulo.setImagen("src/Titulo.PNG");
		
		
		this.setLayout(new BorderLayout());
		panelde.setOpaque(false);
		paneliz.setOpaque(false);
		paneliz.setLayout(new GridLayout(0,1));
		panelinterior.setOpaque(false);
		
		titulo.setOpaque(false);
		titulo.setBorder(null);
		fondo.setLayout(new BoxLayout(fondo,BoxLayout.X_AXIS));
		botonHistoria.setSize(200,200);	
		botonHistoria.setOpaque(false);
		botonHistoria.setContentAreaFilled(false);
		botonHistoria.setBorder(null);
		botonPractica.setOpaque(false);
		botonPractica.setContentAreaFilled(false);
		botonPractica.setBorder(null);
		boton1VS1.setOpaque(false);
		boton1VS1.setContentAreaFilled(false);
		
		boton1VS1.setBorder(null);
		botonAyuda.setOpaque(false);
		botonAyuda.setContentAreaFilled(false);
		botonAyuda.setBorder(null);
		
		
		
		
		
		
		//Meter contenedores
		this.add(fondo, BorderLayout.CENTER);
		
		
		fondo.add(paneliz);
		fondo.add(panelde);
		panelde.add(titulo,BorderLayout.NORTH);
		paneliz.add(panelinterior);
		
		paneliz.add(botonHistoria);
		paneliz.add(botonPractica);
		paneliz.add(boton1VS1);
		paneliz.add(botonAyuda);
		
	}
	
	public static void main(String[] args) {
		VentanaPrincipal ventana = new VentanaPrincipal();
		ventana.setVisible(true);
	}
}
