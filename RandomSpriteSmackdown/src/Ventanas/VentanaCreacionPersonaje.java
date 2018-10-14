package Ventanas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Personalizados.JLabelGraficoAjustado;
import personaje.personajeJugable.PersonajeJugable;

public class VentanaCreacionPersonaje extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private ArrayList<PersonajeJugable> listaPersonajes = new ArrayList<>();
	private PersonajeJugable personajeCreado;
	
	public VentanaCreacionPersonaje() {
		
		setSize(700, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		JPanel pFondo = new JPanel(new BorderLayout());
			JPanel pTitulo = new JPanel(new FlowLayout(FlowLayout.CENTER));
				JLabel lTitulo = new JLabel("Creación de personaje");
				lTitulo.setFont(new Font("", Font.PLAIN, 40));
			JPanel pPrincipal = new JPanel(new GridLayout(1, 2));
				JPanel pIzquierda = new JPanel(new BorderLayout());
					JPanel pSprite = new JPanel(new BorderLayout());
						JLabelGraficoAjustado lPersonaje = new JLabelGraficoAjustado("Personaje 1", 50, 100);
					JPanel pCambioSprite = new JPanel(new FlowLayout(FlowLayout.CENTER));
						JButton bAtras = new JButton("Previous");
						JButton bAlante = new JButton("Next");
				JPanel pDerecha = new JPanel(new BorderLayout());
					JPanel pNombre = new JPanel(new GridLayout(2, 1));
						JLabel lNomb = new JLabel("Introduzca el nombre de su personaje:");
						JTextField tfNombre = new JTextField(10);
					JPanel pEstadisticas = new JPanel(new GridLayout(4, 1));
						JLabel lEstadisticas = new JLabel("Estadísticas");
						JPanel pFuerza = new JPanel(new FlowLayout());
						JPanel pVida = new JPanel(new FlowLayout());
						JPanel pVelocidad = new JPanel(new FlowLayout());
					JPanel pConfirmar = new JPanel(new FlowLayout(FlowLayout.CENTER));
						JButton bConfirmar = new JButton("OK");
			JPanel pSalida = new JPanel(new FlowLayout(FlowLayout.LEFT));
				JButton bSalir = new JButton("Salir");
		
		
		this.add(pFondo);
		
		pFondo.add(pTitulo, BorderLayout.NORTH);
			pTitulo.add(lTitulo);
		pFondo.add(pPrincipal, BorderLayout.CENTER);
			pPrincipal.add(pIzquierda);
				pIzquierda.add(pSprite, BorderLayout.CENTER);
					pSprite.add(lPersonaje, BorderLayout.CENTER);
				pIzquierda.add(pCambioSprite, BorderLayout.SOUTH);
					pCambioSprite.add(bAtras);
					pCambioSprite.add(bAlante);
			pPrincipal.add(pDerecha);
				pDerecha.add(pNombre, BorderLayout.NORTH);
					pNombre.add(lNomb);
					pNombre.add(tfNombre);
				pDerecha.add(pEstadisticas, BorderLayout.CENTER); 
					pEstadisticas.add(lEstadisticas);
					pEstadisticas.add(pFuerza);
						pFuerza.add(new JLabel("Fuerza"));
						//Añadir las barras de progreso de cada personaje
					pEstadisticas.add(pVida);
						pVida.add(new JLabel("Vida"));
					
					pEstadisticas.add(pVelocidad);
						pVelocidad.add(new JLabel("Velociad"));
						
				pDerecha.add(pConfirmar, BorderLayout.SOUTH);
					pConfirmar.add(bConfirmar);
		pFondo.add(pSalida, BorderLayout.SOUTH);
			pSalida.add(bSalir);	
				
	}
	
	
	public static void main(String[] args) {
		VentanaCreacionPersonaje vcp = new VentanaCreacionPersonaje();
		vcp.setVisible(true);
	}
	
	

}
