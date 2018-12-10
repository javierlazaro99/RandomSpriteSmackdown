package personaje.personajeJugable;

import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

import Personalizados.JLabelGraficoAjustado;
import personaje.Personaje;

public class PersonajeJugable extends Personaje {
	
	private String nombre;
	private int puntosMejora;
	private JLabelGraficoAjustado lPersonaje;
	private JProgressBar pbFuerza;
	private JProgressBar pbVida;
	private JProgressBar pbVelocidad;
	private String path;

	public PersonajeJugable(String nombre,Point posicion, int fuerza, int vida, int velocidad, String path) {
		super(posicion, fuerza, vida, velocidad);
		this.nombre = nombre;
		this.path = path;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPuntosMejora() {
		return puntosMejora;
	}

	public void setPuntosMejora(int puntosMejora) {
		this.puntosMejora = puntosMejora;
	}
	
	public JLabelGraficoAjustado getlPersonaje(int width, int height) {
		if(lPersonaje == null) {
			lPersonaje = new JLabelGraficoAjustado(path, width, height);
		}
		return lPersonaje;
	}
	
//	public void setlPersonaje(String path, int width, int height) {
//		this.lPersonaje = new JLabelGraficoAjustado(path, width, height);
//	}
//	
//	public JLabelGraficoAjustado getlPersonaje() {
//		return lPersonaje;
//	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public JProgressBar getPbFuerza() {
		if(pbFuerza == null) {
			pbFuerza = new JProgressBar(0, 100);
			pbFuerza.setValue((int) this.getFuerza());
		}
		return pbFuerza;
	}

	public JProgressBar getPbVida() {
		if(pbVida == null) {
			pbVida = new JProgressBar(0, 100);
			pbVida.setValue((int) this.getVida());
		}
		return pbVida;
	}
	

	public JProgressBar getPbVelocidad() {
		if(pbVelocidad == null) {
			pbVelocidad = new JProgressBar(0, 100);
			pbVelocidad.setValue((int) this.getVelocidad());
		}
		return pbVelocidad;
	}

	public void SubirNivel(String statASubir) {
		if(this.getPuntosMejora() > 0 && (statASubir.equals("fuerza") || statASubir.equals("vida") || statASubir.equals("velocidad"))) {
			if(statASubir.equals("fuerza")) {
				this.setFuerza(this.getFuerza() + 10);
			}if (statASubir.equals("vida")) {
				this.setVida(this.getVida() + 10);
			}if (statASubir.equals("velocidad")){
				this.setVelocidad(this.getVelocidad() + 10);
			}
			
			this.setPuntosMejora(getPuntosMejora() - 1);
		}	
	}

	@Override
	public void DarGolpe(Personaje enemigo) {
		double distancia = Math.sqrt(Math.pow(enemigo.getPosicion().getX() - this.getPosicion().getX(), 2));
		
		if(distancia < 5) {
			//Se ejecuta el pegado
			enemigo.setVida(enemigo.getVida() - 0.1 * this.getFuerza());
			enemigo.Rebotar(this);
			
		}
		
	}
}
