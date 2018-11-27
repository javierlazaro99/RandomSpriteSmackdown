package control;

import java.awt.Point;
import java.sql.Time;

import Personalizados.JLabelGraficoAjustado;
import personaje.Personaje;
import personaje.personajeJugable.PersonajeJugable;

public class ControlEstados implements Runnable{
	
	private boolean APulsado;
	private boolean DPulsado;
	private boolean WPulsado;
	private PersonajeJugable pPrincipal;
	private Personaje pSecundario;
	private boolean StageCerrado;
	private ControlAnimaciones controlAnimacion= new ControlAnimaciones();
	public ControlEstados(PersonajeJugable pPrincipal,Personaje pSecundario) {//Personaje de la izquierda y de la derecha
		this.pPrincipal=pPrincipal;
		this.pSecundario=pSecundario;
		
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
		
		if(pPrincipal.getPosicion().getX()-pSecundario.getPosicion().getX()>0) {//Comprobacion de direccion de vista
			
			if(pPrincipal.getlPersonaje().isVertFlip()==true) {//comprobacion de adonde mira
				pPrincipal.getlPersonaje().setVertFlip(false);
			}
			controlAnimacion.AnimacionParado(diferenciaTimers, pPrincipal);//sprites
		}else {
			pPrincipal.getlPersonaje().setFlip(false, true);
			controlAnimacion.AnimacionParado(diferenciaTimers, pPrincipal);
		}
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
				if(diferenciaTimers <= 1000) {//Posible cambio
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
			
			while(APulsado && !DPulsado && !WPulsado) {//Moverse hacia la derecha
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
