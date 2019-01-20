package main;

import Ventanas.VentanaValidacion;
import control.BaseDeDatos;

public class Partida {

	public static void main(String[] args) {
		VentanaValidacion.ventanaVal = new VentanaValidacion();
		VentanaValidacion.ventanaVal.setVisible(true);
		
		BaseDeDatos.crearConexion();
		BaseDeDatos.crearBD();
	}

}

