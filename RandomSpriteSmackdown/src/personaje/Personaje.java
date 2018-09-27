package personaje;

import javax.swing.JFrame;

public abstract class Personaje {
	
	private int fuerza;
	private int vida;
	private int velocidad;
	
	public Personaje(int fuerza, int vida, int velocidad) {
		this.fuerza = fuerza;
		this.vida = vida;
		this.velocidad = velocidad;
	}

	public int getFuerza() {
		return fuerza;
	}

	public void setFuerza(int fuerza) {
		this.fuerza = fuerza;
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velocidad) {
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
	
	public abstract void Moverse(JFrame stage, int movX, int movY);
}
