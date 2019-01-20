package personaje;

import java.awt.Point;

import Personalizados.JLabelGraficoAjustado;
import Ventanas.VentanaStage;
import control.ControlEstados;

public abstract class Personaje {
	
	private Point posicion;
	private double fuerza;
	private double vida;
	private double velocidad;
	private JLabelGraficoAjustado lPersonaje;
	private String tipoPersonaje;
	
	public Personaje(Point posicion, double fuerza, double vida, double velocidad, String tipoPersonaje) {
		this.posicion = posicion;
		this.fuerza = fuerza;
		this.vida = vida;
		this.velocidad = velocidad;
		this.tipoPersonaje = tipoPersonaje;
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
	
	public String getTipoPersonaje() {
		return tipoPersonaje;
	}

	public void setTipoPersonaje(String tipoPersonaje) {
		this.tipoPersonaje = tipoPersonaje;
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
	public abstract int DarGolpe(Personaje enemigo);
	
	public void Moverse(double movX, double movY,VentanaStage stage,ControlEstados ce) {//Preguntar
		if((posicion.getX() + movX * getVelocidad())>=-100 && (posicion.getX() + movX * getVelocidad())<= stage.getWidth()-150) {
		ce.setChoque(false);
		
		posicion.setLocation(posicion.getX() + movX * getVelocidad(), posicion.getY() + movY * getVelocidad());
		}else {
			posicion.setLocation(posicion.getX(), posicion.getY());
			ce.setChoque(true);
		
		}
	}
	
	public void Rebotar(Personaje golpeador,VentanaStage stage) {
		double pos = this.getPosicion().getX();
		
		if(golpeador.getPosicion().getX() <= this.getPosicion().getX()) { //El golpeado está a la derecha
			posicion.setLocation(pos + 20, getPosicion().getY());
			stage.getiProta().setLocation(posicion);
		}else if (golpeador.getPosicion().getX() >= this.getPosicion().getX()) {
			posicion.setLocation(pos - 20, getPosicion().getY());
			stage.getiProta().setLocation(posicion);
		}
	}
}
