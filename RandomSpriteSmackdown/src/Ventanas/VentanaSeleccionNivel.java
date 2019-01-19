package Ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.LineNumberInputStream;
import java.util.ArrayList;
import java.util.TreeMap;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Personalizados.JPanelBackground;
import Usuarios.UsuariosValidar;
import control.ControlHistoria;
import control.Nivel;
import control.MouseAdapters.MouseAdapterBotonesMenus;
import personaje.personajeJugable.PersonajeJugable;

public class VentanaSeleccionNivel extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private JButton bN1; private JButton bN2; private JButton bN3; private JButton bN4; private JButton bN5; private JButton bN6; private JButton bN7; private JButton bN8;
	private ControlHistoria ch;
	private ArrayList<JButton>arrayBotones;
	public static VentanaSeleccionNivel venSelecNivel;
	public VentanaSeleccionNivel(UsuariosValidar user, ControlHistoria ch, int victorias1v1) {
		this.ch=ch;
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
		
		Nivel.generarListaNiveles(ch.getPersonajePrincipal(),ch); //Del control de la historia se coje el personaje y se genera la lista de niveles 
		
		setUndecorated(true);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		JPanelBackground pbFondo = new JPanelBackground("src/FondoMadera.png");
		pbFondo.setLayout(new BorderLayout());
		
		JPanel pSuperior = new JPanel();
			JPanel pTitulo = new JPanel(new BorderLayout());
				JLabel lTitulo = new JLabel("Selecciona un Nivel Para Comenzar");
				lTitulo.setFont(new Font("SoulCalibur", Font.BOLD, 85));
				lTitulo.setForeground(Color.ORANGE);
		
		JPanel pInferior = new JPanel(new GridLayout(0,2));
			JPanel pHome = new JPanel();
				JButton bHome = new JButton("Home");
			JPanel pMejoras = new JPanel();
				JButton bMejoras = new JButton("Mejoras");
		JPanel pPrincipal = new JPanel(new GridLayout(3, 4));
			JPanel pN1 = new JPanel(new BorderLayout());
				bN1 = new JButton();
			JPanel pN2 = new JPanel(new BorderLayout());
				bN2 = new JButton();
			JPanel pN3 = new JPanel(new BorderLayout());
				bN3 = new JButton();
			JPanel pN4 = new JPanel(new BorderLayout());
				bN4 = new JButton();
			JPanel pN5 = new JPanel(new BorderLayout());
				bN5 = new JButton();
			JPanel pN6 = new JPanel(new BorderLayout());
				bN6 = new JButton();
			JPanel pN7 = new JPanel(new BorderLayout());
				bN7 = new JButton();
			JPanel pN8 = new JPanel(new BorderLayout());
				bN8 = new JButton();
			
		JPanel pVacio1 = new JPanel();	
		JPanel pVacio2 = new JPanel();	
			JPanel pVacio21 = new JPanel();
			JPanel pVacio22 = new JPanel();
		JPanel pVacio3 = new JPanel();	
			JPanel pVacio31 = new JPanel();
			JPanel pVacio32 = new JPanel();
		JPanel pVacio4 = new JPanel();	
		
		
		//Editar componentes
		ArrayList<JButton> arrayBotones = CrearListaBotones();
		ArrayList<ImageIcon> arrayIconos = CrearlistaIconos();
		this. arrayBotones=arrayBotones;
		int cont = 0;
		for (JButton boton : arrayBotones) {
			boton.setMargin(new Insets(0, 0, 0, 0));
			boton.setContentAreaFilled(false);	
			
			boton.setIcon(new ImageIcon(arrayIconos.get(cont).getImage().getScaledInstance(500, 290,  java.awt.Image.SCALE_SMOOTH)));
			cont++;
		}
		ComprobarNiveles(arrayBotones);
		
		pTitulo.setPreferredSize(new Dimension(900, 200));
		
		bHome.setFont(new Font("Play Pretend", Font.TRUETYPE_FONT, 25));
		bHome.setForeground(Color.ORANGE);
		bHome.setPreferredSize(new Dimension(200, 55));
		bHome.setFocusable(false);
		bHome.setBackground(Color.black);
		bHome.setBorder(BorderFactory.createLineBorder(Color.lightGray, 3));
		
		bMejoras.setFont(new Font("Play Pretend", Font.TRUETYPE_FONT, 25));
		bMejoras.setForeground(Color.ORANGE);
		bMejoras.setPreferredSize(new Dimension(200, 55));
		bMejoras.setFocusable(false);
		bMejoras.setBackground(Color.black);
		bMejoras.setBorder(BorderFactory.createLineBorder(Color.lightGray, 3));
		
		//Opaques
		pTitulo.setOpaque(false);
		pSuperior.setOpaque(false);
		pPrincipal.setOpaque(false);
		pVacio1.setOpaque(false);
		pVacio2.setOpaque(false);
		pVacio21.setOpaque(false);
		pVacio22.setOpaque(false);
		pVacio3.setOpaque(false);
		pVacio31.setOpaque(false);
		pVacio32.setOpaque(false);
		pVacio4.setOpaque(false);
		pHome.setOpaque(false);
		pMejoras.setOpaque(false);
		
		//Estructura de la Ventana
		getContentPane().add(pbFondo);
		pbFondo.add(pSuperior, BorderLayout.NORTH);
		pbFondo.add(pPrincipal, BorderLayout.CENTER);
		pbFondo.add(pInferior, BorderLayout.SOUTH);
		
		pSuperior.add(pTitulo, BorderLayout.CENTER);
		pTitulo.add(lTitulo);
		
		pPrincipal.add(pN1); pPrincipal.add(pN2); pPrincipal.add(pN3); pPrincipal.add(pN4);
		pPrincipal.add(pN5); pPrincipal.add(pN6); pPrincipal.add(pN7); pPrincipal.add(pN8);
		pPrincipal.add(pVacio1); pPrincipal.add(pVacio2); pPrincipal.add(pVacio3); pPrincipal.add(pVacio4);
		
		pVacio2.setLayout(new GridLayout(3, 1));
			pVacio2.add(pVacio21);
			pVacio2.add(pHome);
				pHome.add(bHome);
			pVacio2.add(pVacio22);
		pVacio3.setLayout(new GridLayout(3, 1));
			pVacio3.add(pVacio31);
			pVacio3.add(pMejoras);
				pMejoras.add(bMejoras);
			pVacio3.add(pVacio32);
		pN1.add(bN1, BorderLayout.CENTER); pN2.add(bN2, BorderLayout.CENTER); pN3.add(bN3, BorderLayout.CENTER); pN4.add(bN4, BorderLayout.CENTER); 
		pN5.add(bN5, BorderLayout.CENTER); pN6.add(bN6, BorderLayout.CENTER); pN7.add(bN7, BorderLayout.CENTER); pN8.add(bN8, BorderLayout.CENTER);
		
		
		
		
		bN1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Nivel nivel1 = Nivel.listaNiveles.get(0);
				VentanaStage stage1 = new VentanaStage(nivel1.getPj(), nivel1.getEnem(), 1, nivel1.getCh(), true,VentanaSeleccionNivel.this);
				stage1.setVisible(true);	
			}
		});
		
		bN2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Nivel nivel2 = Nivel.listaNiveles.get(1);
				VentanaStage stage2 = new VentanaStage(nivel2.getPj(), nivel2.getEnem(), 2, nivel2.getCh(), true,VentanaSeleccionNivel.this);
				stage2.setVisible(true);
			}
		});
		bN3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Nivel nivel3 = Nivel.listaNiveles.get(2);
				VentanaStage stage3 = new VentanaStage(nivel3.getPj(), nivel3.getEnem(), 3, nivel3.getCh(), true,VentanaSeleccionNivel.this);
				stage3.setVisible(true);
			}
		});
		bN4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Nivel nivel4 = Nivel.listaNiveles.get(3);
				VentanaStage stage4 = new VentanaStage(nivel4.getPj(), nivel4.getEnem(), 4, nivel4.getCh(), true,VentanaSeleccionNivel.this);
				stage4.setVisible(true);	
			}
		});
		bN5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Nivel nivel5 = Nivel.listaNiveles.get(4);
				VentanaStage stage5 = new VentanaStage(nivel5.getPj(), nivel5.getEnem(), 5, nivel5.getCh(), true,VentanaSeleccionNivel.this);
				stage5.setVisible(true);
			}
		});
		bN6.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				Nivel nivel6 = Nivel.listaNiveles.get(5);
				VentanaStage stage6 = new VentanaStage(nivel6.getPj(), nivel6.getEnem(), 6, nivel6.getCh(), true,VentanaSeleccionNivel.this);
				stage6.setVisible(true);	
			}
		});
		bN7.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Nivel nivel7= Nivel.listaNiveles.get(6);
				VentanaStage stage7 = new VentanaStage(nivel7.getPj(), nivel7.getEnem(), 7, nivel7.getCh(), true,VentanaSeleccionNivel.this);
				stage7.setVisible(true);	
			}
		});
		bN8.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Nivel nivel8 = Nivel.listaNiveles.get(7);
				VentanaStage stage8 = new VentanaStage(nivel8.getPj(), nivel8.getEnem(), 8, nivel8.getCh(), true,VentanaSeleccionNivel.this);
				stage8.setVisible(true);	
			}
		});
		
		bHome.addMouseListener(new MouseAdapterBotonesMenus(bHome));
		bHome.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				VentanaPrincipal.venPrincip = new VentanaPrincipal(0,user, ch.getPersonajePrincipal(), ch.getNivelesCompletados(), victorias1v1);
				VentanaPrincipal.venPrincip.setVisible(true);
				VentanaSeleccionNivel.this.dispose();	
			}
		});
		bMejoras.addMouseListener(new MouseAdapterBotonesMenus(bMejoras));
		bMejoras.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaMejoras ventana= new VentanaMejoras(user, ch, victorias1v1);
				ventana.setVisible(true);
				VentanaSeleccionNivel.this.setEnabled(false);	
			}
		});
	}
		
	public ArrayList<JButton> getArrayBotones() {
		return arrayBotones;
	}

	public void setArrayBotones(ArrayList<JButton> arrayBotones) {
		this.arrayBotones = arrayBotones;
	}

	private ArrayList<JButton> CrearListaBotones(){
		ArrayList<JButton> listaBotones = new ArrayList<>();
		
		listaBotones.add(bN1);
		listaBotones.add(bN2);
		listaBotones.add(bN3);
		listaBotones.add(bN4);
		listaBotones.add(bN5);
		listaBotones.add(bN6);
		listaBotones.add(bN7);
		listaBotones.add(bN8);
		
		return listaBotones;	
	}
	
	private ArrayList<ImageIcon> CrearlistaIconos(){
		ArrayList<ImageIcon> listaIconos = new ArrayList<>();
		
		listaIconos.add(new ImageIcon("StagePreview/Stage1Preview.jpg"));
		listaIconos.add(new ImageIcon("StagePreview/Stage2Preview.jpg"));
		listaIconos.add(new ImageIcon("StagePreview/Stage3Preview.jpg"));
		listaIconos.add(new ImageIcon("StagePreview/Stage4Preview.jpg"));
		listaIconos.add(new ImageIcon("StagePreview/Stage5Preview.jpg"));
		listaIconos.add(new ImageIcon("StagePreview/Stage6Preview.jpg"));
		listaIconos.add(new ImageIcon("StagePreview/Stage7Preview.jpg"));
		listaIconos.add(new ImageIcon("StagePreview/Stage8Preview.jpg"));
		
		return listaIconos;
		
	}
	 public void ComprobarNiveles(ArrayList<JButton> listaBotones) {
		for(int contB=1;contB< listaBotones.size();contB++) {
			if(contB>=ch.getNivelesCompletados()+1) {
				listaBotones.get(contB).setEnabled(false); 
			}else {
				listaBotones.get(contB).setEnabled(true);
			}
		}
		revalidate();
		repaint();
		
	}
	public void resetNivel() {
		Nivel.reset();
	}
	public static void main(String[] args) {
		VentanaSeleccionNivel vs = new VentanaSeleccionNivel(null, new ControlHistoria(new PersonajeJugable("", new Point(0, 0), 10, 10, 10, "Ninja"), 0), 0);
		vs.setVisible(true);
	}
}
