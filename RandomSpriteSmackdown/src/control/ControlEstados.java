package control;

import java.awt.Point;
import java.sql.Time;

import javax.swing.JFrame;

import Personalizados.JLabelGraficoAjustado;
import Ventanas.VentanaStage;
import personaje.Personaje;
import personaje.personajeJugable.PersonajeJugable;

public class ControlEstados implements Runnable{
	
	private boolean APulsado;
	private boolean DPulsado;
	private boolean WPulsado;
	private boolean saltando;
	private boolean saltandoLateral;
	private PersonajeJugable pPrincipal;
	private Personaje pSecundario;
	private boolean StageCerrado;
	private ControlAnimaciones controlAnimacion= new ControlAnimaciones();
	private VentanaStage stage;
	
	
	public ControlEstados(PersonajeJugable pPrincipal,Personaje pSecundario, VentanaStage stage) {//Personaje de la izquierda y de la derecha
		this.pPrincipal=pPrincipal;
		this.pSecundario=pSecundario;
		this.stage = stage;
		
		this.APulsado = false;
		this.DPulsado = false;
		this.WPulsado = false;
	}
	
	public boolean isAPulsado() {
		return APulsado;
	}

	public void setAPulsado(boolean aPulsado) {
		APulsado = aPulsado;
	}

	public boolean isDPulsado() {
		return DPulsado;
	}

	public void setDPulsado(boolean dPulsado) {
		DPulsado = dPulsado;
	}

	public boolean isWPulsado() {
		return WPulsado;
	}

	public void setWPulsado(boolean wPulsado) {
		WPulsado = wPulsado;
	}

	public boolean isStageCerrado() {
		return StageCerrado;
	}

	public void setStageCerrado(boolean stageCerrado) {
		StageCerrado = stageCerrado;
	}

	private void EstadoParado(long diferenciaTimers) { //Puede haber parado mirando a derecha o izquierda pero eso lo voy a arreglar de otra forma
		
		if((pPrincipal.getPosicion().getX()-pSecundario.getPosicion().getX())>0) {//Comprobacion de direccion de vista
			
			if(pPrincipal.getlPersonaje().isVertFlip()==true) {//comprobacion de adonde mira
				pPrincipal.getlPersonaje().setVertFlip(false);
			}
			controlAnimacion.AnimacionParado(diferenciaTimers, pPrincipal, stage);//sprites
		}else {
			controlAnimacion.AnimacionParado(diferenciaTimers, pPrincipal, stage);
		}
	}
	
	private void EstadoMoverseDerecha() {
		
	}
	
	private void EstadoMoverseIzquierda() {
		
	}
	
	private void EstadoSalto(long diferenciaTimers) {
		if((pPrincipal.getPosicion().getX()-pSecundario.getPosicion().getX())>0) {
			if(pPrincipal.getlPersonaje().isVertFlip()==true) {//comprobacion de adonde mira
				pPrincipal.getlPersonaje().setVertFlip(false);
			}
			controlAnimacion.AnimacionSaltando(diferenciaTimers, pPrincipal, stage);//sprites
		}else {
			controlAnimacion.AnimacionSaltando(diferenciaTimers, pPrincipal, stage);
		}
	}
	
	private void EstadoSaltoDerecha(long diferenciaTimers) {
		stage.getiProta().setHorFlip(false);
		controlAnimacion.AnimacionSaltando(diferenciaTimers, pPrincipal, stage);
	}
	
	private void EstadoSaltoIzquierda(long diferenciaTimers) {
		stage.getiProta().setHorFlip(true);
		controlAnimacion.AnimacionSaltando(diferenciaTimers, pPrincipal, stage);
	}
	
	
	@Override
	public void run() {
		
		while (!StageCerrado) {
			long timerJuego = System.currentTimeMillis();
			long diferenciaTimers = 0;
			long timerEstado = 0;
			//Estado moverse parado
			while(!APulsado && !DPulsado && !WPulsado && !StageCerrado) { //Estado parado
				timerEstado = System.currentTimeMillis();
				diferenciaTimers = timerEstado - timerJuego;
				if(diferenciaTimers <= ElementoAnimacion.getTiempoAnimParado()) {//Posible cambio
					EstadoParado(diferenciaTimers);
				}else {
					diferenciaTimers = 0;
					timerJuego = System.currentTimeMillis();
				}
				
				try {
					Thread.sleep(16); //Mas o menos 60 veces por segundo hará el bucle
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
			diferenciaTimers = 0; //Reset de la diferencia al saltar a otro estado
			timerJuego = System.currentTimeMillis(); //Volvemos a calcular el tiempo del juego para el siguiente estado
			//Estado moverse derecha
			while(APulsado && !DPulsado && !WPulsado && !StageCerrado) {//Moverse hacia la derecha
				timerEstado = System.currentTimeMillis();
				diferenciaTimers = timerEstado - timerJuego;
				if(diferenciaTimers <= 1000) {//Posible cambio
					EstadoMoverseDerecha();
				}else {
					diferenciaTimers = 0;
					timerJuego = System.currentTimeMillis();
				}
				
				try {
					Thread.sleep(16); //Mas o menos 60 veces por segundo hará el bucle
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			diferenciaTimers = 0;
			timerJuego = System.currentTimeMillis();
			//Estado moverse izquierda
			while(!APulsado && DPulsado && !WPulsado && !StageCerrado) {
				timerEstado = System.currentTimeMillis();
				diferenciaTimers = timerEstado - timerJuego;
				if(diferenciaTimers <= 1000) {
					EstadoMoverseIzquierda();
				}else {
					diferenciaTimers = 0;
					timerJuego = System.currentTimeMillis();
				}
				
				try {
					Thread.sleep(16); //Mas o menos 60 veces por segundo hará el bucle
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			diferenciaTimers = 0;
			timerJuego = System.currentTimeMillis();
			//Estado saltando básico
			while(!APulsado && !DPulsado && WPulsado && !StageCerrado) {
				saltando = true;
				
				int alturaBase = (int) pPrincipal.getPosicion().getY();
				int alturaMaxima = alturaBase - 100;
				int alturaObjetivo = alturaMaxima;
				
				while(saltando) {
					timerEstado = System.currentTimeMillis();
					diferenciaTimers = timerEstado - timerJuego;
					
					//Movimiento del salto(Se podría meter en un método)
					int miposicion = (int) pPrincipal.getPosicion().getY();
					
					if(miposicion > alturaObjetivo) {
						pPrincipal.Moverse(0, -1);
						miposicion = (int) pPrincipal.getPosicion().getY();
						stage.getiProta().setLocation(pPrincipal.getPosicion());
					}if(miposicion == alturaObjetivo) {
						alturaObjetivo = alturaBase;	
					}if(miposicion < alturaObjetivo) {
						pPrincipal.Moverse(0, 1);
						miposicion = (int) pPrincipal.getPosicion().getY();
						stage.getiProta().setLocation(pPrincipal.getPosicion());	
						
						if(miposicion == alturaBase) {
							saltando = false; //Acaba el salto y puede volver a comprobar si w está pulsado
						}
					}
					
					stage.repaint();
					stage.revalidate();
					
					
					if(diferenciaTimers <= 1000) {
						EstadoSalto(diferenciaTimers);
					}else {
						diferenciaTimers = 0;
						timerJuego = System.currentTimeMillis();
					}
					
					try {
						Thread.sleep(16); //Mas o menos 60 veces por segundo hará el bucle
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
			}	
			
			diferenciaTimers = 0;
			timerJuego = System.currentTimeMillis();
			//Estado saltando derecha
			while(!APulsado && DPulsado && WPulsado && !StageCerrado) {
				boolean saltandoDerecha = true;
				
				int alturaBase = (int) pPrincipal.getPosicion().getY();
				int alturaMaxima = alturaBase - 100;
				int alturaObjetivo = alturaMaxima;
				
				while(saltandoDerecha) {
					timerEstado = System.currentTimeMillis();
					diferenciaTimers = timerEstado - timerJuego;
					
					//Movimiento del salto(Se podría meter en un método)
					int miposicion = (int) pPrincipal.getPosicion().getY();
					
					if(miposicion > alturaObjetivo) {
						pPrincipal.Moverse(1, -1);
						miposicion = (int) pPrincipal.getPosicion().getY();
						stage.getiProta().setLocation(pPrincipal.getPosicion());
					}if(miposicion == alturaObjetivo) {
						alturaObjetivo = alturaBase;	
					}if(miposicion < alturaObjetivo) {
						pPrincipal.Moverse(1, 1);
						miposicion = (int) pPrincipal.getPosicion().getY();
						stage.getiProta().setLocation(pPrincipal.getPosicion());	
						
						if(miposicion == alturaBase) {
							saltandoDerecha = false; //Acaba el salto y puede volver a comprobar si w está pulsado
						}
					}
					
					stage.repaint();
					stage.revalidate();
					
					
					if(diferenciaTimers <= 1000) {
						EstadoSaltoDerecha(diferenciaTimers);
					}else {
						diferenciaTimers = 0;
						timerJuego = System.currentTimeMillis();
					}
					
					try {
						Thread.sleep(16); //Mas o menos 60 veces por segundo hará el bucle
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
			}	
			
			diferenciaTimers = 0;
			timerJuego = System.currentTimeMillis();
			//Estado saltando izquierda
			while(APulsado && !DPulsado && WPulsado && !StageCerrado) {
				boolean saltandoIzquierda = true;
				
				int alturaBase = (int) pPrincipal.getPosicion().getY();
				int alturaMaxima = alturaBase - 100;
				int alturaObjetivo = alturaMaxima;
				
				while(saltandoIzquierda) {
					timerEstado = System.currentTimeMillis();
					diferenciaTimers = timerEstado - timerJuego;
					
					//Movimiento del salto(Se podría meter en un método)
					int miposicion = (int) pPrincipal.getPosicion().getY();
					
					if(miposicion > alturaObjetivo) {
						pPrincipal.Moverse(-1, -1);
						miposicion = (int) pPrincipal.getPosicion().getY();
						stage.getiProta().setLocation(pPrincipal.getPosicion());
					}if(miposicion == alturaObjetivo) {
						alturaObjetivo = alturaBase;	
					}if(miposicion < alturaObjetivo) {
						pPrincipal.Moverse(-1, 1);
						miposicion = (int) pPrincipal.getPosicion().getY();
						stage.getiProta().setLocation(pPrincipal.getPosicion());	
						
						if(miposicion == alturaBase) {
							saltandoIzquierda = false; //Acaba el salto y puede volver a comprobar si w está pulsado
						}
					}
					
					stage.repaint();
					stage.revalidate();
					
					
					if(diferenciaTimers <= 1000) {
						EstadoSaltoIzquierda(diferenciaTimers);
					}else {
						diferenciaTimers = 0;
						timerJuego = System.currentTimeMillis();
					}
					
					try {
						Thread.sleep(16); //Mas o menos 60 veces por segundo hará el bucle
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
			}
		}	
	}
}
