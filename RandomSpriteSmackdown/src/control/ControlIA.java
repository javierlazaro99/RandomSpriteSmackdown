package control;

import java.awt.Point;

import Ventanas.VentanaStage;
import personaje.Personaje;
import personaje.enemigo.Enemigo;
import personaje.personajeJugable.PersonajeJugable;

public class ControlIA implements Runnable{
//Esquema de la  IA
/* Estado de movimiento de la IA
 * Estado de golpe de la IA
 * Estado golpeado
 * 
 * 
 */	long timerJuego = System.currentTimeMillis();
	long diferenciaTimers = 0;
	long timerEstado = 0;
	private boolean stageCerrado;
	private boolean stagePausado;
	private PersonajeJugable pPrincipal;
	private Enemigo pSecundario;
	private VentanaStage stage;
	private boolean moverse;
	private ControlAnimaciones ca;
	private ControlEstados ce;
	private boolean golpeando;
	private ElementoAnimacion elementoAnimacionP1;
	private ElementoAnimacion elementoAnimacionP2;
	private boolean golpeado;
	private boolean espera;
	
	
	public ControlIA(PersonajeJugable pPrincipal,Enemigo pSecundario,VentanaStage stage,ControlHistoria ch,ControlEstados ce) {
		this.pPrincipal=pPrincipal;
		this.pSecundario=pSecundario;
		this.stage=stage;
		this.elementoAnimacionP1 = stage.getElementoAnimacionPersonaje1();
		this.elementoAnimacionP2 = stage.getElementoAnimacionPersonaje2();
		
		moverse=true;
		golpeando=false;
		golpeado=false;
		ca=new ControlAnimaciones();
		this.ce=ce;
	}
	
	public boolean isStageCerrado() {
		return stageCerrado;
	}

	public void setStageCerrado(boolean stageCerrado) {
		this.stageCerrado = stageCerrado;
	}
	public boolean isStagePausado() {
		return stagePausado;
	}

	public void setStagePausado(boolean stagePausado) {
		this.stagePausado = stagePausado;
	}
	public boolean isMoverse() {
		return moverse;
	}

	public void setMoverse(boolean moverse) {
		this.moverse = moverse;
	}
	public boolean isGolpeado() {
		return golpeado;
	}

	public void setGolpeado(boolean golpeado) {
		this.golpeado = golpeado;
	}	
	
	public boolean isEspera() {
		return espera;
	}

	public void setEspera(boolean espera) {
		this.espera = espera;
	}

	public void EnemMoverse(long diferenciaTimers) {
		ca.AnimacionMoverse(diferenciaTimers, pSecundario, stage, elementoAnimacionP2);
		
	}
	public void EnemParado(long diferenciaTimers) {
		ca.AnimacionParado(diferenciaTimers, pSecundario, stage, elementoAnimacionP2);
	}
	public void ReajusteLabel() {
		if((pPrincipal.getPosicion().getX() - pSecundario.getPosicion().getX())<0) {
			if(stage.getiEnemigo().isHorFlip()== false) {
			stage.getiEnemigo().setHorFlip(true);
			}
		}
		if((pPrincipal.getPosicion().getX() - pSecundario.getPosicion().getX())>0) {
			if(stage.getiEnemigo().isHorFlip()==true) {
				stage.getiEnemigo().setHorFlip(false);
				}
		}
	}
	
	@Override
	public void run() {
		
		while(!stageCerrado) {
			
			while (stagePausado) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			
		if( pPrincipal.getVida()<=0) {//Comprobacion de vida enemigo
			stageCerrado=true;
			stage.setContador(0);
			stage.dispose();
		}
		
		while(espera) {
			try {
				Thread.sleep(100);
				espera = false;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		while(moverse && !golpeado) {
			timerEstado=System.currentTimeMillis();
			
			ReajusteLabel();
			
			diferenciaTimers=timerEstado-timerJuego;
			
			if((pPrincipal.getPosicion().getX()+200)<=pSecundario.getPosicion().getX()) {
			pSecundario.IAMovimiento(pPrincipal, stage, ce);
			stage.getiEnemigo().setLocation(pSecundario.getPosicion());
				if(diferenciaTimers<= elementoAnimacionP2.getTiempoAnimMoverse()) {
				EnemMoverse(diferenciaTimers);
				}else {
				timerJuego=System.currentTimeMillis();
				timerEstado=0;
				diferenciaTimers=0;
				moverse=false;
				}
			}else if(pPrincipal.getPosicion().getX() - 200 > pSecundario.getPosicion().getX()) {
				
				pSecundario.IAMovimiento(pPrincipal, stage, ce);
				stage.getiEnemigo().setLocation(pSecundario.getPosicion());
				
				if(diferenciaTimers<= elementoAnimacionP2.getTiempoAnimGolpear()) {
					EnemMoverse(diferenciaTimers);
					}else {
					timerJuego=System.currentTimeMillis();
					timerEstado=0;
					diferenciaTimers=0;
					moverse=false;
					}

			}else {
				
				timerEstado=System.currentTimeMillis();
				diferenciaTimers=timerEstado-timerJuego;
				if(diferenciaTimers<=stage.getElementoAnimacionPersonaje2().getTiempoAnimParado()) {
					EnemParado(diferenciaTimers);
				if(pSecundario.DarGolpe(pPrincipal)==1) {
					moverse=false;
					golpeando=true;
					
				}
			}else {
				timerJuego=System.currentTimeMillis();
				timerEstado=0;
				diferenciaTimers=0;
				
			}
			}
			
			
			try {
				Thread.sleep(16);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		if(golpeando !=true && golpeado !=true ) {
			moverse=true;
		}
		timerJuego=System.currentTimeMillis();
		while(golpeando && !golpeado) {
			timerEstado= System.currentTimeMillis();
			diferenciaTimers= timerEstado-timerJuego;
			if(diferenciaTimers<= elementoAnimacionP2.getTiempoAnimGolpear()) {
				ca.AnimacionGolpear(diferenciaTimers, pSecundario, stage, pPrincipal, elementoAnimacionP2,this,ce, null);
			}else {
				diferenciaTimers=0;
				timerJuego=System.currentTimeMillis();
				timerEstado=0;
				moverse=true;
				golpeando=false;
				
			}
			try {
				Thread.sleep(16);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		timerJuego=System.currentTimeMillis();
		while(golpeado) {
			
//			moverse = false;
//			golpeando = false;
			boolean movimientoGolpeado = true;
			
			Personaje pGolpeado = pSecundario;
			Personaje pGolpeador = pPrincipal;
			
			int posIni= (int) pSecundario.getPosicion().getX();
			int posFin = 0;
			int posActual;
			
			//Elige destino en función de si está a derecha o a izquierda
			if (pGolpeado.getPosicion().getX() - pGolpeador.getPosicion().getX() > 0) {
				posFin = (int) pSecundario.getPosicion().getX() + 80; //Derecha
			}
			if (pGolpeado.getPosicion().getX() - pGolpeador.getPosicion().getX() < 0) {
				posFin = (int) pSecundario.getPosicion().getX() - 80; //Izquierda
			}
			
			while(movimientoGolpeado) {
				
				timerEstado=System.currentTimeMillis();
				diferenciaTimers=timerEstado-timerJuego;
				
				stage.repaint();
				stage.revalidate();
				
				posActual = (int) pGolpeado.getPosicion().getX();
				if (posFin > posIni) { //Objetivo derecha
					pGolpeado.setPosicion(new Point((int) (pGolpeado.getPosicion().getX() + 4),
							((int) pGolpeado.getPosicion().getY())));
					if(posFin <= posActual) {
						movimientoGolpeado = false;
						golpeado = false;
					}
				}
				if (posFin < posIni) { //Objetivo Izquierda
					pGolpeado.setPosicion(new Point((int) (pGolpeado.getPosicion().getX() - 4), 
							((int) pGolpeado.getPosicion().getY())));
					if(posFin >= posActual) {
						movimientoGolpeado = false;
						golpeado = false;
					}
				}
				
				stage.getiEnemigo().setLocation(pGolpeado.getPosicion());
				
				if(diferenciaTimers<=elementoAnimacionP2.getTiempoAnimGolpeado()) {
					ca.AnimacionGolpeado(diferenciaTimers, pPrincipal,pSecundario, stage, elementoAnimacionP2,this,ce, null);
				}
				else {
					diferenciaTimers=0;
					timerJuego=System.currentTimeMillis();
					timerEstado=0;
					moverse=false;
					golpeando=false;
//					golpeado=false;
					
				}
			}
			
		}
	}
		
}

	

	
}
