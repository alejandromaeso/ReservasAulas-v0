package org.iesalandalus.programacion.reservasaulas.mvc.modelo.dominio;

import java.util.Objects;

public class Reserva {
	
	Profesor profesor;
	Aula aula;
	Permanencia permanencia;
	
	Reserva(Profesor profesor, Aula aula, Permanencia permanencia){
		if(profesor == null) {
			throw new NullPointerException("ERROR: La reserva debe estar a nombre de un profesor.");
		}
		if(aula == null) {
			throw new NullPointerException("ERROR: La reserva debe ser para un aula concreta.");
		}
		if(permanencia == null) {
			throw new NullPointerException("ERROR: La reserva se debe hacer para una permanencia concreta.");
		}
		setProfesor(profesor);
		setAula(aula);
		setPermanencia(permanencia);
	}
	
	Reserva(Reserva copiaReserva){
		if(copiaReserva == null) {
			throw new NullPointerException("ERROR: No se puede copiar una reserva nula.");
		}
		setProfesor(copiaReserva.getProfesor());
		setAula(copiaReserva.getAula());
		setPermanencia(copiaReserva.getPermanencia());
	}

	public Profesor getProfesor() {
		return profesor;
	}

	private void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	public Aula getAula() {
		return aula;
	}

	private void setAula(Aula aula) {
		this.aula = aula;
	}

	public Permanencia getPermanencia() {
		return permanencia;
	}

	private void setPermanencia(Permanencia permanencia) {
		this.permanencia = permanencia;
	}

	@Override
	public int hashCode() {
		return Objects.hash(aula, permanencia, profesor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reserva other = (Reserva) obj;
		return Objects.equals(aula, other.aula) && Objects.equals(permanencia, other.permanencia);				
	}

	@Override
	public String toString() {
		return "Profesor=" + profesor + ", aula=" + aula + ", permanencia=" + permanencia;
	}
	
	

}
