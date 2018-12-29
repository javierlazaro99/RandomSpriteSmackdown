package control;

import java.io.*;
import javax.sound.sampled.*;

public class Sonidos {
	
	private static Sonidos mainThemeSonido = new Sonidos();
	private static Sonidos nivel1ThemeSonido = new Sonidos();
	private static Sonidos nivel2ThemeSonido = new Sonidos();
	private static Sonidos nivel3ThemeSonido = new Sonidos();
	private static Sonidos nivel4ThemeSonido = new Sonidos();
	public static Sonidos punch1Sonido = new Sonidos();
	public static Sonidos punch2Sonido = new Sonidos();
	
	public static Clip mainTheme = mainThemeSonido.cargarSonido("sounds/MainTheme.wav");
	public static Clip nivel1Theme = nivel1ThemeSonido.cargarSonido("sounds/Nivel1.wav");
	public static Clip nivel2Theme = nivel2ThemeSonido.cargarSonido("sounds/Nivel2.wav");
	public static Clip nivel3Theme = nivel3ThemeSonido.cargarSonido("sounds/Nivel3.wav");
	public static Clip nivel4Theme = nivel4ThemeSonido.cargarSonido("sounds/Nivel4.wav");
//	public static Clip punch1 = punch1Sonido.cargarSonido("sounds/punch_1.wav");
//	public static Clip punch2 = punch2Sonido.cargarSonido("sounds/punch_2.wav");
	
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
