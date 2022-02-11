package org.iesalandalus.programacion.reservasaulas.mvc.vista;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.reservasaulas.mvc.modelo.dominio.Aula;
import org.iesalandalus.programacion.reservasaulas.mvc.modelo.dominio.Profesor;
import org.iesalandalus.programacion.reservasaulas.mvc.modelo.dominio.Tramo;
import org.iesalandalus.programacion.utilidades.Entrada;

public class Consola {

	private final static DateTimeFormatter FORMATO_DIA = DateTimeFormatter.ofPattern("dd/M/yyyy");

	public Consola() {
		
		//No se le pasa ningún valor debido a que es una clase estática

	}

	public static void mostrarMenu() {

		mostrarCabecera("Gestión de reservas de aulas");

		/*for (Opcion opcion: Opcion.values()) {
			System.out.println(opcion);
		}*/
	}

	public static void mostrarCabecera(String cabecera) {

		System.out.printf("%n%s%n", cabecera);
		String cadena = "%0" + cabecera.length() + "d%n";
		System.out.println(String.format(cadena, 0).replace('0', '-'));

	}

	public static int elegirOpcion() {

		int opcionElegida;
		do {
			System.out.println("Elija una opción: ");
			opcionElegida = Entrada.entero();
		} while (opcionElegida < 0 || opcionElegida > 5);
		return opcionElegida;
	}

	public static Aula leerAula() {

		System.out.println("Por favor, introduzca el nombre del aula: ");
		String nombre = leerNombreAula();
		Aula aula = new Aula(nombre);
		return aula;

	}

	public static String leerNombreAula() {

		String nombre = Entrada.cadena();
		return nombre;
	}

	public static Profesor leerProfesor() {

		String nombre, correo, telefono;
		System.out.println("Por favor, introduzca el nombre del profesor: ");
		nombre = leerNombreProfesor();
		System.out.println("Por favor, introduzca el correo del profesor: ");
		correo = leerNombreProfesor();
		System.out.println("Por favor, introduzca el telefono del profesor: ");
		telefono = leerNombreProfesor();

		Profesor profesor;

		if (telefono == null || telefono.isEmpty()) {
			profesor = new Profesor(nombre, correo);
		} else {
			profesor = new Profesor(nombre, correo, telefono);
		}
		return profesor;
	}

	public static String leerNombreProfesor() {

		String nombre = Entrada.cadena();
		return nombre;
	}

	public static Tramo leerTramo() {

		System.out.println("Por favor, introduzca el tramo:");
		String tramoIntroducido = Entrada.cadena();
		
		return Tramo.valueOf(tramoIntroducido);
	}

	public static LocalDate leerDia() {
		
		System.out.println("Por favor, intrdozuca una fecha: ");
		return LocalDate.parse(Entrada.cadena(), FORMATO_DIA);

	}
}
