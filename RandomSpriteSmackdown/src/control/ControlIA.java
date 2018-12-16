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
	public ControlIA(PersonajeJugable pPrincipal,Enemigo pSecundario,VentanaStage stage,ControlHistoria ch)
	{
	this.pPrincipal=pPrincipal;
	this.pSecundario=pSecundario;
	this.stage=stage;
	moverse=true;
	ca=new ControlAnimaciones();
	ce= new ControlEstados(pPrincipal, pSecundario, stage, ch);
	}
	
	public void EnemMoverse(long diferenciaTimers) {
		ca.AnimEnemMoverse(diferenciaTimers, pSecundario, stage);
		
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
			
			
			diferenciaTimers=timerEstado-timerJuego;
			System.out.println(diferenciaTimers);
			if(pPrincipal.getPosicion().getX()!=pSecundario.getPosicion().getX()) {
			pSecundario.IAMovimiento(pPrincipal, stage, ce);
			}
			stage.getiEnemigo().setLocation(pSecundario.getPosicion());
			stage.repaint();
			stage.revalidate();
			if(diferenciaTimers<=ElementoAnimacion.getTiempoEnemAnimGolpear()) {
				EnemMoverse(diferenciaTimers);
			}else {
				timerJuego=System.currentTimeMillis();
				timerEstado=0;
				diferenciaTimers=0;
				moverse=false;
			}
			try {
				Thread.sleep(16);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		moverse=true;
		}
		
	}
	
	
}
