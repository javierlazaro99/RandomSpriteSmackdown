package personaje.personajeJugable;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PersonajeJugableTest {
	
	private PersonajeJugable pg;

	@Before
	public void setUp() throws Exception {
		pg = new PersonajeJugable("personaje", new Point(0, 0), 0, 0, 0);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void getPuntosMejora() {
		assertEquals(0, pg.getPuntosMejora());
	}
	
	@Test
	public void SubirNivel() {
		pg.setPuntosMejora(3);
		pg.SubirNivel("hola");
		assertEquals(0, pg.getFuerza());
		assertEquals(0, pg.getVida());
		assertEquals(0, pg.getVelocidad());
		assertEquals(3, pg.getPuntosMejora());
		
		pg.SubirNivel("velocidad");
		assertEquals(0, pg.getFuerza());
		assertEquals(0, pg.getVida());
		assertEquals(10, pg.getVelocidad());
		assertEquals(2, pg.getPuntosMejora());
		
		pg.SubirNivel("vida");
		assertEquals(0, pg.getFuerza());
		assertEquals(10, pg.getVida());
		assertEquals(10, pg.getVelocidad());
		assertEquals(1, pg.getPuntosMejora());
		
		pg.SubirNivel("fuerza");
		assertEquals(10, pg.getFuerza());
		assertEquals(10, pg.getVida());
		assertEquals(10, pg.getVelocidad());
		assertEquals(0, pg.getPuntosMejora());
	}
	
	@Test
	public void Moverse() {
		pg.Moverse(null, 10, 0);
		assertEquals(new Point(10, 0),  pg.getPosicion());
		
		pg.Moverse(null, 0, 5);
		assertEquals(new Point(10, 5),  pg.getPosicion());	
	}

}
