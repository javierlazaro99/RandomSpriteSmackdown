package Ventanas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Personalizados.JLabelGraficoAjustado;
import Personalizados.JPanelBackground;
import control.BaseDeDatos;

public class VentanaValidacion extends JFrame {
	int codigo;
	public VentanaValidacion() {
		// TODO Auto-generated constructor stub
		
		//Creacion de ventana basica
		setTitle("Panel login/register");
		setSize(400, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		
		//Creacion de componentes
		JPanel panelcentral = new JPanel();
		JPanel panelsur = new JPanel();
		JPanel paneloeste = new JPanel();
		JPanel paneleste = new JPanel();
		JPanel panelnorte = new JPanel();
		
		JLabelGraficoAjustado titulo = new JLabelGraficoAjustado("src/Titulo.PNG", 650, 137);
		JPanelBackground background = new JPanelBackground("src/Fondo.gif");
		JButton login = new JButton("Login");
		JButton register = new JButton("Register");
		JButton exit = new JButton("Exit");
		JPanel vacio = new JPanel();
		//Modificaciones
		
		background.setOpaque(false);
		panelcentral.setOpaque(false);
		panelsur.setOpaque(false);
		paneloeste.setOpaque(false);
		paneleste.setOpaque(false);
		panelnorte.setOpaque(false);
		
		panelcentral.setLayout(new GridLayout(4, 0));
		background.setLayout(new BorderLayout());
		paneleste.setLayout(new GridLayout(0, 1));
		paneloeste.setLayout(new GridLayout(0, 1));
		//Meter en contenedores
		
		add(background);
		background.add(panelsur,BorderLayout.SOUTH);
		
		background.add(panelnorte,BorderLayout.NORTH);
		panelnorte.add(titulo);
		background.add(paneleste,BorderLayout.EAST);
	
		background.add(paneloeste,BorderLayout.WEST);
		
		background.add(panelcentral,BorderLayout.CENTER);
		
		panelcentral.add(login);
		panelcentral.add(register);
		panelcentral.add(exit);
		
		//Eventos
		
		login.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				VentanaValidacionUsuarios ventana = new VentanaValidacionUsuarios(0);
				ventana.setVisible(true);
				VentanaValidacion.this.dispose();
			}
		});
		
		register.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				VentanaValidacionUsuarios ventana = new VentanaValidacionUsuarios(1);
				ventana.setVisible(true);
				VentanaValidacion.this.dispose();
				
			}
		});
		
		exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
	}
	public static void main(String[] args) {
		VentanaValidacion ventana = new VentanaValidacion();
		ventana.setVisible(true);
		
		BaseDeDatos.crearBD();
	}
}
