package VentanaValidacion;

import static org.junit.Assert.*;

import java.awt.AWTException;
import java.awt.Component;
import java.awt.Container;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.InputEvent;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRootPane;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Ventanas.VentanaValidacion;

public class VentanaValidacionTest {
	VentanaValidacion ventana;
	@Before
	public void setup() {
		
		
		try {
			ventana = new VentanaValidacion();
			Thread.sleep(10);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@After 
	public void close() {
		
		try {
			ventana.dispose();
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void testButtonLogin() {
		
		try {
			ventana.setVisible(true);
			Robot robot = new Robot();
			System.out.println(ventana.getComponentCount());
			JRootPane panel=(JRootPane)ventana.getComponent(0);
			System.out.println(panel.getComponentCount());
			for (Component c : panel.getComponents()) {
				System.out.println( c.getClass().getName() );
			}
			JPanel panelcentral=(JPanel)panel.getComponent(0);
			System.out.println(panelcentral.getComponentCount());
			 JButton login=(JButton)panelcentral.getComponents()[0];
			Point lugar = login.getLocationOnScreen();
			robot.mouseMove((int)lugar.getX()+2, (int)lugar.getY()+2);
			robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
			robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
			int activo=Thread.activeCount();
			assertEquals(2, activo);
			
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void testButtonRegister() {
		try {
			ventana.setVisible(true);
			Robot robot = new Robot();
			System.out.println(ventana.getComponentCount());
			JRootPane panel=(JRootPane)ventana.getComponent(0);
			System.out.println(panel.getComponentCount());
			JPanel panelcentral=(JPanel)panel.getComponent(0);
			System.out.println(panelcentral.getComponentCount());
			 JButton login=(JButton)panelcentral.getComponents()[0];
			Point lugar = login.getLocationOnScreen();
			robot.mouseMove((int)lugar.getX()+2, (int)lugar.getY()+2);
			robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
			robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
			int activo=Thread.activeCount();
			assertEquals(2, activo);
			
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void testexit() {
		try {
			Thread.sleep(20);
			assertEquals(0, Thread.activeCount());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
