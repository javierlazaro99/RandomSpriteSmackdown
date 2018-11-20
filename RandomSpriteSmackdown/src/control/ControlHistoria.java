package control;

import java.util.ArrayList;

import personaje.personajeJugable.PersonajeJugable;
import ventanas.VentanaCreacionPersonaje;

public class ControlHistoria {
	
	private PersonajeJugable personajePrincipal;
	private int nivelesCompletados;
	
	public ControlHistoria(PersonajeJugable pj, int nivelesComp) {
		personajePrincipal = pj;
		nivelesCompletados = nivelesComp;
	}

	public PersonajeJugable getPersonajePrincipal() {
		return personajePrincipal;
	}

	public void setPersonajePrincipal(PersonajeJugable personajePrincipal) {
		this.personajePrincipal = personajePrincipal;
	}

	public int getNivelesCompletados() {
		return nivelesCompletados;
	}

	public void setNivelesCompletados(int nivelesCompletados) {
		this.nivelesCompletados = nivelesCompletados;
	}

	
	
	
	

}
