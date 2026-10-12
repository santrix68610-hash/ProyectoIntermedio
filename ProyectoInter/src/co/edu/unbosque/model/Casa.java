package co.edu.unbosque.model;

import java.util.List;

/**
 * Clase que representa un alojamiento de tipo casa, heredando de la clase abstracta {@link Alojamiento}.
 * Incorpora un costo adicional por concepto de tarifa de aseo que se añade al valor total de la reserva.
 * 
 * @author Universidad El Bosque
 * @version 1.0
 */
public class Casa extends Alojamiento {
	
	/**
	 * Tarifa de aseo adicional aplicable a la casa.
	 */
	private double tarifaAseo;

	/**
	 * Constructor de la clase Casa.
	 * Inicializa una nueva instancia de una casa heredando los atributos de la clase padre {@link Alojamiento}
	 * y estableciendo su tarifa de aseo específica.
	 * 
	 * @param id identificador único de la casa
	 * @param nombre nombre comercial de la casa
	 * @param ciudad ciudad donde se encuentra ubicada
	 * @param tipo tipo de alojamiento
	 * @param ubicacion dirección o ubicación exacta de la casa
	 * @param capacidad número máximo de huéspedes que puede recibir
	 * @param preciopornoche costo por noche de estancia
	 * @param activo estado booleano que indica si la casa está activa u operativa
	 * @param descripcion descripción detallada de la casa
	 * @param serviciosAdicionales lista de servicios adicionales que ofrece
	 * @param activo2 representación en texto para el estado activo
	 * @param inactivo representación en texto para el estado inactivo
	 * @param tarifaAseo costo adicional correspondiente a la tarifa de aseo de la casa
	 */
	public Casa(String id, String nombre, String ciudad, String tipo, String ubicacion, int capacidad,
			double preciopornoche, boolean activo, String descripcion, List<String> serviciosAdicionales,
			String activo2, String inactivo, double tarifaAseo) {
		super(id, nombre, ciudad, tipo, ubicacion, capacidad, preciopornoche, activo, descripcion, serviciosAdicionales,
				activo2, inactivo);
		this.tarifaAseo = tarifaAseo;
	}

	/**
	 * Calcula el valor total de la reserva para la casa, sumando el valor base de la estancia 
	 * y la tarifa de aseo adicional.
	 * 
	 * @param noches cantidad de noches de la reserva
	 * @return el valor total de la reserva incluyendo la tarifa de aseo
	 */
	@Override
	public double calcularValorReserva(int noches) {
		return super.calcularValorReserva(noches) + tarifaAseo;
	}
}