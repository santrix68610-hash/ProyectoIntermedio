package co.edu.unbosque.model;

/**
 * Clase que representa a un huésped dentro del sistema de alojamientos.
 * Almacena la información personal y de contacto del cliente.
 * 
 * @author Universidad El Bosque
 * @version 1.0
 */
public class Huesped {
	
	/** Identificador único del huésped (ej. documento de identidad). */
	private String id;
	
	/** Nombre del huésped. */
	private String nombre;
	
	/** Apellido del huésped. */
	private String apellido;
	
	/** Correo electrónico de contacto del huésped. */
	private String correo;
	
	/** Número telefónico de contacto del huésped. */
	private String telefono;

	/**
	 * Constructor de la clase Huesped.
	 * Inicializa una nueva instancia de huésped con sus datos de identificación y contacto.
	 * 
	 * @param id identificador único del huésped
	 * @param nombre nombre del huésped
	 * @param apellido apellido del huésped
	 * @param correo correo electrónico de contacto
	 * @param telefono número telefónico de contacto
	 */
	public Huesped(String id, String nombre, String apellido, String correo, String telefono) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.telefono = telefono;
	}

	/**
	 * Obtiene el identificador único del huésped.
	 * 
	 * @return el ID del huésped
	 */
	public String getId() {
		return id;
	}

	/**
	 * Establece el identificador único del huésped.
	 * 
	 * @param id el nuevo ID a asignar
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Obtiene el nombre del huésped.
	 * 
	 * @return el nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Establece el nombre del huésped.
	 * 
	 * @param nombre el nuevo nombre a asignar
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Obtiene el apellido del huésped.
	 * 
	 * @return el apellido
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * Establece el apellido del huésped.
	 * 
	 * @param apellido el nuevo apellido a asignar
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	/**
	 * Obtiene el correo electrónico del huésped.
	 * 
	 * @return el correo electrónico
	 */
	public String getCorreo() {
		return correo;
	}

	/**
	 * Establece el correo electrónico del huésped.
	 * 
	 * @param correo el nuevo correo electrónico a asignar
	 */
	public void setCorreo(String correo) {
		this.correo = correo;
	}

	/**
	 * Obtiene el número telefónico del huésped.
	 * 
	 * @return el número de teléfono
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * Establece el número telefónico del huésped.
	 * 
	 * @param telefono el nuevo número telefónico a asignar
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
}