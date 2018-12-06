package control;

import java.util.ArrayList;

public class ElementoAnimacion {
	private String label;
	private long tiempos;
	
	
	public static ArrayList<ElementoAnimacion> animParado = new ArrayList<ElementoAnimacion>();
	static long tiempoAnimParado;
	public static ArrayList<ElementoAnimacion> animSaltando = new ArrayList<ElementoAnimacion>();
	static long tiempoAnimSaltando;
	public static ArrayList<ElementoAnimacion> animMoverse = new ArrayList<ElementoAnimacion>();
	static long tiempoAnimMoverse;
	public static ArrayList<ElementoAnimacion> animGolpear = new ArrayList<ElementoAnimacion>();
	static long tiempoAnimGolpear;
	
	public ElementoAnimacion(String label,long tiempos) {
		this.label = label;
		this.tiempos = tiempos;
	}
	
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public long getTiempos() {
		return tiempos;
	}

	public void setTiempos(long tiempos) {
		this.tiempos = tiempos;
	}

	public static ArrayList<ElementoAnimacion> CrearAnimParado() {
		animParado.add(new ElementoAnimacion("png/Idle (1).png", 100));
		animParado.add(new ElementoAnimacion("png/Idle (2).png", 200));
		animParado.add(new ElementoAnimacion("png/Idle (3).png", 300));
		animParado.add(new ElementoAnimacion("png/Idle (4).png", 400));
		animParado.add(new ElementoAnimacion("png/Idle (5).png", 500));
		animParado.add(new ElementoAnimacion("png/Idle (6).png", 600));
		animParado.add(new ElementoAnimacion("png/Idle (7).png", 700));
		animParado.add(new ElementoAnimacion("png/Idle (8).png", 800));
		animParado.add(new ElementoAnimacion("png/Idle (9).png", 900));
		animParado.add(new ElementoAnimacion("png/Idle (10).png", 1000));

		return animParado;
	}
	
	public static ArrayList<ElementoAnimacion> CrearAnimSaltando() {
		animSaltando.add(new ElementoAnimacion("png/Jump (1).png", 100));
		animSaltando.add(new ElementoAnimacion("png/Jump (2).png", 200));
		animSaltando.add(new ElementoAnimacion("png/Jump (3).png", 300));
		animSaltando.add(new ElementoAnimacion("png/Jump (4).png", 400));
		animSaltando.add(new ElementoAnimacion("png/Jump (5).png", 500));
		animSaltando.add(new ElementoAnimacion("png/Jump (6).png", 600));
		animSaltando.add(new ElementoAnimacion("png/Jump (7).png", 700));
		animSaltando.add(new ElementoAnimacion("png/Jump (8).png", 800));
		animSaltando.add(new ElementoAnimacion("png/Jump (9).png", 900));
		animSaltando.add(new ElementoAnimacion("png/Jump (10).png", 1000));

		return animSaltando;
	}
	public static ArrayList<ElementoAnimacion> CrearAnimMoverse(){
		animMoverse.add(new ElementoAnimacion("png/Run (1).png", 100));
		animMoverse.add(new ElementoAnimacion("png/Run (2).png", 200));
		animMoverse.add(new ElementoAnimacion("png/Run (3).png", 300));
		animMoverse.add(new ElementoAnimacion("png/Run (4).png", 400));
		animMoverse.add(new ElementoAnimacion("png/Run (5).png", 500));
		animMoverse.add(new ElementoAnimacion("png/Run (6).png", 600));
		animMoverse.add(new ElementoAnimacion("png/Run (7).png", 700));
		animMoverse.add(new ElementoAnimacion("png/Run (8).png", 800));
		
		return animMoverse;

	}
	public static ArrayList<ElementoAnimacion> CrearAnimGolpear(){
		animGolpear.add(new ElementoAnimacion("png/Melee (1).png", 100));
		animGolpear.add(new ElementoAnimacion("png/Melee (2).png", 200));
		animGolpear.add(new ElementoAnimacion("png/Melee (3).png", 300));
		animGolpear.add(new ElementoAnimacion("png/Melee (4).png", 400));
		animGolpear.add(new ElementoAnimacion("png/Melee (5).png", 500));
		animGolpear.add(new ElementoAnimacion("png/Melee (6).png", 600));
		animGolpear.add(new ElementoAnimacion("png/Melee (7).png", 700));
		animGolpear.add(new ElementoAnimacion("png/Melee (8).png", 800));
		
		return animGolpear;
	}
	
	public static long getTiempoAnimParado() {
		return animParado.get(animParado.size() -1).tiempos;
	}
	
	public static long getTiempoAnimSaltando() {
		return animParado.get(animSaltando.size() -1).tiempos;
	}
	public static long getTiempoAnimMoverse() {
		return animMoverse.get(animMoverse.size() -1).tiempos;
	}
	public static long getTiempoAnimGolpear() {
		return animGolpear.get(animGolpear.size() -1).tiempos;
	}
	
}
