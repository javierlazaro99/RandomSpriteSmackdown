package personaje.personajeJugable;

import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JLabel;

import personaje.Personaje;

public class PersonajeJugable extends Personaje {
	
	private String nombre;
	private Point posicion;
	private int puntosMejora;
	private JLabel lPersonaje;
	private JLabel lFuerza;
	private JLabel lVida;
	private JLabel lVelocidad;

	public PersonajeJugable(String nombre,Point posicion, int fuerza, int vida, int velocidad) {
		super(fuerza, vida, velocidad);
		this.nombre = nombre;
		this.posicion = posicion;
		this.puntosMejora = 0;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Point getPosicion() {
		return posicion;
	}

	public void setPosicion(Point posicion) {
		this.posicion = posicion;
	}

	public int getPuntosMejora() {
		return puntosMejora;
	}

	public void setPuntosMejora(int puntosMejora) {
		this.puntosMejora = puntosMejora;
	}
	
	public JLabel getlPersonaje() {
		if(lPersonaje == null) {
			lPersonaje = new JLabel();
		}
		return lPersonaje;
	}

	public JLabel getlFuerza() {
		if(lFuerza == null) {
			lFuerza = new JLabel();
		}
		return lFuerza;
	}

	public JLabel getlVida() {
		if(lVida == null) {
			lVida = new JLabel();
		}
		return lVida;
	}

	public JLabel getlVelocidad() {
		if(lVelocidad == null) {
			lVelocidad = new JLabel();
		}
		return lVelocidad;
	}
	
	public void SubirNivel(String statASubir) {
		if(this.getPuntosMejora() > 0) {
			if(statASubir.equals("fuerza")) {
				this.setFuerza(this.getFuerza() + 1);
			}else if (statASubir.equals("vida")) {
				this.setVida(this.getVida() + 1);
			}else {
				this.setVelocidad(this.getVelocidad() + 1);
			}
		}	
	}

	@Override
	public void DarGolpe(Personaje enemigo) {
		
	}

	@Override
	public void Moverse(JFrame stage, int movX, int movY) {
		posicion.setLocation(posicion.getX() + movX, posicion.getY() + movY);
		
	}
	
	
	

}
