package personaje;

import java.awt.Point;

import javax.swing.JFrame;

import Personalizados.JLabelGraficoAjustado;
import Ventanas.VentanaStage;

public abstract class Personaje {
	
	private Point posicion;
	private double fuerza;
	private double vida;
	private double velocidad;
	private JLabelGraficoAjustado lPersonaje;
	
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
	
	public void crearlPersonaje(int width, int height) {
		this.lPersonaje = new JLabelGraficoAjustado("", width, height);
	}
	
	public JLabelGraficoAjustado getlPersonaje() {
		return this.lPersonaje;
	}
	
	public void setlPersonaje(String path) {
		this.lPersonaje.setImagen(path);
	}

	@Override
	public String toString() {
		return "Personaje [fuerza=" + fuerza + ", vida=" + vida + ", velocidad=" + velocidad
				+ "]";
	}
	
	/** Método para calcular un golpe en la lógica interna del programa
	 * @param enemigo personaje que recibe el golpe
	 * @return 
	 */
	public abstract void DarGolpe(Personaje enemigo);
	
	public void Moverse(double movX, double movY,VentanaStage stage) {
		//if(posicion.getX()<=-20 || posicion.getX() >= 1800) {
		System.out.println(stage.getWidth()+"-"+posicion.getX());
		posicion.setLocation(posicion.getX() + movX * getVelocidad(), posicion.getY() + movY * getVelocidad());
		
		//}
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
