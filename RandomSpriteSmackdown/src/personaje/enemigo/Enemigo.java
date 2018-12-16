package personaje.enemigo;

import java.awt.Point;
import java.util.Random;

import javax.swing.JFrame;

import Ventanas.VentanaStage;
import control.ControlEstados;
import control.ControlIA;
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
	public int DarGolpe(Personaje enemigo) {
		if(Math.abs(enemigo.getPosicion().getX()-getPosicion().getX()) <=200) {
			switch(dificultad) {
			case 0:
				try {
					Thread.sleep(900);
					return 1;
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			case 1:
				try {
					Thread.sleep(800);
					return 1;
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			case 2:
				try {
					Thread.sleep(700);
					return 1;
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				case 3:
			try {
				Thread.sleep(600);
				return 1;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
				case 4:
					
			try {
				Thread.sleep(500);
				return 1;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
				case 5:
					
					try {
						Thread.sleep(400);
						return 1;
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
				case 6:
					
					try {
						Thread.sleep(300);
						return 1;
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				case 7:
					
					try {
						Thread.sleep(200);
						return 1;
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				case 8:
					
					try {
						Thread.sleep(100);
						return 1;
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				default:
					return 0;
			}
			
		}
		return 0;
		

	}

	public void IAMovimiento(PersonajeJugable p,VentanaStage stage,ControlEstados ce) {
		Point pos = p.getPosicion();
		//Hay que comprobar si el jugador está a la derecha del enemigo o a la izquierda
		if (getPosicion().getX() > pos.getX()) {
			this.Moverse( -1, 0,stage,ce);
		}else if (getPosicion().getX() < pos.getX()){
			this.Moverse( 1, 0,stage,ce);
		}
		
		
	}
	//Controlador del sentido de la imagen
	
}
