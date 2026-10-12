package co.edu.unbosque.persistence;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase DTO (Data Transfer Object) que representa la estructura de datos de un
 * alojamiento utilizada para la transferencia y persistencia de la información
 * entre las capas del sistema.
 * 
 * @author Universidad El Bosque
 * @version 1.0
 */
public class AlojamientoDTO {

	private String id;
	private String nombre;
	private String ciudad;
	private String tipo;
	private String ubicacion;
	private int capacidad;
	private double precioPorNoche;
	private boolean activo;
	private String descripcion;
	private List<String> serviciosAdicionales;
	private double tarifaAdicional;

	/**
	 * Constructor principal de la clase AlojamientoDTO. Inicializa todas las
	 * propiedades del objeto de transferencia con los valores especificados.
	 * 
	 * @param id                   identificador único del alojamiento
	 * @param nombre               nombre comercial del alojamiento
	 * @param ciudad               ciudad de ubicación
	 * @param tipo                 tipo de alojamiento
	 * @param ubicacion            dirección o ubicación exacta
	 * @param capacidad            capacidad máxima de huéspedes
	 * @param precioPorNoche       costo por noche de estancia
	 * @param activo               estado booleano de disponibilidad
	 * @param descripcion          descripción detallada
	 * @param serviciosAdicionales lista de servicios adicionales que ofrece
	 * @param tarifaAdicional      tarifa o costo adicional aplicable al alojamiento
	 */
	public AlojamientoDTO(String id, String nombre, String ciudad, String tipo, String ubicacion, int capacidad,
			double precioPorNoche, boolean activo, String descripcion, List<String> serviciosAdicionales,
			double tarifaAdicional) {

		this.id = id;
		this.nombre = nombre;
		this.ciudad = ciudad;
		this.tipo = tipo;
		this.ubicacion = ubicacion;
		this.capacidad = capacidad;
		this.precioPorNoche = precioPorNoche;
		this.activo = activo;
		this.descripcion = descripcion;
		this.tarifaAdicional = tarifaAdicional;

		this.serviciosAdicionales = new ArrayList<String>();
		if (serviciosAdicionales != null) {
			this.serviciosAdicionales.addAll(serviciosAdicionales);
		}
	}

	/**
	 * Constructor sobrecargado de la clase AlojamientoDTO para alojamientos
	 * básicos. Inicializa los atributos principales y asigna una lista vacía de
	 * servicios y una tarifa adicional de 0.0 por defecto.
	 * 
	 * @param id             identificador único del alojamiento
	 * @param nombre         nombre comercial del alojamiento
	 * @param ciudad         ciudad de ubicación
	 * @param tipo           tipo de alojamiento
	 * @param ubicacion      dirección o ubicación exacta
	 * @param capacidad      capacidad máxima de huéspedes
	 * @param precioPorNoche costo por noche de estancia
	 * @param activo         estado booleano de disponibilidad
	 * @param descripcion    descripción detallada
	 */
	public AlojamientoDTO(String id, String nombre, String ciudad, String tipo, String ubicacion, int capacidad,
			double precioPorNoche, boolean activo, String descripcion) {

		this(id, nombre, ciudad, tipo, ubicacion, capacidad, precioPorNoche, activo, descripcion,
				new ArrayList<String>(), 0.0);
	}

	/**
	 * Constructor sobrecargado de la clase AlojamientoDTO con la tarifa adicional
	 * ubicada al inicio de los parámetros.
	 * 
	 * @param tarifaAdicional      tarifa o costo adicional aplicable al alojamiento
	 * @param id                   identificador único del alojamiento
	 * @param nombre               nombre comercial del alojamiento
	 * @param ciudad               ciudad de ubicación
	 * @param tipo                 tipo de alojamiento
	 * @param ubicacion            dirección o ubicación exacta
	 * @param capacidad            capacidad máxima de huéspedes
	 * @param precioPorNoche       costo por noche de estancia
	 * @param activo               estado booleano de disponibilidad
	 * @param descripcion          descripción detallada
	 * @param serviciosAdicionales lista de servicios adicionales que ofrece
	 */
	public AlojamientoDTO(double tarifaAdicional, String id, String nombre, String ciudad, String tipo,
			String ubicacion, int capacidad, double precioPorNoche, boolean activo, String descripcion,
			List<String> serviciosAdicionales) {

		this(id, nombre, ciudad, tipo, ubicacion, capacidad, precioPorNoche, activo, descripcion, serviciosAdicionales,
				tarifaAdicional);
	}

	/**
	 * Obtiene el identificador único del alojamiento.
	 * 
	 * @return el ID del alojamiento
	 */
	public String getId() {
		return id;
	}

	/**
	 * Establece el identificador único del alojamiento.
	 * 
	 * @param id el nuevo ID a asignar
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Obtiene el nombre del alojamiento.
	 * 
	 * @return el nombre del alojamiento
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Establece el nombre del alojamiento.
	 * 
	 * @param nombre el nuevo nombre a asignar
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Obtiene la ciudad del alojamiento.
	 * 
	 * @return la ciudad
	 */
	public String getCiudad() {
		return ciudad;
	}

	/**
	 * Establece la ciudad del alojamiento.
	 * 
	 * @param ciudad la nueva ciudad a asignar
	 */
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	/**
	 * Obtiene el tipo de alojamiento.
	 * 
	 * @return el tipo de alojamiento
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * Establece el tipo de alojamiento.
	 * 
	 * @param tipo el nuevo tipo a asignar
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/**
	 * Obtiene la ubicación exacta del alojamiento.
	 * 
	 * @return la ubicación
	 */
	public String getUbicacion() {
		return ubicacion;
	}

	/**
	 * Establece la ubicación del alojamiento.
	 * 
	 * @param ubicacion la nueva ubicación a asignar
	 */
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	/**
	 * Obtiene la capacidad máxima de huéspedes.
	 * 
	 * @return la capacidad máxima
	 */
	public int getCapacidad() {
		return capacidad;
	}

	/**
	 * Establece la capacidad máxima de huéspedes.
	 * 
	 * @param capacidad la nueva capacidad a asignar
	 */
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	/**
	 * Obtiene el precio por noche del alojamiento.
	 * 
	 * @return el precio por noche
	 */
	public double getPrecioPorNoche() {
		return precioPorNoche;
	}

	/**
	 * Establece el precio por noche del alojamiento.
	 * 
	 * @param precioPorNoche el nuevo precio por noche a asignar
	 */
	public void setPrecioPorNoche(double precioPorNoche) {
		this.precioPorNoche = precioPorNoche;
	}

	/**
	 * Indica si el alojamiento se encuentra activo.
	 * 
	 * @return true si está activo, false en caso contrario
	 */
	public boolean isActivo() {
		return activo;
	}

	/**
	 * Establece el estado de actividad del alojamiento.
	 * 
	 * @param activo el estado booleano a asignar
	 */
	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	/**
	 * Obtiene la descripción detallada del alojamiento.
	 * 
	 * @return la descripción
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Establece la descripción detallada del alojamiento.
	 * 
	 * @param descripcion la nueva descripción a asignar
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * Obtiene la lista de servicios adicionales del alojamiento.
	 * 
	 * @return la lista de servicios adicionales
	 */
	public List<String> getServiciosAdicionales() {
		return serviciosAdicionales;
	}

	/**
	 * Establece o actualiza la lista de servicios adicionales del alojamiento.
	 * 
	 * @param serviciosAdicionales la nueva lista de servicios a asignar
	 */
	public void setServiciosAdicionales(List<String> serviciosAdicionales) {
		this.serviciosAdicionales = new ArrayList<String>();
		if (serviciosAdicionales != null) {
			this.serviciosAdicionales.addAll(serviciosAdicionales);
		}
	}

	/**
	 * Obtiene la tarifa adicional asociada al alojamiento.
	 * 
	 * @return la tarifa adicional
	 */
	public double getTarifaAdicional() {
		return tarifaAdicional;
	}

	/**
	 * Establece la tarifa adicional asociada al alojamiento.
	 * 
	 * @param tarifaAdicional la nueva tarifa a asignar
	 */
	public void setTarifaAdicional(double tarifaAdicional) {
		this.tarifaAdicional = tarifaAdicional;
	}
}