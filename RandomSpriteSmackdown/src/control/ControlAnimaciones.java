package control;

import java.util.ArrayList;

import javax.swing.JFrame;

import Ventanas.VentanaStage;
import personaje.Personaje;
import personaje.enemigo.Enemigo;

public class ControlAnimaciones {
	private ArrayList<String> label;
	private ArrayList<Integer> tiempos;

	
	public int AnimacionParado(long milis, Personaje personaje, VentanaStage stage) {
		ArrayList<ElementoAnimacion> animParado = ElementoAnimacion.animParado;
		
		for (ElementoAnimacion elementoAnimacion : animParado) {
			if(milis <= elementoAnimacion.getTiempos()) {
				stage.getiProta().setImagen(elementoAnimacion.getLabel());
				return 1;
			}
		}
		return 0;
	}
	

	
	public int AnimacionSaltando(long milis, Personaje personaje, VentanaStage stage) {
		ArrayList<ElementoAnimacion> animSaltando = ElementoAnimacion.animSaltando;
		
		for (ElementoAnimacion elementoAnimacion : animSaltando) {
			if(milis <= elementoAnimacion.getTiempos()) {
				stage.getiProta().setImagen(elementoAnimacion.getLabel());
				
				return 1;
			}
		}
		return 0;
	}


	public int AnimacionMoverseDerecha(long milis,Personaje personaje,VentanaStage stage) {
		ArrayList<ElementoAnimacion>animMoverse = ElementoAnimacion.animMoverse;
		
		for(ElementoAnimacion elementoAnimacion: animMoverse) {
			if(milis <= elementoAnimacion.getTiempos()) {
				stage.getiProta().setImagen(elementoAnimacion.getLabel());
				return 1;
			}
		}
		
		return 0;
		
	}

	public int AnimacionMoverseIzquierda(long milis,Personaje personaje, VentanaStage stage) {
		ArrayList<ElementoAnimacion>animMoverse = ElementoAnimacion.animMoverse;
		for(ElementoAnimacion elementoAnimacion:animMoverse) {
			if(milis <=elementoAnimacion.getTiempos()) {
				stage.getiProta().setImagen(elementoAnimacion.getLabel());
				return 1;
			}
		}
		
		return 0;
		
	}
	
	public int AnimacionGolpear(long milis,Personaje personaje,VentanaStage stage,Personaje enemigo) {
		ArrayList<ElementoAnimacion>animGolpear = ElementoAnimacion.animGolpear;
		for(ElementoAnimacion elementoAnimacion:animGolpear) {
			if(milis <=elementoAnimacion.getTiempos()) {
				stage.getiProta().setImagen(elementoAnimacion.getLabel());
				
				if(elementoAnimacion.getLabel().equals("png/Melee (4).png")){
					
					
					personaje.DarGolpe(enemigo);
					stage.setJpbVida2(enemigo.getVida());
					System.out.println(personaje.getPosicion());
					System.out.println(enemigo.getPosicion());
					System.out.println(enemigo.getVida());
					
					
				}
				
				return 1;
			}
		}
		
		return 0;
		
	}
	
	public int AnimacionGolpeado(long milis,Personaje personaje, VentanaStage stage) {
		ArrayList<ElementoAnimacion>animGolpeado = ElementoAnimacion.animGolpeado;
		for(ElementoAnimacion elementoAnimacion:animGolpeado) {
			if(milis <=elementoAnimacion.getTiempos()) {
				stage.getiProta().setImagen(elementoAnimacion.getLabel());
				return 1;
			}
		}
		
		return 0;
		
	}
	public int AnimEnemMoverse(long milis,Enemigo enemigo,VentanaStage stage) {
		ArrayList<ElementoAnimacion>animMoverse = ElementoAnimacion.animEnemMoverse;
		for(ElementoAnimacion elemento:animMoverse) {
			if(milis <= elemento.getTiempos()) {
				
				stage.getiEnemigo().setImagen(elemento.getLabel());
				stage.repaint();
				stage.revalidate();
				return 1;
			}
		}
		return 0;
	}
}
