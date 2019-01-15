package personaje;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Ventanas.VentanaStage;
import control.ControlEstados;
import control.ControlHistoria;
import control.ControlIA;
import personaje.enemigo.Enemigo;
import personaje.personajeJugable.PersonajeJugable;

public class PersonajeTest {
	
	private PersonajeJugable p1;
	private Personaje p2;
	private ControlHistoria ch;
	private ControlEstados ce;
	private VentanaStage stage;
	private ControlIA cia;
	@Before
	public void setUp() throws Exception {
		
		p1 = new PersonajeJugable(null, new Point(0,0), 10, 10, 10, "robot") ; 
		
		p2 = new Enemigo(new Point(0,0), 10, 10, 10, "robot", 0) ;
		ch= new ControlHistoria(p1, 0);
		stage= new VentanaStage(p1, p2, 0, ch, true);
		ce= new ControlEstados(p1, p2,stage , ch, null, ce);
		cia = new ControlIA(p1, (Enemigo) p2, stage, ch, ce);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void MoverseTest() {
		p1.Moverse(1, 0,stage,ce);
		assertEquals(new Point(10, 648), p1.getPosicion());
		
		p1.Moverse(0, 0.5,stage,ce);
		assertEquals(new Point(10, 653), p1.getPosicion());	
	}
	
	@Test 
	public void RebotarTest1() {
		//Prueba para comprobar si se hace bien el rebote hacia la izquierda
		p1.setPosicion(new Point(50, 0));
		p2.setPosicion(new Point(60, 0));
		
		p1.Rebotar(p2,stage);
		assertEquals(new Point(30,0) , p1.getPosicion());
		
		p2.Rebotar(p1,stage);
		assertEquals(new Point(80, 0), p2.getPosicion());
	}
	
	@Test 
	public void RebotarTest2() {
		//Prueba para comprobar si se hace bien el rebote hacia la derecha
		p1.setPosicion(new Point(50, 0));
		p2.setPosicion(new Point(50, 0));
		
		p1.Rebotar(p2,stage);
		assertNotEquals(new Point(48,0) , p1.getPosicion());
	}
	

}
