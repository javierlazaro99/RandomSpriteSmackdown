package Ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Personalizados.JLabelGraficoAjustado;
import Personalizados.JPanelBackground;
import control.MouseAdapters.MouseAdapterBotonesMenus;

public class VentanaAyuda extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JLabelGraficoAjustado lgaBoton = new JLabelGraficoAjustado("", 100, 100);
	private JLabelGraficoAjustado lPersonaje;
	
	public VentanaAyuda() {
	
		setSize(700, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setUndecorated(true);

		JPanelBackground pB = new JPanelBackground("src/FondoMadera.png");
		pB.setLayout(new BorderLayout());
			JPanel pPrincipal = new JPanel(new GridLayout(1, 2));
				JPanel pIzquierda = new JPanel(new GridBagLayout());
					lPersonaje = new JLabelGraficoAjustado("png/Idle (1).png", 290,300);
				JPanel pDerecha = new JPanel(new BorderLayout());
					JPanel pDerechaSup = new JPanel(new GridBagLayout());
						JLabel lDerecha = new JLabel("Tecla Pulsada");
					JPanel pDerechaCentr = new JPanel(new GridBagLayout());
			JPanel pSuperior = new JPanel(new GridBagLayout());
				JLabel lTitulo = new JLabel("Tutorial");
			JPanel pInferior = new JPanel();
				JButton bHome = new JButton("Home");
				
		///////////////////////////////
		pB.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
		lTitulo.setFont(new Font("Unreal Tournament", Font.PLAIN, 60));
		lTitulo.setForeground(Color.ORANGE);
		lDerecha.setFont(new Font("Play Pretend", Font.PLAIN, 20));
		lDerecha.setForeground(Color.ORANGE);
		
		pDerechaSup.setPreferredSize(new Dimension(200, 70));
		lgaBoton.setVisible(false);
		
		pIzquierda.setBorder(BorderFactory.createLineBorder(Color.black, 5));
		
		bHome.setFont(new Font("Play Pretend", Font.TRUETYPE_FONT, 20));
		bHome.setForeground(Color.ORANGE);
		bHome.setPreferredSize(new Dimension(130, 40));
		bHome.setFocusable(false);
		bHome.setBackground(Color.black);
		bHome.setBorder(BorderFactory.createLineBorder(Color.lightGray, 3));
		
		///////////////////////////////
		pPrincipal.setOpaque(false);
		pDerecha.setOpaque(false);
		pSuperior.setOpaque(false);
		pInferior.setOpaque(false);
		pDerechaCentr.setOpaque(false);
		pDerechaSup.setOpaque(false);
		
		pIzquierda.setBackground(Color.LIGHT_GRAY);
		
			
		this.add(pB);
			pB.add(pPrincipal, BorderLayout.CENTER);
				pPrincipal.add(pIzquierda);
					pIzquierda.add(lPersonaje);
				pPrincipal.add(pDerecha);
					pDerecha.add(pDerechaSup, BorderLayout.NORTH);
						pDerechaSup.add(lDerecha);
					pDerecha.add(pDerechaCentr, BorderLayout.CENTER);
						pDerechaCentr.add(lgaBoton);
			pB.add(pSuperior, BorderLayout.NORTH);
				pSuperior.add(lTitulo);
			pB.add(pInferior, BorderLayout.SOUTH);
				pInferior.add(bHome);
		
		
		bHome.addMouseListener(new MouseAdapterBotonesMenus(bHome));
		bHome.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaPrincipal.venPrincip.setEnabled(true);
				VentanaAyuda.this.dispose();
			}
		});
		
		addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyReleased(KeyEvent e) {
				lPersonaje.setImagen("png/Idle (1).png");
				lgaBoton.setVisible(false);
				repaint();
			}
				
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_W) {
					lPersonaje.setHorFlip(false);
					lPersonaje.setImagen("png/Jump (3).png");
					lgaBoton.setSize(200, 200);
					lgaBoton.setVisible(true);
					lgaBoton.setImagen("src/letter_w.png"); 
				}
				if(e.getKeyCode() == KeyEvent.VK_D) {
					lPersonaje.setHorFlip(false);
					lPersonaje.setImagen("png/Run (3).png");
					lgaBoton.setSize(200, 200);
					lgaBoton.setVisible(true);
					lgaBoton.setImagen("src/letter_d.png"); 
				}
				if(e.getKeyCode() == KeyEvent.VK_A) {
					lPersonaje.setHorFlip(true);
					lPersonaje.setImagen("png/Run (3).png");
					lgaBoton.setSize(200, 200);
					lgaBoton.setVisible(true);
					lgaBoton.setImagen("src/letter_a.png"); 
				}
				if(e.getKeyCode() == KeyEvent.VK_SPACE) {
					lPersonaje.setHorFlip(false);
					lPersonaje.setImagen("png/Melee (1).png");
					lgaBoton.setImagen("src/space_key_s.png"); 
					lgaBoton.setVisible(true);
					lgaBoton.setSize(260, 100);
				}
			}
		});
	}
	
	public static void main(String[] args) {
		VentanaAyuda va = new VentanaAyuda();
		va.setVisible(true);
	}
}
