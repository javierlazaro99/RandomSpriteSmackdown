package control;

import java.io.*;
import javax.sound.sampled.*;

public class Sonidos {
	
	public Sonidos() {
	}
	
	//Método que toma un path y carga el sonido correspondiente en un AudioClip para luego ejecutar
	public Clip cargarSonido(String path) {
		Clip clip = null;
		try {
			File soundFile = new File(path);
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
			clip = AudioSystem.getClip();
			clip.open(audioIn);
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return clip;
	}

}
