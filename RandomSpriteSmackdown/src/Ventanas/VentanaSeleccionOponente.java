package Ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.sound.sampled.Clip;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import Personalizados.JLabelGraficoAjustado;
import Personalizados.JPanelBackground;
import Usuarios.UsuariosValidar;
import control.ControlHistoria;
import control.Nivel;
import control.Sonidos;
import control.MouseAdapters.MouseAdapterBotonesMenus;
import control.MouseAdapters.MouseAdapterPreviousNext;
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
		//Creacion de font
		
		try {
		     GraphicsEnvironment ge = 
		         GraphicsEnvironment.getLocalGraphicsEnvironment();
		     ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("fonts/SoulCalibur.ttf")));
		     ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("fonts/UnrealT.ttf")));
		     ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("fonts/Play Pretend.otf")));
		} catch (IOException|FontFormatException e) {
		     //Handle exception
		}
		
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
		setSize(1450, 600);
		setUndecorated(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		// Creacion de contenedores
		JPanelBackground pFondo = new JPanelBackground("src/FondoMadera.png");
			pFondo.setLayout(new BorderLayout());
		
		JPanel panelSuperior = new JPanel(new GridBagLayout());
			JLabel labelTitulo = new JLabel("Seleccion De Sticman");
			labelTitulo.setFont(new Font("SoulCalibur", Font.TRUETYPE_FONT, 80));
			labelTitulo.setForeground(Color.ORANGE);
		JPanel panelCentral = new JPanel();
		panelCentral.setLayout(new GridLayout(1, 2));
			JPanel panelIzquierdo = new JPanel(new FlowLayout());
				JPanel panelIzInterior = new JPanel(new BorderLayout());			
			JPanel panelInteriorCentral = new JPanel(new BorderLayout());
				labelImage = new JLabelGraficoAjustado("png/Idle (1).png", 400, 300);
				labelImage.setPreferredSize(new Dimension(350, 400));
			JPanel panelInteriorInferior = new JPanel(new GridLayout(0, 2));
				JButton atras = new JButton("Previous");
				JButton siguiente = new JButton("Next");
				
			JPanel panelDerInterior = new JPanel(new BorderLayout());
				JPanel pEstadisticas = new JPanel(new BorderLayout());
					JPanel pEstatsLabel = new JPanel(new GridBagLayout());
						JLabel lEstadisticas = new JLabel("Estadisticas");
					JPanel pEstatsPb = new JPanel(new GridLayout(3, 1));
						JPanel pFuerza = new JPanel(new FlowLayout());
							JPanel pFuerzaLabel = new JPanel(new GridBagLayout());
								JLabel lFuerza = new JLabel("Fuerza");
							JPanel pFuerzaPb = new JPanel(new GridBagLayout());
								JProgressBar pbFuerza = VentanaCreacionPersonaje.FormatearPb(personajeSeleccionadoIzquierda.getPbFuerza(), 170, 22);
						JPanel pVida = new JPanel(new FlowLayout());
							JPanel pVidaLabel = new JPanel(new GridBagLayout());
								JLabel lVida = new JLabel("Vida");
							JPanel pVidaPb = new JPanel(new GridBagLayout());
								JProgressBar pbVida = VentanaCreacionPersonaje.FormatearPb(personajeSeleccionadoIzquierda.getPbVida(), 170, 22);
						JPanel pVelocidad = new JPanel(new FlowLayout());
							JPanel pVelocidadLabel = new JPanel(new GridBagLayout());
								JLabel lVelo = new JLabel("Velocidad");
							JPanel pVelocidadPb = new JPanel(new GridBagLayout());
								JProgressBar pbVelo = VentanaCreacionPersonaje.FormatearPb(personajeSeleccionadoIzquierda.getPbVelocidad(), 170, 22);
							
		JPanel panelDerecho = new JPanel();
			JPanel panelIzInterior1 = new JPanel(new BorderLayout());
				JPanel panelInteriorCentral1 = new JPanel(new BorderLayout());
					labelImage1 = new JLabelGraficoAjustado("png/Idle (1).png", 400, 300);
					labelImage1.setPreferredSize(new Dimension(350, 400));
				JPanel panelInteriorInferior1 = new JPanel(new GridLayout(1, 2));
					JButton atras1 = new JButton("Previous");
					JButton siguiente1 = new JButton("Next");
		
				JPanel panelDerInterior1 = new JPanel(new BorderLayout());
					JPanel pEstadisticas1 = new JPanel(new BorderLayout());
						JPanel pEstatsLabel1 = new JPanel(new GridBagLayout());
							JLabel lEstadisticas1 = new JLabel("Estadisticas");
						JPanel pEstatsPb1 = new JPanel(new GridLayout(3, 1));
							JPanel pFuerza1 = new JPanel(new FlowLayout());
								JPanel pFuerza1Label = new JPanel(new GridBagLayout());
									JLabel lFuerza1 = new JLabel("Fuerza");
								JPanel pFuerzaPb1 = new JPanel(new GridBagLayout());
									JProgressBar pbFuerza1 = VentanaCreacionPersonaje.FormatearPb(personajeSeleccionadoDerecha.getPbFuerza(), 170, 22);
								JPanel pVida1 = new JPanel(new FlowLayout());
									JPanel pVida1Label = new JPanel(new GridBagLayout());
										JLabel lVida1 = new JLabel("Vida");
									JPanel pVida1Pb = new JPanel(new GridBagLayout());
										JProgressBar pbVida1 = VentanaCreacionPersonaje.FormatearPb(personajeSeleccionadoDerecha.getPbVida(), 170, 22);
								JPanel pVelocidad1 = new JPanel(new FlowLayout());
									JPanel pVelocidad1Label = new JPanel(new GridBagLayout());
										JLabel lVelo1 = new JLabel("Velocidad");
									JPanel pVelocidadPb1 = new JPanel(new GridBagLayout());
										JProgressBar pbVelo1 = VentanaCreacionPersonaje.FormatearPb(personajeSeleccionadoDerecha.getPbVelocidad(), 170, 22);
						
		JPanel panelInferior = new JPanel(new GridLayout(1, 2));
			JPanel panelIzInferior = new JPanel(new FlowLayout(FlowLayout.LEFT));
				JButton bAtras = new JButton("Home");
			JPanel panelDerInferior = new JPanel(new FlowLayout(FlowLayout.RIGHT));
				JButton bConfirmar = new JButton("Confirmar");
		
		//Modificación de componentes
		panelSuperior.setPreferredSize(new Dimension(1400, 120));
		panelIzInterior.setPreferredSize(new Dimension(350, 390));
		panelIzInterior1.setPreferredSize(new Dimension(350, 390));
		
		panelInteriorCentral.setBorder(BorderFactory.createLineBorder(Color.black, 5));
		panelInteriorCentral.setBackground(Color.LIGHT_GRAY);
		
		panelInteriorCentral1.setBorder(BorderFactory.createLineBorder(Color.black, 5));
		panelInteriorCentral1.setBackground(Color.LIGHT_GRAY);
		
		pEstatsLabel.setPreferredSize(new Dimension(200, 100));
		pFuerzaLabel.setPreferredSize(new Dimension(130, 40));
		pVidaLabel.setPreferredSize(new Dimension(130, 40));
		pVelocidadLabel.setPreferredSize(new Dimension(130, 40));
		pFuerzaLabel.setBackground(Color.LIGHT_GRAY);
		pVidaLabel.setBackground(Color.LIGHT_GRAY);
		pVelocidadLabel.setBackground(Color.LIGHT_GRAY);
		pFuerzaLabel.setBorder(BorderFactory.createLineBorder(Color.black, 3));
		pVidaLabel.setBorder(BorderFactory.createLineBorder(Color.black, 3));
		pVelocidadLabel.setBorder(BorderFactory.createLineBorder(Color.black, 3));
		
		pFuerzaPb.setPreferredSize(new Dimension(180, 50));
		pVidaPb.setPreferredSize(new Dimension(180, 50));
		pVelocidadPb.setPreferredSize(new Dimension(180, 50));
		
		lEstadisticas.setFont(new Font("Play Pretend", Font.TRUETYPE_FONT, 26));
		lEstadisticas.setForeground(Color.orange);
		lFuerza.setFont(new Font("Play Pretend", Font.TRUETYPE_FONT, 19));
		lVida.setFont(new Font("Play Pretend", Font.TRUETYPE_FONT, 19));
		lVelo.setFont(new Font("Play Pretend", Font.TRUETYPE_FONT, 19));
		
		pEstatsLabel1.setPreferredSize(new Dimension(200, 100));
		pFuerza1Label.setPreferredSize(new Dimension(130, 40));
		pVida1Label.setPreferredSize(new Dimension(130, 40));
		pVelocidad1Label.setPreferredSize(new Dimension(130, 40));
		pFuerza1Label.setBackground(Color.LIGHT_GRAY);
		pVida1Label.setBackground(Color.LIGHT_GRAY);
		pVelocidad1Label.setBackground(Color.LIGHT_GRAY);
		pFuerza1Label.setBorder(BorderFactory.createLineBorder(Color.black, 3));
		pVida1Label.setBorder(BorderFactory.createLineBorder(Color.black, 3));
		pVelocidad1Label.setBorder(BorderFactory.createLineBorder(Color.black, 3));
		
		pFuerzaPb1.setPreferredSize(new Dimension(180, 50));
		pVida1Pb.setPreferredSize(new Dimension(180, 50));
		pVelocidadPb1.setPreferredSize(new Dimension(180, 50));
		
		lEstadisticas1.setFont(new Font("Play Pretend", Font.TRUETYPE_FONT, 26));
		lEstadisticas1.setForeground(Color.orange);
		lFuerza1.setFont(new Font("Play Pretend", Font.TRUETYPE_FONT, 19));
		lVida1.setFont(new Font("Play Pretend", Font.TRUETYPE_FONT, 19));
		lVelo1.setFont(new Font("Play Pretend", Font.TRUETYPE_FONT, 19));
		
		//Botones
		atras.setFont(new Font("Play Pretend", Font.TRUETYPE_FONT, 17));
		atras.setForeground(Color.ORANGE);
		atras.setPreferredSize(new Dimension(120, 30));
		atras.setFocusPainted(false);
		atras.setBackground(Color.darkGray);
		atras.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		
		siguiente.setFont(new Font("Play Pretend", Font.TRUETYPE_FONT, 17));
		siguiente.setForeground(Color.ORANGE);
		siguiente.setPreferredSize(new Dimension(120, 30));
		siguiente.setFocusPainted(false);
		siguiente.setBackground(Color.darkGray);
		siguiente.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		
		atras1.setFont(new Font("Play Pretend", Font.TRUETYPE_FONT, 17));
		atras1.setForeground(Color.ORANGE);
		atras1.setPreferredSize(new Dimension(120, 30));
		atras1.setFocusPainted(false);
		atras1.setBackground(Color.darkGray);
		atras1.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		
		siguiente1.setFont(new Font("Play Pretend", Font.TRUETYPE_FONT, 17));
		siguiente1.setForeground(Color.ORANGE);
		siguiente1.setPreferredSize(new Dimension(120, 30));
		siguiente1.setFocusPainted(false);
		siguiente1.setBackground(Color.darkGray);
		siguiente1.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		
		bAtras.setFont(new Font("Play Pretend", Font.TRUETYPE_FONT, 16));
		bAtras.setForeground(Color.ORANGE);
		bAtras.setPreferredSize(new Dimension(100, 30));
		bAtras.setFocusPainted(false);
		bAtras.setBackground(Color.black);
		bAtras.setBorder(BorderFactory.createLineBorder(Color.lightGray, 1));
		
		bConfirmar.setFont(new Font("Play Pretend", Font.TRUETYPE_FONT, 16));
		bConfirmar.setForeground(Color.ORANGE);
		bConfirmar.setPreferredSize(new Dimension(120, 30));
		bConfirmar.setFocusPainted(false);
		bConfirmar.setBackground(Color.black);
		bConfirmar.setBorder(BorderFactory.createLineBorder(Color.lightGray, 1));
		
		//Opaques
		panelSuperior.setOpaque(false);
		panelCentral.setOpaque(false);
		panelInferior.setOpaque(false);
		panelDerecho.setOpaque(false);
		panelIzquierdo.setOpaque(false);
		panelDerInferior.setOpaque(false);
		panelIzInferior.setOpaque(false);
		panelDerInterior.setOpaque(false);
		panelDerInterior1.setOpaque(false);
		pEstadisticas.setOpaque(false);
		pEstadisticas1.setOpaque(false);
		pEstatsLabel.setOpaque(false);
		pEstatsLabel1.setOpaque(false);
		pEstatsPb.setOpaque(false);
		pEstatsPb1.setOpaque(false);
		pVida.setOpaque(false);
		pFuerza.setOpaque(false);
		pVelocidad.setOpaque(false);
		pVida1.setOpaque(false);
		pFuerza1.setOpaque(false);
		pVelocidad1.setOpaque(false);
		pVidaPb.setOpaque(false);
		pFuerzaPb.setOpaque(false);
		pVelocidadPb.setOpaque(false);
		pVida1Pb.setOpaque(false);
		pFuerzaPb1.setOpaque(false);
		pVelocidadPb1.setOpaque(false);
		
		//// Añadir a contenedores
		
		add(pFondo);
		
		pFondo.add(panelSuperior, BorderLayout.NORTH);
			panelSuperior.add(labelTitulo);
		pFondo.add(panelCentral, BorderLayout.CENTER);
			panelCentral.add(panelIzquierdo);
				panelIzquierdo.add(panelIzInterior);
					panelIzInterior.add(panelInteriorCentral, BorderLayout.CENTER);
						panelInteriorCentral.add(labelImage);
					panelIzInterior.add(panelInteriorInferior, BorderLayout.SOUTH);
						panelInteriorInferior.add(atras);
							panelInteriorInferior.add(siguiente);
				panelIzquierdo.add(panelDerInterior);
					panelDerInterior.add(pEstadisticas);
						pEstadisticas.add(pEstatsLabel, BorderLayout.NORTH);
							pEstatsLabel.add(lEstadisticas);
						pEstadisticas.add(pEstatsPb, BorderLayout.CENTER);
							pEstatsPb.add(pVida);
								pVida.add(pVidaLabel);
									pVidaLabel.add(lVida);
								pVida.add(pVidaPb);
									pVidaPb.add(pbVida);
							pEstatsPb.add(pFuerza);
								pFuerza.add(pFuerzaLabel);
									pFuerzaLabel.add(lFuerza);
								pFuerza.add(pFuerzaPb);
									pFuerzaPb.add(pbFuerza);
							pEstatsPb.add(pVelocidad);
								pVelocidad.add(pVelocidadLabel);
									pVelocidadLabel.add(lVelo);
								pVelocidad.add(pVelocidadPb);
									pVelocidadPb.add(pbVelo);
			panelCentral.add(panelDerecho);
				panelDerecho.add(panelIzInterior1);
					panelIzInterior1.add(panelInteriorCentral1, BorderLayout.CENTER);
						panelInteriorCentral1.add(labelImage1);
					panelIzInterior1.add(panelInteriorInferior1, BorderLayout.SOUTH);
						panelInteriorInferior1.add(atras1);
							panelInteriorInferior1.add(siguiente1);
				panelDerecho.add(panelDerInterior1);
					panelDerInterior1.add(pEstadisticas1);
						pEstadisticas1.add(pEstatsLabel1, BorderLayout.NORTH);
							pEstatsLabel1.add(lEstadisticas1);
						pEstadisticas1.add(pEstatsPb1, BorderLayout.CENTER);
							pEstatsPb1.add(pVida1);
								pVida1.add(pVida1Label);
									pVida1Label.add(lVida1);
								pVida1.add(pVida1Pb);
									pVida1Pb.add(pbVida1);
							pEstatsPb1.add(pFuerza1);
								pFuerza1.add(pFuerza1Label);
									pFuerza1Label.add(lFuerza1);
								pFuerza1.add(pFuerzaPb1);
									pFuerzaPb1.add(pbFuerza1);
							pEstatsPb1.add(pVelocidad1);
								pVelocidad1.add(pVelocidad1Label);
									pVelocidad1Label.add(lVelo1);
								pVelocidad1.add(pVelocidadPb1);
									pVelocidadPb1.add(pbVelo1);
		pFondo.add(panelInferior, BorderLayout.SOUTH);
			panelInferior.add(panelIzInferior);
				panelIzInferior.add(bAtras);
			panelInferior.add(panelDerInferior);
				panelDerInferior.add(bConfirmar);
			
		
		// Listeners
		atras.addMouseListener(new MouseAdapterPreviousNext(atras));
		atras.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent e) {
				personajeSeleccionadoIzquierda  = cambiarAnterior(personajeSeleccionadoIzquierda, listaPersonajesIzquierda);
				ElegirLabel(personajeSeleccionadoIzquierda, labelImage);
				
				pFuerzaPb.removeAll();
				pFuerzaPb.add(VentanaCreacionPersonaje.FormatearPb(personajeSeleccionadoIzquierda.getPbFuerza(), 170, 22));
				pVelocidadPb.removeAll();
				pVelocidadPb.add(VentanaCreacionPersonaje.FormatearPb(personajeSeleccionadoIzquierda.getPbVelocidad(), 170, 22));
				pVidaPb.removeAll();
				pVidaPb.add(VentanaCreacionPersonaje.FormatearPb(personajeSeleccionadoIzquierda.getPbVida(), 170, 22));
				revalidate();
				repaint();
		
			}
		});
		
		siguiente.addMouseListener(new MouseAdapterPreviousNext(siguiente));
		siguiente.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent e) {
				personajeSeleccionadoIzquierda = cambiarSiguiente(personajeSeleccionadoIzquierda, listaPersonajesIzquierda);
				ElegirLabel(personajeSeleccionadoIzquierda, labelImage);
				
				pFuerzaPb.removeAll();
				pFuerzaPb.add(VentanaCreacionPersonaje.FormatearPb(personajeSeleccionadoIzquierda.getPbFuerza(), 170, 22));
				pVelocidadPb.removeAll();
				pVelocidadPb.add(VentanaCreacionPersonaje.FormatearPb(personajeSeleccionadoIzquierda.getPbVelocidad(), 170, 22));
				pVidaPb.removeAll();
				pVidaPb.add(VentanaCreacionPersonaje.FormatearPb(personajeSeleccionadoIzquierda.getPbVida(), 170, 22));
				
				revalidate();
				repaint();
		
			}
		});
		
		atras1.addMouseListener(new MouseAdapterPreviousNext(atras1));
		atras1.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent e) {
				personajeSeleccionadoDerecha = cambiarAnterior(personajeSeleccionadoDerecha, listaPersonajesDerecha);
				ElegirLabel(personajeSeleccionadoDerecha, labelImage1);
				
				pFuerzaPb1.removeAll();
				pFuerzaPb1.add(VentanaCreacionPersonaje.FormatearPb(personajeSeleccionadoDerecha.getPbFuerza(), 170, 22));
				pVelocidadPb1.removeAll();
				pVelocidadPb1.add(VentanaCreacionPersonaje.FormatearPb(personajeSeleccionadoDerecha.getPbVelocidad(), 170, 22));
				pVida1Pb.removeAll();
				pVida1Pb.add(VentanaCreacionPersonaje.FormatearPb(personajeSeleccionadoDerecha.getPbVida(), 170, 22));
				
				revalidate();
				repaint();
			}
		});
		
		siguiente1.addMouseListener(new MouseAdapterPreviousNext(siguiente1));
		siguiente1.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent e) {
				personajeSeleccionadoDerecha = cambiarSiguiente(personajeSeleccionadoDerecha, listaPersonajesDerecha);
				ElegirLabel(personajeSeleccionadoDerecha, labelImage1);
				
				pFuerzaPb1.removeAll();
				pFuerzaPb1.add(VentanaCreacionPersonaje.FormatearPb(personajeSeleccionadoDerecha.getPbFuerza(), 170, 22));
				pVelocidadPb1.removeAll();
				pVelocidadPb1.add(VentanaCreacionPersonaje.FormatearPb(personajeSeleccionadoDerecha.getPbVelocidad(), 170, 22));
				pVida1Pb.removeAll();
				pVida1Pb.add(VentanaCreacionPersonaje.FormatearPb(personajeSeleccionadoDerecha.getPbVida(), 170, 22));
				
				revalidate();
				repaint();
		
			}
		});
		
		bAtras.addMouseListener(new MouseAdapterBotonesMenus(bAtras));
		bAtras.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent e) {
				
				VentanaPrincipal ventana = new VentanaPrincipal(codigo, user, pPrincipal, nivelesCompletados,
						victorias1v1);
				ventana.setVisible(true);
				VentanaSeleccionOponente.this.dispose();
			}
		});
		
		bConfirmar.addMouseListener(new MouseAdapterBotonesMenus(bConfirmar));
		bConfirmar.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent e) {
		
				if(UnoVUno) {
					VentanaStage vs = new VentanaStage(personajeSeleccionadoIzquierda, personajeSeleccionadoDerecha, 0, ch, false,null);
					vs.setVisible(true);
					VentanaSeleccionOponente.this.dispose();
				}else {
					Enemigo enem = new Enemigo(new Point(100, 0), (int)personajeSeleccionadoDerecha.getFuerza(), 
							(int)personajeSeleccionadoDerecha.getVida(), (int)personajeSeleccionadoDerecha.getVelocidad(), 
							personajeSeleccionadoDerecha.getTipoPersonaje(), 1);
					
					VentanaStage vs = new VentanaStage(personajeSeleccionadoIzquierda, enem, 0, ch, false,null);
					vs.setVisible(true);
					VentanaSeleccionOponente.this.dispose();
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
		lImagen.setPreferredSize(new Dimension(350, 400));
	}
	if(personajeSeleccionado.getTipoPersonaje().equals("ninja")) {
		lImagen.setImagen("pngEnem/Idle__000.png");
		lImagen.setSize(200, 300);
		lImagen.setPreferredSize(new Dimension(350, 400));
	}
	if(personajeSeleccionado.getTipoPersonaje().equals("caballero")) {
		lImagen.setImagen("pngEnem2/Idle (1).png");
		lImagen.setSize(350, 350);
		lImagen.setPreferredSize(new Dimension(350, 400));
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
