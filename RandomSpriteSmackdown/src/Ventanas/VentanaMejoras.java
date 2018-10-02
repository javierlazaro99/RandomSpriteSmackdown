package Ventanas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import Personalizados.JLabelGraficoAjustado;
import personaje.personajeJugable.PersonajeJugable;

public class VentanaMejoras extends JFrame{
	
	private static final long serialVersionUID = 1L;

	public VentanaMejoras(PersonajeJugable pPrincipal) {
		
		setSize(500, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		JPanel pIzquierda = new JPanel(new BorderLayout());
			JLabel lTitulo = new JLabel("Mejoras");
			JLabelGraficoAjustado lgaPersonaje = new JLabelGraficoAjustado("", 200, 200);
			JButton bHome = new JButton("Home");
		JPanel pDerecha = new JPanel(new BorderLayout());
			JLabel lPuntosMejora = new JLabel("Puntos de mejora: " + pPrincipal.getPuntosMejora());
			JPanel pMejoras = new JPanel(new GridLayout(4, 1));
				JLabel lMejoras = new JLabel("Comprar mejoras");
				JPanel pFuerza = new JPanel(new FlowLayout());
					JButton bSubirFuerza = new JButton("+");
				JPanel pVida = new JPanel(new FlowLayout());
					JButton bSubirVida = new JButton("+");
				JPanel pVelocidad = new JPanel(new FlowLayout());
					JButton bSubirVelocidad = new JButton("+");
		
		
		getContentPane().add(pIzquierda, BorderLayout.WEST);		
		getContentPane().add(pDerecha, BorderLayout.CENTER);
		
		pIzquierda.add(lTitulo, BorderLayout.NORTH);
		pIzquierda.add(lgaPersonaje, BorderLayout.CENTER);
		pIzquierda.add(bHome, BorderLayout.SOUTH);
		
		pDerecha.add(lPuntosMejora, BorderLayout.NORTH);
		pDerecha.add(pMejoras, BorderLayout.CENTER);
		
		pMejoras.add(lMejoras);
		pMejoras.add(pFuerza);
		pMejoras.add(pVida);
		pMejoras.add(pVelocidad);
		
		pFuerza.add(new JLabel("Fuerza"));
		pFuerza.add(pPrincipal.getPbFuerza());
		pFuerza.add(bSubirFuerza);
		
		pVida.add(new JLabel("Vida"));
		pVida.add(pPrincipal.getPbVida());
		pVida.add(bSubirVida);
		
		pVelocidad.add(new JLabel("Velocidad"));
		pVelocidad.add(pPrincipal.getPbVelocidad());
		pVelocidad.add(bSubirVelocidad);
		
		bSubirFuerza.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				pPrincipal.SubirNivel("fuerza");
				pPrincipal.getPbFuerza().setValue(pPrincipal.getFuerza());
				
				lPuntosMejora.setText("Puntos mejora: " + pPrincipal.getPuntosMejora());
				
				getContentPane().revalidate();
			}
		});
		
		bSubirVida.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				pPrincipal.SubirNivel("vida");
				pPrincipal.getPbVida().setValue(pPrincipal.getVida());
				
				lPuntosMejora.setText("Puntos mejora: " + pPrincipal.getPuntosMejora());
				
				getContentPane().revalidate();
			}
		});
		
		bSubirVelocidad.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				pPrincipal.SubirNivel("velocidad");
				pPrincipal.getPbVelocidad().setValue(pPrincipal.getVelocidad());
				
				lPuntosMejora.setText("Puntos mejora: " + pPrincipal.getPuntosMejora());
				
				getContentPane().revalidate();
				
			}
		});
		
		
		
	}
	
	public static void main(String[] args) {
		
		PersonajeJugable pPrincip = new PersonajeJugable("", new Point(0, 0), 1, 1, 1);
		pPrincip.setPuntosMejora(10);
		VentanaMejoras vm = new VentanaMejoras(pPrincip);
		
		vm.setVisible(true);
	}

}
