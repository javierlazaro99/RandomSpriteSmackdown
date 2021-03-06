package control;

import java.util.ArrayList;

import javax.sound.sampled.Clip;

import Ventanas.VentanaStage;
import personaje.Personaje;
import personaje.enemigo.Enemigo;
import personaje.personajeJugable.PersonajeJugable;

public class ControlAnimaciones {

	
	/** Control de animacion Parado
	 * @param milis milisegundo en el que esta
	 * @param personaje personaje al que se le cambia el label
	 * @param stage Ventana de partida
	 * @param x Paramentro de elementoAnimacion 
	 * @return devuelve 1 si funciona, 0 si no entra dentro
	 */
	public int AnimacionParado(long milis, Personaje personaje, VentanaStage stage,ElementoAnimacion x) {
		
		ArrayList<ElementoAnimacion> animParado = new ArrayList<>();
		animParado = x.getAnimParado();
	
		for (ElementoAnimacion elementoAnimacion : animParado) {
			if(milis <= elementoAnimacion.getTiempos()) {
				if(personaje.equals(stage.getpPrincipal())) {
					stage.getiProta().setImagen(elementoAnimacion.getLabel());
					if(personaje.getTipoPersonaje().equals("ninja")) {
						stage.getiProta().setSize(200, 250);
					}
				}
				if(personaje.equals(stage.getpSecundario())) {
					stage.getiEnemigo().setImagen(elementoAnimacion.getLabel());
					if(personaje.getTipoPersonaje().equals("ninja")) {
						stage.getiEnemigo().setSize(200, 250);
					}
				}
				return 1;
			}
		}
		return 0;
	}
	
	
	/**Control de Animacion Saltando
	 *@param milis milisegundo en el que esta
	 * @param personaje personaje al que se le cambia el label
	 * @param stage Ventana de partida
	 * @param x Paramentro de elementoAnimacion 
	 * @return devuelve 1 si funciona, 0 si no entra dentro
	 */
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

	
	/**Control de Anim moverse
	 *@param milis milisegundo en el que esta
	 * @param personaje personaje al que se le cambia el label
	 * @param stage Ventana de partida
	 * @param x Paramentro de elementoAnimacion 
	 * @return devuelve 1 si funciona, 0 si no entra dentro
	 */
	public int AnimacionMoverse(long milis,Personaje personaje, VentanaStage stage,ElementoAnimacion x) {
		
		ArrayList<ElementoAnimacion>animMoverse = new ArrayList<>();
		animMoverse = x.getAnimMoverse();
		
		for(ElementoAnimacion elementoAnimacion:animMoverse) {
			if(milis <=elementoAnimacion.getTiempos()) {
				
				if(personaje.equals(stage.getpPrincipal())) {
					stage.getiProta().setImagen(elementoAnimacion.getLabel());
					if(personaje.getTipoPersonaje().equals("ninja")) {
						stage.getiProta().setSize(300, 250);
					}
				}
				if(personaje.equals(stage.getpSecundario())) {
					stage.getiEnemigo().setImagen(elementoAnimacion.getLabel());
					if(personaje.getTipoPersonaje().equals("ninja")) {
						stage.getiEnemigo().setSize(300, 250);
					}
				}
				
				return 1;
			}
		}
		
		return 0;
		
	}
	
	/** Anim golpeado
	 *@param milis milisegundo en el que esta
	 * @param personaje personaje al que se le cambia el label
	 * @param stage Ventana de partida
	 * @param x Paramentro de elementoAnimacion 
	 * @return devuelve 1 si funciona, 0 si no entra dentro
	 * @param cIA ControlIA
	 * @param ce Control Estado
	 * @param ceEnemigo Control Estados si es un jugador
	 * @return devuelve 1 si funciona, 0 si no entra dentro
	 */
	public int AnimacionGolpear(long milis,Personaje personaje,VentanaStage stage,Personaje enemigo,ElementoAnimacion x,ControlIA cIA,
			ControlEstados ce, ControlEstados ceEnemigo) {
		
		ArrayList<ElementoAnimacion>animGolpear = new ArrayList<>(); 
		animGolpear = x.getAnimGolpear();
		 
		for(ElementoAnimacion elementoAnimacion:animGolpear) {
			if(milis <=elementoAnimacion.getTiempos()) {
				if(personaje.equals(stage.getpPrincipal())) {
					stage.getiProta().setImagen(elementoAnimacion.getLabel());
					if(personaje.getTipoPersonaje().equals("ninja")) {
						stage.getiProta().setSize(365, 280);
					}
				}
				if(personaje.equals(stage.getpSecundario())) {
					stage.getiEnemigo().setImagen(elementoAnimacion.getLabel());
					if(personaje.getTipoPersonaje().equals("ninja")) {
						stage.getiEnemigo().setSize(365, 280);
					}
				}
				
				if(elementoAnimacion.getLabel().equals("png/Melee (4).png") || elementoAnimacion.getLabel().equals("pngEnem/Attack__004.png") 
						|| elementoAnimacion.getLabel().equals("pngEnem2/Attack (5).png")){
					
					if(personaje instanceof PersonajeJugable) {
						if(stage.getiProta().isHorFlip()==true && stage.getiEnemigo().isHorFlip()==false || stage.getiProta().isHorFlip()==false 
								&& stage.getiEnemigo().isHorFlip()==true) {
							
							if(personaje.DarGolpe(enemigo)==1) {
							
							if(enemigo instanceof Enemigo) {
								Clip punch1 = Sonidos.punch1Sonido.cargarSonido("sounds/punch_1.wav");
								punch1.start();
								stage.getJpbVida2().setValue((int)enemigo.getVida());
								cIA.setGolpeado(true); // Antes se hac�a set al ce
							}
							
							if(enemigo instanceof PersonajeJugable) {
								ceEnemigo.setGolpeado(true);//Se golpea el enemigo
								Clip punch2 = Sonidos.punch2Sonido.cargarSonido("sounds/punch_2.wav");
								punch2.start();
							}
							}
							if(personaje.equals(stage.getpPrincipal())) {
								stage.getJpbVida2().setValue((int)enemigo.getVida());
							}else {
								stage.getJpbVida1().setValue((int)enemigo.getVida());
							}
						}
					}
					if(personaje instanceof Enemigo) {
						Clip punch= Sonidos.punch1Sonido.cargarSonido("sounds/punch_1.wav");
						if(personaje.getPosicion().getX() >= (enemigo.getPosicion().getX()-200) && personaje.getPosicion().getX()<= enemigo.getPosicion().getX() && stage.getiEnemigo().isHorFlip()==false ) {
							enemigo.setVida(enemigo.getVida()-personaje.getFuerza()*0.1);
							stage.getJpbVida1().setValue((int)enemigo.getVida());
							// Tu personaje recibe el estado de golpeado
							punch.start();
							ce.setGolpeado(true); // Antes el set se hac�a al cIA
						}
						
						if(personaje.getPosicion().getX() <= (enemigo.getPosicion().getX() +200) && personaje.getPosicion().getX() >= enemigo.getPosicion().getX() && stage.getiEnemigo().isHorFlip()==true) {
							enemigo.setVida(enemigo.getVida()-personaje.getFuerza()*0.1);
							stage.getJpbVida1().setValue((int)enemigo.getVida());
							// Tu personaje recibe el estado de golpeado
							ce.setGolpeado(true); // Antes el set se hac�a al cIA
							punch.start();
						}
						
					}
				}
				
				return 1;
			}
		}
		
		return 0;	
	}
	
	/** Control de Anim golpeado
	 * @param milis milisegundo en el que esta la anim
	 * @param golpeado personaje que ha sido golpeado
	 * @param golpeador personaje que ha golpeado
	 * @param stage Ventana de partida
	 * @param x Elemento de animacion 
	 * @param cIA Control de IA
	 * @param ce Control de Estados
	 * @param ceEnemigo Control Estados enemigo
	 * @return
	 */
	public int AnimacionGolpeado(long milis, Personaje golpeado, Personaje golpeador, VentanaStage stage,
			ElementoAnimacion x, ControlIA cIA, ControlEstados ce, ControlEstados ceEnemigo) {

		ArrayList<ElementoAnimacion> animGolpeado = new ArrayList<>();
		animGolpeado = x.getAnimGolpeado();

		for (ElementoAnimacion elementoAnimacion : animGolpeado) {
			if (milis <= elementoAnimacion.getTiempos()) {
				if (stage.isActiveIA()) { // Parte para si hay IA
					
					if(ce.isGolpeado()) {
						
						stage.getiProta().setImagen(elementoAnimacion.getLabel());
						return 1;

					}if(cIA.isGolpeado()) {
						
						stage.getiEnemigo().setImagen(elementoAnimacion.getLabel());
						return 1; 
					}
				} else { // Parte para cunado no hay IA (Pr�ctica o 1v1)
					
						
					if(golpeado.equals(stage.getpPrincipal())) {
						stage.getiEnemigo().setImagen(elementoAnimacion.getLabel());
					}
					
					if(golpeado.equals(stage.getpSecundario())) {
						
						stage.getiProta().setImagen(elementoAnimacion.getLabel());
					}
					
					return 1; 
				}
			}
		}
		
		return 0;
	}
}


