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
	public static ArrayList<ElementoAnimacion> animGolpeado = new ArrayList<ElementoAnimacion>();
	static long tiempoAnimGolpeado;
	public static ArrayList<ElementoAnimacion> animEnemMoverse= new ArrayList<ElementoAnimacion>();
	static long tiempoAnimEnemMoverse;
	public static ArrayList<ElementoAnimacion> animEnemGolpear= new ArrayList<ElementoAnimacion>();
	static long tiempoAnimEnemGolpear;
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
		animSaltando.add(new ElementoAnimacion("png/Jump (1).png", 70));
		animSaltando.add(new ElementoAnimacion("png/Jump (2).png", 140));
		animSaltando.add(new ElementoAnimacion("png/Jump (3).png", 210));
		animSaltando.add(new ElementoAnimacion("png/Jump (4).png", 280));
		animSaltando.add(new ElementoAnimacion("png/Jump (5).png", 350));
		animSaltando.add(new ElementoAnimacion("png/Jump (6).png", 420));
		animSaltando.add(new ElementoAnimacion("png/Jump (7).png", 490));
		animSaltando.add(new ElementoAnimacion("png/Jump (8).png", 560));
		animSaltando.add(new ElementoAnimacion("png/Jump (9).png", 630));
		animSaltando.add(new ElementoAnimacion("png/Jump (10).png", 700));

		return animSaltando;
	}
	public static ArrayList<ElementoAnimacion> CrearAnimMoverse(){
		animMoverse.add(new ElementoAnimacion("png/Run (1).png", 62));
		animMoverse.add(new ElementoAnimacion("png/Run (2).png", 125));
		animMoverse.add(new ElementoAnimacion("png/Run (3).png", 187));
		animMoverse.add(new ElementoAnimacion("png/Run (4).png", 250));
		animMoverse.add(new ElementoAnimacion("png/Run (5).png", 312));
		animMoverse.add(new ElementoAnimacion("png/Run (6).png", 375));
		animMoverse.add(new ElementoAnimacion("png/Run (7).png", 437));
		animMoverse.add(new ElementoAnimacion("png/Run (8).png", 500));
		animMoverse.add(new ElementoAnimacion("png/Run (1).png", 562));
		animMoverse.add(new ElementoAnimacion("png/Run (2).png", 625));
		animMoverse.add(new ElementoAnimacion("png/Run (3).png", 687));
		animMoverse.add(new ElementoAnimacion("png/Run (4).png", 750));
		animMoverse.add(new ElementoAnimacion("png/Run (5).png", 812));
		animMoverse.add(new ElementoAnimacion("png/Run (6).png", 875));
		animMoverse.add(new ElementoAnimacion("png/Run (7).png", 937));
		animMoverse.add(new ElementoAnimacion("png/Run (8).png", 1000));
		
		return animMoverse;

	}
	public static ArrayList<ElementoAnimacion> CrearAnimGolpear(){
		animGolpear.add(new ElementoAnimacion("png/Melee (1).png", 90));
		animGolpear.add(new ElementoAnimacion("png/Melee (2).png", 180));
		animGolpear.add(new ElementoAnimacion("png/Melee (3).png", 270));
		animGolpear.add(new ElementoAnimacion("png/Melee (4).png", 360));
		animGolpear.add(new ElementoAnimacion("png/Melee (5).png", 450));
		animGolpear.add(new ElementoAnimacion("png/Melee (6).png", 540));
		animGolpear.add(new ElementoAnimacion("png/Melee (7).png", 630));
		animGolpear.add(new ElementoAnimacion("png/Melee (8).png", 720));
		
		return animGolpear;
	}
	public static ArrayList<ElementoAnimacion> CrearAnimGolpeado(){
		animGolpeado.add(new ElementoAnimacion("png/Slide (1).png", 100));
		animGolpeado.add(new ElementoAnimacion("png/Slide (2).png", 200));
		animGolpeado.add(new ElementoAnimacion("png/Slide (3).png", 300));
		animGolpeado.add(new ElementoAnimacion("png/Slide (4).png", 400));
		animGolpeado.add(new ElementoAnimacion("png/Slide (5).png", 500));
		animGolpeado.add(new ElementoAnimacion("png/Slide (6).png", 600));
		animGolpeado.add(new ElementoAnimacion("png/Slide (7).png", 700));
		animGolpeado.add(new ElementoAnimacion("png/Slide (8).png", 800));
		animGolpeado.add(new ElementoAnimacion("png/Slide (9).png", 900));
		animGolpeado.add(new ElementoAnimacion("png/Slide (10).png", 1000));
		
		return animGolpeado;
	}
	public static ArrayList<ElementoAnimacion >CrearAnimEnemMoverse(){
		
		animEnemMoverse.add(new ElementoAnimacion("pngEnem/Run__000.png", 100));
		animEnemMoverse.add(new ElementoAnimacion("pngEnem/Run__001.png", 200));
		animEnemMoverse.add(new ElementoAnimacion("pngEnem/Run__002.png", 300));
		animEnemMoverse.add(new ElementoAnimacion("pngEnem/Run__003.png", 400));
		animEnemMoverse.add(new ElementoAnimacion("pngEnem/Run__004.png", 500));
		animEnemMoverse.add(new ElementoAnimacion("pngEnem/Run__005.png", 600));
		animEnemMoverse.add(new ElementoAnimacion("pngEnem/Run__006.png", 700));
		animEnemMoverse.add(new ElementoAnimacion("pngEnem/Run__007.png", 800));
		animEnemMoverse.add(new ElementoAnimacion("pngEnem/Run__008.png", 900));
		animEnemMoverse.add(new ElementoAnimacion("pngEnem/Run__009.png", 1000));
		
		
		return animEnemMoverse;
	}
	public static ArrayList<ElementoAnimacion>CrearAnimEnemGolpear(){
		animEnemGolpear.add(new ElementoAnimacion("pngEnem/Attack__000.png", 100));
		animEnemGolpear.add(new ElementoAnimacion("pngEnem/Attack__001.png", 200));
		animEnemGolpear.add(new ElementoAnimacion("pngEnem/Attack__002.png", 300));
		animEnemGolpear.add(new ElementoAnimacion("pngEnem/Attack__003.png", 400));
		animEnemGolpear.add(new ElementoAnimacion("pngEnem/Attack__004.png", 500));
		animEnemGolpear.add(new ElementoAnimacion("pngEnem/Attack__005.png", 600));
		animEnemGolpear.add(new ElementoAnimacion("pngEnem/Attack__006.png", 700));
		animEnemGolpear.add(new ElementoAnimacion("pngEnem/Attack__007.png", 800));
		animEnemGolpear.add(new ElementoAnimacion("pngEnem/Attack__008.png", 900));
		animEnemGolpear.add(new ElementoAnimacion("pngEnem/Attack__009.png", 1000));
		return animEnemGolpear;

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
	public static long getTiempoEnemAnimMoverse() {
		return animEnemMoverse.get(animEnemMoverse.size()-1).tiempos;
	}
	public static long getTiempoEnemAnimGolpear() {
		return animEnemGolpear.get(animEnemGolpear.size()-1).tiempos;
	}
}
