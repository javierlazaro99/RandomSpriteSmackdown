package Ventanas;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Personalizados.FondoSwing;
import Personalizados.JPanelBackground;

public class VentanaStage extends JFrame {
	
	private static final long serialVersionUID = 1L;

	public VentanaStage() {
		
		setSize(500, 500);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		JPanelBackground jpb = new JPanelBackground("src/Fondo.gif");
		
		this.setLayout(new BorderLayout());
		this.add(jpb, BorderLayout.CENTER);
		
	}
	
	public static void main(String[] args) {
		VentanaStage vs = new VentanaStage();
		vs.setVisible(true);
	}

}
