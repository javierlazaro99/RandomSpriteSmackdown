package control;

import java.awt.Point;
import java.util.ArrayList;

import javax.swing.JFrame;

import Ventanas.VentanaStage;
import personaje.Personaje;
import personaje.enemigo.Enemigo;
import personaje.personajeJugable.PersonajeJugable;

public class ControlAnimaciones {
	private ArrayList<String> label;
	private ArrayList<Integer> tiempos;

	
	public int AnimacionParado(long milis, Personaje personaje, VentanaStage stage,ElementoAnimacion x) {
		
		ArrayList<ElementoAnimacion> animParado = new ArrayList<>();
		animParado = x.getAnimParado();
	
		for (ElementoAnimacion elementoAnimacion : animParado) {
			if(milis <= elementoAnimacion.getTiempos()) {
				if(personaje.equals(stage.getpPrincipal())) {
					stage.getiProta().setImagen(elementoAnimacion.getLabel());
				}
				if(personaje.equals(stage.getpSecundario())) {
					stage.getiEnemigo().setImagen(elementoAnimacion.getLabel());
				}
				return 1;
			}
		}
		return 0;
	}
	
	
	public int AnimacionSaltando(long milis, Personaje personaje, VentanaStage stage,ElementoAnimacion x) {
		
		ArrayList<ElementoAnimacion> animSaltando = new ArrayList<>();
		animSaltando = x.getAnimSaltando();
		
		
		for (ElementoAnimacion elementoAnimacion : animSaltando) {
			if(milis <= elementoAnimacion.getTiempos()) {
				if(personaje.equals(stage.getpPrincipal())) {
					stage.getiProta().setImagen(elementoAnimacion.getLabel());
				}
				if(personaje.equals(stage.getpSecundario())) {
					stage.getiEnemigo().setImagen(elementoAnimacion.getLabel());
				}
				
				return 1;
			}
		}
		return 0;
	}

	
	public int AnimacionMoverse(long milis,Personaje personaje, VentanaStage stage,ElementoAnimacion x) {
		
		ArrayList<ElementoAnimacion>animMoverse = new ArrayList<>();
		animMoverse = x.getAnimMoverse();
		
		for(ElementoAnimacion elementoAnimacion:animMoverse) {
			if(milis <=elementoAnimacion.getTiempos()) {
				
				if(personaje.equals(stage.getpPrincipal())) {
					stage.getiProta().setImagen(elementoAnimacion.getLabel());
				}
				if(personaje.equals(stage.getpSecundario())) {
					stage.getiEnemigo().setImagen(elementoAnimacion.getLabel());
				}
				
				return 1;
			}
		}
		
		return 0;
		
	}
	
	public int AnimacionGolpear(long milis,Personaje personaje,VentanaStage stage,Personaje enemigo,ElementoAnimacion x,ControlIA cIA) {
		
		ArrayList<ElementoAnimacion>animGolpear = new ArrayList<>(); 
		animGolpear = x.getAnimGolpear();
		 
		for(ElementoAnimacion elementoAnimacion:animGolpear) {
			if(milis <=elementoAnimacion.getTiempos()) {
				if(personaje.equals(stage.getpPrincipal())) {
					stage.getiProta().setImagen(elementoAnimacion.getLabel());
				}
				if(personaje.equals(stage.getpSecundario())) {
					stage.getiEnemigo().setImagen(elementoAnimacion.getLabel());
				}
				
				if(elementoAnimacion.getLabel().equals("png/Melee (4).png") || elementoAnimacion.getLabel().equals("pngEnem/Attack__004.png") ){
					
					if(personaje instanceof PersonajeJugable) {
						personaje.DarGolpe(enemigo);
						stage.getJpbVida2().setValue((int)enemigo.getVida());
					}
					if(personaje instanceof Enemigo) {
						if(personaje.getPosicion().getX() >= (enemigo.getPosicion().getX()-200) && personaje.getPosicion().getX()<= enemigo.getPosicion().getX() && stage.getiEnemigo().isHorFlip()==false ) {
						enemigo.setVida(enemigo.getVida()-personaje.getFuerza()*0.1);
						stage.getJpbVida1().setValue((int)enemigo.getVida());
						cIA.setGolpeado(true);
						
						}
						if(personaje.getPosicion().getX() <= (enemigo.getPosicion().getX() +200) && personaje.getPosicion().getX() >= enemigo.getPosicion().getX() && stage.getiEnemigo().isHorFlip()==true) {
							enemigo.setVida(enemigo.getVida()-personaje.getFuerza()*0.1);
							stage.getJpbVida1().setValue((int)enemigo.getVida());
							cIA.setGolpeado(true);
						}
						
					}
				}
				
				return 1;
			}
		}
		
		return 0;
		
	}
	
	public int AnimacionGolpeado(long milis,Personaje golpeado,Personaje golpeador, VentanaStage stage,ElementoAnimacion x,ControlIA cIA,ControlEstados ce) {
		
		ArrayList<ElementoAnimacion>animGolpeado = new ArrayList<>();
		animGolpeado = x.getAnimGolpeado();
		
		
		int contador=0;
		for(ElementoAnimacion elementoAnimacion:animGolpeado) {
			if(milis <=elementoAnimacion.getTiempos()) {
				if(cIA.isGolpeado()==true) {
				
				ce.setParado(false);
				
				stage.getiProta().setImagen(elementoAnimacion.getLabel());
				if(golpeado.getPosicion().getX()-golpeador.getPosicion().getX() >0) {
					
										
					
					if(contador<=6) {
						golpeado.setPosicion(new Point((int)(golpeado.getPosicion().getX()+2),((int)golpeado.getPosicion().getY())));
						stage.getiProta().setLocation(golpeado.getPosicion());
					}
					contador++;
				}
				if(golpeado.getPosicion().getX()-golpeador.getPosicion().getX() <0) {
					
				
					if(contador<=6) {
					stage.getiProta().setLocation(golpeado.getPosicion());
					golpeado.setPosicion(new Point((int)(golpeado.getPosicion().getX()-2),((int)golpeado.getPosicion().getY())));
					}
					contador++;
				}
				return 1;
				}
				
				
			}
			
		}
		
		return 0;
		
	}
	
	
}
