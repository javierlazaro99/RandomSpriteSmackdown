package control;

import java.awt.Point;
import java.sql.Time;
import java.util.ArrayList;

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
	private ElementoAnimacion elementoAnimacionPersonaje;
	private ControlIA cIA;
	private ControlHistoria ch;
	private boolean choque;
	private boolean Parado;
	public boolean isChoque() {
		return choque;
	}

	public void setChoque(boolean choque) {
		this.choque = choque;
	}

	public ControlEstados(PersonajeJugable pPrincipal,Personaje pSecundario, VentanaStage stage,ControlHistoria ch,ControlIA cIA) {//Personaje de la izquierda y de la derecha
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
		Parado=true;
		if(pPrincipal.equals(stage.getpPrincipal())) {
			this.elementoAnimacionPersonaje = stage.getElementoAnimacionPersonaje1(); 
		}if(pPrincipal.equals(stage.getpSecundario())) {
			this.elementoAnimacionPersonaje = stage.getElementoAnimacionPersonaje2(); 
		}
		
		this.cIA=cIA;
		
	}
	
	
	
	public boolean isParado() {
		return Parado;
	}

	public void setParado(boolean parado) {
		Parado = parado;
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
			controlAnimacion.AnimacionParado(diferenciaTimers, pPrincipal, stage, elementoAnimacionPersonaje);//sprites
		}else {
			if(pPrincipal.getlPersonaje().isVertFlip()==false) {//comprobacion de adonde mira
				pPrincipal.getlPersonaje().setVertFlip(true);
			}
			controlAnimacion.AnimacionParado(diferenciaTimers, pPrincipal, stage, elementoAnimacionPersonaje);
		}
	}
	
	private void EstadoMoverseDerecha(long diferenciaTimers) {
		if(pPrincipal.equals(stage.getpPrincipal())) {
			stage.getiProta().setHorFlip(false);
		}else {
			stage.getiEnemigo().setHorFlip(false);
		}
		
		controlAnimacion.AnimacionMoverse(diferenciaTimers, pPrincipal, stage, elementoAnimacionPersonaje);
	}
	
	private void EstadoMoverseIzquierda(long diferenciaTimers) {
		if(pPrincipal.equals(stage.getpPrincipal())) {
			stage.getiProta().setHorFlip(true);
		}else {
			stage.getiEnemigo().setHorFlip(true);
		}
		controlAnimacion.AnimacionMoverse(diferenciaTimers, pPrincipal, stage, elementoAnimacionPersonaje);
	}
	
	private void EstadoSalto(long diferenciaTimers) {
		if((pPrincipal.getPosicion().getX()-pSecundario.getPosicion().getX())<0) {
			if(pPrincipal.getlPersonaje().isHorFlip()==true) {//comprobacion de adonde mira
				pPrincipal.getlPersonaje().setHorFlip(false);
			}
			controlAnimacion.AnimacionSaltando(diferenciaTimers, pPrincipal, stage, elementoAnimacionPersonaje);//sprites
		}else {
			if(pPrincipal.getlPersonaje().isHorFlip()==false) {//comprobacion de adonde mira
				pPrincipal.getlPersonaje().setHorFlip(true);
			}
			controlAnimacion.AnimacionSaltando(diferenciaTimers, pPrincipal, stage, elementoAnimacionPersonaje);
		}
	}
	
	private void EstadoSaltoDerecha(long diferenciaTimers) {
		if(pPrincipal.equals(stage.getpPrincipal())) {
			stage.getiProta().setHorFlip(false);
		}else {
			stage.getiEnemigo().setHorFlip(false);
		}
		controlAnimacion.AnimacionSaltando(diferenciaTimers, pPrincipal, stage, elementoAnimacionPersonaje);
	}
	
	private void EstadoSaltoIzquierda(long diferenciaTimers) {
		if(pPrincipal.equals(stage.getpPrincipal())) {
			stage.getiProta().setHorFlip(true);
		}else {
			stage.getiEnemigo().setHorFlip(true);
		}
		controlAnimacion.AnimacionSaltando(diferenciaTimers, pPrincipal, stage, elementoAnimacionPersonaje);
	}
	
	private void EstadoGolpear(long diferenciaTimers) {
		if((pPrincipal.getPosicion().getX()-pSecundario.getPosicion().getX())<0) {
			if(pPrincipal.getlPersonaje().isHorFlip()==true) {//comprobacion de adonde mira
				pPrincipal.getlPersonaje().setHorFlip(false);
			}
<<<<<<< HEAD
			controlAnimacion.AnimacionGolpear(diferenciaTimers, pPrincipal, stage,pSecundario, elementoAnimacionP1,cIA,this);//sprites
=======
			controlAnimacion.AnimacionGolpear(diferenciaTimers, pPrincipal, stage,pSecundario, elementoAnimacionPersonaje,cIA);//sprites
>>>>>>> branch 'master' of https://github.com/javierlazaro99/RandomSpriteSmackdown.git
		}else {
			if(pPrincipal.getlPersonaje().isHorFlip()==false) {//comprobacion de adonde mira
				pPrincipal.getlPersonaje().setHorFlip(true);
			}
<<<<<<< HEAD
			controlAnimacion.AnimacionGolpear(diferenciaTimers, pPrincipal, stage,pSecundario, elementoAnimacionP1,cIA,this);
=======
			controlAnimacion.AnimacionGolpear(diferenciaTimers, pPrincipal, stage,pSecundario, elementoAnimacionPersonaje,cIA);
>>>>>>> branch 'master' of https://github.com/javierlazaro99/RandomSpriteSmackdown.git
		}
	}
	public boolean isGolpeado() {
		return golpeado;
	}

	public void setGolpeado(boolean golpeado) {
		this.golpeado = golpeado;
	}

	private void EstadoGolpeado(long diferenciaTimers) {
		if((pPrincipal.getPosicion().getX()-pSecundario.getPosicion().getX())<0) {
			if(pPrincipal.getlPersonaje().isHorFlip()==true) {//comprobacion de adonde mira
				pPrincipal.getlPersonaje().setHorFlip(false);
			}
			controlAnimacion.AnimacionGolpeado(diferenciaTimers, pSecundario,pPrincipal, stage, elementoAnimacionPersonaje,cIA,this);//sprites
		}else {
			if(pPrincipal.getlPersonaje().isHorFlip()==false) {//comprobacion de adonde mira
				pPrincipal.getlPersonaje().setHorFlip(true);
			}
			controlAnimacion.AnimacionGolpeado(diferenciaTimers, pSecundario,pPrincipal, stage, elementoAnimacionPersonaje,cIA,this);
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
				
				if(diferenciaTimers <= elementoAnimacionPersonaje.getTiempoAnimParado()) {//Posible cambio
					if(Parado==true) {
						EstadoParado(diferenciaTimers);
					}
					
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
				System.out.println(pPrincipal.getPosicion().getX());
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
					
					if(pPrincipal.equals(stage.getpPrincipal())) {
						stage.getiProta().setLocation(pPrincipal.getPosicion());
					}else {
						stage.getiEnemigo().setLocation(pPrincipal.getPosicion());
					}
					
					
					stage.repaint();
					stage.revalidate();
					
					if(diferenciaTimers <= elementoAnimacionPersonaje.getTiempoAnimMoverse()) {//Posible cambio
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
					
					if(pPrincipal.equals(stage.getpPrincipal())) {
						stage.getiProta().setLocation(pPrincipal.getPosicion());
					}else {
						stage.getiEnemigo().setLocation(pPrincipal.getPosicion());
					}
					
					stage.repaint();
					stage.revalidate();
					
					if(diferenciaTimers <= elementoAnimacionPersonaje.getTiempoAnimMoverse()) {
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
						if(pPrincipal.equals(stage.getpPrincipal())) {
							stage.getiProta().setLocation(pPrincipal.getPosicion());
						}else {
							stage.getiEnemigo().setLocation(pPrincipal.getPosicion());
						}
					}if(miposicion == alturaObjetivo) {
						alturaObjetivo = alturaBase;	
					}if(miposicion < alturaObjetivo) {
						pPrincipal.Moverse(0, 1,stage,this);
						miposicion = (int) pPrincipal.getPosicion().getY();
						if(pPrincipal.equals(stage.getpPrincipal())) {
							stage.getiProta().setLocation(pPrincipal.getPosicion());
						}else {
							stage.getiEnemigo().setLocation(pPrincipal.getPosicion());
						}
						
						if(miposicion == alturaBase) {
							saltando = false; //Acaba el salto y puede volver a comprobar si w está pulsado
						}
					}
					
					stage.repaint();
					stage.revalidate();
					
					
					if(diferenciaTimers <= elementoAnimacionPersonaje.getTiempoAnimSaltando()) {
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
						if(pPrincipal.equals(stage.getpPrincipal())) {
							stage.getiProta().setLocation(pPrincipal.getPosicion());
						}else {
							stage.getiEnemigo().setLocation(pPrincipal.getPosicion());
						}
					}if(miposicion == alturaObjetivo) {
						alturaObjetivo = alturaBase;	
					}if(miposicion < alturaObjetivo) {
						pPrincipal.Moverse(1, 1,stage,this);
						miposicion = (int) pPrincipal.getPosicion().getY();
						if(pPrincipal.equals(stage.getpPrincipal())) {
							stage.getiProta().setLocation(pPrincipal.getPosicion());
						}else {
							stage.getiEnemigo().setLocation(pPrincipal.getPosicion());
						}
						
						if(miposicion == alturaBase ) {
							saltandoDerecha = false;//Acaba el salto y puede volver a comprobar si w está pulsado
						
						}
					}
					
					stage.repaint();
					stage.revalidate();
					
					
					if(diferenciaTimers <= elementoAnimacionPersonaje.getTiempoAnimSaltando()) {
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
						if(pPrincipal.equals(stage.getpPrincipal())) {
							stage.getiProta().setLocation(pPrincipal.getPosicion());
						}else {
							stage.getiEnemigo().setLocation(pPrincipal.getPosicion());
						}
					}if(miposicion == alturaObjetivo) {
						alturaObjetivo = alturaBase;	
					}if(miposicion < alturaObjetivo) {
						pPrincipal.Moverse(-1, 1,stage,this);
						miposicion = (int) pPrincipal.getPosicion().getY();
						if(pPrincipal.equals(stage.getpPrincipal())) {
							stage.getiProta().setLocation(pPrincipal.getPosicion());
						}else {
							stage.getiEnemigo().setLocation(pPrincipal.getPosicion());
						}
						
						if(miposicion == alturaBase ) {
							saltandoIzquierda = false; //Acaba el salto y puede volver a comprobar si w está pulsado
						}
					}
					
					stage.repaint();
					stage.revalidate();
					
					
					if(diferenciaTimers <= elementoAnimacionPersonaje.getTiempoAnimSaltando()) {
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
					
					
					if(diferenciaTimers <= elementoAnimacionPersonaje.getTiempoAnimGolpear()) {
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
				if(diferenciaTimers <= elementoAnimacionPersonaje.getTiempoAnimGolpeado()) {
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
			
			//CIERRE DE JUEGO
			if(pPrincipal.getVida()<=0 || pSecundario.getVida()<=0) {
				if(pSecundario.getVida()<=0) {
					if(pSecundario instanceof Enemigo) {
						if(ch.getNivelesCompletados()<8) {
							ch.setNivelesCompletados(ch.getNivelesCompletados()+1);
							stage.setContador(0);
							StageCerrado=true;
							stage.dispose();
						}
					}
				}
				
				stage.setContador(0);
				StageCerrado=true;
				stage.dispose();
			}
		}	
	}
}
