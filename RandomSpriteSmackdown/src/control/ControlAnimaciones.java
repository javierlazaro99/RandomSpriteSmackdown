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
		
		ArrayList<ElementoAnimacion> animParado = new ArrayList<>();
		
		if(personaje.getTipoPersonaje().equals("robot")) animParado = ElementoAnimacion.animParadoRobot; 
//		if(personaje.getTipoPersonaje().equals("ninja")) animParado = ElementoAnimacion.animParadoNinja;
		
		for (ElementoAnimacion elementoAnimacion : animParado) {
			if(milis <= elementoAnimacion.getTiempos()) {
				stage.getiProta().setImagen(elementoAnimacion.getLabel());
				return 1;
			}
		}
		return 0;
	}
	

	
	public int AnimacionSaltando(long milis, Personaje personaje, VentanaStage stage) {
		
		ArrayList<ElementoAnimacion> animSaltando = new ArrayList<>();
		
		if(personaje.getTipoPersonaje().equals("robot")) animSaltando = ElementoAnimacion.animSaltandoRobot; 
	//	if(personaje.getTipoPersonaje().equals("ninja")) animSaltando = ElementoAnimacion.animSaltandoNinja;
		
		
		for (ElementoAnimacion elementoAnimacion : animSaltando) {
			if(milis <= elementoAnimacion.getTiempos()) {
				stage.getiProta().setImagen(elementoAnimacion.getLabel());
				
				return 1;
			}
		}
		return 0;
	}


	public int AnimacionMoverseDerecha(long milis,Personaje personaje,VentanaStage stage) {
		ArrayList<ElementoAnimacion>animMoverse = new ArrayList<>();
		
		if(personaje.getTipoPersonaje().equals("robot")) animMoverse = ElementoAnimacion.animMoverseRobot; 
		if(personaje.getTipoPersonaje().equals("ninja")) animMoverse = ElementoAnimacion.animMoverseNinja;
		
		for(ElementoAnimacion elementoAnimacion: animMoverse) {
			if(milis <= elementoAnimacion.getTiempos()) {
				stage.getiProta().setImagen(elementoAnimacion.getLabel());
				return 1;
			}
		}
		
		return 0;
		
	}

	public int AnimacionMoverseIzquierda(long milis,Personaje personaje, VentanaStage stage) {
		
		ArrayList<ElementoAnimacion>animMoverse = new ArrayList<>();
		
		if(personaje.getTipoPersonaje().equals("robot")) animMoverse = ElementoAnimacion.animMoverseRobot; 
		if(personaje.getTipoPersonaje().equals("ninja")) animMoverse = ElementoAnimacion.animMoverseNinja; 
		
		for(ElementoAnimacion elementoAnimacion:animMoverse) {
			if(milis <=elementoAnimacion.getTiempos()) {
				stage.getiProta().setImagen(elementoAnimacion.getLabel());
				return 1;
			}
		}
		
		return 0;
		
	}
	
	public int AnimacionGolpear(long milis,Personaje personaje,VentanaStage stage,Personaje enemigo) {
		
		ArrayList<ElementoAnimacion>animGolpear = new ArrayList<>(); 
		
		if(personaje.getTipoPersonaje().equals("robot")) animGolpear = ElementoAnimacion.animGolpearRobot; 
		if(personaje.getTipoPersonaje().equals("ninja")) animGolpear = ElementoAnimacion.animGolpearNinja; 
		 
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
		
		ArrayList<ElementoAnimacion>animGolpeado = new ArrayList<>();
		
		if(personaje.getTipoPersonaje().equals("robot")) animGolpeado = ElementoAnimacion.animGolpeadoRobot; 
	//	if(personaje.getTipoPersonaje().equals("ninja")) animGolpeado = ElementoAnimacion.animGolpeadoNinja; 
		
		for(ElementoAnimacion elementoAnimacion:animGolpeado) {
			if(milis <=elementoAnimacion.getTiempos()) {
				stage.getiProta().setImagen(elementoAnimacion.getLabel());
				return 1;
			}
		}
		
		return 0;
		
	}
	public int AnimEnemMoverse(long milis,Enemigo enemigo,VentanaStage stage) {
		
		ArrayList<ElementoAnimacion>animMoverse = new ArrayList<>();
		
		if(enemigo.getTipoPersonaje().equals("robot")) animMoverse = ElementoAnimacion.animMoverseRobot; 
		if(enemigo.getTipoPersonaje().equals("ninja")) animMoverse = ElementoAnimacion.animMoverseNinja; 
		

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
