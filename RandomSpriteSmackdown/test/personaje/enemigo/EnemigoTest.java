package personaje.enemigo;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Ventanas.VentanaStage;
import control.ControlEstados;
import control.ControlHistoria;
import personaje.personajeJugable.PersonajeJugable;

public class EnemigoTest {
	
	private PersonajeJugable pj1;
	private Enemigo enem;
	private VentanaStage stage;
	private ControlEstados ce;
	private ControlHistoria ch;
	@Before
	public void setUp() throws Exception {
		pj1 = new PersonajeJugable("", new Point(0, 0), 10, 10, 10, "");
		enem = new Enemigo(new Point(100, 0), 10, 10, 10, 1);
		ch= new ControlHistoria(pj1, 0);
		stage=new VentanaStage(pj1, enem, 0, ch);
		ce=new ControlEstados(pj1, enem, stage, ch);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void IAMovimientoTest1() {
		//Prueba de IA perseguir hascia la izquerda
		pj1.Moverse(1, 0,stage,ce);
		enem.IAMovimiento(pj1,stage,ce);
		assertEquals(new Point(90, 0), enem.getPosicion());
	}
	

	@Test
	public void IAMovimientoTest2() {
		//Prubeba de IA perseguir hacia la derecha
		pj1.Moverse(20, 0,stage,ce);
		enem.IAMovimiento(pj1,stage,ce);
		assertEquals(new Point(110, 0), enem.getPosicion());
	}
	
	@Test
	public void IAMovimientoTest3() {
		//Prueba IA movimiento si el jugador está pegado a la IA
		pj1.Moverse(10, 0,stage,ce);
		enem.IAMovimiento(pj1,stage,ce);
		assertEquals(new Point(100, 0), enem.getPosicion());
	}
	
	
}
