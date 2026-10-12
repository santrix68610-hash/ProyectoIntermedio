package co.edu.unbosque.persistence;

/**
 * Clase DTO (Data Transfer Object) que representa la estructura de datos de una reserva
 * utilizada para la transferencia y persistencia de la información entre las capas del sistema.
 * 
 * @author Universidad El Bosque
 * @version 1.0
 */
public class ReservaDTO {
	
	private String id;
	private String idHuesped;
	private String idAlojamiento;
	private String fechaLlegada;
	private String fechaSalida;
	private int numeroHuespedes;
	private int numeroNoches;
	private double valorTotal;
	private String estado;

	/**
	 * Constructor de la clase ReservaDTO.
	 * Inicializa una nueva instancia del objeto de transferencia con los datos de identificación,
	 * relaciones, fechas, ocupación y estado financiero de la reserva.
	 * 
	 * @param id identificador único de la reserva
	 * @param idHuesped identificador del huésped que realiza la reserva
	 * @param idAlojamiento identificador del alojamiento reservado
	 * @param fechaLlegada fecha de llegada en formato de texto (ej. AAAA-MM-DD)
	 * @param fechaSalida fecha de salida en formato de texto (ej. AAAA-MM-DD)
	 * @param numeroHuespedes cantidad de huéspedes que se alojarán
	 * @param numeroNoches número total de noches de la estancia
	 * @param valorTotal valor monetario total de la reserva
	 * @param estado estado actual de la reserva (ej. CONFIRMADA, CANCELADA)
	 */
	public ReservaDTO(String id, String idHuesped, String idAlojamiento,
	        String fechaLlegada, String fechaSalida, int numeroHuespedes,
	        int numeroNoches, double valorTotal, String estado) {
	    this.id = id;
	    this.idHuesped = idHuesped;
	    this.idAlojamiento = idAlojamiento;
	    this.fechaLlegada = fechaLlegada;
	    this.fechaSalida = fechaSalida;
	    this.numeroHuespedes = numeroHuespedes;
	    this.numeroNoches = numeroNoches;
	    this.valorTotal = valorTotal;
	    this.estado = estado;
	}

	/**
	 * Obtiene el identificador único de la reserva.
	 * 
	 * @return el ID de la reserva
	 */
	public String getId() {
		return id;
	}

	/**
	 * Establece el identificador único de la reserva.
	 * 
	 * @param id el nuevo ID a asignar
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Obtiene el identificador del huésped asociado a la reserva.
	 * 
	 * @return el ID del huésped
	 */
	public String getIdHuesped() {
		return idHuesped;
	}

	/**
	 * Establece el identificador del huésped asociado a la reserva.
	 * 
	 * @param idHuesped el nuevo ID del huésped a asignar
	 */
	public void setIdHuesped(String idHuesped) {
		this.idHuesped = idHuesped;
	}

	/**
	 * Obtiene el identificador del alojamiento reservado.
	 * 
	 * @return el ID del alojamiento
	 */
	public String getIdAlojamiento() {
		return idAlojamiento;
	}

	/**
	 * Establece el identificador del alojamiento reservado.
	 * 
	 * @param idAlojamiento el nuevo ID del alojamiento a asignar
	 */
	public void setIdAlojamiento(String idAlojamiento) {
		this.idAlojamiento = idAlojamiento;
	}

	/**
	 * Obtiene la fecha de llegada de la reserva.
	 * 
	 * @return la fecha de llegada
	 */
	public String getFechaLlegada() {
		return fechaLlegada;
	}

	/**
	 * Establece la fecha de llegada de la reserva.
	 * 
	 * @param fechaLlegada la nueva fecha de llegada a asignar
	 */
	public void setFechaLlegada(String fechaLlegada) {
		this.fechaLlegada = fechaLlegada;
	}

	/**
	 * Obtiene la fecha de salida de la reserva.
	 * 
	 * @return la fecha de salida
	 */
	public String getFechaSalida() {
		return fechaSalida;
	}

	/**
	 * Establece la fecha de salida de la reserva.
	 * 
	 * @param fechaSalida la nueva fecha de salida a asignar
	 */
	public void setFechaSalida(String fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	/**
	 * Obtiene el número de huéspedes de la reserva.
	 * 
	 * @return la cantidad de huéspedes
	 */
	public int getNumeroHuespedes() {
		return numeroHuespedes;
	}

	/**
	 * Establece el número de huéspedes de la reserva.
	 * 
	 * @param numeroHuespedes la nueva cantidad de huéspedes a asignar
	 */
	public void setNumeroHuespedes(int numeroHuespedes) {
		this.numeroHuespedes = numeroHuespedes;
	}

	/**
	 * Obtiene el número de noches de la estancia.
	 * 
	 * @return la cantidad de noches
	 */
	public int getNumeroNoches() {
		return numeroNoches;
	}

	/**
	 * Establece el número de noches de la estancia.
	 * 
	 * @param numeroNoches el nuevo número de noches a asignar
	 */
	public void setNumeroNoches(int numeroNoches) {
		this.numeroNoches = numeroNoches;
	}

	/**
	 * Obtiene el valor monetario total de la reserva.
	 * 
	 * @return el valor total
	 */
	public double getValorTotal() {
		return valorTotal;
	}

	/**
	 * Establece el valor monetario total de la reserva.
	 * 
	 * @param valorTotal el nuevo valor total a asignar
	 */
	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	/**
	 * Obtiene el estado actual de la reserva.
	 * 
	 * @return el estado de la reserva
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * Establece el estado actual de la reserva.
	 * 
	 * @param estado el nuevo estado a asignar
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}
}