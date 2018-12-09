package control;

import java.awt.Point;
import java.lang.reflect.GenericArrayType;
import java.util.ArrayList;

import Ventanas.VentanaStage;
import personaje.Personaje;
import personaje.enemigo.Enemigo;
import personaje.personajeJugable.PersonajeJugable;

public class Nivel {
	
	public static ArrayList<Nivel> listaNiveles = new ArrayList<Nivel>();
	private VentanaStage stage;
	private int numNivel;
	
	public Nivel(PersonajeJugable pj, Enemigo enem, int numNiv,ControlHistoria ch) {
		stage = new VentanaStage(pj, enem,numNiv,ch);
	}
	
	public static void generarListaNiveles(PersonajeJugable pj,ControlHistoria ch) {
		//Me he copiado y pegado el mismo nivel todo el rato, esto hay que tunearlo para hacer cada uno distinto del otro
		//cambiando los atributos del enemigo, y el stage
		listaNiveles.add(new Nivel(pj, new Enemigo(new Point(100, 0), 10, 10, 10, 1), 1,ch));
		listaNiveles.add(new Nivel(pj, new Enemigo(new Point(100, 0), 10, 10, 10, 1), 2,ch));
		listaNiveles.add(new Nivel(pj, new Enemigo(new Point(100, 0), 10, 10, 10, 1), 3,ch));
		listaNiveles.add(new Nivel(pj, new Enemigo(new Point(100, 0), 10, 10, 10, 1), 4,ch));
		listaNiveles.add(new Nivel(pj, new Enemigo(new Point(100, 0), 10, 10, 10, 1), 5,ch));
		listaNiveles.add(new Nivel(pj, new Enemigo(new Point(100, 0), 10, 10, 10, 1), 6,ch));
		listaNiveles.add(new Nivel(pj, new Enemigo(new Point(100, 0), 10, 10, 10, 1), 7,ch));
		listaNiveles.add(new Nivel(pj, new Enemigo(new Point(100, 0), 10, 10, 10, 1), 8,ch));
	}

	public VentanaStage getStage() {
		return stage;
	}

	public void setStage(VentanaStage stage) {
		this.stage = stage;
	}

	public int getNumNivel() {
		return numNivel;
	}

	public void setNumNivel(int numNivel) {
		this.numNivel = numNivel;
	}
}
