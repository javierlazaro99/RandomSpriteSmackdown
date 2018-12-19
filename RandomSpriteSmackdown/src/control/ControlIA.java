package control;

import Ventanas.VentanaStage;
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
	public boolean isGolpeado() {
		return golpeado;
	}

	public void setGolpeado(boolean golpeado) {
		this.golpeado = golpeado;
	}	
	
	public void EnemMoverse(long diferenciaTimers) {
		ca.AnimacionMoverse(diferenciaTimers, pSecundario, stage, elementoAnimacionP2);
		
	}
	public void EnemGolpear(long diferenciaTimers) {
		
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
			
			
		if( pPrincipal.getVida()<=0) {//Comprobacion de vida enemigo
			
			
			stageCerrado=true;
			stage.setContador(0);
			stage.dispose();
		}
		
		while(moverse) {
			timerEstado=System.currentTimeMillis();
			
			ReajusteLabel();
			
			diferenciaTimers=timerEstado-timerJuego;
			System.out.println(diferenciaTimers);
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
				System.out.println("Esta adelante");
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
				if(pSecundario.DarGolpe(pPrincipal)==1) {
					moverse=false;
					golpeando=true;
					
				}
			}
			
			
			
			try {
				Thread.sleep(16);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		if(golpeando !=true || golpeado !=true ) {
			moverse=true;
		}
		timerJuego=System.currentTimeMillis();
		while(golpeando) {
			timerEstado= System.currentTimeMillis();
			diferenciaTimers= timerEstado-timerJuego;
			if(diferenciaTimers<= elementoAnimacionP2.getTiempoAnimGolpear()) {
				ca.AnimacionGolpear(diferenciaTimers, pSecundario, stage, pPrincipal, elementoAnimacionP2,this);
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
			timerEstado=System.currentTimeMillis();
			diferenciaTimers=timerEstado-timerJuego;
			if(diferenciaTimers<=elementoAnimacionP2.getTiempoAnimGolpeado()) {
				
				ca.AnimacionGolpeado(diferenciaTimers, pPrincipal,pSecundario, stage, elementoAnimacionP1,this,ce);
			}
			else {
				diferenciaTimers=0;
				timerJuego=System.currentTimeMillis();
				timerEstado=0;
				moverse=false;
				golpeando=false;
				golpeado=false;
				
				ce.setParado(true);
			}
		}
		}
		
	}

	
}
