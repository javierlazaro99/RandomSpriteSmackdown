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
	private long tiempoAnimGolpear;
	
	public ControlIA(PersonajeJugable pPrincipal,Enemigo pSecundario,VentanaStage stage,ControlHistoria ch) {
		this.pPrincipal=pPrincipal;
		this.pSecundario=pSecundario;
		this.stage=stage;
		
		//A�adido de javi para hacer la vida m�s facil
		
		//this.tiempoAnimGolpear = calcularTiempoAnimGolpear(pSecundario);
		
		moverse=true;
		golpeando=false;
		ca=new ControlAnimaciones();
		ce= new ControlEstados(pPrincipal, pSecundario, stage, ch);
	}
	
	public void EnemMoverse(long diferenciaTimers) {
		ca.AnimacionMoverse(diferenciaTimers, pSecundario, stage,stage.getElementoEnem());
		
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
				if(diferenciaTimers<= stage.getElementoEnem().getTiempoAnimMoverse()) {
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
				
				if(diferenciaTimers<= tiempoAnimGolpear) {
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
					golpeando=false;
					
				}
			}
			
			
			
			try {
				Thread.sleep(16);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		moverse=true;
		timerJuego=System.currentTimeMillis();
		while(golpeando) {
			timerEstado= System.currentTimeMillis();
			diferenciaTimers= timerEstado-timerJuego;
			if(diferenciaTimers<=stage.getElementoEnem().getTiempoAnimGolpear()) {
				
			}
		}
		}
		
	}	
	/*
	private long calcularTiempoAnimGolpear(Enemigo enem) {
		if(enem.getTipoPersonaje().equals("robot")) {
			return ElementoAnimacion.getTiempoAnimGolpearRobot();
		}
		if(enem.getTipoPersonaje().equals("ninja")) {
			return ElementoAnimacion.getTiempoAnimGolpearNinja();
		}
		else {
			return 0;
		}
	}
	*/
}
