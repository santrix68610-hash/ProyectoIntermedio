
package co.edu.unbosque.model;

import java.util.List;

/**
 * Clase que representa un alojamiento de tipo cabaña, heredando de la clase abstracta {@link Alojamiento}.
 * Incorpora un costo adicional por concepto de tarifa de servicio que se añade al valor total de la reserva.
 * 
 * @author Universidad El Bosque
 * @version 1.0
 */
public class Cabaña extends Alojamiento {
	
	/**
	 * Tarifa de servicio adicional aplicable a la cabaña.
	 */
	private double tarifaServicio;

	/**
	 * Constructor de la clase Cabaña.
	 * Inicializa una nueva instancia de una cabaña heredando los atributos de la clase padre {@link Alojamiento}
	 * y estableciendo su tarifa de servicio específica.
	 * 
	 * @param id identificador único de la cabaña
	 * @param nombre nombre comercial de la cabaña
	 * @param ciudad ciudad donde se encuentra ubicada
	 * @param tipo tipo de alojamiento
	 * @param ubicacion dirección o ubicación exacta de la cabaña
	 * @param capacidad número máximo de huéspedes que puede recibir
	 * @param preciopornoche costo por noche de estancia
	 * @param activo estado booleano que indica si la cabaña está activa u operativa
	 * @param descripcion descripción detallada de la cabaña
	 * @param serviciosAdicionales lista de servicios adicionales que ofrece
	 * @param activo2 representación en texto para el estado activo
	 * @param inactivo representación en texto para el estado inactivo
	 * @param tarifaServicio costo adicional correspondiente a la tarifa de servicio de la cabaña
	 */
	public Cabaña(String id, String nombre, String ciudad, String tipo, String ubicacion, int capacidad,
			double preciopornoche, boolean activo, String descripcion, List<String> serviciosAdicionales,
			String activo2, String inactivo, double tarifaServicio) {
		super(id, nombre, ciudad, tipo, ubicacion, capacidad, preciopornoche, activo, descripcion, serviciosAdicionales,
				activo2, inactivo);
		this.tarifaServicio = tarifaServicio;
	}

	/**
	 * Calcula el valor total de la reserva para la cabaña, sumando el valor base de la estancia 
	 * y la tarifa de servicio adicional.
	 * 
	 * @param noches cantidad de noches de la reserva
	 * @return el valor total de la reserva incluyendo la tarifa de servicio
	 */
	@Override
	public double calcularValorReserva(int noches) {
		return super.calcularValorReserva(noches) + tarifaServicio;
	}
}