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
 */
	private boolean stageCerrado;
	private PersonajeJugable pPrincipal;
	private Enemigo pSecundario;
	private VentanaStage stage;
	private boolean moverse;
	ControlIA(PersonajeJugable pPrincipal,Enemigo pSecundario,VentanaStage stage)
	{
	this.pPrincipal=pPrincipal;
	this.pSecundario=pSecundario;
	this.stage=stage;
	moverse=false;
	}
	@Override
	public void run() {
		while(!stageCerrado) {
			long timerJuego = System.currentTimeMillis();
			long diferenciaTimers = 0;
			long timerEstado = 0;
			if( pPrincipal.getVida()<=0) {//Comprobacion de vida enemigo
			
			
			stageCerrado=true;
			stage.setContador(0);
			stage.dispose();
		}
			
		while(moverse==true) {
			timerEstado=System.currentTimeMillis();
			stage.repaint();
			stage.revalidate();
			diferenciaTimers=timerEstado-timerJuego;
			if(diferenciaTimers<=) {
				
			}
		}
		}
		
	}
	
	
}
