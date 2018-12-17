package control;

import java.util.ArrayList;

import personaje.Personaje;

public class ElementoAnimacion {
	private String label;
	private long tiempos;
	static long tiempoAnimParado;
	public  ArrayList<ElementoAnimacion> animSaltando = new ArrayList<ElementoAnimacion>();
	static long tiempoAnimSaltando;
	public  ArrayList<ElementoAnimacion> animMoverse = new ArrayList<ElementoAnimacion>();
	static long tiempoAnimMoverse;
	public  ArrayList<ElementoAnimacion> animGolpear = new ArrayList<ElementoAnimacion>();
	static long tiempoAnimGolpear;
	public  ArrayList<ElementoAnimacion> animGolpeado = new ArrayList<ElementoAnimacion>();
	static long tiempoAnimGolpeadoRobot;
	
	public  ArrayList<ElementoAnimacion> animParado = new ArrayList<ElementoAnimacion>();
	public ArrayList<ElementoAnimacion> getAnimParado() {
		return animParado;
	}

	public void setAnimParado(ArrayList<ElementoAnimacion> animParado) {
		this.animParado = animParado;
	}

	public ArrayList<ElementoAnimacion> getAnimSaltando() {
		return animSaltando;
	}

	public void setAnimSaltando(ArrayList<ElementoAnimacion> animSaltando) {
		this.animSaltando = animSaltando;
	}

	public ArrayList<ElementoAnimacion> getAnimMoverse() {
		return animMoverse;
	}

	public void setAnimMoverse(ArrayList<ElementoAnimacion> animMoverse) {
		this.animMoverse = animMoverse;
	}

	public ArrayList<ElementoAnimacion> getAnimGolpear() {
		return animGolpear;
	}

	public void setAnimGolpear(ArrayList<ElementoAnimacion> animGolpear) {
		this.animGolpear = animGolpear;
	}

	public ArrayList<ElementoAnimacion> getAnimGolpeado() {
		return animGolpeado;
	}

	public void setAnimGolpeado(ArrayList<ElementoAnimacion> animGolpeado) {
		this.animGolpeado = animGolpeado;
	}

	
	
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

	public  ArrayList<ElementoAnimacion> CrearAnimParado(Personaje p) {
		if(p.getTipoPersonaje().equals("robot")) {
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
		}if(p.getTipoPersonaje().equals("ninja")) {
		animParado.add(new ElementoAnimacion("pngEnem/Idle__000.png", 100));
		animParado.add(new ElementoAnimacion("pngEnem/Idle__001.png", 200));
		animParado.add(new ElementoAnimacion("pngEnem/Idle__002.png", 300));
		animParado.add(new ElementoAnimacion("pngEnem/Idle__003.png", 400));
		animParado.add(new ElementoAnimacion("pngEnem/Idle__004.png", 500));
		animParado.add(new ElementoAnimacion("pngEnem/Idle__005.png", 600));
		animParado.add(new ElementoAnimacion("pngEnem/Idle__006.png", 700));
		animParado.add(new ElementoAnimacion("pngEnem/Idle__007.png", 800));
		animParado.add(new ElementoAnimacion("pngEnem/Idle__008.png", 900));
		animParado.add(new ElementoAnimacion("pngEnem/Idle__009.png", 1000));
		return animParado;
		}
		return null;
	}
	
	public  ArrayList<ElementoAnimacion> CrearAnimSaltando(Personaje p) {
		if(p.getTipoPersonaje().equals("robot")) {
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
		if(p.getTipoPersonaje().equals("ninja")) {
			animSaltando.add(new ElementoAnimacion("pngEnem/Jump__000.png", 100));
			animSaltando.add(new ElementoAnimacion("pngEnem/Jump__001.png", 100));
			animSaltando.add(new ElementoAnimacion("pngEnem/Jump__002.png", 100));
			animSaltando.add(new ElementoAnimacion("pngEnem/Jump__003.png", 100));
			animSaltando.add(new ElementoAnimacion("pngEnem/Jump__004.png", 100));
			animSaltando.add(new ElementoAnimacion("pngEnem/Jump__005.png", 100));
			animSaltando.add(new ElementoAnimacion("pngEnem/Jump__006.png", 100));
			animSaltando.add(new ElementoAnimacion("pngEnem/Jump__007.png", 100));
			animSaltando.add(new ElementoAnimacion("pngEnem/Jump__008.png", 100));
			animSaltando.add(new ElementoAnimacion("pngEnem/Jump__009.png", 100));
			return animSaltando;
		}
		return null;
		
	}
	public  ArrayList<ElementoAnimacion> CrearAnimMoverse(Personaje p){
		if(p.getTipoPersonaje().equals("robot")) {
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
		if(p.getTipoPersonaje().equals("ninja")) {
			animMoverse.add(new ElementoAnimacion("pngEnem/Run__000.png", 55));
			animMoverse.add(new ElementoAnimacion("pngEnem/Run__001.png", 110));
			animMoverse.add(new ElementoAnimacion("pngEnem/Run__002.png", 165));
			animMoverse.add(new ElementoAnimacion("pngEnem/Run__003.png", 220));
			animMoverse.add(new ElementoAnimacion("pngEnem/Run__004.png", 275));
			animMoverse.add(new ElementoAnimacion("pngEnem/Run__005.png", 330));
			animMoverse.add(new ElementoAnimacion("pngEnem/Run__006.png", 385));
			animMoverse.add(new ElementoAnimacion("pngEnem/Run__007.png", 440));
			animMoverse.add(new ElementoAnimacion("pngEnem/Run__008.png",495));
			
			animMoverse.add(new ElementoAnimacion("pngEnem/Run__000.png", 550));
			animMoverse.add(new ElementoAnimacion("pngEnem/Run__001.png", 605));
			animMoverse.add(new ElementoAnimacion("pngEnem/Run__002.png", 660));
			animMoverse.add(new ElementoAnimacion("pngEnem/Run__003.png",715));
			animMoverse.add(new ElementoAnimacion("pngEnem/Run__004.png", 770));
			animMoverse.add(new ElementoAnimacion("pngEnem/Run__005.png",825));
			animMoverse.add(new ElementoAnimacion("pngEnem/Run__006.png", 880));
			animMoverse.add(new ElementoAnimacion("pngEnem/Run__007.png", 935));
			animMoverse.add(new ElementoAnimacion("pngEnem/Run__008.png", 990));
			animMoverse.add(new ElementoAnimacion("pngEnem/Run__009.png", 1000));
			return animMoverse;
		}
		return null;
	}
	public  ArrayList<ElementoAnimacion> CrearAnimGolpear(Personaje p){
		if(p.getTipoPersonaje().equals("robot")) {
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
		if(p.getTipoPersonaje().equals("ninja")) {
			animGolpear.add(new ElementoAnimacion("pngEnem/Attack__000.png", 100));
			animGolpear.add(new ElementoAnimacion("pngEnem/Attack__001.png", 200));
			animGolpear.add(new ElementoAnimacion("pngEnem/Attack__002.png", 300));
			animGolpear.add(new ElementoAnimacion("pngEnem/Attack__003.png", 400));
			animGolpear.add(new ElementoAnimacion("pngEnem/Attack__004.png", 500));
			animGolpear.add(new ElementoAnimacion("pngEnem/Attack__005.png", 600));
			animGolpear.add(new ElementoAnimacion("pngEnem/Attack__006.png", 700));
			animGolpear.add(new ElementoAnimacion("pngEnem/Attack__007.png", 800));
			animGolpear.add(new ElementoAnimacion("pngEnem/Attack__008.png", 900));
			animGolpear.add(new ElementoAnimacion("pngEnem/Attack__009.png", 1000));
			return animGolpear;
		}
		return null;
	}
	public  ArrayList<ElementoAnimacion> CrearAnimGolpeado(Personaje p){
		if(p.getTipoPersonaje().equals("robot")) {
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
		if(p.getTipoPersonaje().equals("ninja")) {
			animGolpeado.add(new ElementoAnimacion("pngEnem/Slide__000.png", 100));
			animGolpeado.add(new ElementoAnimacion("pngEnem/Slide__001.png", 200));
			animGolpeado.add(new ElementoAnimacion("pngEnem/Slide__002.png", 300));
			animGolpeado.add(new ElementoAnimacion("pngEnem/Slide__003.png", 400));
			animGolpeado.add(new ElementoAnimacion("pngEnem/Slide__004.png", 500));
			animGolpeado.add(new ElementoAnimacion("pngEnem/Slide__005.png", 600));
			animGolpeado.add(new ElementoAnimacion("pngEnem/Slide__006.png", 700));
			animGolpeado.add(new ElementoAnimacion("pngEnem/Slide__007.png", 800));
			animGolpeado.add(new ElementoAnimacion("pngEnem/Slide__008.png", 900));
			animGolpeado.add(new ElementoAnimacion("pngEnem/Slide__009.png", 1000));
			return animGolpeado;
		}
		return null;
	}
	
	
	public  long getTiempoAnimParadt() {
		return animParado.get(animParado.size() -1).tiempos;
	}
	public  long getTiempoAnimSaltando() {
		return animParado.get(animSaltando.size() -1).tiempos;
	}
	public  long getTiempoAnimMoverse() {
		return animMoverse.get(animMoverse.size() -1).tiempos;
	}
	public  long getTiempoAnimGolpear() {
		return animGolpear.get(animGolpear.size() -1).tiempos;
	}

	public  long getTiempoAnimGolpeado() {
		return tiempoAnimGolpeadoRobot;
	}
}
