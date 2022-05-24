package org.iesalandalus.programacion.reservasaulas.mvc.vista;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.reservasaulas.mvc.controlador.Controlador;
import org.iesalandalus.programacion.reservasaulas.mvc.modelo.dominio.Aula;
import org.iesalandalus.programacion.reservasaulas.mvc.modelo.dominio.Permanencia;
import org.iesalandalus.programacion.reservasaulas.mvc.modelo.dominio.Profesor;
import org.iesalandalus.programacion.reservasaulas.mvc.modelo.dominio.Reserva;

public class Vista {

	/*
	 * private final String ERROR = ""; private final String NOMBRE_VALIDO = "";
	 * private final String CORREO_VALIDO = "";
	 */

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

	public void insertarAula() {

		try {
			controlador.insertarAula(Consola.leerAula());
			System.out.println("El aula se ha insertado correctamente.");
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		} catch (OperationNotSupportedException e) {
			System.out.println(e.getMessage());
		}

	}

	public void borrarAula() {

		try {
			controlador.borrarAula(Consola.leerAula());
			System.out.println("El aula se ha borrado correctamente.");
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		} catch (OperationNotSupportedException e) {
			System.out.println(e.getMessage());
		}
	}

	public void buscarAula() {

		Consola.mostrarCabecera("Buscar aula existente: ");
		Aula aulaBuscar = controlador.buscarAula(Consola.leerAula());
		if (aulaBuscar == null) {
			System.out.println("El aula introducida no existe.");
		} else {
			System.out.println("El aula introducida existe.");
		}
	}

	public void listarAulas() {

		Consola.mostrarCabecera("Listado de aulas existentes: ");
		String[] representar = controlador.representarAulas();

		if (representar.length == 0) {
			System.out.println("No hay aulas introducidas");
		} else {
			for (String cadena : representar) {
				System.out.println(cadena);
			}
		}

	}

	public void insertarProfesor() {

		try {
			controlador.insertarProfesor(Consola.leerProfesor());
			System.out.println("El profesor se ha insertado correctamente.");
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		} catch (OperationNotSupportedException e) {
			System.out.println(e.getMessage());
		}
	}

	public void borrarProfesor() {

		try {
			controlador.borrarProfesor(Consola.leerProfesor());
			System.out.println("El profesor se ha borrado correctamente.");
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		} catch (OperationNotSupportedException e) {
			System.out.println(e.getMessage());
		}
	}

	public void buscarProfesor() {

		Consola.mostrarCabecera("Buscar profesor existente: ");

		Profesor profesorBuscar = controlador.buscarProfesor(Consola.leerProfesor());
		if (profesorBuscar == null) {
			System.out.println("El profesor introducido no existe.");
		} else {
			System.out.println("El profesor introducido existe.");
		}
	}

	public void listarProfesores() {

		Consola.mostrarCabecera("Listado de profesores existentes: ");
		String[] representar = controlador.representarProfesores();

		if (representar.length == 0) {
			System.out.println("No hay profesores introducidos");
		} else {
			for (String cadena : representar) {
				System.out.println(cadena);
			}
		}
	}

	public void realizarReserva() {

		try {
			Profesor profesorBuscar = controlador.buscarProfesor(Consola.leerProfesor());
			if (profesorBuscar == null) {
				throw new NullPointerException("El profesor introducido no existe.");
			} else {
				Reserva reserva = leerReserva(profesorBuscar);
				if (reserva == null) {
					throw new IllegalArgumentException("Error introducido en los datos de la reserva, compruébelos.");
				}
				controlador.realizarReserva(reserva);
				System.out.println("Reserva realizada correctamente.");
			}

		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		} catch (OperationNotSupportedException e) {
			System.out.println(e.getMessage());
		}
	}

	private Reserva leerReserva(Profesor profesor) {
		Permanencia permanencia = new Permanencia(Consola.leerDia(), Consola.leerTramo());
		Aula aulaBuscar = controlador.buscarAula(Consola.leerAula());
		Reserva reserva = null;
		if (aulaBuscar == null) {
			System.out.println("El aula introducida no existe.");
		} else {
			reserva = new Reserva(profesor, aulaBuscar, permanencia);

		}
		return reserva;
	}

	public void anularReserva() {

		try {
			controlador.anularReserva(leerReserva(Consola.leerProfesor()));
			System.out.println("Reserva anulada correctamente.");
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		} catch (OperationNotSupportedException e) {
			System.out.println(e.getMessage());
		}
	}

	public void listarReservas() {
		Consola.mostrarCabecera("Listado de reservas existentes: ");
		String[] representar = controlador.representarReservas();

		for (String cadena : representar) {
			System.out.println(cadena);
		}
	}

	public void listarReservasAula() {
		try {

			Consola.mostrarCabecera("Listado de reservas existentes por aula: ");
			Aula aulaBuscar = controlador.buscarAula(Consola.leerAula());
			if (aulaBuscar == null) {
				System.out.println("El aula introducida no existe.");
			} else {
				Reserva[] arrayReservas = controlador.getReservasAula(aulaBuscar);
				for (Reserva reserva : arrayReservas) {
					if (reserva == null) {
						System.out.println("No hay reservas.");
						break;
					} else {
						System.out.println(reserva.toString());
						break;
					}

				}
			}
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}

	}

	public void listarReservaProfesor() {
		try {

			Consola.mostrarCabecera("Listado de reservas existentes por profesor: ");
			Profesor profesorBuscar = controlador.buscarProfesor(Consola.leerProfesor());
			if (profesorBuscar == null) {
				throw new NullPointerException("El profesor introducido no existe.");
			} else {
				Reserva[] arrayReservas = controlador.getReservasProfesor(profesorBuscar);
				for (Reserva reserva : arrayReservas) {
					if (reserva == null) {
						System.out.println("No hay reservas.");
						break;
					} else {
						System.out.println(reserva.toString());
						break;
					}

				}
			}
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}

	}

	public void listarReservaPermanencia() {
		try {

			Consola.mostrarCabecera("Listado de reservas existentes por permanencia: ");
			Permanencia permanencia = new Permanencia(Consola.leerDia(), Consola.leerTramo());

			Reserva[] arrayReservas = controlador.getReservasPermanencia(permanencia);
			for (Reserva reserva : arrayReservas) {
				if (reserva == null) {
					System.out.println("No hay reservas.");
					break;
				} else {
					System.out.println(reserva.toString());
					break;
				}

			}
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}

	}

	public void consultarDisponibilidad() {
		try {

			Permanencia permanencia = new Permanencia(Consola.leerDia(), Consola.leerTramo());
			Aula aulaBuscar = controlador.buscarAula(Consola.leerAula());
			if (aulaBuscar == null) {
				System.out.println("El aula introducida no existe.");
			} else {
				if (controlador.consultarDisponibilidad(aulaBuscar, permanencia)) {
					System.out.println("El aula está disponible.");
				} else {
					System.out.println("El aula ya está reservada.");
				}

			}
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}

	}

}
