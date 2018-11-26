package control;

import personaje.Personaje;

public class ControlAnimaciones {
	
	private void AnimacionParado(long milis, Personaje personaje) {
		if(milis >= 0 && milis <= 100) {
			personaje.setlPersonaje("png/Idle (1).png");
		}if(milis > 100 && milis <= 200) {
			personaje.setlPersonaje("png/Idle (2).png");
		}if(milis > 200 && milis <= 300) {
			personaje.setlPersonaje("png/Idle (3).png");
		}if(milis > 300 && milis <= 400) {
			personaje.setlPersonaje("png/Idle (4).png");
		}if(milis > 400 && milis <= 500) {
			personaje.setlPersonaje("png/Idle (5).png");
		}if(milis > 500 && milis <= 600) {
			personaje.setlPersonaje("png/Idle (6).png");
		}if(milis > 600 && milis <= 700) {
			personaje.setlPersonaje("png/Idle (7).png");
		}if(milis > 700 && milis <= 800) {
			personaje.setlPersonaje("png/Idle (8).png");
		}if(milis > 800 && milis <= 900) {
			personaje.setlPersonaje("png/Idle (9).png");
		}if(milis > 900 && milis <= 1000) {
			personaje.setlPersonaje("png/Idle (10).png");
		}
	}
}
