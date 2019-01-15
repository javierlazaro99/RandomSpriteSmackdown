package personaje.enemigo;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Ventanas.VentanaStage;
import control.ControlEstados;
import control.ControlHistoria;
import control.ControlIA;
import personaje.personajeJugable.PersonajeJugable;

public class EnemigoTest {
	
	private PersonajeJugable pj1;
	private Enemigo enem;
	private VentanaStage stage;
	private ControlEstados ce;
	private ControlHistoria ch;
	private ControlIA cia ;
	@Before
	public void setUp() throws Exception {
		pj1 = new PersonajeJugable("", new Point(0, 0), 10, 10, 10, "robot");
		enem = new Enemigo(new Point(100, 0), 10, 10, 10, "robot", 1);
		ch= new ControlHistoria(pj1, 0);
		stage=new VentanaStage(pj1, enem, 0, ch, true);
		ce=new ControlEstados(pj1, enem, stage, ch,cia , ce);
		cia = new ControlIA(pj1, enem, stage, ch, ce);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void IAMovimientoTest1() {
		//Prueba de IA perseguir hascia la izquerda
		pj1.Moverse(1, 0,stage,ce);
		enem.IAMovimiento(pj1,stage,ce);
		assertEquals(new Point(1436, 648), enem.getPosicion());
	}
	

	@Test
	public void IAMovimientoTest2() {
		//Prubeba de IA perseguir hacia la derecha
		pj1.Moverse(20, 0,stage,ce);
		enem.IAMovimiento(pj1,stage,ce);
		assertEquals(new Point(1516,648 ), enem.getPosicion());
	}
	
	@Test
	public void IAMovimientoTest3() {
		//Prueba IA movimiento si el jugador está pegado a la IA
		pj1.Moverse(10, 0,stage,ce);
		enem.IAMovimiento(pj1,stage,ce);
		assertEquals(new Point(1516, 648), enem.getPosicion());
	}
	
	
}
