package Ventanas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.LineNumberInputStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Personalizados.JPanelBackground;
import Usuarios.UsuariosValidar;
import control.ControlHistoria;
import control.Nivel;
import personaje.personajeJugable.PersonajeJugable;

public class VentanaSeleccionNivel extends JFrame{
	
	private static final long serialVersionUID = 1L;

	public VentanaSeleccionNivel(UsuariosValidar user, ControlHistoria ch, int victorias1v1) {
		
		Nivel.generarListaNiveles(ch.getPersonajePrincipal(),ch); //Del control de la historia se coje el personaje y se genera la lista de niveles 
		
		setSize(600, 500);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		JPanelBackground pbFondo = new JPanelBackground("");
		pbFondo.setLayout(new BorderLayout());
		
		JPanel pSuperior = new JPanel();
			JPanel pTitulo = new JPanel();
				JLabel lTitulo = new JLabel("Selecciona un nivel para comenzar");
				lTitulo.setFont(new Font("", Font.BOLD, 30));
		
		JPanel pInferior = new JPanel(new GridLayout(0,2));
			JPanel pHome = new JPanel();
				JButton bHome = new JButton("Home");
			JPanel pMejoras = new JPanel();
				JButton bMejoras = new JButton("Mejoras");
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
		pInferior.add(pMejoras);
		pMejoras.add(bMejoras);
		bN1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Nivel nivel1 = Nivel.listaNiveles.get(0);
				VentanaStage stage1 = new VentanaStage(nivel1.getPj(), nivel1.getEnem(), 1, nivel1.getCh(), true);
				stage1.setVisible(true);
				
			}
		});
		
		bN2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Nivel nivel2 = Nivel.listaNiveles.get(1);
				VentanaStage stage2 = new VentanaStage(nivel2.getPj(), nivel2.getEnem(), 2, nivel2.getCh(), true);
				stage2.setVisible(true);
				
				
			}
		
		});
		bN3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Nivel nivel3 = Nivel.listaNiveles.get(2);
				VentanaStage stage3 = new VentanaStage(nivel3.getPj(), nivel3.getEnem(), 3, nivel3.getCh(), true);
				stage3.setVisible(true);
				
				
			}
		});
		bN4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Nivel nivel4 = Nivel.listaNiveles.get(3);
				VentanaStage stage4 = new VentanaStage(nivel4.getPj(), nivel4.getEnem(), 4, nivel4.getCh(), true);
				stage4.setVisible(true);
				
			}
		});
		bN5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Nivel nivel5 = Nivel.listaNiveles.get(4);
				VentanaStage stage5 = new VentanaStage(nivel5.getPj(), nivel5.getEnem(), 5, nivel5.getCh(), true);
				stage5.setVisible(true);
				
			}
		});
		bN6.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Nivel nivel6 = Nivel.listaNiveles.get(5);
				VentanaStage stage6 = new VentanaStage(nivel6.getPj(), nivel6.getEnem(), 6, nivel6.getCh(), true);
				stage6.setVisible(true);
				
			}
		});
		bN7.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Nivel nivel7= Nivel.listaNiveles.get(6);
				VentanaStage stage7 = new VentanaStage(nivel7.getPj(), nivel7.getEnem(), 7, nivel7.getCh(), true);
				stage7.setVisible(true);
				
			}
		});
		bN8.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Nivel nivel8 = Nivel.listaNiveles.get(7);
				VentanaStage stage8 = new VentanaStage(nivel8.getPj(), nivel8.getEnem(), 8, nivel8.getCh(), true);
				stage8.setVisible(true);
				
			}
		});
		bHome.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				VentanaPrincipal ventana = new VentanaPrincipal(0,user, ch.getPersonajePrincipal(), ch.getNivelesCompletados(), victorias1v1);
				ventana.setVisible(true);
				VentanaSeleccionNivel.this.dispose();
				
			}
		});
		bMejoras.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaMejoras ventana= new VentanaMejoras(user, ch, victorias1v1);
				ventana.setVisible(true);
				VentanaSeleccionNivel.this.dispose();
				
			}
		});
	}
}
