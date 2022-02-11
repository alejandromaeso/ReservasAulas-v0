package org.iesalandalus.programacion.reservasaulas.mvc.controlador;

import org.iesalandalus.programacion.reservasaulas.mvc.modelo.Modelo;
import org.iesalandalus.programacion.reservasaulas.mvc.modelo.dominio.Aula;
import org.iesalandalus.programacion.reservasaulas.mvc.modelo.dominio.Permanencia;
import org.iesalandalus.programacion.reservasaulas.mvc.modelo.dominio.Profesor;
import org.iesalandalus.programacion.reservasaulas.mvc.modelo.dominio.Reserva;
import org.iesalandalus.programacion.reservasaulas.mvc.vista.Vista;

public class Controlador {
	
	Vista vista;
	Modelo modelo;

	public Controlador(Modelo modelo, Vista vista) {

	}

	public void comenzar() {

	}

	public void terminar() {

	}

	public void insertarAula(Aula aula) {

	}

	public void insertarProfesor(Profesor profesor) {

	}
	
	public void borrarAula(Aula aula) {

	}

	public void borrarProfesor(Profesor profesor) {

	}

	public Aula buscarAula(Aula aula) {

		return null;
	}

	public Profesor buscarProfesor(Profesor profesor) {

		return null;

	}

	public String[] representarAulas() {

		return null;

	}
	
	public String[] representarProfesores() {
		
		return null;
		
	}
	
	public String[] representarReservas() {
		
		return null;
		
	}
	
	public void realizarReserva(Reserva reserva) {
		
	}
	
	public void anularReserva(Reserva reserva) {
		
	}
	
	public Reserva[] getReservasAula(Aula aula) {
		
		return null;
		
	}
	
	public Reserva[] getReservasProfesor(Profesor profesor) {
		
		return null;
	}
	
	public Reserva[] getReservasPermanencia(Permanencia permanencia) {
		
		return null;
	}
	
	public boolean consultarDisponibilidad(Aula aula, Permanencia permanencia) {
		
		return false;
		
	}
}
