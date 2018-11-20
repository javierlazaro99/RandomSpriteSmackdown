package personaje.enemigo;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import personaje.personajeJugable.PersonajeJugable;

public class EnemigoTest {
	
	private PersonajeJugable pj1;
	private Enemigo enem;

	@Before
	public void setUp() throws Exception {
		pj1 = new PersonajeJugable("", new Point(0, 0), 10, 10, 10, "");
		enem = new Enemigo(new Point(100, 0), 10, 10, 10, 1);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void IAMovimientoTest1() {
		//Prueba de IA perseguir hascia la izquerda
		pj1.Moverse(1, 0);
		enem.IAMovimiento(pj1);
		assertEquals(new Point(90, 0), enem.getPosicion());
	}
	

	@Test
	public void IAMovimientoTest2() {
		//Prubeba de IA perseguir hacia la derecha
		pj1.Moverse(20, 0);
		enem.IAMovimiento(pj1);
		assertEquals(new Point(110, 0), enem.getPosicion());
	}
	
	@Test
	public void IAMovimientoTest3() {
		//Prueba IA movimiento si el jugador está pegado a la IA
		pj1.Moverse(10, 0);
		enem.IAMovimiento(pj1);
		assertEquals(new Point(100, 0), enem.getPosicion());
	}
	
	
}
