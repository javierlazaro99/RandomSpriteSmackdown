package personaje;

import java.awt.Point;

import javax.swing.JFrame;

public abstract class Personaje {
	
	private Point posicion;
	private double fuerza;
	private double vida;
	private double velocidad;
	
	public Personaje(Point posicion, double fuerza, double vida, double velocidad) {
		this.posicion = posicion;
		this.fuerza = fuerza;
		this.vida = vida;
		this.velocidad = velocidad;
	}

	public Point getPosicion() {
		return posicion;
	}
	
	public void setPosicion(Point posicion) {
		this.posicion = posicion;
	}

	public double getFuerza() {
		return fuerza;
	}

	public void setFuerza(double fuerza) {
		this.fuerza = fuerza;
	}

	public double getVida() {
		return vida;
	}

	public void setVida(double vida) {
		this.vida = vida;
	}

	public double getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(double velocidad) {
		this.velocidad = velocidad;
	}

	@Override
	public String toString() {
		return "Personaje [fuerza=" + fuerza + ", vida=" + vida + ", velocidad=" + velocidad
				+ "]";
	}
	
	/** Método para calcular un golpe en la lógica interna del programa
	 * @param enemigo personaje que recibe el golpe
	 */
	public abstract void DarGolpe(Personaje enemigo);
	
	public void Moverse(double movX, double movY) {
		posicion.setLocation(posicion.getX() + movX * getVelocidad(), posicion.getY() + movY * getVelocidad());
	}
	
	public void Rebotar(Personaje golpeador) {
		double pos = this.getPosicion().getX();
		
		if(golpeador.getPosicion().getX() <= this.getPosicion().getX()) { //El golpeado está a la derecha
			posicion.setLocation(pos + pos/2, getPosicion().getY());
		}else if (golpeador.getPosicion().getX() >= this.getPosicion().getX()) {
			posicion.setLocation(pos -  pos/2, getPosicion().getY());
		}
	}
}
