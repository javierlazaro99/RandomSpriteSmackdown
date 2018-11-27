package control;

import java.sql.Time;

public class ControlEstados implements Runnable{
	
	private boolean APulsado;
	private boolean DPulsado;
	private boolean WPulsado;
	private boolean StageCerrado;
	
	
	
	private void EstadoParado(long diferenciaTimers) { //Puede haber parado mirando a derecha o izquierda pero eso lo voy a arreglar de otra forma
		
	}
	
	private void EstadoMoverseDerecha() {
		
	}
	
	private void EstadoMoverseIzquierda() {
		
	}
	
	
	@Override
	public void run() {
		while (StageCerrado = false) {
			long timerJuego = System.currentTimeMillis();
			long diferenciaTimers = 0;
			long timerEstado = 0;
			
			while(!APulsado && !DPulsado && !WPulsado) { //Estado parado
				timerEstado = System.currentTimeMillis();
				diferenciaTimers = timerEstado - timerJuego;
				if(diferenciaTimers <= 1000) {
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
			
			while(APulsado && !DPulsado && !WPulsado) {
				timerEstado = System.currentTimeMillis();
				diferenciaTimers = timerEstado - timerJuego;
				if(diferenciaTimers <= 1000) {
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
			
			while(!APulsado && DPulsado && !WPulsado) {
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
		}
		
	}
	

}
