package control;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;

/**
 * Clase que guarda las distintas subclases de mouse adapters
 * personalizados que utilizan los botones
 * @author pc
 *
 */
public class MouseAdapters {
	
	public MouseAdapters() {
	}
	
	/**
	 * Adaptador para los Botones de subida de nivel de la ventana mejoras
	 * @author pc
	 *
	 */
	public static class MouseAdapterSubirNivel extends MouseAdapter{
		
		private JButton boton;
		
		public MouseAdapterSubirNivel(JButton b) {
			this.boton = b;
		}
		
		@Override
		public void mouseEntered(MouseEvent e) {
			boton.setBorderPainted(true);
			boton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));	
			boton.setContentAreaFilled(true);
			boton.setBackground(Color.orange);
		}

		@Override
		public void mouseExited(MouseEvent e) {
			boton.setBorder(null);
			boton.setContentAreaFilled(false);
		}
	}
	
	/**
	 * Adaptador para los Botones de subida de nivel de la ventana principal 
	 * @author pc
	 *
	 */
	public static class MouseAdapterBotonesVentanaPrincipal extends MouseAdapter{
		
		private JButton boton;
		
		public MouseAdapterBotonesVentanaPrincipal(JButton b) {
			this.boton = b;
		}
		
		@Override
		public void mouseEntered(MouseEvent e) {
			boton.setBorderPainted(true);
			boton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));	
			boton.setContentAreaFilled(true);
			
			float[] f = Color.RGBtoHSB(64, 64, 63, null);
			boton.setBackground(Color.getHSBColor(f[0], f[1], f[2]));
		}

		@Override
		public void mouseExited(MouseEvent e) {
			boton.setBorder(null);
			boton.setContentAreaFilled(false);
		}
	}
	
	/**
	 * Adaptador para los Botones de los distintos menus 
	 * @author pc
	 *
	 */
	public static class MouseAdapterBotonesMenus extends MouseAdapter{
		
		private JButton boton;
		
		public MouseAdapterBotonesMenus(JButton b) {
			this.boton = b;
		}
		
		@Override
		public void mouseEntered(MouseEvent e) {
			float[] f = Color.RGBtoHSB(78, 42, 8, null);
			boton.setBackground(Color.getHSBColor(f[0], f[1], f [2]));
		}

		@Override
		public void mouseExited(MouseEvent e) {
			boton.setBackground(Color.black);
		}
	}
	
	/**
	 * Adaptador para botones previous next de la venta de seleccion
	 * @author pc
	 *
	 */
	public static class MouseAdapterPreviousNext extends MouseAdapter{
		private JButton boton;
	
		public MouseAdapterPreviousNext(JButton b) {
			this.boton = b;
		}
		
		@Override
		public void mouseEntered(MouseEvent e) {
			float[] f = Color.RGBtoHSB(225, 160, 45, null);
			boton.setBackground(Color.getHSBColor(f[0], f[1], f [2]));
		}
	
		@Override
		public void mouseExited(MouseEvent e) {
			boton.setBackground(Color.darkGray);
		}
	}
}
