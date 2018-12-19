package Ventanas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.WeakHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Personalizados.JLabelGraficoAjustado;
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
	private PersonajeJugable personajeR�pido = new PersonajeJugable(null, new Point(0, 0), 5, 5, 20, "ninja");
	private PersonajeJugable personajeLento = new PersonajeJugable(null, new Point(0, 0), 15, 10, 5, "robot");
	
	private JLabelGraficoAjustado lImagen;
	
	
	public VentanaCreacionPersonaje(int codigo,UsuariosValidar user,PersonajeJugable pPrincipal1, ControlHistoria ch, int victorias1v1,int nivelesCompletados) {
		
		listaPersonajes.add(personajeRegular); listaPersonajes.add(personajeR�pido); listaPersonajes.add(personajeLento);
		personajeSeleccionado = listaPersonajes.get(0);
		personajeCreado = null;
		
		
		
		setSize(700, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		JPanel pFondo = new JPanel(new BorderLayout());
			JPanel pTitulo = new JPanel(new FlowLayout(FlowLayout.CENTER));
				JLabel lTitulo = new JLabel("Creaci�n de personaje");
				lTitulo.setFont(new Font("", Font.PLAIN, 40));
			JPanel pPrincipal = new JPanel(new GridLayout(1, 2));
				JPanel pIzquierda = new JPanel(new BorderLayout());
					JPanel pSprite = new JPanel(new BorderLayout());
						lImagen = new JLabelGraficoAjustado("png/Idle (1).png", 400, 300);
					JPanel pCambioSprite = new JPanel(new FlowLayout(FlowLayout.CENTER));
						JButton bAtras = new JButton("Previous");
						JButton bAlante = new JButton("Next");
				JPanel pDerecha = new JPanel(new BorderLayout());
					JPanel pNombre = new JPanel(new GridLayout(2, 1));
						JLabel lNomb = new JLabel("Introduzca el nombre de su personaje:");
						JTextField tfNombre = new JTextField(10);
					JPanel pEstadisticas = new JPanel(new GridLayout(4, 1));
						JLabel lEstadisticas = new JLabel("Estad�sticas");
						JPanel pFuerza = new JPanel(new FlowLayout());
						JPanel pVida = new JPanel(new FlowLayout());
						JPanel pVelocidad = new JPanel(new FlowLayout());
					JPanel pConfirmar = new JPanel(new FlowLayout(FlowLayout.CENTER));
						JButton bConfirmar = new JButton("OK");
			JPanel pSalida = new JPanel(new FlowLayout(FlowLayout.LEFT));
				JButton bSalir = new JButton("Salir");
		
		//Coge las simensiones de la ventana y calcula el tama�o del label		
		Dimension d = getSize();
		int width = (int) (d.getWidth()*0.5);
		int height = (int) (d.getHeight()*0.5);		
		
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
					pNombre.add(lNomb);
					pNombre.add(tfNombre);
				pDerecha.add(pEstadisticas, BorderLayout.CENTER); 
					pEstadisticas.add(lEstadisticas);
					pEstadisticas.add(pFuerza);
						pFuerza.add(new JLabel("Fuerza"));
						pFuerza.add(personajeSeleccionado.getPbFuerza());
					pEstadisticas.add(pVida);
						pVida.add(new JLabel("Vida"));
						pVida.add(personajeSeleccionado.getPbVida());
					pEstadisticas.add(pVelocidad);
						pVelocidad.add(new JLabel("Velociad"));
						pVelocidad.add(personajeSeleccionado.getPbVelocidad());
						
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
				
				pFuerza.remove(1);
				pFuerza.add(personajeSeleccionado.getPbFuerza());
				pVida.remove(1);
				pVida.add(personajeSeleccionado.getPbVida());
				pVelocidad.remove(1);
				pVelocidad.add(personajeSeleccionado.getPbVelocidad());
				repaint();
				revalidate();
			}
		});
		
		bAtras.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				cambiarAnterior();

				ElegirLabel(personajeSeleccionado, lImagen);
				
				pFuerza.remove(1);
				pFuerza.add(personajeSeleccionado.getPbFuerza());
				pVida.remove(1);
				pVida.add(personajeSeleccionado.getPbVida());
				pVelocidad.remove(1);
				pVelocidad.add(personajeSeleccionado.getPbVelocidad());
				repaint();
				revalidate();
			}
		});
		
		bConfirmar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				personajeSeleccionado.setNombre(tfNombre.getText());
				ch.setPersonajePrincipal(personajeSeleccionado);
				setVisible(false);
				VentanaSeleccionNivel ventana = new VentanaSeleccionNivel(user, ch, victorias1v1);
				BaseDeDatos.guardarPartidaBD2(user, ch);
				ventana.setVisible(true);
				VentanaCreacionPersonaje.this.dispose();
				Logger logger= VentanaValidacionUsuarios.getLogger();
				logger.log(Level.INFO, "Personaje principal " +  personajeSeleccionado.getNombre() + "," + personajeSeleccionado.getFuerza() 
				+ "," + personajeSeleccionado.getVida() + "," + personajeSeleccionado.getVelocidad() + " creado");
			}
		});
		
		bSalir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				VentanaPrincipal ventana = new VentanaPrincipal(codigo, user, pPrincipal1, nivelesCompletados, victorias1v1);
				ventana.setVisible(true);
			}
		});
			
	}
	
	/**
	 * M�todo para escoger el siguiente personaje seleccionable de la lista de personajes que se 
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
	 * M�todo para escoger el anterior personaje seleccionable de la lista de personajes que se 
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
		
		revalidate();
		repaint();
	}
	
	public PersonajeJugable devolverCreado() {
		return personajeCreado;
	}
	
	public static void main(String[] args) {
		VentanaCreacionPersonaje vc = new VentanaCreacionPersonaje(0, null, null, null, 0, 0);
		vc.setVisible(true);
	}
	
}
