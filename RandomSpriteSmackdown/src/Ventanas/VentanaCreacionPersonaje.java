package Ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.font.TextAttribute;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

import Personalizados.JLabelGraficoAjustado;
import Personalizados.JPanelBackground;
import Usuarios.UsuariosValidar;
import control.BaseDeDatos;
import control.ControlHistoria;
import personaje.Personaje;
import personaje.personajeJugable.PersonajeJugable;

public class VentanaCreacionPersonaje extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private ArrayList<PersonajeJugable> listaPersonajes = new ArrayList<PersonajeJugable>();
	private PersonajeJugable personajeSeleccionado;
	private PersonajeJugable personajeCreado;
	
	private PersonajeJugable personajeRegular = new PersonajeJugable(null, new Point(0, 0), 10, 10, 10, "robot");
	private PersonajeJugable personajeRápido = new PersonajeJugable(null, new Point(0, 0), 5, 5, 20, "ninja");
	private PersonajeJugable personajeLento = new PersonajeJugable(null, new Point(0, 0), 15, 10, 5, "caballero");
	
	private JLabelGraficoAjustado lImagen;
	
	
	public VentanaCreacionPersonaje(int codigo,UsuariosValidar user,PersonajeJugable pPrincipal1, ControlHistoria ch, int victorias1v1,int nivelesCompletados) {
		
		//Temporal mientras las pruebas
		try {
		     GraphicsEnvironment ge = 
		         GraphicsEnvironment.getLocalGraphicsEnvironment();
		     ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("fonts/SoulCalibur.ttf")));
		     ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("fonts/UnrealT.ttf")));
		     ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("fonts/Play Pretend.otf")));
		} catch (IOException|FontFormatException e) {
		     //Handle exception
		}
		
		listaPersonajes.add(personajeRegular); listaPersonajes.add(personajeRápido); listaPersonajes.add(personajeLento);
		personajeSeleccionado = listaPersonajes.get(0);
		personajeCreado = null;
		
		setSize(700, 600);
		setUndecorated(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		JPanel pFondo = new JPanelBackground("src/RockBackground.jpg");
		pFondo.setLayout(new BorderLayout());
			JPanel pTitulo = new JPanel(new FlowLayout(FlowLayout.CENTER));
				JLabel lTitulo = new JLabel("CREACION DE PERSONAJE");
				lTitulo.setFont(new Font("Unreal Tournament", Font.PLAIN, 40));
				lTitulo.setForeground(Color.ORANGE);
			JPanel pPrincipal = new JPanel(new GridLayout(1, 2));
				JPanel pIzquierda = new JPanel(new BorderLayout());
					JPanel pSprite = new JPanel(new BorderLayout());
						lImagen = new JLabelGraficoAjustado("png/Idle (1).png", 400, 300);
					JPanel pCambioSprite = new JPanel(new FlowLayout(FlowLayout.CENTER));
						JButton bAtras = new JButton("Previous");
							bAtras.setFont(new Font("Play Pretend", Font.PLAIN, 20));
						JButton bAlante = new JButton("Next");
							bAlante.setFont(new Font("Play Pretend", Font.PLAIN, 20));
				JPanel pDerecha = new JPanel(new BorderLayout());
					JPanel pNombre = new JPanel(new GridLayout(2, 1));
						JPanel pNombreLabel = new JPanel();
							JLabel lNomb = new JLabel("Nombre:");
							lNomb.setFont(new Font("Unreal Tournament", Font.PLAIN, 30));
							lNomb.setForeground(Color.ORANGE);
						JPanel pNombreTf = new JPanel();
							JTextField tfNombre = new JTextField(20);
					JPanel pEstadisticas = new JPanel(new GridLayout(5, 1));
						JPanel pVacio = new JPanel();
						JPanel pEstatsLabel = new JPanel();
							JLabel lEstadisticas = new JLabel("Estadísticas");
							lEstadisticas.setFont(new Font("Unreal Tournament", Font.PLAIN, 30));
							lEstadisticas.setForeground(Color.ORANGE);
							
							//Subrayado
							Font font = lEstadisticas.getFont();
							Map<TextAttribute, Object> attributes = new HashMap<>(font.getAttributes());
							attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
							lEstadisticas.setFont(font.deriveFont(attributes));
							
						JPanel pFuerza = new JPanel(new FlowLayout());
							JPanel pFuerzaLabel = new JPanel();
								JLabel lFuerza = new JLabel("Fuerza  ");
								lFuerza.setFont(new Font("Play Pretend", Font.PLAIN, 20));
								lFuerza.setForeground(Color.ORANGE);
							JPanel pFuerzaPb = new JPanel();
								JProgressBar pbFuerza = FormatearPb(personajeSeleccionado.getPbFuerza());
						JPanel pVida = new JPanel(new FlowLayout());
							JPanel pVidaLabel = new JPanel();
								JLabel lVida = new JLabel("Vida  ");
								lVida.setFont(new Font("Play Pretend", Font.PLAIN, 20));
								lVida.setForeground(Color.ORANGE);
							JPanel pVidaPb = new JPanel();
								JProgressBar pbVida = FormatearPb(personajeSeleccionado.getPbVida());
						JPanel pVelocidad = new JPanel(new FlowLayout());
							JPanel pVeloLabel = new JPanel();
								JLabel lVelo = new JLabel("Velocidad  ");
								lVelo.setFont(new Font("Play Pretend", Font.PLAIN, 20));
								lVelo.setForeground(Color.ORANGE);
							JPanel pVeloPb = new JPanel();
								JProgressBar pbVelo = FormatearPb(personajeSeleccionado.getPbVelocidad());
					JPanel pConfirmar = new JPanel(new FlowLayout(FlowLayout.CENTER));
						JButton bConfirmar = new JButton("Finalizar Creacion");
			JPanel pSalida = new JPanel(new FlowLayout(FlowLayout.LEFT));
				JButton bSalir = new JButton("Salir");
				
		
		//Modificación de componentes
		pTitulo.setPreferredSize(new Dimension(700, 70));
		pNombreLabel.setPreferredSize(new Dimension(100, 50));
		
		pFuerzaLabel.setPreferredSize(new Dimension(150, 34));
		pVidaLabel.setPreferredSize(new Dimension(150, 34));
		pVeloLabel.setPreferredSize(new Dimension(150, 34));
		
		pSprite.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
		pSprite.setBackground(Color.LIGHT_GRAY);
		
		pEstadisticas.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
		pEstadisticas.setBackground(Color.LIGHT_GRAY);
		
		pFuerzaLabel.setBorder(BorderFactory.createLineBorder(Color.darkGray, 3));
		pFuerzaLabel.setBackground(Color.black);
		pVidaLabel.setBorder(BorderFactory.createLineBorder(Color.darkGray, 3));
		pVidaLabel.setBackground(Color.BLACK);
		pVeloLabel.setBorder(BorderFactory.createLineBorder(Color.darkGray, 3));
		pVeloLabel.setBackground(Color.black);

		bAtras.setFont(new Font("Play Pretend", Font.TRUETYPE_FONT, 20));
		bAtras.setForeground(Color.ORANGE);
		bAtras.setPreferredSize(new Dimension(150, 50));
		bAtras.setFocusable(false);
		bAtras.setBackground(Color.black);
		bAtras.setBorder(BorderFactory.createLineBorder(Color.lightGray, 3));
		
		bAlante.setFont(new Font("Play Pretend", Font.TRUETYPE_FONT, 20));
		bAlante.setForeground(Color.ORANGE);
		bAlante.setPreferredSize(new Dimension(150, 50));
		bAlante.setFocusable(false);
		bAlante.setBackground(Color.black);
		bAlante.setBorder(BorderFactory.createLineBorder(Color.lightGray, 3));
		
		bConfirmar.setFont(new Font("Play Pretend", Font.TRUETYPE_FONT, 16));
		bConfirmar.setForeground(Color.ORANGE);
		bConfirmar.setPreferredSize(new Dimension(250, 50));
		bConfirmar.setFocusable(false);
		bConfirmar.setBackground(Color.black);
		bConfirmar.setBorder(BorderFactory.createLineBorder(Color.lightGray, 3));
		
		tfNombre.setFont(new Font("Play Pretend", Font.TRUETYPE_FONT, 20));
		tfNombre.setForeground(Color.orange);
		tfNombre.setHorizontalAlignment(SwingConstants.CENTER);
		tfNombre.setBackground(Color.BLACK);
		tfNombre.setBorder(BorderFactory.createLineBorder(Color.lightGray, 3));
		tfNombre.setPreferredSize(new Dimension(500, 35));
		
		bSalir.setFont(new Font("Play Pretend", Font.TRUETYPE_FONT, 17));
		bSalir.setForeground(Color.ORANGE);
		bSalir.setPreferredSize(new Dimension(120, 40));
		bSalir.setFocusable(false);
		bSalir.setBackground(Color.black);
		bSalir.setBorder(BorderFactory.createLineBorder(Color.lightGray, 3));
		
		//Opaques
		pTitulo.setOpaque(false);
		pPrincipal.setOpaque(false);
		pIzquierda.setOpaque(false);
		pDerecha.setOpaque(false);
		pNombre.setOpaque(false);
		pNombreLabel.setOpaque(false);
		pNombreTf.setOpaque(false);
		pVacio.setOpaque(false);
		pCambioSprite.setOpaque(false);
		pConfirmar.setOpaque(false);
		pSalida.setOpaque(false);
		pEstatsLabel.setOpaque(false);
		pFuerza.setOpaque(false);
		pVida.setOpaque(false);
		pVelocidad.setOpaque(false);
		pFuerzaPb.setOpaque(false);
		pVeloPb.setOpaque(false);
		pVidaPb.setOpaque(false);
		
		
		//Estructura de la ventana
		this.add(pFondo);
		
		pFondo.add(pTitulo, BorderLayout.NORTH);
			pTitulo.add(lTitulo);
		pFondo.add(pPrincipal, BorderLayout.CENTER);
			pPrincipal.add(pIzquierda);
				pIzquierda.add(pSprite, BorderLayout.CENTER);
					pSprite.add(lImagen);
				pIzquierda.add(pCambioSprite, BorderLayout.SOUTH);
					pCambioSprite.add(bAtras);
					pCambioSprite.add(bAlante);
			pPrincipal.add(pDerecha);
				pDerecha.add(pNombre, BorderLayout.NORTH);
					pNombre.add(pNombreLabel);
						pNombreLabel.add(lNomb);
					pNombre.add(pNombreTf);
						pNombreTf.add(tfNombre);
				pDerecha.add(pEstadisticas, BorderLayout.CENTER); 
					pEstadisticas.add(pEstatsLabel);
					pEstadisticas.add(pVacio);
						pEstatsLabel.add(lEstadisticas, BorderLayout.CENTER);
					pEstadisticas.add(pFuerza);
						pFuerza.add(pFuerzaLabel);					
							pFuerzaLabel.add(lFuerza, BorderLayout.CENTER);
						pFuerza.add(pFuerzaPb);
							pFuerzaPb.add(pbFuerza);
					pEstadisticas.add(pVida);
						pVida.add(pVidaLabel);
							pVidaLabel.add(lVida);
						pVida.add(pVidaPb);	
							pVidaPb.add(pbVida);
					pEstadisticas.add(pVelocidad);
						pVelocidad.add(pVeloLabel);
							pVeloLabel.add(lVelo, BorderLayout.CENTER);
						pVelocidad.add(pVeloPb);
							pVeloPb.add(pbVelo);
						
				pDerecha.add(pConfirmar, BorderLayout.SOUTH);
					pConfirmar.add(bConfirmar);
		pFondo.add(pSalida, BorderLayout.SOUTH);
			pSalida.add(bSalir);	
		
		////////////////////////////////////////////////////////////////////////////////////////////
		///////////Listerens///////////////////////////////////////////////////////////////////////
			
		bAlante.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cambiarSiguiente();
				
				ElegirLabel(personajeSeleccionado, lImagen);
				
				pFuerzaPb.removeAll();
				pFuerzaPb.add(FormatearPb(personajeSeleccionado.getPbFuerza()));
				pVidaPb.removeAll();
				pVidaPb.add(FormatearPb(personajeSeleccionado.getPbVida()));
				pVeloPb.removeAll();
				pVeloPb.add(FormatearPb(personajeSeleccionado.getPbVelocidad()));
				repaint();
				revalidate();
			}
		});
		
		bAtras.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				cambiarAnterior();

				ElegirLabel(personajeSeleccionado, lImagen);
				
				pFuerzaPb.removeAll();
				pFuerzaPb.add(FormatearPb(personajeSeleccionado.getPbFuerza()));
				pVidaPb.removeAll();
				pVidaPb.add(FormatearPb(personajeSeleccionado.getPbVida()));
				pVeloPb.removeAll();
				pVeloPb.add(FormatearPb(personajeSeleccionado.getPbVelocidad()));
				repaint();
				revalidate();
			}
		});
		
		bConfirmar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				personajeSeleccionado.setNombre(tfNombre.getText());
				ch.setPersonajePrincipal(personajeSeleccionado);
				VentanaSeleccionNivel ventana = new VentanaSeleccionNivel(user, ch, victorias1v1);
				BaseDeDatos.guardarPartidaBD2(user, ch);
				ventana.setVisible(true);
				setVisible(false);
				VentanaCreacionPersonaje.this.dispose();
				VentanaPrincipal.venPrincip.dispose();
				Logger logger= VentanaValidacionUsuarios.getLogger();
				logger.log(Level.INFO, "Personaje principal " +  personajeSeleccionado.getNombre() + "," + personajeSeleccionado.getFuerza() 
				+ "," + personajeSeleccionado.getVida() + "," + personajeSeleccionado.getVelocidad() + " creado");
			}
		});
		
		bSalir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaPrincipal.venPrincip.setEnabled(true);
				VentanaCreacionPersonaje.this.dispose();	
			}
		});
			
	}
	
	/**
	 * Método para escoger el siguiente personaje seleccionable de la lista de personajes que se 
	 * le muestran al jugador
	 */
	private void cambiarSiguiente() {
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
	private void cambiarAnterior() {
		PersonajeJugable personajeParaCambiar;
		if(listaPersonajes.indexOf(personajeSeleccionado) != 0) {
			personajeParaCambiar = listaPersonajes.get(listaPersonajes.indexOf(personajeSeleccionado) - 1);
		}else {
			personajeParaCambiar = listaPersonajes.get(listaPersonajes.size() - 1);
		}
		personajeSeleccionado = personajeParaCambiar;
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
	
	/**
	 * Cambia el formato de una progress bar al adecuado para la ventana
	 * @param progressBar Progress bar a cambiar
	 * @return PB formateada para meter en algún componente
	 */
	private JProgressBar FormatearPb( JProgressBar progressBar) {
		
		progressBar.setPreferredSize(new Dimension(170, 22));
		progressBar.setBorderPainted(false);
		progressBar.setForeground(Color.orange);
		progressBar.setBackground(Color.black);
		
		return progressBar;
		
	}
	
	public PersonajeJugable devolverCreado() {
		return personajeCreado;
	}
	
	public static void main(String[] args) {
		VentanaCreacionPersonaje vc = new VentanaCreacionPersonaje(0, null, null, null, 0, 0);
		vc.setVisible(true);
	}
	
}
