package control;

import java.util.ArrayList;

public class ElementoAnimacion {
	private String label;
	private long tiempos;
	
	
	public static ArrayList<ElementoAnimacion> animParadoRobot = new ArrayList<ElementoAnimacion>();
	static long tiempoAnimParadoRobot;
	public static ArrayList<ElementoAnimacion> animSaltandoRobot = new ArrayList<ElementoAnimacion>();
	static long tiempoAnimSaltandoRobot;
	public static ArrayList<ElementoAnimacion> animMoverseRobot = new ArrayList<ElementoAnimacion>();
	static long tiempoAnimMoverseRobot;
	public static ArrayList<ElementoAnimacion> animGolpearRobot = new ArrayList<ElementoAnimacion>();
	static long tiempoAnimGolpearRobot;
	public static ArrayList<ElementoAnimacion> animGolpeadoRobot = new ArrayList<ElementoAnimacion>();
	static long tiempoAnimGolpeadoRobot;
	public static ArrayList<ElementoAnimacion> animMoverseNinja= new ArrayList<ElementoAnimacion>();
	static long tiempoAnimMoverseNinja;
	public static ArrayList<ElementoAnimacion> animGolpearNinja= new ArrayList<ElementoAnimacion>();
	static long tiempoAnimGolpearNinja;
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

	public static ArrayList<ElementoAnimacion> CrearAnimParadoRobot() {
		animParadoRobot.add(new ElementoAnimacion("png/Idle (1).png", 100));
		animParadoRobot.add(new ElementoAnimacion("png/Idle (2).png", 200));
		animParadoRobot.add(new ElementoAnimacion("png/Idle (3).png", 300));
		animParadoRobot.add(new ElementoAnimacion("png/Idle (4).png", 400));
		animParadoRobot.add(new ElementoAnimacion("png/Idle (5).png", 500));
		animParadoRobot.add(new ElementoAnimacion("png/Idle (6).png", 600));
		animParadoRobot.add(new ElementoAnimacion("png/Idle (7).png", 700));
		animParadoRobot.add(new ElementoAnimacion("png/Idle (8).png", 800));
		animParadoRobot.add(new ElementoAnimacion("png/Idle (9).png", 900));
		animParadoRobot.add(new ElementoAnimacion("png/Idle (10).png", 1000));

		return animParadoRobot;
	}
	
	public static ArrayList<ElementoAnimacion> CrearAnimSaltandoRobot() {
		animSaltandoRobot.add(new ElementoAnimacion("png/Jump (1).png", 70));
		animSaltandoRobot.add(new ElementoAnimacion("png/Jump (2).png", 140));
		animSaltandoRobot.add(new ElementoAnimacion("png/Jump (3).png", 210));
		animSaltandoRobot.add(new ElementoAnimacion("png/Jump (4).png", 280));
		animSaltandoRobot.add(new ElementoAnimacion("png/Jump (5).png", 350));
		animSaltandoRobot.add(new ElementoAnimacion("png/Jump (6).png", 420));
		animSaltandoRobot.add(new ElementoAnimacion("png/Jump (7).png", 490));
		animSaltandoRobot.add(new ElementoAnimacion("png/Jump (8).png", 560));
		animSaltandoRobot.add(new ElementoAnimacion("png/Jump (9).png", 630));
		animSaltandoRobot.add(new ElementoAnimacion("png/Jump (10).png", 700));

		return animSaltandoRobot;
	}
	public static ArrayList<ElementoAnimacion> CrearAnimMoverseRobot(){
		animMoverseRobot.add(new ElementoAnimacion("png/Run (1).png", 62));
		animMoverseRobot.add(new ElementoAnimacion("png/Run (2).png", 125));
		animMoverseRobot.add(new ElementoAnimacion("png/Run (3).png", 187));
		animMoverseRobot.add(new ElementoAnimacion("png/Run (4).png", 250));
		animMoverseRobot.add(new ElementoAnimacion("png/Run (5).png", 312));
		animMoverseRobot.add(new ElementoAnimacion("png/Run (6).png", 375));
		animMoverseRobot.add(new ElementoAnimacion("png/Run (7).png", 437));
		animMoverseRobot.add(new ElementoAnimacion("png/Run (8).png", 500));
		animMoverseRobot.add(new ElementoAnimacion("png/Run (1).png", 562));
		animMoverseRobot.add(new ElementoAnimacion("png/Run (2).png", 625));
		animMoverseRobot.add(new ElementoAnimacion("png/Run (3).png", 687));
		animMoverseRobot.add(new ElementoAnimacion("png/Run (4).png", 750));
		animMoverseRobot.add(new ElementoAnimacion("png/Run (5).png", 812));
		animMoverseRobot.add(new ElementoAnimacion("png/Run (6).png", 875));
		animMoverseRobot.add(new ElementoAnimacion("png/Run (7).png", 937));
		animMoverseRobot.add(new ElementoAnimacion("png/Run (8).png", 1000));
		
		return animMoverseRobot;

	}
	public static ArrayList<ElementoAnimacion> CrearAnimGolpearRobot(){
		animGolpearRobot.add(new ElementoAnimacion("png/Melee (1).png", 90));
		animGolpearRobot.add(new ElementoAnimacion("png/Melee (2).png", 180));
		animGolpearRobot.add(new ElementoAnimacion("png/Melee (3).png", 270));
		animGolpearRobot.add(new ElementoAnimacion("png/Melee (4).png", 360));
		animGolpearRobot.add(new ElementoAnimacion("png/Melee (5).png", 450));
		animGolpearRobot.add(new ElementoAnimacion("png/Melee (6).png", 540));
		animGolpearRobot.add(new ElementoAnimacion("png/Melee (7).png", 630));
		animGolpearRobot.add(new ElementoAnimacion("png/Melee (8).png", 720));
		
		return animGolpearRobot;
	}
	public static ArrayList<ElementoAnimacion> CrearAnimGolpeadoRobot(){
		animGolpeadoRobot.add(new ElementoAnimacion("png/Slide (1).png", 100));
		animGolpeadoRobot.add(new ElementoAnimacion("png/Slide (2).png", 200));
		animGolpeadoRobot.add(new ElementoAnimacion("png/Slide (3).png", 300));
		animGolpeadoRobot.add(new ElementoAnimacion("png/Slide (4).png", 400));
		animGolpeadoRobot.add(new ElementoAnimacion("png/Slide (5).png", 500));
		animGolpeadoRobot.add(new ElementoAnimacion("png/Slide (6).png", 600));
		animGolpeadoRobot.add(new ElementoAnimacion("png/Slide (7).png", 700));
		animGolpeadoRobot.add(new ElementoAnimacion("png/Slide (8).png", 800));
		animGolpeadoRobot.add(new ElementoAnimacion("png/Slide (9).png", 900));
		animGolpeadoRobot.add(new ElementoAnimacion("png/Slide (10).png", 1000));
		
		return animGolpeadoRobot;
	}
	public static ArrayList<ElementoAnimacion> CrearAnimMoverseNinja(){
		
		animMoverseNinja.add(new ElementoAnimacion("pngEnem/Run__000.png", 100));
		animMoverseNinja.add(new ElementoAnimacion("pngEnem/Run__001.png", 200));
		animMoverseNinja.add(new ElementoAnimacion("pngEnem/Run__002.png", 300));
		animMoverseNinja.add(new ElementoAnimacion("pngEnem/Run__003.png", 400));
		animMoverseNinja.add(new ElementoAnimacion("pngEnem/Run__004.png", 500));
		animMoverseNinja.add(new ElementoAnimacion("pngEnem/Run__005.png", 600));
		animMoverseNinja.add(new ElementoAnimacion("pngEnem/Run__006.png", 700));
		animMoverseNinja.add(new ElementoAnimacion("pngEnem/Run__007.png", 800));
		animMoverseNinja.add(new ElementoAnimacion("pngEnem/Run__008.png", 900));
		animMoverseNinja.add(new ElementoAnimacion("pngEnem/Run__009.png", 1000));
		
		return animMoverseNinja;
	}
	public static ArrayList<ElementoAnimacion> CrearAnimGolpearNinja(){
		animGolpearNinja.add(new ElementoAnimacion("pngEnem/Attack__000.png", 100));
		animGolpearNinja.add(new ElementoAnimacion("pngEnem/Attack__001.png", 200));
		animGolpearNinja.add(new ElementoAnimacion("pngEnem/Attack__002.png", 300));
		animGolpearNinja.add(new ElementoAnimacion("pngEnem/Attack__003.png", 400));
		animGolpearNinja.add(new ElementoAnimacion("pngEnem/Attack__004.png", 500));
		animGolpearNinja.add(new ElementoAnimacion("pngEnem/Attack__005.png", 600));
		animGolpearNinja.add(new ElementoAnimacion("pngEnem/Attack__006.png", 700));
		animGolpearNinja.add(new ElementoAnimacion("pngEnem/Attack__007.png", 800));
		animGolpearNinja.add(new ElementoAnimacion("pngEnem/Attack__008.png", 900));
		animGolpearNinja.add(new ElementoAnimacion("pngEnem/Attack__009.png", 1000));
		return animGolpearNinja;

	}
	public static long getTiempoAnimParadoRobot() {
		return animParadoRobot.get(animParadoRobot.size() -1).tiempos;
	}
	public static long getTiempoAnimSaltandoRobot() {
		return animParadoRobot.get(animSaltandoRobot.size() -1).tiempos;
	}
	public static long getTiempoAnimMoverseRobot() {
		return animMoverseRobot.get(animMoverseRobot.size() -1).tiempos;
	}
	public static long getTiempoAnimGolpearRobot() {
		return animGolpearRobot.get(animGolpearRobot.size() -1).tiempos;
	}
	public static long getTiempoAnimMoverseNinja() {
		return animMoverseNinja.get(animMoverseNinja.size()-1).tiempos;
	}
	public static long getTiempoAnimGolpearNinja() {
		return animGolpearNinja.get(animGolpearNinja.size()-1).tiempos;
	}

	public static long getTiempoAnimGolpeadoRobot() {
		return tiempoAnimGolpeadoRobot;
	}
}
