package personalizados;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Fondo extends JPanel{


		public Fondo(){

		}
		@Override
		public void paintComponent (Graphics g){
		Dimension tamanio = getSize();
		ImageIcon imagenFondo = new ImageIcon(getClass().getResource("src\\Fondo.gif"));
		g.drawImage(imagenFondo.getImage(),0,0,tamanio.width, tamanio.height, null);
		setOpaque(false);
		super.paintComponent(g);
		}

		}

