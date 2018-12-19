package control;

import java.util.ArrayList;

import personaje.Personaje;

public class ElementoAnimacion {
	private String label;
	private long tiempos;
	
	public  ArrayList<ElementoAnimacion> animSaltandoP1 = new ArrayList<ElementoAnimacion>();
	public  ArrayList<ElementoAnimacion> animSaltandoP2 = new ArrayList<ElementoAnimacion>();
	long tiempoAnimSaltando;
	public  ArrayList<ElementoAnimacion> animMoverseP1 = new ArrayList<ElementoAnimacion>();
	public  ArrayList<ElementoAnimacion> animMoverseP2 = new ArrayList<ElementoAnimacion>();
	long tiempoAnimMoverse;
	public  ArrayList<ElementoAnimacion> animGolpearP1 = new ArrayList<ElementoAnimacion>();
	public  ArrayList<ElementoAnimacion> animGolpearP2 = new ArrayList<ElementoAnimacion>();
	long tiempoAnimGolpear;
	public  ArrayList<ElementoAnimacion> animGolpeadoP1 = new ArrayList<ElementoAnimacion>();
	public  ArrayList<ElementoAnimacion> animGolpeadoP2 = new ArrayList<ElementoAnimacion>();
	long tiempoAnimGolpeado;
	public  ArrayList<ElementoAnimacion> animParadoP1 = new ArrayList<ElementoAnimacion>();
	public  ArrayList<ElementoAnimacion> animParadoP2 = new ArrayList<ElementoAnimacion>();
	long tiempoAnimParado;
	
	
	
	
	public ArrayList<ElementoAnimacion> getAnimSaltandoP1() {
		return animSaltandoP1;
	}

	public void setAnimSaltandoP1(ArrayList<ElementoAnimacion> animSaltandoP1) {
		this.animSaltandoP1 = animSaltandoP1;
	}

	public ArrayList<ElementoAnimacion> getAnimSaltandoP2() {
		return animSaltandoP2;
	}

	public void setAnimSaltandoP2(ArrayList<ElementoAnimacion> animSaltandoP2) {
		this.animSaltandoP2 = animSaltandoP2;
	}

	public ArrayList<ElementoAnimacion> getAnimMoverseP1() {
		return animMoverseP1;
	}

	public void setAnimMoverseP1(ArrayList<ElementoAnimacion> animMoverseP1) {
		this.animMoverseP1 = animMoverseP1;
	}

	public ArrayList<ElementoAnimacion> getAnimMoverseP2() {
		return animMoverseP2;
	}

	public void setAnimMoverseP2(ArrayList<ElementoAnimacion> animMoverseP2) {
		this.animMoverseP2 = animMoverseP2;
	}

	public ArrayList<ElementoAnimacion> getAnimGolpearP1() {
		return animGolpearP1;
	}

	public void setAnimGolpearP1(ArrayList<ElementoAnimacion> animGolpearP1) {
		this.animGolpearP1 = animGolpearP1;
	}

	public ArrayList<ElementoAnimacion> getAnimGolpearP2() {
		return animGolpearP2;
	}

	public void setAnimGolpearP2(ArrayList<ElementoAnimacion> animGolpearP2) {
		this.animGolpearP2 = animGolpearP2;
	}

	public ArrayList<ElementoAnimacion> getAnimGolpeadoP1() {
		return animGolpeadoP1;
	}

	public void setAnimGolpeadoP1(ArrayList<ElementoAnimacion> animGolpeadoP1) {
		this.animGolpeadoP1 = animGolpeadoP1;
	}

	public ArrayList<ElementoAnimacion> getAnimGolpeadoP2() {
		return animGolpeadoP2;
	}

	public void setAnimGolpeadoP2(ArrayList<ElementoAnimacion> animGolpeadoP2) {
		this.animGolpeadoP2 = animGolpeadoP2;
	}

	public ArrayList<ElementoAnimacion> getAnimParadoP1() {
		return animParadoP1;
	}

	public void setAnimParadoP1(ArrayList<ElementoAnimacion> animParadoP1) {
		this.animParadoP1 = animParadoP1;
	}

	public ArrayList<ElementoAnimacion> getAnimParadoP2() {
		return animParadoP2;
	}

	public void setAnimParadoP2(ArrayList<ElementoAnimacion> animParadoP2) {
		this.animParadoP2 = animParadoP2;
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

	public  ArrayList<ElementoAnimacion> CrearAnimParado(Personaje p,int personaje) {
		switch(personaje) {
		case 0:
			if(p.getTipoPersonaje().equals("robot")) {
				animParadoP1.add(new ElementoAnimacion("png/Idle (1).png", 100));
				animParadoP1.add(new ElementoAnimacion("png/Idle (2).png", 200));
				animParadoP1.add(new ElementoAnimacion("png/Idle (3).png", 300));
				animParadoP1.add(new ElementoAnimacion("png/Idle (4).png", 400));
				animParadoP1.add(new ElementoAnimacion("png/Idle (5).png", 500));
				animParadoP1.add(new ElementoAnimacion("png/Idle (6).png", 600));
				animParadoP1.add(new ElementoAnimacion("png/Idle (7).png", 700));
				animParadoP1.add(new ElementoAnimacion("png/Idle (8).png", 800));
				animParadoP1.add(new ElementoAnimacion("png/Idle (9).png", 900));
				animParadoP1.add(new ElementoAnimacion("png/Idle (10).png", 1000));

					return animParadoP1;
			}if(p.getTipoPersonaje().equals("ninja")) {
				animParadoP1.add(new ElementoAnimacion("pngEnem/Idle__000.png", 100));
				animParadoP1.add(new ElementoAnimacion("pngEnem/Idle__001.png", 200));
				animParadoP1.add(new ElementoAnimacion("pngEnem/Idle__002.png", 300));
				animParadoP1.add(new ElementoAnimacion("pngEnem/Idle__003.png", 400));
				animParadoP1.add(new ElementoAnimacion("pngEnem/Idle__004.png", 500));
				animParadoP1.add(new ElementoAnimacion("pngEnem/Idle__005.png", 600));
				animParadoP1.add(new ElementoAnimacion("pngEnem/Idle__006.png", 700));
				animParadoP1.add(new ElementoAnimacion("pngEnem/Idle__007.png", 800));
				animParadoP1.add(new ElementoAnimacion("pngEnem/Idle__008.png", 900));
				animParadoP1.add(new ElementoAnimacion("pngEnem/Idle__009.png", 1000));
					return animParadoP1;
			}
		case 1:
			if(p.getTipoPersonaje().equals("robot")) {
				animParadoP2.add(new ElementoAnimacion("png/Idle (1).png", 100));
				animParadoP2.add(new ElementoAnimacion("png/Idle (2).png", 200));
				animParadoP2.add(new ElementoAnimacion("png/Idle (3).png", 300));
				animParadoP2.add(new ElementoAnimacion("png/Idle (4).png", 400));
				animParadoP2.add(new ElementoAnimacion("png/Idle (5).png", 500));
				animParadoP2.add(new ElementoAnimacion("png/Idle (6).png", 600));
				animParadoP2.add(new ElementoAnimacion("png/Idle (7).png", 700));
				animParadoP2.add(new ElementoAnimacion("png/Idle (8).png", 800));
				animParadoP2.add(new ElementoAnimacion("png/Idle (9).png", 900));
				animParadoP2.add(new ElementoAnimacion("png/Idle (10).png", 1000));

					return animParadoP2;
			}if(p.getTipoPersonaje().equals("ninja")) {
				animParadoP2.add(new ElementoAnimacion("pngEnem/Idle__000.png", 100));
				animParadoP2.add(new ElementoAnimacion("pngEnem/Idle__001.png", 200));
				animParadoP2.add(new ElementoAnimacion("pngEnem/Idle__002.png", 300));
				animParadoP2.add(new ElementoAnimacion("pngEnem/Idle__003.png", 400));
				animParadoP2.add(new ElementoAnimacion("pngEnem/Idle__004.png", 500));
				animParadoP2.add(new ElementoAnimacion("pngEnem/Idle__005.png", 600));
				animParadoP2.add(new ElementoAnimacion("pngEnem/Idle__006.png", 700));
				animParadoP2.add(new ElementoAnimacion("pngEnem/Idle__007.png", 800));
				animParadoP2.add(new ElementoAnimacion("pngEnem/Idle__008.png", 900));
				animParadoP2.add(new ElementoAnimacion("pngEnem/Idle__009.png", 1000));
					return animParadoP2;
			}
		default:
					return null;
		}
	}
	
	public  ArrayList<ElementoAnimacion> CrearAnimSaltando(Personaje p,int personaje) {
		switch(personaje) {
		case 0:
			if(p.getTipoPersonaje().equals("robot")) {
				animSaltandoP1.add(new ElementoAnimacion("png/Jump (1).png", 70));
				animSaltandoP1.add(new ElementoAnimacion("png/Jump (2).png", 140));
				animSaltandoP1.add(new ElementoAnimacion("png/Jump (3).png", 210));
				animSaltandoP1.add(new ElementoAnimacion("png/Jump (4).png", 280));
				animSaltandoP1.add(new ElementoAnimacion("png/Jump (5).png", 350));
				animSaltandoP1.add(new ElementoAnimacion("png/Jump (6).png", 420));
				animSaltandoP1.add(new ElementoAnimacion("png/Jump (7).png", 490));
				animSaltandoP1.add(new ElementoAnimacion("png/Jump (8).png", 560));
				animSaltandoP1.add(new ElementoAnimacion("png/Jump (9).png", 630));
				animSaltandoP1.add(new ElementoAnimacion("png/Jump (10).png", 700));

					return animSaltandoP1;
			}if(p.getTipoPersonaje().equals("ninja")) {
				animSaltandoP1.add(new ElementoAnimacion("pngEnem/Jump__000.png", 100));
				animSaltandoP1.add(new ElementoAnimacion("pngEnem/Jump__001.png", 200));
				animSaltandoP1.add(new ElementoAnimacion("pngEnem/Jump__002.png", 300));
				animSaltandoP1.add(new ElementoAnimacion("pngEnem/Jump__003.png", 400));
				animSaltandoP1.add(new ElementoAnimacion("pngEnem/Jump__004.png", 500));
				animSaltandoP1.add(new ElementoAnimacion("pngEnem/Jump__005.png", 600));
				animSaltandoP1.add(new ElementoAnimacion("pngEnem/Jump__006.png", 700));
				animSaltandoP1.add(new ElementoAnimacion("pngEnem/Jump__007.png", 800));
				animSaltandoP1.add(new ElementoAnimacion("pngEnem/Jump__008.png", 900));
				animSaltandoP1.add(new ElementoAnimacion("pngEnem/Jump__009.png", 1000));
					return animSaltandoP1;
			}
		case 1:
			if(p.getTipoPersonaje().equals("robot")) {
				animSaltandoP2.add(new ElementoAnimacion("png/Jump (1).png", 70));
				animSaltandoP2.add(new ElementoAnimacion("png/Jump (2).png", 140));
				animSaltandoP2.add(new ElementoAnimacion("png/Jump (3).png", 210));
				animSaltandoP2.add(new ElementoAnimacion("png/Jump (4).png", 280));
				animSaltandoP2.add(new ElementoAnimacion("png/Jump (5).png", 350));
				animSaltandoP2.add(new ElementoAnimacion("png/Jump (6).png", 420));
				animSaltandoP2.add(new ElementoAnimacion("png/Jump (7).png", 490));
				animSaltandoP2.add(new ElementoAnimacion("png/Jump (8).png", 560));
				animSaltandoP2.add(new ElementoAnimacion("png/Jump (9).png", 630));
				animSaltandoP2.add(new ElementoAnimacion("png/Jump (10).png", 700));


					return animSaltandoP2;
			}if(p.getTipoPersonaje().equals("ninja")) {
				animSaltandoP2.add(new ElementoAnimacion("pngEnem/Jump__000.png", 100));
				animSaltandoP2.add(new ElementoAnimacion("pngEnem/Jump__001.png", 200));
				animSaltandoP2.add(new ElementoAnimacion("pngEnem/Jump__002.png", 300));
				animSaltandoP2.add(new ElementoAnimacion("pngEnem/Jump__003.png", 400));
				animSaltandoP2.add(new ElementoAnimacion("pngEnem/Jump__004.png", 500));
				animSaltandoP2.add(new ElementoAnimacion("pngEnem/Jump__005.png", 600));
				animSaltandoP2.add(new ElementoAnimacion("pngEnem/Jump__006.png", 700));
				animSaltandoP2.add(new ElementoAnimacion("pngEnem/Jump__007.png", 800));
				animSaltandoP2.add(new ElementoAnimacion("pngEnem/Jump__008.png", 900));
				animSaltandoP2.add(new ElementoAnimacion("pngEnem/Jump__009.png", 1000));
					return animSaltandoP2;
			}
		default:
					return null;
		}
		
		

		
		
	}
	public  ArrayList<ElementoAnimacion> CrearAnimMoverse(Personaje p,int personaje){
		switch(personaje) {
		case 0:
			if(p.getTipoPersonaje().equals("robot")) {
				animMoverseP1.add(new ElementoAnimacion("png/Run (1).png", 62));
				animMoverseP1.add(new ElementoAnimacion("png/Run (2).png", 125));
				animMoverseP1.add(new ElementoAnimacion("png/Run (3).png", 187));
				animMoverseP1.add(new ElementoAnimacion("png/Run (4).png", 250));
				animMoverseP1.add(new ElementoAnimacion("png/Run (5).png", 312));
				animMoverseP1.add(new ElementoAnimacion("png/Run (6).png", 375));
				animMoverseP1.add(new ElementoAnimacion("png/Run (7).png", 437));
				animMoverseP1.add(new ElementoAnimacion("png/Run (8).png", 500));
				animMoverseP1.add(new ElementoAnimacion("png/Run (1).png", 562));
				animMoverseP1.add(new ElementoAnimacion("png/Run (2).png", 625));
				animMoverseP1.add(new ElementoAnimacion("png/Run (3).png", 687));
				animMoverseP1.add(new ElementoAnimacion("png/Run (4).png", 750));
				animMoverseP1.add(new ElementoAnimacion("png/Run (5).png", 812));
				animMoverseP1.add(new ElementoAnimacion("png/Run (6).png", 875));
				animMoverseP1.add(new ElementoAnimacion("png/Run (7).png", 937));
				animMoverseP1.add(new ElementoAnimacion("png/Run (8).png", 1000));
				

					return animMoverseP1;
			}if(p.getTipoPersonaje().equals("ninja")) {
				animMoverseP1.add(new ElementoAnimacion("pngEnem/Run__000.png", 55));
				animMoverseP1.add(new ElementoAnimacion("pngEnem/Run__001.png", 110));
				animMoverseP1.add(new ElementoAnimacion("pngEnem/Run__002.png", 165));
				animMoverseP1.add(new ElementoAnimacion("pngEnem/Run__003.png", 220));
				animMoverseP1.add(new ElementoAnimacion("pngEnem/Run__004.png", 275));
				animMoverseP1.add(new ElementoAnimacion("pngEnem/Run__005.png", 330));
				animMoverseP1.add(new ElementoAnimacion("pngEnem/Run__006.png", 385));
				animMoverseP1.add(new ElementoAnimacion("pngEnem/Run__007.png", 440));
				animMoverseP1.add(new ElementoAnimacion("pngEnem/Run__008.png",495));
				
				animMoverseP1.add(new ElementoAnimacion("pngEnem/Run__000.png", 550));
				animMoverseP1.add(new ElementoAnimacion("pngEnem/Run__001.png", 605));
				animMoverseP1.add(new ElementoAnimacion("pngEnem/Run__002.png", 660));
				animMoverseP1.add(new ElementoAnimacion("pngEnem/Run__003.png",715));
				animMoverseP1.add(new ElementoAnimacion("pngEnem/Run__004.png", 770));
				animMoverseP1.add(new ElementoAnimacion("pngEnem/Run__005.png",825));
				animMoverseP1.add(new ElementoAnimacion("pngEnem/Run__006.png", 880));
				animMoverseP1.add(new ElementoAnimacion("pngEnem/Run__007.png", 935));
				animMoverseP1.add(new ElementoAnimacion("pngEnem/Run__008.png", 990));
				animMoverseP1.add(new ElementoAnimacion("pngEnem/Run__009.png", 1000));
					return animMoverseP1;
			}
		case 1:
			if(p.getTipoPersonaje().equals("robot")) {
				animMoverseP2.add(new ElementoAnimacion("png/Run (1).png", 62));
				animMoverseP2.add(new ElementoAnimacion("png/Run (2).png", 125));
				animMoverseP2.add(new ElementoAnimacion("png/Run (3).png", 187));
				animMoverseP2.add(new ElementoAnimacion("png/Run (4).png", 250));
				animMoverseP2.add(new ElementoAnimacion("png/Run (5).png", 312));
				animMoverseP2.add(new ElementoAnimacion("png/Run (6).png", 375));
				animMoverseP2.add(new ElementoAnimacion("png/Run (7).png", 437));
				animMoverseP2.add(new ElementoAnimacion("png/Run (8).png", 500));
				animMoverseP2.add(new ElementoAnimacion("png/Run (1).png", 562));
				animMoverseP2.add(new ElementoAnimacion("png/Run (2).png", 625));
				animMoverseP2.add(new ElementoAnimacion("png/Run (3).png", 687));
				animMoverseP2.add(new ElementoAnimacion("png/Run (4).png", 750));
				animMoverseP2.add(new ElementoAnimacion("png/Run (5).png", 812));
				animMoverseP2.add(new ElementoAnimacion("png/Run (6).png", 875));
				animMoverseP2.add(new ElementoAnimacion("png/Run (7).png", 937));
				animMoverseP2.add(new ElementoAnimacion("png/Run (8).png", 1000));


					return animMoverseP2;
			}if(p.getTipoPersonaje().equals("ninja")) {
				animMoverseP2.add(new ElementoAnimacion("pngEnem/Run__000.png", 55));
				animMoverseP2.add(new ElementoAnimacion("pngEnem/Run__001.png", 110));
				animMoverseP2.add(new ElementoAnimacion("pngEnem/Run__002.png", 165));
				animMoverseP2.add(new ElementoAnimacion("pngEnem/Run__003.png", 220));
				animMoverseP2.add(new ElementoAnimacion("pngEnem/Run__004.png", 275));
				animMoverseP2.add(new ElementoAnimacion("pngEnem/Run__005.png", 330));
				animMoverseP2.add(new ElementoAnimacion("pngEnem/Run__006.png", 385));
				animMoverseP2.add(new ElementoAnimacion("pngEnem/Run__007.png", 440));
				animMoverseP2.add(new ElementoAnimacion("pngEnem/Run__008.png",495));
				
				animMoverseP2.add(new ElementoAnimacion("pngEnem/Run__000.png", 550));
				animMoverseP2.add(new ElementoAnimacion("pngEnem/Run__001.png", 605));
				animMoverseP2.add(new ElementoAnimacion("pngEnem/Run__002.png", 660));
				animMoverseP2.add(new ElementoAnimacion("pngEnem/Run__003.png",715));
				animMoverseP2.add(new ElementoAnimacion("pngEnem/Run__004.png", 770));
				animMoverseP2.add(new ElementoAnimacion("pngEnem/Run__005.png",825));
				animMoverseP2.add(new ElementoAnimacion("pngEnem/Run__006.png", 880));
				animMoverseP2.add(new ElementoAnimacion("pngEnem/Run__007.png", 935));
				animMoverseP2.add(new ElementoAnimacion("pngEnem/Run__008.png", 990));
				animMoverseP2.add(new ElementoAnimacion("pngEnem/Run__009.png", 1000));
					return animMoverseP2;
			}
		default:
					return null;
		
		}
	}
	public  ArrayList<ElementoAnimacion> CrearAnimGolpear(Personaje p,int personaje){
		switch(personaje) {
		case 0:
			if(p.getTipoPersonaje().equals("robot")) {
				animGolpearP1.add(new ElementoAnimacion("png/Melee (1).png", 90));
				animGolpearP1.add(new ElementoAnimacion("png/Melee (2).png", 180));
				animGolpearP1.add(new ElementoAnimacion("png/Melee (3).png", 270));
				animGolpearP1.add(new ElementoAnimacion("png/Melee (4).png", 360));
				animGolpearP1.add(new ElementoAnimacion("png/Melee (5).png", 450));
				animGolpearP1.add(new ElementoAnimacion("png/Melee (6).png", 540));
				animGolpearP1.add(new ElementoAnimacion("png/Melee (7).png", 630));
				animGolpearP1.add(new ElementoAnimacion("png/Melee (8).png", 720));

					return animGolpearP1;
			}if(p.getTipoPersonaje().equals("ninja")) {
				animGolpearP1.add(new ElementoAnimacion("pngEnem/Attack__000.png", 100));
				animGolpearP1.add(new ElementoAnimacion("pngEnem/Attack__001.png", 200));
				animGolpearP1.add(new ElementoAnimacion("pngEnem/Attack__002.png", 300));
				animGolpearP1.add(new ElementoAnimacion("pngEnem/Attack__003.png", 400));
				animGolpearP1.add(new ElementoAnimacion("pngEnem/Attack__004.png", 500));
				animGolpearP1.add(new ElementoAnimacion("pngEnem/Attack__005.png", 600));
				animGolpearP1.add(new ElementoAnimacion("pngEnem/Attack__006.png", 700));
				animGolpearP1.add(new ElementoAnimacion("pngEnem/Attack__007.png", 800));
				animGolpearP1.add(new ElementoAnimacion("pngEnem/Attack__008.png", 900));
				animGolpearP1.add(new ElementoAnimacion("pngEnem/Attack__009.png", 1000));
					return animGolpearP1;
			}
		case 1:
			if(p.getTipoPersonaje().equals("robot")) {
				animGolpearP2.add(new ElementoAnimacion("png/Melee (1).png", 90));
				animGolpearP2.add(new ElementoAnimacion("png/Melee (2).png", 180));
				animGolpearP2.add(new ElementoAnimacion("png/Melee (3).png", 270));
				animGolpearP2.add(new ElementoAnimacion("png/Melee (4).png", 360));
				animGolpearP2.add(new ElementoAnimacion("png/Melee (5).png", 450));
				animGolpearP2.add(new ElementoAnimacion("png/Melee (6).png", 540));
				animGolpearP2.add(new ElementoAnimacion("png/Melee (7).png", 630));
				animGolpearP2.add(new ElementoAnimacion("png/Melee (8).png", 720));


					return animGolpearP2;
			}if(p.getTipoPersonaje().equals("ninja")) {
				animGolpearP2.add(new ElementoAnimacion("pngEnem/Attack__000.png", 100));
				animGolpearP2.add(new ElementoAnimacion("pngEnem/Attack__001.png", 200));
				animGolpearP2.add(new ElementoAnimacion("pngEnem/Attack__002.png", 300));
				animGolpearP2.add(new ElementoAnimacion("pngEnem/Attack__003.png", 400));
				animGolpearP2.add(new ElementoAnimacion("pngEnem/Attack__004.png", 500));
				animGolpearP2.add(new ElementoAnimacion("pngEnem/Attack__005.png", 600));
				animGolpearP2.add(new ElementoAnimacion("pngEnem/Attack__006.png", 700));
				animGolpearP2.add(new ElementoAnimacion("pngEnem/Attack__007.png", 800));
				animGolpearP2.add(new ElementoAnimacion("pngEnem/Attack__008.png", 900));
				animGolpearP2.add(new ElementoAnimacion("pngEnem/Attack__009.png", 1000));
					return animGolpearP2;
			}
		default:
					return null;
		}
	}
	public  ArrayList<ElementoAnimacion> CrearAnimGolpeado(Personaje p,int personaje){
		switch(personaje) {
		case 0:
			if(p.getTipoPersonaje().equals("robot")) {
				animGolpeadoP1.add(new ElementoAnimacion("png/Slide (1).png", 100));
				animGolpeadoP1.add(new ElementoAnimacion("png/Slide (2).png", 200));
				animGolpeadoP1.add(new ElementoAnimacion("png/Slide (3).png", 300));
				animGolpeadoP1.add(new ElementoAnimacion("png/Slide (4).png", 400));
				animGolpeadoP1.add(new ElementoAnimacion("png/Slide (5).png", 500));
				animGolpeadoP1.add(new ElementoAnimacion("png/Slide (6).png", 600));
				animGolpeadoP1.add(new ElementoAnimacion("png/Slide (7).png", 700));
				animGolpeadoP1.add(new ElementoAnimacion("png/Slide (8).png", 800));
				animGolpeadoP1.add(new ElementoAnimacion("png/Slide (9).png", 900));
				animGolpeadoP1.add(new ElementoAnimacion("png/Slide (10).png", 1000));

					return animGolpeadoP1;
			}if(p.getTipoPersonaje().equals("ninja")) {
				animGolpeadoP1.add(new ElementoAnimacion("pngEnem/Slide__000.png", 100));
				animGolpeadoP1.add(new ElementoAnimacion("pngEnem/Slide__001.png", 200));
				animGolpeadoP1.add(new ElementoAnimacion("pngEnem/Slide__002.png", 300));
				animGolpeadoP1.add(new ElementoAnimacion("pngEnem/Slide__003.png", 400));
				animGolpeadoP1.add(new ElementoAnimacion("pngEnem/Slide__004.png", 500));
				animGolpeadoP1.add(new ElementoAnimacion("pngEnem/Slide__005.png", 600));
				animGolpeadoP1.add(new ElementoAnimacion("pngEnem/Slide__006.png", 700));
				animGolpeadoP1.add(new ElementoAnimacion("pngEnem/Slide__007.png", 800));
				animGolpeadoP1.add(new ElementoAnimacion("pngEnem/Slide__008.png", 900));
				animGolpeadoP1.add(new ElementoAnimacion("pngEnem/Slide__009.png", 1000));
					return animGolpeadoP1;
			}
		case 1:
			if(p.getTipoPersonaje().equals("robot")) {
				animGolpeadoP2.add(new ElementoAnimacion("png/Slide (1).png", 100));
				animGolpeadoP2.add(new ElementoAnimacion("png/Slide (2).png", 200));
				animGolpeadoP2.add(new ElementoAnimacion("png/Slide (3).png", 300));
				animGolpeadoP2.add(new ElementoAnimacion("png/Slide (4).png", 400));
				animGolpeadoP2.add(new ElementoAnimacion("png/Slide (5).png", 500));
				animGolpeadoP2.add(new ElementoAnimacion("png/Slide (6).png", 600));
				animGolpeadoP2.add(new ElementoAnimacion("png/Slide (7).png", 700));
				animGolpeadoP2.add(new ElementoAnimacion("png/Slide (8).png", 800));
				animGolpeadoP2.add(new ElementoAnimacion("png/Slide (9).png", 900));
				animGolpeadoP2.add(new ElementoAnimacion("png/Slide (10).png", 1000));


					return animGolpeadoP2;
			}if(p.getTipoPersonaje().equals("ninja")) {
				animGolpeadoP2.add(new ElementoAnimacion("pngEnem/Slide__000.png", 100));
				animGolpeadoP2.add(new ElementoAnimacion("pngEnem/Slide__001.png", 200));
				animGolpeadoP2.add(new ElementoAnimacion("pngEnem/Slide__002.png", 300));
				animGolpeadoP2.add(new ElementoAnimacion("pngEnem/Slide__003.png", 400));
				animGolpeadoP2.add(new ElementoAnimacion("pngEnem/Slide__004.png", 500));
				animGolpeadoP2.add(new ElementoAnimacion("pngEnem/Slide__005.png", 600));
				animGolpeadoP2.add(new ElementoAnimacion("pngEnem/Slide__006.png", 700));
				animGolpeadoP2.add(new ElementoAnimacion("pngEnem/Slide__007.png", 800));
				animGolpeadoP2.add(new ElementoAnimacion("pngEnem/Slide__008.png", 900));
				animGolpeadoP2.add(new ElementoAnimacion("pngEnem/Slide__009.png", 1000));
					return animGolpeadoP2;
			}
		default:
					return null;
		}
	}
	
	
	public  long getTiempoAnimParado(int personaje) {
		switch(personaje){
		case 0:	
			return animParadoP1.get(animParadoP1.size() -1).tiempos;
		case 1:
			return animParadoP2.get(animParadoP2.size() -1).tiempos;
		default:
			return 0;
		}
		
	}
	public  long getTiempoAnimSaltando(int personaje) {
		switch(personaje){
		case 0:	
			return animSaltandoP1.get(animSaltandoP1.size() -1).tiempos;
		case 1:
			return animSaltandoP2.get(animSaltandoP2.size() -1).tiempos;
		default:
			return 0;
		}
		
	}
	public  long getTiempoAnimMoverse(int personaje) {
		switch(personaje){
		case 0:	
			return animMoverseP1.get(animMoverseP1.size() -1).tiempos;
		case 1:
			return animMoverseP2.get(animMoverseP2.size() -1).tiempos;
		default:
			return 0;
		}
		
	}
	public  long getTiempoAnimGolpear(int personaje) {
		switch(personaje){
		case 0:	
			return animGolpearP1.get(animGolpearP1.size() -1).tiempos;
		case 1:
			return animGolpearP2.get(animGolpearP2.size() -1).tiempos;
		default:
			return 0;
		}
		
	}

	public  long getTiempoAnimGolpeado(int personaje) {
		switch(personaje){
		case 0:	
			return animGolpeadoP1.get(animGolpeadoP1.size() -1).tiempos;
		case 1:
			return animGolpeadoP2.get(animGolpeadoP2.size() -1).tiempos;
		default:
			return 0;
		}
		
	}
}
