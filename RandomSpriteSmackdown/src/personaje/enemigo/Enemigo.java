package personaje.enemigo;

import java.awt.Point;
import java.util.Random;

import javax.swing.JFrame;

import personaje.Personaje;
import personaje.personajeJugable.PersonajeJugable;

public class Enemigo extends Personaje {
	
	private int dificultad;

	public Enemigo(Point posicion, int fuerza, int vida, int velocidad, int dificultad) {
		super(posicion, fuerza, vida, velocidad);
		this.dificultad = dificultad;
	}
	
	public int getDificultad() {
		return dificultad;
	}

	public void setDificultad(int dificultad) {
		this.dificultad = dificultad;
	}

	@Override
	public void DarGolpe(Personaje enemigo) {
		// TODO Auto-generated method stub

	}

	public void IAMovimiento(Personaje p) {
		Point pos = p.getPosicion();
		//Hay que comprobar si el jugador está a la derecha del enemigo o a la izquierda
		if (getPosicion().getX() > pos.getX()) {
			this.Moverse(null, -1, 0);
		}else if (getPosicion().getX() < pos.getX()){
			this.Moverse(null, 1, 0);
		}
		
		
	}
}
