package co.edu.unbosque.model;

import java.util.List;

/**
 * Clase que representa un alojamiento de tipo finca, heredando de la clase abstracta {@link Alojamiento}.
 * Incorpora un costo adicional por concepto de tarifa de piscina que se añade al valor total de la reserva.
 * 
 * @author Universidad El Bosque
 * @version 1.0
 */
public class Finca extends Alojamiento {
	
	/**
	 * Tarifa de piscina adicional aplicable a la finca.
	 */
	private double tarifaPiscina;

	/**
	 * Constructor de la clase Finca.
	 * Inicializa una nueva instancia de una finca heredando los atributos de la clase padre {@link Alojamiento}
	 * y estableciendo su tarifa de piscina específica.
	 * 
	 * @param id identificador único de la finca
	 * @param nombre nombre comercial de la finca
	 * @param ciudad ciudad donde se encuentra ubicada
	 * @param tipo tipo de alojamiento
	 * @param ubicacion dirección o ubicación exacta de la finca
	 * @param capacidad número máximo de huéspedes que puede recibir
	 * @param preciopornoche costo por noche de estancia
	 * @param activo estado booleano que indica si la finca está activa u operativa
	 * @param descripcion descripción detallada de la finca
	 * @param serviciosAdicionales lista de servicios adicionales que ofrece
	 * @param activo2 representación en texto para el estado activo
	 * @param inactivo representación en texto para el estado inactivo
	 * @param tarifaPiscina costo adicional correspondiente a la tarifa de piscina de la finca
	 */
	public Finca(String id, String nombre, String ciudad, String tipo, String ubicacion, int capacidad,
			double preciopornoche, boolean activo, String descripcion, List<String> serviciosAdicionales,
			String activo2, String inactivo, double tarifaPiscina) {
		super(id, nombre, ciudad, tipo, ubicacion, capacidad, preciopornoche, activo, descripcion, serviciosAdicionales,
				activo2, inactivo);
		this.tarifaPiscina = tarifaPiscina;
	}

	/**
	 * Calcula el valor total de la reserva para la finca, sumando el valor base de la estancia 
	 * y la tarifa de piscina adicional.
	 * 
	 * @param noches cantidad de noches de la reserva
	 * @return el valor total de la reserva incluyendo la tarifa de piscina
	 */
	@Override
	public double calcularValorReserva(int noches) {
		return super.calcularValorReserva(noches) + tarifaPiscina;
	}
}