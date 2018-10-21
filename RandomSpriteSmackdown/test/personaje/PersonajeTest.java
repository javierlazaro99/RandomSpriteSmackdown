package personaje;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PersonajeTest {
	
	private Personaje p1;
	private Personaje p2;

	@Before
	public void setUp() throws Exception {
		p1 = new Personaje(new Point(0,0), 10, 10, 10) {
			@Override
			public void DarGolpe(Personaje enemigo) {
				//No necesario
			}
		}; 
		
		p2 = new Personaje(new Point(0,0), 10, 10, 10) {
			
			@Override
			public void DarGolpe(Personaje enemigo) {
				// No necesario
				
			}
		};
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void MoverseTest() {
		p1.Moverse(null, 1, 0);
		assertEquals(new Point(10, 0), p1.getPosicion());
		
		p1.Moverse(null, 0, 0.5);
		assertEquals(new Point(10, 5), p1.getPosicion());	
	}
	
	@Test 
	public void RebotarTest1() {
		//Prueba para comprobar si se hace bien el rebote hacia la izquierda
		p1.setPosicion(new Point(50, 0));
		p2.setPosicion(new Point(60, 0));
		
		p1.Rebotar(p2);
		assertEquals(new Point(25,0) , p1.getPosicion());
		
		p2.Rebotar(p1);
		assertEquals(new Point(90, 0), p2.getPosicion());
	}
	
	@Test 
	public void RebotarTest2() {
		//Prueba para comprobar si se hace bien el rebote hacia la derecha
		p1.setPosicion(new Point(50, 0));
		p2.setPosicion(new Point(50, 0));
		
		p1.Rebotar(p2);
		assertNotEquals(new Point(50,0) , p1.getPosicion());
	}
	

}
