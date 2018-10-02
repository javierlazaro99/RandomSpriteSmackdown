package Ventanas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Personalizados.JPanelBackground;

public class VentanaSeleccionNivel extends JFrame{
	
	public VentanaSeleccionNivel() {
		
		setSize(600, 500);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		JPanelBackground pbFondo = new JPanelBackground("");
		pbFondo.setLayout(new BorderLayout());
		
		JPanel pSuperior = new JPanel();
			JPanel pTitulo = new JPanel();
				JLabel lTitulo = new JLabel("Selecciona un nivel para comenzar");
				lTitulo.setFont(new Font("", Font.BOLD, 30));
		
		JPanel pInferior = new JPanel(new FlowLayout(FlowLayout.LEFT));
			JPanel pHome = new JPanel();
				JButton bHome = new JButton("Home");
		//
		JPanel pPrincipal = new JPanel(new GridLayout(2, 4));
			JPanel pN1 = new JPanel();
				JButton bN1 = new JButton("Nivel 1");
			JPanel pN2 = new JPanel();
				JButton bN2 = new JButton("Nivel 2");
			JPanel pN3 = new JPanel();
				JButton bN3 = new JButton("Nivel 3");
			JPanel pN4 = new JPanel();
				JButton bN4 = new JButton("Nivel 4");
			JPanel pN5 = new JPanel();
				JButton bN5 = new JButton("Nivel 5");
			JPanel pN6 = new JPanel();
				JButton bN6 = new JButton("Nivel 6");
			JPanel pN7 = new JPanel();
				JButton bN7 = new JButton("Nivel 7");
			JPanel pN8 = new JPanel();
				JButton bN8 = new JButton("Nivel 8");
				
		
		getContentPane().add(pbFondo);
		pbFondo.add(pSuperior, BorderLayout.NORTH);
		pbFondo.add(pPrincipal, BorderLayout.CENTER);
		pbFondo.add(pInferior, BorderLayout.SOUTH);
		
		pSuperior.add(pTitulo);
		pTitulo.add(lTitulo);
		
		pPrincipal.add(pN1); pPrincipal.add(pN2); pPrincipal.add(pN3); pPrincipal.add(pN4);
		pPrincipal.add(pN5); pPrincipal.add(pN6); pPrincipal.add(pN7); pPrincipal.add(pN8);
		
		pN1.add(bN1); pN2.add(bN2); pN3.add(bN3); pN4.add(bN4); pN5.add(bN5); pN6.add(bN6); pN7.add(bN7); pN8.add(bN8);
		
		pInferior.add(pHome);
		pHome.add(bHome);
		
		bN1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//Crear el stage 
				
			}
		});
		
		bN2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//Crear el stage
				
			}
		});
	}
	
	public static void main(String[] args) {
		VentanaSeleccionNivel vsn = new VentanaSeleccionNivel();
		vsn.setVisible(true);
	}

}
