package control;

import java.util.ArrayList;

import javax.swing.JFrame;

import Ventanas.VentanaStage;
import personaje.Personaje;
import personaje.enemigo.Enemigo;

public class ControlAnimaciones {
	private ArrayList<String> label;
	private ArrayList<Integer> tiempos;

	
	public int AnimacionParado(long milis, Personaje personaje, VentanaStage stage,ElementoAnimacion x,String personajeTipo) {
		
		ArrayList<ElementoAnimacion> animParado = new ArrayList<>();
		switch(personajeTipo) {
		case "P1":
			animParado = x.getAnimParadoP1();
		break;
		case "P2":
			animParado = x.getAnimParadoP2();
		break;
	}
		

		
		for (ElementoAnimacion elementoAnimacion : animParado) {
			if(milis <= elementoAnimacion.getTiempos()) {
				stage.getiProta().setImagen(elementoAnimacion.getLabel());
				return 1;
			}
		}
		return 0;
	}
	

	
	public int AnimacionSaltando(long milis, Personaje personaje, VentanaStage stage,ElementoAnimacion x,String personajeTipo) {
		
		ArrayList<ElementoAnimacion> animSaltando = new ArrayList<>();
		switch(personajeTipo) {
		case "P1":
			animSaltando= x.getAnimSaltandoP1();
		break;
		case "P2":
			animSaltando= x.getAnimSaltandoP2();
		break;
	}
		
		
		
		for (ElementoAnimacion elementoAnimacion : animSaltando) {
			if(milis <= elementoAnimacion.getTiempos()) {
				stage.getiProta().setImagen(elementoAnimacion.getLabel());
				
				return 1;
			}
		}
		return 0;
	}


	

	public int AnimacionMoverse(long milis,Personaje personaje, VentanaStage stage,ElementoAnimacion x,String personajeTipo) {
		
		ArrayList<ElementoAnimacion>animMoverse = new ArrayList<>();
		switch(personajeTipo) {
			case "P1":
			animMoverse = x.getAnimMoverseP1();
			break;
			case "P2":
				animMoverse = x.getAnimMoverseP2();
				break;
		}
		
		for(ElementoAnimacion elementoAnimacion:animMoverse) {
			if(milis <=elementoAnimacion.getTiempos()) {
				stage.getiProta().setImagen(elementoAnimacion.getLabel());
				return 1;
			}
		}
		
		return 0;
		
	}
	
	public int AnimacionGolpear(long milis,Personaje personaje,VentanaStage stage,Personaje enemigo,ElementoAnimacion x,String personajeTipo) {
		
		ArrayList<ElementoAnimacion>animGolpear = new ArrayList<>(); 
		switch(personajeTipo) {
		case "P1":
			animGolpear= x.getAnimGolpearP1();
		break;
		case "P2":
			animGolpear= x.getAnimGolpearP2();
		break;
	}
		
		 
		for(ElementoAnimacion elementoAnimacion:animGolpear) {
			if(milis <=elementoAnimacion.getTiempos()) {
				stage.getiProta().setImagen(elementoAnimacion.getLabel());
				
				if(elementoAnimacion.getLabel().equals("png/Melee (4).png") || elementoAnimacion.getLabel().equals("pngEnem/Attack__004.png") ){
					
					if(stage.isActiveIA()==true) {
						enemigo.setVida(enemigo.getVida()-personaje.getFuerza()*0.1);
						stage.setJpbVida1(enemigo.getVida());
					}
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
	
	public int AnimacionGolpeado(long milis,Personaje personaje, VentanaStage stage,ElementoAnimacion x,String personajeTipo) {
		
		ArrayList<ElementoAnimacion>animGolpeado = new ArrayList<>();
		switch(personajeTipo) {
		case "P1":
			animGolpeado= x.getAnimGolpeadoP1();
		break;
		case "P2":
			animGolpeado= x.animGolpeadoP2;
		break;
	}
		
		
		for(ElementoAnimacion elementoAnimacion:animGolpeado) {
			if(milis <=elementoAnimacion.getTiempos()) {
				stage.getiProta().setImagen(elementoAnimacion.getLabel());
				return 1;
			}
		}
		
		return 0;
		
	}
	
	
}
