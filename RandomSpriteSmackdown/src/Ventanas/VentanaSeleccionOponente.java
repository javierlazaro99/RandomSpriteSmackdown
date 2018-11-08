package Ventanas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Personalizados.JLabelGraficoAjustado;
import Usuarios.UsuariosValidar;
import control.ControlHistoria;
import personaje.personajeJugable.PersonajeJugable;
	
public class VentanaSeleccionOponente extends JFrame{
	private ArrayList<PersonajeJugable> listaPersonajes1 = new ArrayList<PersonajeJugable>();
	private ArrayList<PersonajeJugable> listaPersonajes = new ArrayList<PersonajeJugable>();
	private PersonajeJugable personajeSeleccionado;
	private PersonajeJugable personajeSeleccionado1;
	private PersonajeJugable personajeCreado;
	
	private PersonajeJugable personajeRegular = new PersonajeJugable(null, new Point(0, 0), 10, 10, 10);
	private PersonajeJugable personajeRápido = new PersonajeJugable(null, new Point(0, 0), 5, 5, 20);
	private PersonajeJugable personajeLento = new PersonajeJugable(null, new Point(0, 0), 15, 10, 5);
	private PersonajeJugable personajeRegular1 = new PersonajeJugable(null, new Point(0, 0), 10, 10, 10);
	private PersonajeJugable personajeRápido1 = new PersonajeJugable(null, new Point(0, 0), 5, 5, 20);
	private PersonajeJugable personajeLento1 = new PersonajeJugable(null, new Point(0, 0), 15, 10, 5);
	public VentanaSeleccionOponente(int codigo, UsuariosValidar user, PersonajeJugable pPrincipal, int nivelesCompletados, int victorias1v1) {
		// TODO Auto-generated constructor stub
		listaPersonajes.add(personajeRegular); listaPersonajes.add(personajeRápido); listaPersonajes.add(personajeLento);listaPersonajes.add(pPrincipal);
		personajeSeleccionado = listaPersonajes.get(0);
		listaPersonajes1.add(personajeRegular1); listaPersonajes1.add(personajeRápido1); listaPersonajes1.add(personajeLento1);
		personajeSeleccionado1 = listaPersonajes1.get(0);
		personajeCreado = null;
		
		setTitle("Seleccion de Srickmans");
		setSize(1400, 600);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		
		//Creacion de contenedores
		
		JPanel panelSuperior = new JPanel();
				JLabel labelTitulo = new JLabel("SELECCION DE STICMAN");
				labelTitulo.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 16));
		JPanel panelCentral = new JPanel();
		panelCentral.setLayout(new FlowLayout());
				JPanel panelIzquierdo = new JPanel();
					//panelIzquierdo.setLayout(new GridLayout(1,1));
					JPanel panelIzInterior = new JPanel();	
						panelIzInterior.setLayout(new BorderLayout());
						JPanel panelInteriorCentral = new JPanel();
							JLabelGraficoAjustado labelImage = new JLabelGraficoAjustado("",300 , 400);
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
						JPanel panelInteriorCentral1 = new JPanel();
							JLabelGraficoAjustado labelImage1 = new JLabelGraficoAjustado("",300 , 400);
						JPanel panelInteriorInferior1 = new JPanel();
						panelInteriorInferior1.setLayout(new GridLayout(0, 2));
							JButton atras1 = new JButton("Previous");
							JButton siguiente1 = new JButton("Next");
					JPanel panelDerInterior1 = new JPanel();
						JPanel pEstadisticas1 = new JPanel(new GridLayout(4, 1));
							JLabel lEstadisticas1 = new JLabel("Estadísticas");
						JPanel pFuerza1 = new JPanel(new FlowLayout());
						JPanel pVida1 = new JPanel(new FlowLayout());
						JPanel pVelocidad1 = new JPanel(new FlowLayout());
		JPanel panelInferior = new JPanel();
		panelInferior.setLayout(new GridLayout(0, 2));
				JPanel panelIzInferior = new JPanel();
				panelIzInferior.setLayout(new FlowLayout(FlowLayout.LEFT));
					JButton bAtras = new JButton("Home");
				JPanel panelDerInferior = new JPanel();
				panelDerInferior.setLayout(new FlowLayout(FlowLayout.RIGHT));
					JButton bConfirmar = new JButton("Confirmar");
		//Añadir a contenedores
		add(panelSuperior,BorderLayout.NORTH);
			panelSuperior.add(labelTitulo);
		add(panelCentral,BorderLayout.CENTER);
			panelCentral.add(panelIzquierdo);
				panelIzquierdo.add(panelIzInterior);
					panelIzInterior.add(panelInteriorCentral,BorderLayout.CENTER);
						panelInteriorCentral.add(labelImage);
					panelIzInterior.add(panelInteriorInferior,BorderLayout.SOUTH);
						panelInteriorInferior.add(atras);
						panelInteriorInferior.add(siguiente);
				panelIzquierdo.add(panelDerInterior);
					panelDerInterior.add(pEstadisticas);
						pEstadisticas.add(lEstadisticas);
					pEstadisticas.add(pVida);
						pVida.add(new JLabel("Vida"));	
						pVida.add(personajeSeleccionado.getPbVida());
					pEstadisticas.add(pFuerza);
						pFuerza.add(new JLabel("Fuerza"));
						pFuerza.add(personajeSeleccionado.getPbFuerza());
					pEstadisticas.add(pVelocidad);
						pVelocidad.add(new JLabel("Velocidad"));
						pVelocidad.add(personajeSeleccionado.getPbVelocidad());
			panelCentral.add(panelDerecho);
				panelDerecho.add(panelIzInterior1);
					panelIzInterior1.add(panelInteriorCentral1,BorderLayout.CENTER);
						panelInteriorCentral1.add(labelImage1);
					panelIzInterior1.add(panelInteriorInferior1,BorderLayout.SOUTH);
						panelInteriorInferior1.add(atras1);
						panelInteriorInferior1.add(siguiente1);
				panelDerecho.add(panelDerInterior1);
					panelDerInterior1.add(pEstadisticas1);
						pEstadisticas1.add(lEstadisticas1);
					pEstadisticas1.add(pVida1);
							pVida1.add(new JLabel("Vida"));
							pVida1.add(personajeSeleccionado1.getPbVida());
							pEstadisticas1.add(pFuerza1);
								pFuerza1.add(new JLabel("Fuerza"));
								pFuerza1.add(personajeSeleccionado1.getPbFuerza());
							pEstadisticas1.add(pVelocidad1);
								pVelocidad1.add(new JLabel("Velocidad"));
								pVelocidad1.add(personajeSeleccionado1.getPbVelocidad());
	add(panelInferior,BorderLayout.SOUTH);	
		panelInferior.add(panelIzInferior);
				panelIzInferior.add(bAtras);
			panelInferior.add(panelDerInferior);
				panelDerInferior.add(bConfirmar);
	//Listeners
		atras.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cambiarAnterior(personajeSeleccionado);
				labelImage.removeAll();
				labelImage.add(personajeSeleccionado.getlPersonaje());
				cambioDeJprogresBar(personajeSeleccionado, pFuerza, pVida, pVelocidad);
				repaint();
				
			}
		});
		siguiente.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cambiarSiguiente(personajeSeleccionado);
				labelImage.removeAll();
				labelImage.add(personajeSeleccionado.getlPersonaje());
				
				cambioDeJprogresBar(personajeSeleccionado, pFuerza, pVida, pVelocidad);
				repaint();
				
			}
		});	
		atras1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cambiarAnterior(personajeSeleccionado1);
				labelImage1.removeAll();
				labelImage1.add(personajeSeleccionado1.getlPersonaje());
				cambioDeJprogresBar(personajeSeleccionado1, pFuerza1, pVida1, pVelocidad1);
				repaint();
				
				
			}
		});
		siguiente1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cambiarSiguiente(personajeSeleccionado1);
				labelImage.removeAll();
				labelImage.add(personajeSeleccionado1.getlPersonaje());
				cambioDeJprogresBar(personajeSeleccionado1, pFuerza1, pVida1, pVelocidad1);
				repaint();
				
				
			}
		});
		bAtras.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				VentanaPrincipal ventana = new VentanaPrincipal(codigo,user,pPrincipal,nivelesCompletados,victorias1v1);
				ventana.setVisible(true);
				VentanaSeleccionOponente.this.dispose();
			}
		});
		bConfirmar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
	}
	/**
	 * Método para escoger el siguiente personaje seleccionable de la lista de personajes que se 
	 * le muestran al jugador
	 */
	private void cambiarSiguiente(PersonajeJugable personajeSeleccionado ) {
		PersonajeJugable personajeParaCambiar;
		if(listaPersonajes.indexOf(personajeSeleccionado) != listaPersonajes.size() - 1) {
			personajeParaCambiar = listaPersonajes.get(listaPersonajes.indexOf(personajeSeleccionado) + 1);
		}else {
			personajeParaCambiar = listaPersonajes.get(0);
		}
		personajeSeleccionado = personajeParaCambiar;
	}
	
	/**
	 * Método para escoger el anterior personaje seleccionable de la lista de personajes que se 
	 * le muestran al jugador
	 */
	private void cambiarAnterior(PersonajeJugable personajeSeleccionado ) {
		PersonajeJugable personajeParaCambiar;
		if(listaPersonajes.indexOf(personajeSeleccionado) != 0) {
			personajeParaCambiar = listaPersonajes.get(listaPersonajes.indexOf(personajeSeleccionado) - 1);
		}else {
			personajeParaCambiar = listaPersonajes.get(listaPersonajes.size() - 1);
		}
		personajeSeleccionado = personajeParaCambiar;
	}
	private void cambioDeJprogresBar(PersonajeJugable personajeSeleccionado,JPanel pFuerza,JPanel pVida,JPanel pVelocidad ) {
		pFuerza.remove(1);
		pFuerza.add(personajeSeleccionado.getPbFuerza());
		pVida.remove(1);
		pVida.add(personajeSeleccionado.getPbVida());
		pVelocidad.remove(1);
		pVelocidad.add(personajeSeleccionado.getPbVelocidad());
		revalidate();
	}
	public PersonajeJugable devolverCreado() {
		return personajeCreado;
	}
	
	public static void main(String[] args) {
		VentanaSeleccionOponente ventana = new VentanaSeleccionOponente(null);
		ventana.setVisible(true);
	}
}
