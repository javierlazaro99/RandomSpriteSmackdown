package ventanas;

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

import control.ControlHistoria;
import personaje.personajeJugable.PersonajeJugable;
import personalizados.JLabelGraficoAjustado;
import usuarios.UsuariosValidar;

public class VentanaMejoras extends JFrame{
	
	private static final long serialVersionUID = 1L;

	public VentanaMejoras(UsuariosValidar user, ControlHistoria ch, int victorias1v1) {
		
		setSize(500, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		JPanel pIzquierda = new JPanel(new BorderLayout());
			JLabel lTitulo = new JLabel("Mejoras");
			JLabelGraficoAjustado lgaPersonaje = new JLabelGraficoAjustado("", 200, 200);
			JButton bHome = new JButton("Home");
		JPanel pDerecha = new JPanel(new BorderLayout());
			JLabel lPuntosMejora = new JLabel("Puntos de mejora: " + ch.getPersonajePrincipal().getPuntosMejora());
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
		
		System.out.println(ch.getPersonajePrincipal().getPbFuerza());
		
		pFuerza.add(new JLabel("Fuerza"));
		pFuerza.add(ch.getPersonajePrincipal().getPbFuerza());
		pFuerza.add(bSubirFuerza);
		
		pVida.add(new JLabel("Vida"));
		pVida.add(ch.getPersonajePrincipal().getPbVida());
		pVida.add(bSubirVida);
		
		pVelocidad.add(new JLabel("Velocidad"));
		pVelocidad.add(ch.getPersonajePrincipal().getPbVelocidad());
		pVelocidad.add(bSubirVelocidad);
		
		bSubirFuerza.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ch.getPersonajePrincipal().SubirNivel("fuerza");
				ch.getPersonajePrincipal().getPbFuerza().setValue((int) ch.getPersonajePrincipal().getFuerza());
				
				lPuntosMejora.setText("Puntos mejora: " + ch.getPersonajePrincipal().getPuntosMejora());
				
				getContentPane().revalidate();
			}
		});
		
		bSubirVida.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ch.getPersonajePrincipal().SubirNivel("vida");
				ch.getPersonajePrincipal().getPbVida().setValue((int) ch.getPersonajePrincipal().getVida());
				
				lPuntosMejora.setText("Puntos mejora: " + ch.getPersonajePrincipal().getPuntosMejora());
				
				getContentPane().revalidate();
			}
		});
		
		bSubirVelocidad.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ch.getPersonajePrincipal().SubirNivel("velocidad");
				ch.getPersonajePrincipal().getPbVelocidad().setValue((int) ch.getPersonajePrincipal().getVelocidad());
				
				lPuntosMejora.setText("Puntos mejora: " + ch.getPersonajePrincipal().getPuntosMejora());
				
				getContentPane().revalidate();
				
			}
		});
		
		bHome.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaSeleccionNivel ventana = new VentanaSeleccionNivel(user, ch, victorias1v1);
				ventana.setVisible(true);
				VentanaMejoras.this.dispose();
				
			}
		});	
		
	}

}
