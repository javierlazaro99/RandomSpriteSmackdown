package control;

import java.util.ArrayList;

import javax.swing.JFrame;

import personaje.Personaje;

public class ControlAnimaciones {
	ArrayList<String> label;
	ArrayList<Integer> tiempos;

	
	public String AnimacionParado(long milis, Personaje personaje, JFrame stage) {
		ArrayList<ElementoAnimacion> animParado = ElementoAnimacion.animParado;
		
		for (ElementoAnimacion elementoAnimacion : animParado) {
			if(milis <= elementoAnimacion.getTiempos()) {
				return elementoAnimacion.getLabel();
			}
		}
		return "";
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
	
	public String AnimacionSaltando(long milis, Personaje personaje, JFrame stage) {
		ArrayList<ElementoAnimacion> animSaltando = ElementoAnimacion.animSaltando;
		
		for (ElementoAnimacion elementoAnimacion : animSaltando) {
			if(milis <= elementoAnimacion.getTiempos()) {
				return elementoAnimacion.getLabel();
			}
		}
		return "";
	}
}
