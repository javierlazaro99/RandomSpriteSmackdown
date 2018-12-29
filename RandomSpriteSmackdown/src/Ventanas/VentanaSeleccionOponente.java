package Ventanas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.sound.sampled.Clip;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import Personalizados.JLabelGraficoAjustado;
import Usuarios.UsuariosValidar;
import control.ControlHistoria;
import control.Nivel;
import control.Sonidos;
import personaje.Personaje;
import personaje.enemigo.Enemigo;
import personaje.personajeJugable.PersonajeJugable;

public class VentanaSeleccionOponente extends JFrame {
	private ArrayList<PersonajeJugable> listaPersonajesDerecha = new ArrayList<PersonajeJugable>();
	private ArrayList<PersonajeJugable> listaPersonajesIzquierda = new ArrayList<PersonajeJugable>();
	private PersonajeJugable personajeSeleccionadoIzquierda;
	private PersonajeJugable personajeSeleccionadoDerecha;
	private PersonajeJugable personajeCreado;

	private PersonajeJugable personajeRegular = new PersonajeJugable(null, new Point(0, 0), 10, 10, 10, "robot");
	private PersonajeJugable personajeRápido = new PersonajeJugable(null, new Point(0, 0), 5, 5, 20, "ninja");
	private PersonajeJugable personajeLento = new PersonajeJugable(null, new Point(0, 0), 15, 10, 5, "caballero");
	private PersonajeJugable enemigoRegular = new PersonajeJugable(null, new Point(0,0),10, 10, 10,"robot");
	private PersonajeJugable enemigoRapido = new PersonajeJugable(null, new Point(0,0),5, 5, 20,"ninja");
	private PersonajeJugable enemigoLento = new PersonajeJugable(null, new Point(0,0),15, 10, 5,"caballero");
	
	private JLabelGraficoAjustado labelImage;
	private JLabelGraficoAjustado labelImage1;

	public VentanaSeleccionOponente(int codigo, UsuariosValidar user, PersonajeJugable pPrincipal, int nivelesCompletados, int victorias1v1, ControlHistoria ch, boolean UnoVUno) {
		
		listaPersonajesIzquierda.add(personajeRegular);
		listaPersonajesIzquierda.add(personajeRápido);
		listaPersonajesIzquierda.add(personajeLento);
		personajeSeleccionadoIzquierda = listaPersonajesIzquierda.get(0);
		
		listaPersonajesDerecha.add(enemigoRegular);
		listaPersonajesDerecha.add(enemigoRapido);
		listaPersonajesDerecha.add(enemigoLento);
		personajeSeleccionadoDerecha = listaPersonajesDerecha.get(0);
		personajeCreado = null;

		setTitle("Seleccion de Srickmans");
		setSize(1400, 600);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);

		// Creacion de contenedores

		JPanel panelSuperior = new JPanel();
		JLabel labelTitulo = new JLabel("SELECCION DE STICMAN");
		labelTitulo.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 16));
		JPanel panelCentral = new JPanel();
		panelCentral.setLayout(new GridLayout(1,2));
		JPanel panelIzquierdo = new JPanel();
		// panelIzquierdo.setLayout(new GridLayout(1,1));
		JPanel panelIzInterior = new JPanel();
		panelIzInterior.setLayout(new BorderLayout());
		JPanel panelInteriorCentral = new JPanel(new BorderLayout());
		labelImage = new JLabelGraficoAjustado("png/Idle (1).png", 400, 300);
		labelImage.setPreferredSize(new Dimension(400, 400));
		JPanel panelInteriorInferior = new JPanel();
		panelInteriorInferior.setLayout(new GridLayout(0, 2));
		JButton atras = new JButton("Previous");
		JButton siguiente = new JButton("Next");
		JPanel panelDerInterior = new JPanel();
		JPanel pEstadisticas = new JPanel(new GridLayout(4, 1));
		JLabel lEstadisticas = new JLabel("Estadísticas");
		JPanel pFuerza = new JPanel(new FlowLayout());
		JPanel pVida = new JPanel(new FlowLayout());
		JPanel pVelocidad = new JPanel(new FlowLayout());
		JPanel panelDerecho = new JPanel();
		panelDerecho.setLayout(new FlowLayout());
		JPanel panelIzInterior1 = new JPanel();
		panelIzInterior1.setLayout(new BorderLayout());
		JPanel panelInteriorCentral1 = new JPanel(new BorderLayout());
		labelImage1 = new JLabelGraficoAjustado("png/Idle (1).png", 400, 300);
		labelImage1.setPreferredSize(new Dimension(400, 400));
		JPanel panelInteriorInferior1 = new JPanel();
		panelInteriorInferior1.setLayout(new GridLayout(1, 2));
		JButton atras1 = new JButton("Previous");
		JButton siguiente1 = new JButton("Next");
		JPanel panelDerInterior1 = new JPanel();
		JPanel pEstadisticas1 = new JPanel(new GridLayout(4, 1));
		JLabel lEstadisticas1 = new JLabel("Estadísticas");
		JPanel pFuerza1 = new JPanel(new FlowLayout());
		JPanel pVida1 = new JPanel(new FlowLayout());
		JPanel pVelocidad1 = new JPanel(new FlowLayout());
		JPanel panelInferior = new JPanel();
		panelInferior.setLayout(new GridLayout(1, 2));
		JPanel panelIzInferior = new JPanel();
		panelIzInferior.setLayout(new FlowLayout(FlowLayout.LEFT));
		JButton bAtras = new JButton("Home");
		JPanel panelDerInferior = new JPanel();
		panelDerInferior.setLayout(new FlowLayout(FlowLayout.RIGHT));
		JButton bConfirmar = new JButton("Confirmar");
		// Añadir a contenedores
		add(panelSuperior, BorderLayout.NORTH);
		panelSuperior.add(labelTitulo);
		add(panelCentral, BorderLayout.CENTER);
		panelCentral.add(panelIzquierdo);
		panelIzquierdo.add(panelIzInterior);
		panelIzInterior.add(panelInteriorCentral, BorderLayout.CENTER);
		panelInteriorCentral.add(labelImage);
		panelIzInterior.add(panelInteriorInferior, BorderLayout.SOUTH);
		panelInteriorInferior.add(atras);
		panelInteriorInferior.add(siguiente);
		panelIzquierdo.add(panelDerInterior);
		panelDerInterior.add(pEstadisticas);
		pEstadisticas.add(lEstadisticas);
		pEstadisticas.add(pVida);
		pVida.add(new JLabel("Vida"));
		pVida.add(personajeSeleccionadoIzquierda.getPbVida());
		pEstadisticas.add(pFuerza);
		pFuerza.add(new JLabel("Fuerza"));
		pFuerza.add(personajeSeleccionadoIzquierda.getPbFuerza());
		pEstadisticas.add(pVelocidad);
		pVelocidad.add(new JLabel("Velocidad"));
		pVelocidad.add(personajeSeleccionadoIzquierda.getPbVelocidad());
		panelCentral.add(panelDerecho);
		panelDerecho.add(panelIzInterior1);
		panelIzInterior1.add(panelInteriorCentral1, BorderLayout.CENTER);
		panelInteriorCentral1.add(labelImage1);
		panelIzInterior1.add(panelInteriorInferior1, BorderLayout.SOUTH);
		panelInteriorInferior1.add(atras1);
		panelInteriorInferior1.add(siguiente1);
		panelDerecho.add(panelDerInterior1);
		panelDerInterior1.add(pEstadisticas1);
		pEstadisticas1.add(lEstadisticas1);
		pEstadisticas1.add(pVida1);
		pVida1.add(new JLabel("Vida"));
		pVida1.add(personajeSeleccionadoDerecha.getPbVida());
		pEstadisticas1.add(pFuerza1);
		pFuerza1.add(new JLabel("Fuerza"));
		pFuerza1.add(personajeSeleccionadoDerecha.getPbFuerza());
		pEstadisticas1.add(pVelocidad1);
		pVelocidad1.add(new JLabel("Velocidad"));
		pVelocidad1.add(personajeSeleccionadoDerecha.getPbVelocidad());
		add(panelInferior, BorderLayout.SOUTH);
		panelInferior.add(panelIzInferior);
		panelIzInferior.add(bAtras);
		panelInferior.add(panelDerInferior);
		panelDerInferior.add(bConfirmar);
		// Listeners
		atras.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				personajeSeleccionadoIzquierda  = cambiarAnterior(personajeSeleccionadoIzquierda, listaPersonajesIzquierda);
				ElegirLabel(personajeSeleccionadoIzquierda, labelImage);
				
				pFuerza.remove(1);
				pFuerza.add(personajeSeleccionadoIzquierda.getPbFuerza());
				pVelocidad.remove(1);
				pVelocidad.add(personajeSeleccionadoIzquierda.getPbVelocidad());
				pVida.remove(1);
				pVida.add(personajeSeleccionadoIzquierda.getPbVida());
				revalidate();
				repaint();

			}
		});
		siguiente.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				personajeSeleccionadoIzquierda = cambiarSiguiente(personajeSeleccionadoIzquierda, listaPersonajesIzquierda);
				ElegirLabel(personajeSeleccionadoIzquierda, labelImage);
				
				pFuerza.remove(1);
				pFuerza.add(personajeSeleccionadoIzquierda.getPbFuerza());
				pVelocidad.remove(1);
				pVelocidad.add(personajeSeleccionadoIzquierda.getPbVelocidad());
				pVida.remove(1);
				pVida.add(personajeSeleccionadoIzquierda.getPbVida());
				
				revalidate();
				repaint();

			}
		});
		atras1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				personajeSeleccionadoDerecha = cambiarAnterior(personajeSeleccionadoDerecha, listaPersonajesDerecha);
				ElegirLabel(personajeSeleccionadoDerecha, labelImage1);
				
				pFuerza1.remove(1);
				pFuerza1.add(personajeSeleccionadoDerecha.getPbFuerza());
				pVelocidad1.remove(1);
				pVelocidad1.add(personajeSeleccionadoDerecha.getPbVelocidad());
				pVida1.remove(1);
				pVida1.add(personajeSeleccionadoDerecha.getPbVida());
				
				revalidate();
				repaint();
			}
		});
		siguiente1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				personajeSeleccionadoDerecha = cambiarSiguiente(personajeSeleccionadoDerecha, listaPersonajesDerecha);
				ElegirLabel(personajeSeleccionadoDerecha, labelImage1);
				
				pFuerza1.remove(1);				
				pFuerza1.add(personajeSeleccionadoDerecha.getPbFuerza());
				pVelocidad1.remove(1);
				pVelocidad1.add(personajeSeleccionadoDerecha.getPbVelocidad());
				pVida1.remove(1);
				pVida1.add(personajeSeleccionadoDerecha.getPbVida());
				
				revalidate();
				repaint();

			}
		});
		bAtras.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				VentanaPrincipal ventana = new VentanaPrincipal(codigo, user, pPrincipal, nivelesCompletados,
						victorias1v1);
				ventana.setVisible(true);
				VentanaSeleccionOponente.this.dispose();
			}
		});
		bConfirmar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
		
				if(UnoVUno) {
					VentanaStage vs = new VentanaStage(personajeSeleccionadoIzquierda, personajeSeleccionadoDerecha, 0, ch, false);
					vs.setVisible(true);
					dispose();
				}else {
					Enemigo enem = new Enemigo(new Point(100, 0), (int)personajeSeleccionadoDerecha.getFuerza(), 
							(int)personajeSeleccionadoDerecha.getVida(), (int)personajeSeleccionadoDerecha.getVelocidad(), 
							personajeSeleccionadoDerecha.getTipoPersonaje(), 1);
					
					VentanaStage vs = new VentanaStage(personajeSeleccionadoIzquierda, enem, 0, ch, false);
					vs.setVisible(true);
					dispose();
				}
			}
		});
	}

	/**
	 * Método para escoger el siguiente personaje seleccionable de la lista de
	 * personajes que se le muestran al jugador
	 */
	private PersonajeJugable cambiarSiguiente(Personaje personajeSeleccionado, ArrayList<PersonajeJugable> listaPersonajes) {
		PersonajeJugable personajeParaCambiar;
		if (listaPersonajes.indexOf(personajeSeleccionado) != listaPersonajes.size() - 1) {
			personajeParaCambiar = listaPersonajes.get(listaPersonajes.indexOf(personajeSeleccionado) + 1);
		} else {
			personajeParaCambiar = listaPersonajes.get(0);
		}
		return personajeParaCambiar;
	}

	/**
	 * Método para escoger el anterior personaje seleccionable de la lista de
	 * personajes que se le muestran al jugador
	 */
	private PersonajeJugable cambiarAnterior(PersonajeJugable personajeSeleccionado, ArrayList<PersonajeJugable> listaPersonajes) {
		PersonajeJugable personajeParaCambiar;
		
		if (listaPersonajes.indexOf(personajeSeleccionado) != 0) {
			personajeParaCambiar = listaPersonajes.get(listaPersonajes.indexOf(personajeSeleccionado) - 1);
			
		} else {
			personajeParaCambiar = listaPersonajes.get(listaPersonajes.size() - 1);
		}
		return personajeParaCambiar;
	}
	
	/**
	 * Selecciona el label adecuado para el nuevo personaje seleccionado de la lista de personajes
	 * @param personajeSeleccionado personaje de la lista actualmente seleccionado
	 * @param lImagen label que se quiere modificar su imagen
	 */
	private void ElegirLabel(PersonajeJugable personajeSeleccionado, JLabelGraficoAjustado lImagen) {
		
		if(personajeSeleccionado.getTipoPersonaje().equals("robot")) {
			lImagen.setImagen("png/Idle (1).png");
			lImagen.setSize(400, 300);
			lImagen.setPreferredSize(new Dimension(400, 400));
		}
		if(personajeSeleccionado.getTipoPersonaje().equals("ninja")) {
			lImagen.setImagen("pngEnem/Idle__000.png");
			lImagen.setSize(200, 300);
			lImagen.setPreferredSize(new Dimension(400, 400));
		}
		if(personajeSeleccionado.getTipoPersonaje().equals("caballero")) {
			lImagen.setImagen("pngEnem2/Idle (1).png");
			lImagen.setSize(350, 350);
			lImagen.setPreferredSize(new Dimension(400, 400));
		}
		
		revalidate();
		repaint();
	}
	
	public PersonajeJugable devolverCreado() {
		return personajeCreado;
	}

	public static void main(String[] args) {
		VentanaSeleccionOponente ventana = new VentanaSeleccionOponente(0,null, null, 0,0,null, true);
		ventana.setVisible(true);
	}
}
