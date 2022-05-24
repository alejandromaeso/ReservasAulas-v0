package org.iesalandalus.programacion.reservasaulas.mvc.modelo.negocio;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.reservasaulas.mvc.modelo.dominio.Profesor;

public class Profesores {

	int capacidad, tamano;
	Profesor[] coleccionProfesores;

	public Profesores(int numeroProfesores) {
		if (numeroProfesores <= 0) {
			throw new IllegalArgumentException("ERROR: La capacidad debe ser mayor que cero.");
		}
		capacidad = numeroProfesores;
		tamano = 0;
		coleccionProfesores = new Profesor[numeroProfesores];

	}

	public Profesor[] get() {
		return copiaProfundaProfesores();
	}

	private Profesor[] copiaProfundaProfesores() {
		Profesor[] copiaProfesores = new Profesor[capacidad];
		for (int i = 0; i < tamano; i++) {
			copiaProfesores[i] = new Profesor(coleccionProfesores[i]);
		}
		return copiaProfesores;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public int getTamano() {
		return tamano;
	}

	public void insertar(Profesor insertarProfesor) throws OperationNotSupportedException {
		if (insertarProfesor == null) {
			throw new NullPointerException("ERROR: No se puede insertar un profesor nulo.");
		}
		int indice = buscarIndice(insertarProfesor);

		if (capacidadSuperada(indice)) {
			throw new OperationNotSupportedException("ERROR: No se aceptan más profesores.");
		}

		if (tamanoSuperado(indice)) {
			coleccionProfesores[indice] = new Profesor(insertarProfesor);
			tamano++;
		} else {
			throw new OperationNotSupportedException("ERROR: Ya existe un profesor con ese nombre.");
		}

	}

	private int buscarIndice(Profesor buscarProfesor) {
		int indice = 0;
		boolean profesorEncontrado = false;
		while (!tamanoSuperado(indice) && !profesorEncontrado) {
			if (coleccionProfesores[indice].equals(buscarProfesor)) {
				profesorEncontrado = true;
			} else {
				indice++;
			}
		}
		return indice;
	}

	private boolean tamanoSuperado(int indice) {

		return (indice >= tamano);
	}

	private boolean capacidadSuperada(int indice) {

		return (indice >= capacidad);
	}

	public Profesor buscar(Profesor buscarProfesor) {
		if (buscarProfesor == null) {
			throw new NullPointerException("ERROR: No se puede buscar un profesor nulo.");
		}
		int indice = buscarIndice(buscarProfesor);
		if (tamanoSuperado(indice)) {
			return null;
		} else {
			return new Profesor(buscarProfesor);
		}
	}

	public void borrar(Profesor borrarProfesor) throws OperationNotSupportedException {
		if (borrarProfesor == null) {
			throw new NullPointerException("ERROR: No se puede borrar un profesor nulo.");
		}
		int indice = buscarIndice(borrarProfesor);
		if (!tamanoSuperado(indice)) {
			desplazarUnaPosicionHaciaIzquierda(indice);
		} else {
			throw new OperationNotSupportedException("ERROR: No existe ningún profesor con ese nombre.");
		}

	}

	// Método desplazarUnaPosicionHaciaIzquierda
	private void desplazarUnaPosicionHaciaIzquierda(int indice) {
		for (int i = indice; !tamanoSuperado(i); i++) {
			coleccionProfesores[i] = coleccionProfesores[i + 1];
		}
		tamano--;
	}

	public String[] representar() {
		String[] representacion = new String[tamano];
		for (int i = 0; i < tamano; i++) {
			representacion[i] = coleccionProfesores[i].toString();
		}
		return representacion;
	}

}
