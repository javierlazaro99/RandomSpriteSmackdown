package control;

import java.util.ArrayList;

import Personalizados.JLabelGraficoAjustado;
import personaje.Personaje;
import personaje.personajeJugable.PersonajeJugable;

public class Animaciones implements Runnable {
	private ArrayList<String> listaPaths;
	private PersonajeJugable p;
	private JLabelGraficoAjustado lAnim;
	
	public Animaciones(ArrayList<String> listaPaths, JLabelGraficoAjustado lAnim) {
		this.listaPaths = listaPaths;
		this.lAnim = lAnim;
	}
	
	public static void animacionAndar(ArrayList<String> listaPaths, Personaje p) {
		
		
	}

	@Override
	public void run() {
		for (String path : listaPaths) {
			lAnim.setImagen(path);
			
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
		
	}

}
