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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import Personalizados.FondoSwing;
import Personalizados.JLabelGraficoAjustado;
import Personalizados.JPanelBackground;
import Usuarios.UsuariosValidar;
import control.Animaciones;
import control.BaseDeDatos;
import control.ControlAnimaciones;
import control.ControlEstados;
import control.ControlHistoria;
import control.ControlIA;
import control.ElementoAnimacion;
import personaje.Personaje;
import personaje.enemigo.Enemigo;
import personaje.personajeJugable.PersonajeJugable;

public class VentanaStage extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JLabelGraficoAjustado iProta = new JLabelGraficoAjustado("png/Idle (1).png", 50, 50);
	private JLabelGraficoAjustado iEnemigo = new JLabelGraficoAjustado("png/Idle (1).png", 50, 50);
	public JLabelGraficoAjustado getiEnemigo() {
		return iEnemigo;
	}



	public void setiEnemigo(JLabelGraficoAjustado iEnemigo) {
		this.iEnemigo = iEnemigo;
	}

	private JLabel lTiempo=null ;
	private int contador=60;
	
	public int getContador() {
		return contador;
	}



	public void setContador(int contador) {
		this.contador = contador;
	}

	private ControlEstados controlEstados ;
	private ControlIA controlIA;
	private PersonajeJugable pPrincipal;
	private Personaje pSecundario;
	private JProgressBar jpbVida2 ;
	private JProgressBar jpbVida1 ;
	public JProgressBar getJpbVida2() {
		return jpbVida2;
	}



	public void setJpbVida2(double vidaEnemigo) {
		this.jpbVida2.setValue((int)vidaEnemigo);;
	}



	public JProgressBar getJpbVida1() {
		return jpbVida1;
	}



	public void setJpbVida1(double vidaPrincipal) {
		this.jpbVida1.setValue((int)vidaPrincipal);
	}



	public VentanaStage(PersonajeJugable p1, Enemigo p2,int nivel,ControlHistoria ch ) {
		
		pPrincipal=p1;
		pSecundario=p2;
		
		
		
		
		ElementoAnimacion.CrearAnimParado();
		ElementoAnimacion.CrearAnimSaltando();
		ElementoAnimacion.CrearAnimMoverse();
		ElementoAnimacion.CrearAnimGolpear();
		ElementoAnimacion.CrearAnimEnemMoverse();
		p1.crearlPersonaje(50, 50);
		
		setSize(1920, 1080);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setUndecorated(true);
		
		Dimension d = getSize();
		p1.setPosicion(new Point(0, (int) (d.getHeight()*0.6)));
		
		p2.setPosicion(new Point((int)(d.getWidth()-d.getWidth()*0.2),(int) (d.getHeight()*0.6)));
		
		//Thread de juego
		controlEstados = new ControlEstados(p1, p2, this,ch);
		Thread t = new Thread(controlEstados);
		controlEstados.setStageCerrado(false);
		t.start();
		controlIA= new ControlIA(p1, p2, this, ch);
		Thread enemt = new Thread(controlIA);
		enemt.start();
	
		int width = (int) (d.getWidth()*0.2);
		int height = (int) (d.getHeight()*0.25);	
		
		
		System.out.println(p2.getPosicion());
		JPanelBackground jpBackground = new JPanelBackground(SpriteStage(nivel));
		JPanel pNorte = new JPanel(new GridLayout(2, 1));
			JPanel pNs = new JPanel();
			JPanel pNi = new JPanel(new GridLayout(1, 3));
			JPanel pN1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
			JPanel pN2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
			JPanel pN3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JPanel pCentral = new JPanel();
		pCentral.setLayout(null);
		
		this.setLayout(new BorderLayout());
		this.add(jpBackground, BorderLayout.CENTER);
		
		pNorte.setPreferredSize(new Dimension(4000, 150));
		
		jpbVida1 = new JProgressBar();
		jpbVida2 = new JProgressBar();
			jpbVida1.setValue((int)p1.getVida());
			jpbVida1.setMaximum((int)p1.getVida());
			jpbVida2.setValue((int)p2.getVida());
			jpbVida2.setMaximum((int)p2.getVida());
		lTiempo = new JLabel("60");
		JLabel lStage = new JLabel("Stage "+nivel);
		
		lTiempo.setFont(new Font("", Font.PLAIN, 40));
		
		jpbVida1.setPreferredSize(new Dimension(500, 60));
		jpbVida2.setPreferredSize(new Dimension(500, 60));
		lTiempo.setPreferredSize(new Dimension(50, 50));
		
		jpbVida2.setValue(500);
		jpbVida1.setBorderPainted(false);
		jpbVida2.setBorderPainted(false);
		jpbVida1.setOpaque(true);
		jpbVida2.setOpaque(false);
		jpbVida1.setForeground(Color.RED);
		jpbVida2.setForeground(Color.RED);
		
		
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
		iEnemigo.setOpaque(false);
		pCentral.add(iProta);
		pCentral.add(iEnemigo);
		iProta.setLocation(p1.getPosicion().x, p1.getPosicion().y);
		iProta.setSize(new Dimension(width, height));
		iEnemigo.setLocation(p2.getPosicion().x,p2.getPosicion().y);
		iEnemigo.setSize(new Dimension(width, height));
		pNorte.add(pNs);
		pNorte.add(pNi);
		
		pNs.add(lStage);
		
		pNi.add(pN1); 
		pNi.add(pN2); 
		pNi.add(pN3);
		
		pN1.add(jpbVida1);
		pN2.add(lTiempo);
		pN3.add(jpbVida2);
		
		tiempo.start();
		
		addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub	
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_W) {
					controlEstados.setWPulsado(false);
				}
				if(e.getKeyCode() == KeyEvent.VK_D) {
					controlEstados.setDPulsado(false);
				}
				if(e.getKeyCode() == KeyEvent.VK_A) {
					System.out.println("hola");
					controlEstados.setAPulsado(false);
				}
				if(e.getKeyCode() == KeyEvent.VK_SPACE) {
					controlEstados.setSpacePulsado(false);
				}
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_W) {
					controlEstados.setWPulsado(true);
				}
				if(e.getKeyCode() == KeyEvent.VK_D) {
					controlEstados.setDPulsado(true);
				}
				if(e.getKeyCode() == KeyEvent.VK_A) {
					controlEstados.setAPulsado(true);
				}
				if(e.getKeyCode() == KeyEvent.VK_SPACE) {
					controlEstados.setSpacePulsado(true);
				}
				if(e.getKeyCode()==KeyEvent.VK_ESCAPE) {
					controlEstados.setStagePausado(true);
					if(JOptionPane.showInternalConfirmDialog(getContentPane(), "¿Quieres cerrar el juego?","Cierre de ventana",JOptionPane.YES_NO_OPTION)==0) {
						VentanaStage.this.dispose();
						controlEstados.setStagePausado(false);
						controlEstados.setStageCerrado(true);
						contador=0;
					}else {
						controlEstados.setAPulsado(false);
						controlEstados.setDPulsado(false);
						controlEstados.setStagePausado(false);
					}
				}
			}
		});
		
		
	}				
			
 Thread tiempo = new Thread(new Runnable() {
	
	@Override
	public void run() {
		
		try {
			
				
			while(contador>0 ) {
				
				while(controlEstados.isStagePausado()) {
					Thread.sleep(1000);
				}
				
				Thread.sleep(1000);
				contador= contador -1;
				
				lTiempo.setText(String.valueOf(contador));
				VentanaStage.this.revalidate();
				
		
				}
				controlEstados.setStageCerrado(true);
				contador=0;
				VentanaStage.this.dispose();
		
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
 });
	
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
	
	

	public JLabelGraficoAjustado getiProta() {
		return iProta;
	}

	public void setiProta(JLabelGraficoAjustado iProta) {
		this.iProta = iProta;
	}

	public static void main(String[] args) {
		VentanaStage vs = new VentanaStage(new PersonajeJugable(null, new Point(0, 0), 10, 10, 10, "png/Idle (1).png"), new Enemigo(new Point(100, 0), 10, 10, 10, 1) ,1,new ControlHistoria(new PersonajeJugable(null, new Point(0, 0), 10, 10, 10, "png/Idle (1).png"), 0));
		vs.setVisible(true);
	}
}

