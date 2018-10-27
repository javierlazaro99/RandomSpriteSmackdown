package Ventanas;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Personalizados.JLabelGraficoAjustado;

public class VentanaValidacion extends JFrame {
	int codigo;
	public VentanaValidacion() {
		// TODO Auto-generated constructor stub
		
		//Creacion de ventana basica
		setTitle("Panel login/register");
		setSize(400, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		
		
		//Creacion de componentes
		JPanel panelcentral = new JPanel();
		JPanel panel = new JPanel();
		JLabelGraficoAjustado titulo = new JLabelGraficoAjustado("", 200, 50);
		JButton login = new JButton("Login");
		JButton register = new JButton("Register");
		JButton exit = new JButton("Exit");
		
		//Modificaciones
		panelcentral.setLayout(new GridLayout(0, 1));
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		//Meter en contenedores
		
		add(panel,BorderLayout.CENTER);
		add(titulo,BorderLayout.NORTH);
		panel.add(panelcentral);
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
	}
}
