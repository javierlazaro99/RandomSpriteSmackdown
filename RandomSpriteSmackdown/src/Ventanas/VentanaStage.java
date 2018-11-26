package Ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import Personalizados.FondoSwing;
import Personalizados.JLabelGraficoAjustado;
import Personalizados.JPanelBackground;
import control.Animaciones;
import control.BaseDeDatos;
import personaje.Personaje;
import personaje.enemigo.Enemigo;
import personaje.personajeJugable.PersonajeJugable;

public class VentanaStage extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	private ArrayList<String> listaPathsAndar = new ArrayList<String>();
	private ArrayList<String> listaPathsJump = new ArrayList<>();
	private ArrayList<String> listaPathsPegar = new ArrayList<>();
	private ArrayList<String> listaPathsAndarAlReves = new ArrayList<String>();

	public VentanaStage(PersonajeJugable p1, Personaje p2,int nivel) {
		listaPathsAndar.add("png/Run (1).png");
		listaPathsAndar.add("png/Run (2).png");
		listaPathsAndar.add("png/Run (3).png");
		listaPathsAndar.add("png/Run (4).png");
		listaPathsAndar.add("png/Run (5).png");
		listaPathsAndar.add("png/Run (6).png");
		listaPathsAndar.add("png/Run (7).png");
		listaPathsAndar.add("png/Run (8).png");
		listaPathsAndar.add("png/Idle (1).png");
		
		listaPathsJump.add("png/Jump (1).png");
		listaPathsJump.add("png/Jump (2).png");
		listaPathsJump.add("png/Jump (3).png");
		listaPathsJump.add("png/Jump (4).png");
		listaPathsJump.add("png/Jump (5).png");
		listaPathsJump.add("png/Jump (6).png");
		listaPathsJump.add("png/Jump (7).png");
		listaPathsJump.add("png/Jump (8).png");
		listaPathsJump.add("png/Jump (9).png");
		listaPathsJump.add("png/Jump (10).png");
		listaPathsJump.add("png/Idle (1).png");
		
		listaPathsPegar.add("png/Melee (1).png");
		listaPathsPegar.add("png/Melee (2).png");
		listaPathsPegar.add("png/Melee (3).png");
		listaPathsPegar.add("png/Melee (4).png");
		listaPathsPegar.add("png/Melee (5).png");
		listaPathsPegar.add("png/Melee (6).png");
		listaPathsPegar.add("png/Melee (7).png");
		listaPathsPegar.add("png/Melee (8).png");
		listaPathsPegar.add("png/Idle (1).png");
		
		listaPathsAndarAlReves.add("png/RunInverso (1).png");
		listaPathsAndarAlReves.add("png/RunInverso (2).png");
		listaPathsAndarAlReves.add("png/RunInverso (3).png");
		listaPathsAndarAlReves.add("png/RunInverso (4).png");
		listaPathsAndarAlReves.add("png/RunInverso (5).png");
		listaPathsAndarAlReves.add("png/RunInverso (6).png");
		listaPathsAndarAlReves.add("png/RunInverso (7).png");
		listaPathsAndarAlReves.add("png/RunInverso (8).png");
		listaPathsAndarAlReves.add("png/IdleInverso (1).png");
		setSize(1920, 1080);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		Dimension d = getSize();
		int width = (int) (d.getWidth()*0.2);
		int height = (int) (d.getHeight()*0.25);	
		
		p1.setPosicion(new Point(0, (int) (d.getHeight()*0.5)));
		//p1 = new PersonajeJugable(null, new Point(0, (int) (d.getHeight()*0.5)), 10, 10, 10, "png/Melee (8).png");
		p2 = new Enemigo(null, 10, 10, 10, 1);
		
		JPanelBackground jpBackground = new JPanelBackground(SpriteStage(nivel));
		JPanel pNorte = new JPanel(new GridLayout(2, 1));
			JPanel pNs = new JPanel();
			JPanel pNi = new JPanel(new GridLayout(1, 3));
			JPanel pN1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
			JPanel pN2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
			JPanel pN3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JPanel pCentral = new JPanel();
		pCentral.setLayout(null);
		JLabelGraficoAjustado iProta=p1.getlPersonaje(width, height);
		this.setLayout(new BorderLayout());
		this.add(jpBackground, BorderLayout.CENTER);
		
		pNorte.setPreferredSize(new Dimension(4000, 150));
		
		JProgressBar jpbVida1 = new JProgressBar();
		JProgressBar jpbVida2 = new JProgressBar();
			jpbVida1.setValue((int)p1.getVida());
			jpbVida1.setValue((int)p2.getVida());
		JLabel lTiempo = new JLabel("60");
		JLabel lStage = new JLabel("Stage "+nivel);
		
		lTiempo.setFont(new Font("", Font.PLAIN, 40));
		
		jpbVida1.setPreferredSize(new Dimension(500, 60));
		jpbVida2.setPreferredSize(new Dimension(500, 60));
		lTiempo.setPreferredSize(new Dimension(50, 50));
		
		jpbVida1.setValue(500);
		jpbVida2.setValue(500);
		jpbVida1.setBorderPainted(false);
		jpbVida2.setBorderPainted(false);
		jpbVida1.setOpaque(false);
		jpbVida2.setOpaque(false);
		jpbVida1.setForeground(Color.RED);
		jpbVida2.setForeground(Color.RED);
		
//		pNorte.setBorder(BorderFactory.createLineBorder(Color.BLACK));
//		pN1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		
		jpBackground.setLayout(new BorderLayout());
		jpBackground.add(pNorte, BorderLayout.NORTH);
		jpBackground.add(pCentral,BorderLayout.CENTER);
		pNorte.setOpaque(false);
		pCentral.setOpaque(false);
		pNs.setOpaque(false);
		pNi.setOpaque(false);
		pN1.setOpaque(false);
		pN2.setOpaque(false);
		pN3.setOpaque(false);
		iProta.setOpaque(false);
		pCentral.add(iProta);
		iProta.setLocation(p1.getPosicion().x, p1.getPosicion().y);
		pNorte.add(pNs);
		pNorte.add(pNi);
		
		pNs.add(lStage);
		
		pNi.add(pN1); 
		pNi.add(pN2); 
		pNi.add(pN3);
		
		pN1.add(jpbVida1);
		pN2.add(lTiempo);
		pN3.add(jpbVida2);
		
		addKeyListener(new KeyListener() {
			
			Animaciones a = new Animaciones(listaPathsAndar, iProta,0,p1);
			
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_D) {
					//p1.Moverse(5, 0);
					a.setCodigoMovimiento(0);
					a.setListaPaths(listaPathsAndar);
					if(Thread.activeCount() <=4){
					new Thread(a).start();
					}
					//iProta.setLocation(new Point(p1.getPosicion().x, p1.getPosicion().y));
					revalidate();
				}if(e.getKeyCode() == KeyEvent.VK_A) {
					p1.Moverse(-10, 0);
					iProta.setLocation(new Point(p1.getPosicion().x, p1.getPosicion().y));
				}
				if(e.getKeyCode() == KeyEvent.VK_A) {
					a.setCodigoMovimiento(1);
					a.setListaPaths(listaPathsAndarAlReves);
					if(Thread.activeCount() <=3){
						new Thread(a).start();
						}
					
				}
				if(e.getKeyCode() == KeyEvent.VK_W) {
					a.setCodigoMovimiento(2);
					a.setListaPaths(listaPathsJump);
					System.out.println(Thread.activeCount());
					//Esto esta mal pero luego lo discutimos
					if(Thread.activeCount() <=3) {
					new Thread(a).start();
					}
					
					revalidate();
				}
				if(e.getKeyCode()== KeyEvent.VK_SPACE) {
					a.setListaPaths(listaPathsPegar);
					a.setCodigoMovimiento(3);
					System.out.println("Codigo="+a.getCodigoMovimiento());
					if(Thread.activeCount() <=3){
					new Thread(a).start();
					}
					revalidate();
				}
			}
		});
		
		
	}
	public String SpriteStage(int nivel) {
		String snivel= "src/Stage";
		String snivelfinal = ".gif";
		String global = snivel+nivel+snivelfinal;
		switch(nivel) {
		case 1:
			return global;
		case 2:
			return global;
		case 3:
			return global;
		case 4:
			return global;
		case 5:
			return global;
		case 6:
			return global;
		case 7:
			return global;
		case 8: 
			return global;
		default:
			return "src/Stage1.gif";
		}
	}
	
	public static void main(String[] args) {
		VentanaStage vs = new VentanaStage(new PersonajeJugable(null, new Point(0, 0), 10, 10, 10, "png/Melee (8).png"), null, 1);
		vs.setVisible(true);
	}
}

