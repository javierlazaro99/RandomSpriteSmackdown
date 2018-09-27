package Ventanas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;

import javax.swing.*;

import Personalizados.Fondo;
import Personalizados.FondoSwing;




public class VentanaPrincipal extends JFrame{

	public VentanaPrincipal() {
		
		//Iniciacion de ventana
		//(new ImageIcon("src\\Fondo.gif"));
		
		
		setTitle("RandomSprite Smackdown");//titulo del juego
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );//Operacion de cierre
		setSize(900, 700);//parametro de medidas de la ventana
		setLocationRelativeTo(null);//Centrado
		setLayout(new GridLayout());
		
		//Contenedores
		
		JLabel fondo = new JLabel(new ImageIcon("src\\Fondo.gif"));
		JPanel  paneliz = new JPanel();
		//Panel  botones principales
			JPanel panelinterior = new JPanel();
			JButton botonHistoria = new JButton(new ImageIcon(""));
			JButton botonPractica = new JButton();
			JButton boton1VS1 = new JButton();
			JButton botonAyuda = new JButton();
		JPanel panelde = new JPanel();//Panel de titulo
			JLabel labelTitulo = new JLabel();
		//Modificaciones
			panelinterior.setLayout(new BoxLayout(panelinterior,BoxLayout.Y_AXIS));
			
			
			paneliz.setOpaque(false);
			panelde.setOpaque(false);
			panelinterior.setOpaque(false);
			boton1VS1.setOpaque(false);
			botonAyuda.setOpaque(false);
			botonHistoria.setOpaque(false);
			botonPractica.setOpaque(false);
			fondo.setOpaque(false);
			Dimension fondosize =getSize();
			fondo.setSize(fondosize);
			
			
		//Añadir los contenedores
		add(fondo);
		fondo.add(paneliz);
		fondo.add(panelde);
		
		
		paneliz.add(panelinterior,BorderLayout.CENTER);
		panelinterior.add(botonHistoria);
		panelinterior.add(botonPractica);
		panelinterior.add(boton1VS1);
		panelinterior.add(botonAyuda);
		panelde.add(labelTitulo,BorderLayout.NORTH);
		
	}
	
	




public static void main(String[] args) {
		VentanaPrincipal ventana = new VentanaPrincipal();
		ventana.setVisible(true);
	}
}