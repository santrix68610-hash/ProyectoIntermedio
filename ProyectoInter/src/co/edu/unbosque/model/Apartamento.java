package co.edu.unbosque.model;

import java.util.List;

public class Apartamento extends Alojamiento {

	public Apartamento(String id, String nombre, String ciudad, String tipo, String ubicacion, int capacidad,
			double preciopornoche, boolean activo, String descripcion, List<String> serviciosAdicionales,
			String activo2, String inactivo) {
		super(id, nombre, ciudad, tipo, ubicacion, capacidad, preciopornoche, activo, descripcion, serviciosAdicionales,
				activo2, inactivo);
	}

}
