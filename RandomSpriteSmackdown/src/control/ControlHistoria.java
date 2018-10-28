package control;

import java.util.ArrayList;

import Ventanas.VentanaCreacionPersonaje;
import personaje.personajeJugable.PersonajeJugable;

public class ControlHistoria {
	
	private PersonajeJugable personajePrincipal;
	private ArrayList<Nivel> listaNiveles;
	public boolean personajeCreado;
	
	public ControlHistoria() {
		personajePrincipal = null;
		listaNiveles = new ArrayList<Nivel>();
		personajeCreado = false;
	}
	
	public void Historia() {
		if(personajePrincipal == null) {
			VentanaCreacionPersonaje vcp = new VentanaCreacionPersonaje();
			vcp.setVisible(true);
			
			while(vcp.devolverCreado() == null) {
				try {
					if(vcp.isVisible()) {
						Thread.sleep(200);
					}else {
						break;
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			personajePrincipal = vcp.devolverCreado();
			System.out.println(personajePrincipal + personajePrincipal.getNombre());
			vcp.dispose();
			
		}
		
		
	}

	public boolean isPersonajeCreado() {
		return personajeCreado;
	}

	public void setPersonajeCreado(boolean personajeCreado) {
		this.personajeCreado = personajeCreado;
	}
	
	
	
	

}
