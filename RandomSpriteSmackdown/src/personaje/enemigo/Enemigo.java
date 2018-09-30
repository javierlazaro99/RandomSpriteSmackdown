package personaje.enemigo;

import java.awt.Point;

import javax.swing.JFrame;

import personaje.Personaje;

public class Enemigo extends Personaje {
	
	private Point posicion;
	private int dificultad;

	public Enemigo(int fuerza, int vida, int velocidad) {
		super(fuerza, vida, velocidad);
	}
	
	public Point getPosicion() {
		return posicion;
	}

	public void setPosicion(Point posicion) {
		this.posicion = posicion;
	}

	@Override
	public void DarGolpe(Personaje enemigo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void Moverse(JFrame stage, int movX, int movY) {
		// TODO Auto-generated method stub

	}
}
