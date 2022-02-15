package org.iesalandalus.programacion.reservasaulas.mvc.vista;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.reservasaulas.mvc.controlador.Controlador;
import org.iesalandalus.programacion.reservasaulas.mvc.modelo.dominio.Permanencia;
import org.iesalandalus.programacion.reservasaulas.mvc.modelo.dominio.Profesor;
import org.iesalandalus.programacion.reservasaulas.mvc.modelo.dominio.Reserva;

public class Vista {

	/* private final String ERROR = "";
	private final String NOMBRE_VALIDO = "";
	private final String CORREO_VALIDO = ""; */

	Controlador controlador;

	public Vista() {

	}

	public void setControlador(Controlador controlador) {

		this.controlador = controlador;
	}

	public void comenzar() throws OperationNotSupportedException {
		int ordinalOpcion;
		do {
			Consola.mostrarMenu();
			ordinalOpcion = Consola.elegirOpcion();
			Opcion opcion = Opcion.getOpcionSegunOrdinal(ordinalOpcion);
			opcion.ejecutar();
		} while (ordinalOpcion != Opcion.SALIR.ordinal());
	}

	public void salir() {

		System.out.println("Se ha terminado el programa.");
		controlador.terminar();
	}

	public void insertarAula() throws OperationNotSupportedException {

		controlador.insertarAula(Consola.leerAula());

	}

	public void borrarAula() throws OperationNotSupportedException {

		controlador.borrarAula(Consola.leerAula());

	}

	public void buscarAula() {

		controlador.buscarAula(Consola.leerAula());
	}

	public void listarAulas() {

		String[] representar = controlador.representarAulas();

		for (String cadena : representar) {
			System.out.println(cadena);
		}

		/*
		 * OTRA FORMA DE REPRESENTAR EL BUCLE:
		 * 
		 * for(int i=0; i < representar.length; i++) {
		 * 
		 * System.out.println(representar[i]); }
		 */
	}

	public void insertarProfesor() throws OperationNotSupportedException {

		controlador.insertarProfesor(Consola.leerProfesor());
	}

	public void borrarProfesor() throws OperationNotSupportedException {

		controlador.borrarProfesor(Consola.leerProfesor());
	}

	public void buscarProfesor() {

		controlador.buscarProfesor(Consola.leerProfesor());
	}

	public void listarProfesores() {

		String[] representar = controlador.representarProfesores();

		for (String cadena : representar) {
			System.out.println(cadena);
		}
	}

	public void realizarReserva() throws OperationNotSupportedException {

		controlador.realizarReserva(leerReserva(Consola.leerProfesor()));
	}

	private Reserva leerReserva(Profesor profesor) {
		Permanencia permanencia = new Permanencia(Consola.leerDia(), Consola.leerTramo());
		Reserva reserva = new Reserva(profesor, Consola.leerAula(), permanencia);
		return reserva;

	}

	public void anularReserva() throws OperationNotSupportedException {

		controlador.anularReserva(leerReserva(Consola.leerProfesor()));
	}

	public void listarReservas() {

		String[] representar = controlador.representarReservas();

		for (String cadena: representar) {
			System.out.println(cadena);
		}
	}

	public void listarReservasAula() {

		Reserva[] arrayReservas = controlador.getReservasAula(Consola.leerAula());

		for (Reserva reserva: arrayReservas) {
			System.out.println(reserva.toString());
		}

	}

	public void listarReservaProfesor() {
		
		Reserva[] arrayReservas = controlador.getReservasProfesor(Consola.leerProfesor());

		for (Reserva reserva: arrayReservas) {
			System.out.println(reserva.toString());
		}

	}

	public void listarReservaPermanencia() {

		Permanencia permanencia = new Permanencia(Consola.leerDia(), Consola.leerTramo());
		
		Reserva[] arrayReservas = 	controlador.getReservasPermanencia(permanencia);
		
		for (Reserva reserva: arrayReservas) {
			System.out.println(reserva.toString());
		}

	}

	public void consultarDisponibilidad() {

		Permanencia permanencia = new Permanencia(Consola.leerDia(), Consola.leerTramo());
		
		if(controlador.consultarDisponibilidad(Consola.leerAula(), permanencia)) {
			System.out.println("El aula está disponible.");
		} else {
			System.out.println("El aula ya está reservada.");
		}
		
	}

}
