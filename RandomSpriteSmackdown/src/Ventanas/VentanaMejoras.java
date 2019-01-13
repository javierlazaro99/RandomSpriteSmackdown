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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import Personalizados.JLabelGraficoAjustado;
import Usuarios.UsuariosValidar;
import control.ControlHistoria;
import personaje.personajeJugable.PersonajeJugable;

public class VentanaMejoras extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private JButton bSubirFuerza;
	private JButton bSubirVida;
	private JButton bSubirVelocidad;
	

	public VentanaMejoras(UsuariosValidar user, ControlHistoria ch, int victorias1v1) {
		
		try {
		     GraphicsEnvironment ge = 
		         GraphicsEnvironment.getLocalGraphicsEnvironment();
		     ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("fonts/SoulCalibur.ttf")));
		     ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("fonts/UnrealT.ttf")));
		     ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("fonts/Play Pretend.otf")));
		} catch (IOException|FontFormatException e) {
		     //Handle exception
		}
		
		setSize(800, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		JPanel pIzquierda = new JPanel(new BorderLayout());
			JPanel pTitulo = new JPanel();
				JLabel lTitulo = new JLabel("Mejoras");
			JPanel pPersonaje = new JPanel(new BorderLayout());
				JLabelGraficoAjustado lgaPersonaje = SeleccionarLabel(ch.getPersonajePrincipal());
			JPanel pHome = new JPanel();
				JButton bHome = new JButton("Home");
		JPanel pDerecha = new JPanel(new BorderLayout());
			JPanel pVacio = new JPanel();
			JPanel pMejoras = new JPanel(new BorderLayout());
				JPanel pVacio2 = new JPanel();
				JPanel pMejorasLabel = new JPanel(new GridBagLayout());
					JLabel lMejoras = new JLabel("Comprar mejoras");
				JPanel pMejorasCentro = new JPanel(new BorderLayout());
					JPanel pPuntosMejora = new JPanel(new GridBagLayout());
						JLabel lPuntosMejora = new JLabel("Puntos disponibles: " + ch.getPersonajePrincipal().getPuntosMejora());
					JPanel pMejorasStats = new JPanel(new GridLayout(3, 1));
						JPanel pFuerza = new JPanel(new FlowLayout());
							JPanel pFuerzaLabel = new JPanel(new GridBagLayout());
								JLabel lFuerza = new JLabel("Fuerza  ");
							JPanel pFuerzaPb = new JPanel(new GridBagLayout());
							JPanel pSubirFuerza = new JPanel();
								bSubirFuerza = new JButton("+");
						JPanel pVida = new JPanel(new FlowLayout());
							JPanel pVidaLabel = new JPanel(new GridBagLayout());
								JLabel lVida = new JLabel("Vida  ");
							JPanel pVidaPb = new JPanel(new GridBagLayout());
							JPanel pSubirVida = new JPanel();
								bSubirVida = new JButton("+");
						JPanel pVelocidad = new JPanel(new FlowLayout());
							JPanel pVelocidadLabel = new JPanel(new GridBagLayout());
								JLabel lVelocidad = new JLabel("Velocidad  ");
							JPanel pVelocidadPb = new JPanel(new GridBagLayout());
							JPanel pSubirVelo = new JPanel(new GridBagLayout());
								bSubirVelocidad = new JButton("+");
				
			
		
					
		//Mejora de componentes
		lTitulo.setFont(new Font("Play Pretend", Font.TRUETYPE_FONT, 80));
		lTitulo.setForeground(Color.orange);
		pVacio.setPreferredSize(new Dimension(200, 100));
		pPuntosMejora.setPreferredSize(new Dimension(200, 100));
		
		lMejoras.setFont(new Font("Unreal Tournament", Font.TRUETYPE_FONT, 30));
		lMejoras.setForeground(Color.ORANGE);
		lPuntosMejora.setFont(new Font("Unreal Tournament", Font.TRUETYPE_FONT, 17));
		lPuntosMejora.setForeground(Color.ORANGE);
		
		pMejorasStats.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
		
		bHome.setFont(new Font("Play Pretend", Font.TRUETYPE_FONT, 20));
		bHome.setForeground(Color.ORANGE);
		bHome.setPreferredSize(new Dimension(130, 40));
		bHome.setFocusable(false);
		bHome.setBackground(Color.black);
		bHome.setBorder(BorderFactory.createLineBorder(Color.lightGray, 3));
		
		pFuerzaLabel.setPreferredSize(new Dimension(120, 30));
		pVidaLabel.setPreferredSize(new Dimension(120, 30));
		pVelocidadLabel.setPreferredSize(new Dimension(120, 30));
		
		lFuerza.setFont(new Font("Play Pretend", Font.TRUETYPE_FONT, 19));
		lFuerza.setForeground(Color.ORANGE);
		
		lVida.setFont(new Font("Play Pretend", Font.TRUETYPE_FONT, 19));
		lVida.setForeground(Color.ORANGE);
		lVelocidad.setFont(new Font("Play Pretend", Font.TRUETYPE_FONT, 16));
		lVelocidad.setForeground(Color.ORANGE);
		
		ArrayList<JButton> listaBotones = CrearListaBotones();
		
		for (JButton jButton : listaBotones) {
			jButton.setPreferredSize(new Dimension(48, 48));
			jButton.setFont(new Font("Play Pretend", Font.TRUETYPE_FONT, 25));
			jButton.setBorderPainted(false);
			jButton.setContentAreaFilled(false);
			jButton.setOpaque(false);
			jButton.setFocusPainted(false);
		}
		
		
		pVacio2.setPreferredSize(new Dimension(100, 70));
		
		
		//Estructura de la Ventana
		getContentPane().add(pIzquierda, BorderLayout.WEST);		
		getContentPane().add(pDerecha, BorderLayout.CENTER);
		
		pIzquierda.add(pTitulo, BorderLayout.NORTH);
			pTitulo.add(lTitulo);
		pIzquierda.add(pPersonaje, BorderLayout.CENTER);
			pPersonaje.add(lgaPersonaje, BorderLayout.CENTER);
		pIzquierda.add(pHome, BorderLayout.SOUTH);
			pHome.add(bHome);
		
		pDerecha.add(pVacio, BorderLayout.NORTH);
		pDerecha.add(pMejoras, BorderLayout.CENTER);
			pMejoras.add(pMejorasLabel, BorderLayout.NORTH);
				pMejorasLabel.add(lMejoras);
			pMejoras.add(pVacio2, BorderLayout.SOUTH);
			pMejoras.add(pMejorasCentro, BorderLayout.CENTER);
				pMejorasCentro.add(pPuntosMejora, BorderLayout.NORTH);
					pPuntosMejora.add(lPuntosMejora);
				pMejorasCentro.add(pMejorasStats, BorderLayout.CENTER);
					pMejorasStats.add(pFuerza);
						pFuerza.add(pFuerzaLabel);
							pFuerzaLabel.add(lFuerza);
						pFuerza.add(pFuerzaPb);
							pFuerzaPb.add(VentanaCreacionPersonaje.FormatearPb(ch.getPersonajePrincipal().getPbFuerza(), 140, 18));
						pFuerza.add(pSubirFuerza);
							pSubirFuerza.add(bSubirFuerza);
					pMejorasStats.add(pVida);
						pVida.add(pVidaLabel);
							pVidaLabel.add(lVida);
						pVida.add(pVidaPb);
							pVidaPb.add(VentanaCreacionPersonaje.FormatearPb(ch.getPersonajePrincipal().getPbVida(), 140, 18));
						pVida.add(pSubirVida);
							pSubirVida.add(bSubirVida);
					pMejorasStats.add(pVelocidad);
						pVelocidad.add(pVelocidadLabel);
							pVelocidadLabel.add(lVelocidad);
						pVelocidad.add(pVelocidadPb);
							pVelocidadPb.add(VentanaCreacionPersonaje.FormatearPb(ch.getPersonajePrincipal().getPbVelocidad(), 140, 18));
						pVelocidad.add(pSubirVelo);
							pSubirVelo.add(bSubirVelocidad);
						
		
		
		bSubirFuerza.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ch.getPersonajePrincipal().SubirNivel("fuerza");
				ch.getPersonajePrincipal().getPbFuerza().setValue((int) ch.getPersonajePrincipal().getFuerza());
				
				lPuntosMejora.setText("Puntos disponibles: " + ch.getPersonajePrincipal().getPuntosMejora());
				
				getContentPane().revalidate();
			}
		});
		bSubirFuerza.addMouseListener(new MiMouseAdapter(bSubirFuerza));
		
		bSubirVida.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ch.getPersonajePrincipal().SubirNivel("vida");
				ch.getPersonajePrincipal().getPbVida().setValue((int) ch.getPersonajePrincipal().getVida());
				
				lPuntosMejora.setText("Puntos disponibles: " + ch.getPersonajePrincipal().getPuntosMejora());
				
				getContentPane().revalidate();
			}
		});
		bSubirVida.addMouseListener(new MiMouseAdapter(bSubirVida));
		
		bSubirVelocidad.addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent e) {
				ch.getPersonajePrincipal().SubirNivel("velocidad");
				ch.getPersonajePrincipal().getPbVelocidad().setValue((int) ch.getPersonajePrincipal().getVelocidad());
				
				lPuntosMejora.setText("Puntos disponibles: " + ch.getPersonajePrincipal().getPuntosMejora());
				
				getContentPane().revalidate();
			}
		});
		bSubirVelocidad.addMouseListener(new MiMouseAdapter(bSubirVelocidad));
		
		bHome.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaSeleccionNivel ventana = new VentanaSeleccionNivel(user, ch, victorias1v1);
				ventana.setVisible(true);
				VentanaMejoras.this.dispose();
			}
		});	
	}
	
	/**
	 * M�tdodo para generar un JLabelGrafico ajustado a partir del personaje principal del jugador
	 * @param p Personaje principal del jugador
	 * @return JLabel correspondiente al tipo de personaje enviado
	 */
	private JLabelGraficoAjustado SeleccionarLabel(PersonajeJugable p) {
		JLabelGraficoAjustado lDevolver;
		
		if(p.getTipoPersonaje().equals("robot")) {
			lDevolver = new JLabelGraficoAjustado("png/Idle (1).png", 400, 300);
			lDevolver.setPreferredSize(new Dimension(400, 400));
			
			return lDevolver;
		}
		if(p.getTipoPersonaje().equals("ninja")) {
			lDevolver = new JLabelGraficoAjustado("pngEnem/Idle__000.png", 200, 300);
			lDevolver.setPreferredSize(new Dimension(400, 400));
					
			return lDevolver;
		}else {
			return null;
		}
	}
	
	private ArrayList<JButton> CrearListaBotones(){
		ArrayList<JButton> lB = new ArrayList<>();
		
		lB.add(bSubirFuerza);
		lB.add(bSubirVida);
		lB.add(bSubirVelocidad);
		
		return lB;
		
	}
	
	/**
	 * Clase interna que implementa Mouse adapter para que lo usen todos
	 * Los botones de la ventana
	 * @author pc
	 *
	 */
	class MiMouseAdapter extends MouseAdapter{
		private JButton boton;
		
		public MiMouseAdapter(JButton b) {
			this.boton = b;
		}
		

		@Override
		public void mouseEntered(MouseEvent e) {
			boton.setBorderPainted(true);
			boton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));	
			boton.setContentAreaFilled(true);
			boton.setBackground(Color.lightGray);
		}

		@Override
		public void mouseExited(MouseEvent e) {
			boton.setBorder(null);
			boton.setContentAreaFilled(false);
		}
	}
	
	
	public static void main(String[] args) {
		VentanaMejoras vm = new VentanaMejoras(null, new ControlHistoria(new PersonajeJugable("Jose", new Point(0, 0), 10, 10, 10, "robot"), 0), 0);
		vm.setVisible(true);
	}
}
