package org.iesalandalus.programacion.reservasaulas.mvc.modelo.dominio;

public enum Tramo {
	
	
	MANANA("MAÑANA"),
	TARDE("TARDE");
	
	
	private String cadenaAMostrar;
	
	private Tramo(String cadenaAMostrar) {
		this.cadenaAMostrar = cadenaAMostrar;
	}
	
	@Override
	public String toString() {
		return cadenaAMostrar;
	}
}
