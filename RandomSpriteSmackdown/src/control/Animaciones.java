package control;

import java.awt.Point;
import java.util.ArrayList;

import Personalizados.JLabelGraficoAjustado;
import personaje.Personaje;
import personaje.personajeJugable.PersonajeJugable;

public class Animaciones implements Runnable {
	private ArrayList<String> listaPaths;
	private PersonajeJugable p;
	private JLabelGraficoAjustado lAnim;
	private int codigoMovimiento=0;
	// codigo Movimiento
	//Moverse para delante 0 
	//Moverse para atras 1
	//Salto=2
	//Pegar=3
	public Animaciones(ArrayList<String> listaPaths, JLabelGraficoAjustado lAnim,int codigoMovimiento,PersonajeJugable p) {
		this.listaPaths = listaPaths;
		this.lAnim = lAnim;
		this.codigoMovimiento=codigoMovimiento;
		this.p = p;
	}
	
	public static void animacionAndar(ArrayList<String> listaPaths, Personaje p) {
		
		
	}

	@Override
	public void run() {
		if(codigoMovimiento==0) {
<<<<<<< HEAD
			p.Moverse(1, 0);
			
			
=======
			p.Moverse(10, 0);
				
>>>>>>> branch 'master' of https://github.com/javierlazaro99/RandomSpriteSmackdown.git
			
			for (String path : listaPaths) {
				lAnim.setImagen(path);

				try {
					Thread.sleep(12);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			lAnim.setLocation(new Point(p.getPosicion().x, p.getPosicion().y));
			}
		}
		if(codigoMovimiento==1) {
			p.Moverse(-5, 0);
			
			for (String path : listaPaths) {
				lAnim.setImagen(path);
				
			
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			System.out.println(path);
		}
			lAnim.setLocation(new Point(p.getPosicion().x, p.getPosicion().y));
		}
		if(codigoMovimiento==2) {
			
			try {
				p.Moverse(0, -15);
				lAnim.setLocation(p.getPosicion());
				
				for (String path : listaPaths) {
					lAnim.setImagen(path);
					Thread.sleep(16);
				}
				p.Moverse(0, 15);
				lAnim.setLocation(p.getPosicion());
				codigoMovimiento=0;
				
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		if(codigoMovimiento==3) {
				
				try {
					for (String path : listaPaths) {
						lAnim.setImagen(path);
						
						Thread.sleep(25);
					}
	
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
	}

	public ArrayList<String> getListaPaths() {
		return listaPaths;
	}

	public void setListaPaths(ArrayList<String> listaPaths) {
		this.listaPaths = listaPaths;
	}

	public int getCodigoMovimiento() {
		return codigoMovimiento;
	}

	public void setCodigoMovimiento(int codigoMovimiento) {
		this.codigoMovimiento = codigoMovimiento;
	}

}
