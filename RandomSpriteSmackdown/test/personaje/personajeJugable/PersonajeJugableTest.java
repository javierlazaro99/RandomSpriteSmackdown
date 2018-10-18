package personaje.personajeJugable;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import personaje.enemigo.Enemigo;

public class PersonajeJugableTest {
	
	private PersonajeJugable pj;

	@Before
	public void setUp() throws Exception {
		pj = new PersonajeJugable("personaje", new Point(0, 0), 10, 10, 10);
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
		pj.Moverse(null, 1, 0);
		pj.DarGolpe(enem);
		assertEquals(10, enem.getVida(), 0.01);
		
		pj.Moverse(null, 1, 0);
		pj.DarGolpe(enem);
		assertEquals(9, enem.getVida(), 0.01);
	}
	
	@Test
	public void DarGolpeTestJugador() {
		PersonajeJugable pj2 = new PersonajeJugable("Guille", new Point(20, 0), 20, 20, 10);
		pj.Moverse(null, 1, 0);
		pj2.Moverse(null, -1, 0);
		
		pj.DarGolpe(pj2);
		pj2.DarGolpe(pj);
		
		//assertEquals(8, pj.getVida(), 0.01); //Esto no funcionará porque ha habido rebote
		assertEquals(19, pj2.getVida(), 0.01); 
		
	}
	

}
