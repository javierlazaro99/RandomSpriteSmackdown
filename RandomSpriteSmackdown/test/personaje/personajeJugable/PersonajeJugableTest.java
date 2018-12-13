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
		pj = new PersonajeJugable("personaje", new Point(0, 0), 10, 10, 10, "");
		ch = new ControlHistoria(pj, 0);
		ce= new ControlEstados(pj, null, stage, ch);
		stage = new VentanaStage(pj, null, 0, ch);
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
		Enemigo enem = new Enemigo(new Point(20, 0), 10, 10, 10, 1);
		pj.Moverse(1, 0,stage,ce);
		pj.DarGolpe(enem);
		assertEquals(9, enem.getVida(), 0.01);
		
		pj.Moverse(1, 0,stage,ce);
		pj.DarGolpe(enem);
		assertEquals(8, enem.getVida(), 0.01);
	}
	
	@Test
	public void DarGolpeTestJugador() {
		PersonajeJugable pj2 = new PersonajeJugable("Guille", new Point(20, 0), 20, 20, 10, "");
		pj.Moverse(1, 0,stage,ce);
		pj2.Moverse(-1, 0,stage,ce);
		
		pj.DarGolpe(pj2);
		pj2.DarGolpe(pj);
		
		//assertEquals(8, pj.getVida(), 0.01); //Esto no funcionará porque ha habido rebote
		assertEquals(19, pj2.getVida(), 0.01); 
		
	}
	

}
