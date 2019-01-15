package personaje.personajeJugable;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Ventanas.VentanaStage;
import control.ControlEstados;
import control.ControlHistoria;
import personaje.enemigo.Enemigo;

public class PersonajeJugableTest {
	
	private PersonajeJugable pj;
	private VentanaStage stage;
	private ControlEstados ce;
	private ControlHistoria ch;
	@Before
	public void setUp() throws Exception {
		pj = new PersonajeJugable("personaje", new Point(0, 0), 10, 10, 10, "ninja");
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void getPuntosMejora() {
		assertEquals(0, pj.getPuntosMejora());
	}
	
	@Test
	public void SubirNivel() {
		pj.setPuntosMejora(3);
		pj.SubirNivel("hola");
		assertEquals(10, pj.getFuerza(), 0.01);
		assertEquals(10, pj.getVida(), 0.01);
		assertEquals(10, pj.getVelocidad(), 0.01);
		assertEquals(3, pj.getPuntosMejora());
		
		pj.SubirNivel("velocidad");
		assertEquals(10, pj.getFuerza(), 0.01);
		assertEquals(10, pj.getVida(), 0.01);
		assertEquals(20, pj.getVelocidad(), 0.01);
		assertEquals(2, pj.getPuntosMejora());
		
		pj.SubirNivel("vida");
		assertEquals(10, pj.getFuerza(), 0.01);
		assertEquals(20, pj.getVida(), 0.01);
		assertEquals(20, pj.getVelocidad(), 0.01);
		assertEquals(1, pj.getPuntosMejora());
		
		pj.SubirNivel("fuerza");
		assertEquals(20, pj.getFuerza(), 0.01);
		assertEquals(20, pj.getVida(), 0.01);
		assertEquals(20, pj.getVelocidad(), 0.01);
		assertEquals(0, pj.getPuntosMejora());
	}
	
	@Test
	public void DarGolpeTestEnemigo() {
		Enemigo enem = new Enemigo(new Point(20, 0), 10, 10, 10, "robot", 1);
		ch=new ControlHistoria(pj, 0);
		stage = new VentanaStage(pj, enem, 0, ch, true,null);
		enem.setPosicion(new Point(40, 0));
			
		
		pj.DarGolpe(enem);
		assertEquals(9, enem.getVida(), 0.01);
		
		
	}
	
	@Test
	public void DarGolpeTestJugador() {
		PersonajeJugable pj2 = new PersonajeJugable("Guille", new Point(20, 0), 20, 20, 10, "robot");
		
		ch=new ControlHistoria(pj, 0);
		stage = new VentanaStage(pj, pj2, 0, ch, false,null);
		pj2.setPosicion(new Point(40, 0));
		
		pj.DarGolpe(pj2);
		
		
		
		assertEquals(19, pj2.getVida(), 0.01); 
		
	}
	

}
