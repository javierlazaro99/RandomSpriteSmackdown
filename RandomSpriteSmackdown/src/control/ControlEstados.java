package control;

import java.awt.Point;
import java.sql.Time;

import javax.swing.JFrame;
import javax.swing.JLabel;

import Personalizados.JLabelGraficoAjustado;
import Usuarios.UsuariosValidar;
import Ventanas.VentanaStage;
import personaje.Personaje;
import personaje.enemigo.Enemigo;
import personaje.personajeJugable.PersonajeJugable;

public class ControlEstados implements Runnable{
	
	private boolean APulsado;
	private boolean DPulsado;
	private boolean WPulsado;
	private boolean SpacePulsado;
	private boolean golpeado;
	private PersonajeJugable pPrincipal;
	private Personaje pSecundario;
	private boolean StageCerrado;
	private boolean StagePausado;
	private ControlAnimaciones controlAnimacion= new ControlAnimaciones();
	private VentanaStage stage;
	private long tiempoAnimParado;
	private long tiempoAnimMoverse;
	private long tiempoAnimGolpear;
	private long tiempoAnimGolpeado;
	
	private ControlHistoria ch;
	private boolean choque;
	public boolean isChoque() {
		return choque;
	}

	public void setChoque(boolean choque) {
		this.choque = choque;
	}

	public ControlEstados(PersonajeJugable pPrincipal,Personaje pSecundario, VentanaStage stage,ControlHistoria ch) {//Personaje de la izquierda y de la derecha
		this.pPrincipal=pPrincipal;
		this.pSecundario=pSecundario;
		this.stage = stage;
		this.ch=ch;
		this.APulsado = false;
		this.DPulsado = false;
		this.WPulsado = false;
		this.SpacePulsado=false;
		this.golpeado=false;
		this.choque=false;
		
		//Añadido de Javi para hacer la vida más facil
		this.tiempoAnimParado = calcularTiempoAnimParado(pPrincipal);
		this.tiempoAnimMoverse	= calcularTiempoAnimMoverse(pPrincipal);
		this.tiempoAnimGolpear = calcularTiempoAnimGolpear(pPrincipal);
		this.tiempoAnimGolpeado = calcularTiempoAnimGolpeado(pPrincipal);		
		
	}
	
	
	
	public boolean isSpacePulsado() {
		return SpacePulsado;
	}

	public void setSpacePulsado(boolean spacePulsado) {
		SpacePulsado = spacePulsado;
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
	
	public boolean isStagePausado() {
		return StagePausado;
	}

	public void setStagePausado(boolean stagePausado) {
		StagePausado = stagePausado;
	}

	private void EstadoParado(long diferenciaTimers) { //Puede haber parado mirando a derecha o izquierda pero eso lo voy a arreglar de otra forma
		
		if((pPrincipal.getPosicion().getX()-pSecundario.getPosicion().getX())<0) {//Comprobacion de direccion de vista
			
			if(pPrincipal.getlPersonaje().isVertFlip()==true) {//comprobacion de adonde mira
				pPrincipal.getlPersonaje().setVertFlip(false);
			}
			controlAnimacion.AnimacionParado(diferenciaTimers, pPrincipal, stage);//sprites
		}else {
			if(pPrincipal.getlPersonaje().isVertFlip()==false) {//comprobacion de adonde mira
				pPrincipal.getlPersonaje().setVertFlip(true);
			}
			controlAnimacion.AnimacionParado(diferenciaTimers, pPrincipal, stage);
		}
	}
	
	private void EstadoMoverseDerecha(long diferenciaTimers) {
		stage.getiProta().setHorFlip(false);
		controlAnimacion.AnimacionMoverseDerecha(diferenciaTimers, pPrincipal, stage);
		
//		if((pPrincipal.getPosicion().getX()-pSecundario.getPosicion().getX())<=0) {//Comprobacion de direccion de vista
//			
//			if(pPrincipal.getlPersonaje().isVertFlip()==true) {//comprobacion de adonde mira
//				pPrincipal.getlPersonaje().setVertFlip(false);
//			}
//			controlAnimacion.AnimacionMoverseDerecha(diferenciaTimers, pPrincipal,stage);
//		}else {
//			if(pPrincipal.getlPersonaje().isVertFlip()==false) {//comprobacion de adonde mira
//				pPrincipal.getlPersonaje().setVertFlip(true);
//			}
//			controlAnimacion.AnimacionMoverseDerecha(diferenciaTimers, pPrincipal, stage);
//			}
	}
	
	private void EstadoMoverseIzquierda(long diferenciaTimers) {
		stage.getiProta().setHorFlip(true);
		controlAnimacion.AnimacionMoverseIzquierda(diferenciaTimers, pPrincipal, stage);
		
//		if((pPrincipal.getPosicion().getX()-pSecundario.getPosicion().getX())<=0) {//Comprobacion de direccion de vista
//			
//			if(pPrincipal.getlPersonaje().isVertFlip()==true) {//comprobacion de adonde mira
//				pPrincipal.getlPersonaje().setVertFlip(false);
//			}
//			controlAnimacion.AnimacionMoverseIzquierda(diferenciaTimers, pPrincipal,stage);
//		}else {
//			if(pPrincipal.getlPersonaje().isVertFlip()==false) {//comprobacion de adonde mira
//				pPrincipal.getlPersonaje().setVertFlip(true);
//			}
//			controlAnimacion.AnimacionMoverseIzquierda(diferenciaTimers, pPrincipal, stage);
//			}
	}
	
	private void EstadoSalto(long diferenciaTimers) {
		if((pPrincipal.getPosicion().getX()-pSecundario.getPosicion().getX())<0) {
			if(pPrincipal.getlPersonaje().isHorFlip()==true) {//comprobacion de adonde mira
				pPrincipal.getlPersonaje().setHorFlip(false);
			}
			controlAnimacion.AnimacionSaltando(diferenciaTimers, pPrincipal, stage);//sprites
		}else {
			if(pPrincipal.getlPersonaje().isHorFlip()==false) {//comprobacion de adonde mira
				pPrincipal.getlPersonaje().setHorFlip(true);
			}
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
	
	private void EstadoGolpear(long diferenciaTimers) {
		if((pPrincipal.getPosicion().getX()-pSecundario.getPosicion().getX())<0) {
			if(pPrincipal.getlPersonaje().isHorFlip()==true) {//comprobacion de adonde mira
				pPrincipal.getlPersonaje().setHorFlip(false);
			}
			controlAnimacion.AnimacionGolpear(diferenciaTimers, pPrincipal, stage,pSecundario);//sprites
		}else {
			if(pPrincipal.getlPersonaje().isHorFlip()==false) {//comprobacion de adonde mira
				pPrincipal.getlPersonaje().setHorFlip(true);
			}
			controlAnimacion.AnimacionGolpear(diferenciaTimers, pPrincipal, stage,pSecundario);
		}
	}
	private void EstadoGolpeado(long diferenciaTimers) {
		if((pPrincipal.getPosicion().getX()-pSecundario.getPosicion().getX())<0) {
			if(pPrincipal.getlPersonaje().isHorFlip()==true) {//comprobacion de adonde mira
				pPrincipal.getlPersonaje().setHorFlip(false);
			}
			controlAnimacion.AnimacionGolpeado(diferenciaTimers, pPrincipal, stage);//sprites
		}else {
			if(pPrincipal.getlPersonaje().isHorFlip()==false) {//comprobacion de adonde mira
				pPrincipal.getlPersonaje().setHorFlip(true);
			}
			controlAnimacion.AnimacionGolpeado(diferenciaTimers, pPrincipal, stage);
		}
	}
	
	
	@Override
	public void run() {
		
		while (!StageCerrado) {
			
			while(StagePausado) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		
			long timerJuego = System.currentTimeMillis();
			long diferenciaTimers = 0;
			long timerEstado = 0;
			
			if(APulsado && DPulsado) { //Evitar bug de andar hacia un lado, dar a adar hacia opuesto y quedarse congelado
				APulsado = false;
				DPulsado = false;
			}
			
			if(SpacePulsado && APulsado || DPulsado) { //Evitar bug anterior pero con el golpeo
				APulsado = false;
				DPulsado = false;
			}
			
			if( pSecundario.getVida()<=0 ) {//Comprobacion de vida enemigo
				
				if(ch.getNivelesCompletados()<8) {
				ch.setNivelesCompletados(ch.getNivelesCompletados()+1);
				
			}
			
			
			StageCerrado=true;
			stage.setContador(0);
			stage.dispose();
		}
			if( pPrincipal.getVida()<=0) {//Comprobacion de vida enemigo
				
				
				StageCerrado=true;
				stage.setContador(0);
				stage.dispose();
			}
			//Estado moverse parado
			while(!APulsado && !DPulsado && !WPulsado && !SpacePulsado && !StageCerrado && !StagePausado) { //Estado parado
				
				timerEstado = System.currentTimeMillis();
				diferenciaTimers = timerEstado - timerJuego;
				
				stage.repaint();
				stage.revalidate();
				
				if(diferenciaTimers <= tiempoAnimParado) {//Posible cambio
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
			while(!APulsado && DPulsado && !WPulsado && !StageCerrado && !SpacePulsado && !StagePausado) {//Moverse hacia la derecha
				
				boolean corriendoDerecha = true;
				
				int posActual = (int) pPrincipal.getPosicion().getX();
				int posObjetivo = posActual + 20; //Este +20 se puede cambiar a lo que quieras que valga el ciclo, múltiplo de 10 tiene que ser
				//Cambiar el + 20 la relacionarlo con la velocidad del personaje
				while(corriendoDerecha) {
					timerEstado = System.currentTimeMillis();
					diferenciaTimers = timerEstado - timerJuego;
					
					if(posActual < posObjetivo) {
						pPrincipal.Moverse(1,0,stage,this);
						posActual = (int) pPrincipal.getPosicion().getX();
					}
					
					if(posActual >= posObjetivo || choque==true) { //Completa el ciclo de movimiento y vuelve a comprobar si D pulsado
						corriendoDerecha = false;
					}
					
					stage.getiProta().setLocation(pPrincipal.getPosicion());
					
					stage.repaint();
					stage.revalidate();
					
					if(diferenciaTimers <= tiempoAnimParado) {//Posible cambio
						EstadoMoverseDerecha(diferenciaTimers);
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
			//Estado moverse izquierda
			while(APulsado && !DPulsado && !WPulsado && !StageCerrado && !SpacePulsado && !StagePausado) {
				boolean corriendoIzquierda = true;
				
				
				int posActual = (int) pPrincipal.getPosicion().getX();
				int posObjetivo = posActual - 20; //Este -20 se puede cambiar a lo que quieras que valga el ciclo, múltiplo de 10 tiene que ser
				
				while(corriendoIzquierda) {
					timerEstado = System.currentTimeMillis();
					diferenciaTimers = timerEstado - timerJuego;
					
					if(posActual > posObjetivo) {
						pPrincipal.Moverse(-1,0,stage,this);
						posActual = (int) pPrincipal.getPosicion().getX();
					}
					if(posActual <= posObjetivo || choque==true) { //Completa el ciclo de movimiento y vuelve a comprobar si A pulsado
						corriendoIzquierda = false;
					}
					
					stage.getiProta().setLocation(pPrincipal.getPosicion());
					
					stage.repaint();
					stage.revalidate();
					
					if(diferenciaTimers <= tiempoAnimMoverse) {
						EstadoMoverseIzquierda(diferenciaTimers);
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
			//Estado saltando básico
			while(!APulsado && !DPulsado && WPulsado && !StageCerrado && !SpacePulsado && !StagePausado) {
				boolean saltando = true;
				
				int alturaBase = (int) pPrincipal.getPosicion().getY();
				int alturaMaxima = alturaBase - 150;
				int alturaObjetivo = alturaMaxima;
				
				while(saltando) {
					timerEstado = System.currentTimeMillis();
					diferenciaTimers = timerEstado - timerJuego;
					
					//Movimiento del salto(Se podría meter en un método)
					int miposicion = (int) pPrincipal.getPosicion().getY();
					
					if(miposicion > alturaObjetivo) {
						pPrincipal.Moverse(0, -1,stage,this);
						miposicion = (int) pPrincipal.getPosicion().getY();
						stage.getiProta().setLocation(pPrincipal.getPosicion());
					}if(miposicion == alturaObjetivo) {
						alturaObjetivo = alturaBase;	
					}if(miposicion < alturaObjetivo) {
						pPrincipal.Moverse(0, 1,stage,this);
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
			while(!APulsado && DPulsado && WPulsado && !StageCerrado && !SpacePulsado && !StagePausado) {
				boolean saltandoDerecha = true;
				
				int alturaBase = (int) pPrincipal.getPosicion().getY();
				int alturaMaxima = alturaBase - 150;
				int alturaObjetivo = alturaMaxima;
				
				while(saltandoDerecha) {
					timerEstado = System.currentTimeMillis();
					diferenciaTimers = timerEstado - timerJuego;
					
					//Movimiento del salto(Se podría meter en un método)
					int miposicion = (int) pPrincipal.getPosicion().getY();
					
					if(miposicion > alturaObjetivo) {
						pPrincipal.Moverse(1, -1,stage,this);
						miposicion = (int) pPrincipal.getPosicion().getY();
						stage.getiProta().setLocation(pPrincipal.getPosicion());
					}if(miposicion == alturaObjetivo) {
						alturaObjetivo = alturaBase;	
					}if(miposicion < alturaObjetivo) {
						pPrincipal.Moverse(1, 1,stage,this);
						miposicion = (int) pPrincipal.getPosicion().getY();
						stage.getiProta().setLocation(pPrincipal.getPosicion());	
						
						if(miposicion == alturaBase ) {
							saltandoDerecha = false;//Acaba el salto y puede volver a comprobar si w está pulsado
						
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
			while(APulsado && !DPulsado && WPulsado && !StageCerrado && !SpacePulsado && !StagePausado) {
				boolean saltandoIzquierda = true;
				
				int alturaBase = (int) pPrincipal.getPosicion().getY();
				int alturaMaxima = alturaBase - 150;
				int alturaObjetivo = alturaMaxima;
				
				while(saltandoIzquierda) {
					timerEstado = System.currentTimeMillis();
					diferenciaTimers = timerEstado - timerJuego;
					
					//Movimiento del salto(Se podría meter en un método)
					int miposicion = (int) pPrincipal.getPosicion().getY();
					
					if(miposicion > alturaObjetivo) {
						pPrincipal.Moverse(-1, -1,stage,this);
						miposicion = (int) pPrincipal.getPosicion().getY();
						stage.getiProta().setLocation(pPrincipal.getPosicion());
					}if(miposicion == alturaObjetivo) {
						alturaObjetivo = alturaBase;	
					}if(miposicion < alturaObjetivo) {
						pPrincipal.Moverse(-1, 1,stage,this);
						miposicion = (int) pPrincipal.getPosicion().getY();
						stage.getiProta().setLocation(pPrincipal.getPosicion());	
						
						if(miposicion == alturaBase ) {
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
			
			//Estado golpe
			while(!APulsado && !DPulsado && !WPulsado && !StageCerrado && SpacePulsado && !StagePausado) {
				boolean golpeando = true;
				
				while(golpeando) {

					timerEstado=System.currentTimeMillis();
					diferenciaTimers=timerEstado - timerJuego;
					
					stage.repaint();
					stage.revalidate();
					
					
					if(diferenciaTimers <= tiempoAnimGolpear) {
						EstadoGolpear(diferenciaTimers);
					}
					else {
						diferenciaTimers =0;
						timerJuego = System.currentTimeMillis();
						golpeando = false;
					}
					try {
						Thread.sleep(16); //Mas o menos 60 veces por segundo hará el bucle
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			
			//Estado golpeado
			int posIni= (int) pPrincipal.getPosicion().getX();
			int posFinDer= (int) pPrincipal.getPosicion().getX()+ 20;
			int posFinIz= (int) pPrincipal.getPosicion().getX() -20; 
			while(golpeado) {
				APulsado=false;
				DPulsado=false;
				WPulsado=false;
				SpacePulsado=false;
				
				timerEstado=System.currentTimeMillis();
				diferenciaTimers= timerEstado - timerJuego;
				
				stage.repaint();
				stage.revalidate();
				if(((int) pPrincipal.getPosicion().getX() >= posFinIz && (int) pPrincipal.getPosicion().getX() <= posIni) || ((int) pPrincipal.getPosicion().getX()) >= posIni && (int) pPrincipal.getPosicion().getX() <= posFinDer) {
				pPrincipal.Rebotar(pSecundario,stage);
				}
				if(diferenciaTimers <= tiempoAnimGolpeado) {
					EstadoGolpeado(diferenciaTimers);
				}
				else {
					diferenciaTimers =0;
					timerJuego = System.currentTimeMillis();
					golpeado=false;
				}
				try {
					Thread.sleep(16); //Mas o menos 60 veces por segundo hará el bucle
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			//CONTROL DE LADOS
				//lado izquierdo
		//	if(pPrincipal.getPosicion().getX()<=3 || pSecundario.getPosicion().getX()<=3) {
		//		pPrincipal.setPosicion(new Point((int)(pPrincipal.getPosicion().getX()+5),(int)(pPrincipal.getPosicion().getY())));
		//		pSecundario.setPosicion(new Point((int)(pPrincipal.getPosicion().getX()+5),(int)(pPrincipal.getPosicion().getY())));
		//	}
		//		//lado derecho
		//	if(pPrincipal.getPosicion().getX()>=(stage.getWidth()-3) || pSecundario.getPosicion().getX()>=(stage.getWidth()-3)) {
		//		pPrincipal.setPosicion(new Point((int)(pPrincipal.getPosicion().getX()-5),(int)(pPrincipal.getPosicion().getY())));
		//		pSecundario.setPosicion(new Point((int)(pPrincipal.getPosicion().getX()-5),(int)(pPrincipal.getPosicion().getY())));
		//	}
			//CIERRE DE JUEGO
			if(pPrincipal.getVida()==0 || pSecundario.getVida()==0) {
				if(pSecundario.getVida()==0) {
					if(pSecundario instanceof Enemigo) {
						if(ch.getNivelesCompletados()<8) {
							ch.setNivelesCompletados(ch.getNivelesCompletados()+1);
						}
					}
				}
				
				StageCerrado=true;
				stage.dispose();
			}
		}	
	}
	
	private long calcularTiempoAnimParado(PersonajeJugable principal) {
		if(principal.getTipoPersonaje().equals("robot")) {
			return ElementoAnimacion.getTiempoAnimParadoRobot();
		}
		if(principal.getTipoPersonaje().equals("ninja")) {
			return 0;
			//return ElementoAnimacion.getTiempoAnimParadoNinja();
		}
		else {
			return 0;
		}
	}
	
	private long calcularTiempoAnimMoverse(PersonajeJugable principal) {
		if(principal.getTipoPersonaje().equals("robot")) {
			return ElementoAnimacion.getTiempoAnimMoverseRobot();
		} 
		if(principal.getTipoPersonaje().equals("ninja")) {
			return ElementoAnimacion.getTiempoAnimMoverseNinja();
		}
		else {
			return 0;
		}
	}
	
	private long calcularTiempoAnimGolpear(PersonajeJugable principal) {
		if(principal.getTipoPersonaje().equals("robot")) {
			return ElementoAnimacion.getTiempoAnimGolpearRobot();
		}
		if(principal.getTipoPersonaje().equals("ninja")) {
			return ElementoAnimacion.getTiempoAnimGolpearNinja();
		}
		else {
			return 0;
		}
	}
	
	private long calcularTiempoAnimGolpeado(PersonajeJugable principal) {
		if(principal.getTipoPersonaje().equals("robot")) {
			return ElementoAnimacion.getTiempoAnimGolpeadoRobot();
		}
		if(principal.getTipoPersonaje().equals("ninja")) {
			return 0;
			//return ElementoAnimacion.getTiempoAnimParadoNinja();
		}
		else {
			return 0;
		}
	}
}
