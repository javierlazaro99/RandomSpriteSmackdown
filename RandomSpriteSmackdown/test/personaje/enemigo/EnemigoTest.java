package personaje.enemigo;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import personaje.personajeJugable.PersonajeJugable;

public class EnemigoTest {
	
	PersonajeJugable pj1;
	Enemigo enem;

	@Before
	public void setUp() throws Exception {
		pj1 = new PersonajeJugable("", new Point(0, 0), 10, 10, 10);
		enem = new Enemigo(new Point(100, 0), 10, 10, 10, 1);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void IAMovimientoTest1() {
		pj1.Moverse(null, 1, 0);
		enem.IAMovimiento(pj1);
		assertEquals(new Point(90, 0), enem.getPosicion());
	}
	

	@Test
	public void IAMovimientoTest2() {
		pj1.Moverse(null, 20, 0);
		enem.IAMovimiento(pj1);
		assertEquals(new Point(110, 0), enem.getPosicion());
	}
	
	@Test
	public void IAMovimientoTest3() {
		pj1.Moverse(null, 10, 0);
		enem.IAMovimiento(pj1);
		assertEquals(new Point(100, 0), enem.getPosicion());
	}
	
	
}
