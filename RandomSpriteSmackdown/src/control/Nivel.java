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
	private PersonajeJugable pj;
	private Enemigo enem;
	private ControlHistoria ch;
	public Nivel(PersonajeJugable pj, Enemigo enem, int numNiv,ControlHistoria ch) {
		this.pj=pj;
		this.enem=enem;
		this.ch=ch;
	}
	
	public PersonajeJugable getPj() {
		return pj;
	}

	public void setPj(PersonajeJugable pj) {
		this.pj = pj;
	}

	public Enemigo getEnem() {
		return enem;
	}

	public void setEnem(Enemigo enem) {
		this.enem = enem;
	}

	public ControlHistoria getCh() {
		return ch;
	}

	public void setCh(ControlHistoria ch) {
		this.ch = ch;
	}

	public static void generarListaNiveles(PersonajeJugable pj,ControlHistoria ch) {
		//Me he copiado y pegado el mismo nivel todo el rato, esto hay que tunearlo para hacer cada uno distinto del otro
		//cambiando los atributos del enemigo, y el stage
		listaNiveles.add(new Nivel(pj, new Enemigo(new Point(100, 0), 10, 10, 10,"robot", 1), 1,ch));
		listaNiveles.add(new Nivel(pj, new Enemigo(new Point(100, 0), 10, 20, 10,"ninja", 1), 2,ch));
		listaNiveles.add(new Nivel(pj, new Enemigo(new Point(100, 0), 10, 30, 10,"robot", 1), 3,ch));
		listaNiveles.add(new Nivel(pj, new Enemigo(new Point(100, 0), 10, 40, 10,"ninja", 1), 4,ch));
		listaNiveles.add(new Nivel(pj, new Enemigo(new Point(100, 0), 10, 50, 10,"robot", 1), 5,ch));
		listaNiveles.add(new Nivel(pj, new Enemigo(new Point(100, 0), 20, 50, 10,"ninja", 1), 6,ch));
		listaNiveles.add(new Nivel(pj, new Enemigo(new Point(100, 0), 20, 50, 20,"robot", 1), 7,ch));
		listaNiveles.add(new Nivel(pj, new Enemigo(new Point(100, 0), 30, 60, 30,"ninja", 1), 8,ch));
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
