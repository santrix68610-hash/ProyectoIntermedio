package co.edu.unbosque.model;

import java.util.List;

/**
 * Clase que representa un alojamiento de tipo apartamento, heredando de la clase abstracta {@link Alojamiento}.
 * Contiene el constructor específico para la creación y gestión de apartamentos dentro del sistema.
 * 
 * @author Universidad El Bosque
 * @version 1.0
 */
public class Apartamento extends Alojamiento {

	/**
	 * Constructor de la clase Apartamento.
	 * Inicializa una nueva instancia de un apartamento heredando y asignando sus atributos desde la clase padre {@link Alojamiento}.
	 * 
	 * @param id identificador único del apartamento
	 * @param nombre nombre comercial del apartamento
	 * @param ciudad ciudad donde se encuentra ubicado
	 * @param tipo tipo de alojamiento
	 * @param ubicacion dirección o ubicación exacta del apartamento
	 * @param capacidad número máximo de huéspedes que puede recibir
	 * @param preciopornoche costo por noche de estancia
	 * @param activo estado booleano que indica si el apartamento está activo u operativo
	 * @param descripcion descripción detallada del apartamento
	 * @param serviciosAdicionales lista de servicios adicionales que ofrece
	 * @param activo2 representación en texto para el estado activo
	 * @param inactivo representación en texto para el estado inactivo
	 */
	public Apartamento(String id, String nombre, String ciudad, String tipo, String ubicacion, int capacidad,
			double preciopornoche, boolean activo, String descripcion, List<String> serviciosAdicionales,
			String activo2, String inactivo) {
		super(id, nombre, ciudad, tipo, ubicacion, capacidad, preciopornoche, activo, descripcion, serviciosAdicionales,
				activo2, inactivo);
	}

}