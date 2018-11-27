package control;

import java.util.ArrayList;

import personaje.Personaje;

public class ControlAnimaciones {
	ArrayList<String> label;
	ArrayList<Integer> tiempos;

	public ControlAnimaciones(ArrayList<String> label,ArrayList<Integer> tiempos) {
		this.label=label;
		this.tiempos=tiempos;
	}
	public void AnimacionParado(long milis, Personaje personaje) {
		if(milis >= 0 && milis <= tiempos.get(0)) {
			personaje.setlPersonaje("png/Idle (1).png");
		}if(milis > tiempos.get(0) && milis <= tiempos.get(1)) {
			personaje.setlPersonaje("png/Idle (2).png");
		}if(milis > tiempos.get(1) && milis <= tiempos.get(2)) {
			personaje.setlPersonaje("png/Idle (3).png");
		}if(milis > tiempos.get(2) && milis <= tiempos.get(3)) {
			personaje.setlPersonaje("png/Idle (4).png");
		}if(milis > tiempos.get(3) && milis <= tiempos.get(4)) {
			personaje.setlPersonaje("png/Idle (5).png");
		}if(milis > tiempos.get(4) && milis <= tiempos.get(5)) {
			personaje.setlPersonaje("png/Idle (6).png");
		}if(milis > tiempos.get(5) && milis <= tiempos.get(6)) {
			personaje.setlPersonaje("png/Idle (7).png");
		}if(milis > tiempos.get(6) && milis <= tiempos.get(7)) {
			personaje.setlPersonaje("png/Idle (8).png");
		}if(milis > tiempos.get(7) && milis <= tiempos.get(8)) {
			personaje.setlPersonaje("png/Idle (9).png");
		}if(milis > tiempos.get(8) && milis <= tiempos.get(9)) {
			personaje.setlPersonaje("png/Idle (10).png");
		}
	}
	public void AnimacionMoverse(long milis, Personaje personaje) {
		if(milis >= 0 && milis <= tiempos.get(0)) {
			personaje.setlPersonaje("png/Run (1).png");
		}if(milis > tiempos.get(0) && milis <= tiempos.get(1)) {
			personaje.setlPersonaje("png/Run (2).png");
		}if(milis > tiempos.get(1) && milis <= tiempos.get(2)){
			personaje.setlPersonaje("png/Run (3).png");
		}if(milis > tiempos.get(2) && milis <= tiempos.get(3)) {
			personaje.setlPersonaje("png/Run (4).png");
		}if(milis > tiempos.get(3) && milis <= tiempos.get(4)) {
			personaje.setlPersonaje("png/Run (5).png");
		}if(milis > tiempos.get(4) && milis <= tiempos.get(5)){
			personaje.setlPersonaje("png/Run (6).png");
		}if(milis > tiempos.get(5) && milis <= tiempos.get(6)){
			personaje.setlPersonaje("png/Run (7).png");
		}if(milis > tiempos.get(6) && milis <= tiempos.get(7)){
			personaje.setlPersonaje("png/Run (8).png");	
	}
}
}
