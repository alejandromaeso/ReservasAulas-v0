package org.iesalandalus.programacion.reservasaulas;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.reservasaulas.mvc.controlador.Controlador;
import org.iesalandalus.programacion.reservasaulas.mvc.modelo.Modelo;
import org.iesalandalus.programacion.reservasaulas.mvc.vista.Consola;
import org.iesalandalus.programacion.reservasaulas.mvc.vista.Opcion;
import org.iesalandalus.programacion.reservasaulas.mvc.vista.Vista;

public class MainApp {

	public static void main(String[] args) throws OperationNotSupportedException {

		Vista vista = new Vista();
		Modelo modelo = new Modelo();
		Controlador controlador = new Controlador(modelo, vista);

		vista.setControlador(controlador);
		Opcion.setVista(vista);
		controlador.comenzar();
	}

}
