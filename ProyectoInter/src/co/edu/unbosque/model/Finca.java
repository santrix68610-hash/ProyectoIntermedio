package co.edu.unbosque.model;

import java.util.List;

public class Finca extends Alojamiento {
	private double tarifaPiscina;

	public Finca(String id, String nombre, String ciudad, String tipo, String ubicacion, int capacidad,
			double preciopornoche, boolean activo, String descripcion, List<String> serviciosAdicionales,
			String activo2, String inactivo, double tarifaPiscina) {
		super(id, nombre, ciudad, tipo, ubicacion, capacidad, preciopornoche, activo, descripcion, serviciosAdicionales,
				activo2, inactivo);
		this.tarifaPiscina = tarifaPiscina;
	}

	@Override
	public double calcularValorReserva(int noches) {
		return super.calcularValorReserva(noches) + tarifaPiscina;
	}
}
