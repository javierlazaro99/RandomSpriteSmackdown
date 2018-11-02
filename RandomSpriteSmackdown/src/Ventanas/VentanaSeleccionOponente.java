package Ventanas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Personalizados.JLabelGraficoAjustado;
import control.ControlHistoria;
import personaje.personajeJugable.PersonajeJugable;
	
public class VentanaSeleccionOponente extends JFrame{
	private ArrayList<PersonajeJugable> listaPersonajes = new ArrayList<PersonajeJugable>();
	private PersonajeJugable personajeSeleccionado;
	private PersonajeJugable personajeCreado;
	
	private PersonajeJugable personajeRegular = new PersonajeJugable(null, new Point(0, 0), 10, 10, 10);
	private PersonajeJugable personajeRápido = new PersonajeJugable(null, new Point(0, 0), 5, 5, 20);
	private PersonajeJugable personajeLento = new PersonajeJugable(null, new Point(0, 0), 15, 10, 5);
	
	public VentanaSeleccionOponente(PersonajeJugable personajePersonalizado) {
		// TODO Auto-generated constructor stub
		listaPersonajes.add(personajeRegular); listaPersonajes.add(personajeRápido); listaPersonajes.add(personajeLento);listaPersonajes.add(personajePersonalizado);
		personajeSeleccionado = listaPersonajes.get(0);
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
				panelIzquierdo.setLayout(new FlowLayout());
					JPanel panelIzInterior = new JPanel();	
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
					panelIzInterior.add(panelInteriorCentral);
						panelInteriorCentral.add(labelImage);
					panelIzInterior.add(panelInteriorInferior);
						panelInteriorInferior.add(atras);
						panelInteriorInferior.add(siguiente);
					panelDerInterior.add(pEstadisticas);
						pEstadisticas.add(lEstadisticas);
					panelDerInterior.add(pVida);
						pVida.add(new JLabel("Vida"));	
						pVida.add(personajeSeleccionado.getPbVida());
					panelDerInterior.add(pFuerza);
						pFuerza.add(new JLabel("Fuerza"));
						pFuerza.add(personajeSeleccionado.getPbFuerza());
					panelDerInterior.add(pVelocidad);
						pVelocidad.add(new JLabel("Velocidad"));
						pVelocidad.add(personajeSeleccionado.getPbVelocidad());
					
						
	}
	public static void main(String[] args) {
		VentanaSeleccionOponente ventana = new VentanaSeleccionOponente(null);
		ventana.setVisible(true);
	}
}
