
package co.edu.unbosque.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Clase que representa una reserva dentro del sistema.
 * Conecta a un huésped con un alojamiento para un periodo de tiempo determinado,
 * calculando costos, noches de estancia y permitiendo gestionar su estado.
 * 
 * @author Universidad El Bosque
 * @version 1.0
 */
public class Reserva {
	
	/** Constante que representa el estado confirmado de una reserva. */
	public static final String CONFIRMADA = "CONFIRMADA";
	
	/** Constante que representa el estado cancelado de una reserva. */
	public static final String CANCELADA = "CANCELADA";

	private String id;
	private Huesped huesped;
	private Alojamiento alojamiento;
	private String fechaLlegada;
	private String fechaSalida;
	private int numeroHuespedes;
	private int numeroNoches;
	private double valorTotal;
	private String estado;

	/**
	 * Constructor de la clase Reserva.
	 * Inicializa una nueva instancia con todos sus atributos de identificación, relaciones y detalles de la estancia.
	 * 
	 * @param id identificador único de la reserva
	 * @param huesped objeto {@link Huesped} que realiza la reserva
	 * @param alojamiento objeto {@link Alojamiento} reservado
	 * @param fechaLlegada fecha de llegada en formato de texto (ej. AAAA-MM-DD)
	 * @param fechaSalida fecha de salida en formato de texto (ej. AAAA-MM-DD)
	 * @param numeroHuespedes cantidad de huéspedes que se alojarán
	 * @param numeroNoches número total de noches de la estancia
	 * @param valorTotal valor monetario total de la reserva
	 * @param estado estado actual de la reserva
	 */
	public Reserva(String id, Huesped huesped, Alojamiento alojamiento, String fechaLlegada, String fechaSalida,
			int numeroHuespedes, int numeroNoches, double valorTotal, String estado) {
		super();
		this.id = id;
		this.huesped = huesped;
		this.alojamiento = alojamiento;
		this.fechaLlegada = fechaLlegada;
		this.fechaSalida = fechaSalida;
		this.numeroHuespedes = numeroHuespedes;
		this.numeroNoches = numeroNoches;
		this.valorTotal = valorTotal;
		this.estado = estado;
	}

	/**
	 * Calcula el número de noches de la estancia restando la fecha de llegada de la fecha de salida.
	 * 
	 * @return la cantidad de noches entre la llegada y la salida
	 */
	public int calcularNoches() {
		LocalDate llegada = LocalDate.parse(fechaLlegada);
		LocalDate salida = LocalDate.parse(fechaSalida);

		return (int) ChronoUnit.DAYS.between(llegada, salida);
	}

	/**
	 * Calcula el valor total de la reserva actualizando primero el número de noches 
	 * y aplicando la tarifa del alojamiento correspondiente.
	 * 
	 * @return el valor monetario total calculado de la reserva
	 */
	public double calcularTotal() {
		numeroNoches = calcularNoches();
		valorTotal = alojamiento.calcularValorReserva(numeroNoches);

		return valorTotal;
	}

	/**
	 * Cambia el estado de la reserva a "CANCELADA" siempre y cuando se encuentre previamente en estado "CONFIRMADA".
	 */
	public void cancelar() {
		if (estado == "CONFIRMADA") {
			estado = "CANCELADA";
		}
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
	 * Obtiene el huésped asociado a la reserva.
	 * 
	 * @return el objeto {@link Huesped}
	 */
	public Huesped getHuesped() {
		return huesped;
	}

	/**
	 * Establece el huésped asociado a la reserva.
	 * 
	 * @param huesped el nuevo objeto {@link Huesped} a asignar
	 */
	public void setHuesped(Huesped huesped) {
		this.huesped = huesped;
	}

	/**
	 * Obtiene el alojamiento reservado.
	 * 
	 * @return el objeto {@link Alojamiento}
	 */
	public Alojamiento getAlojamiento() {
		return alojamiento;
	}

	/**
	 * Establece el alojamiento reservado.
	 * 
	 * @param alojamiento el nuevo objeto {@link Alojamiento} a asignar
	 */
	public void setAlojamiento(Alojamiento alojamiento) {
		this.alojamiento = alojamiento;
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

	/**
	 * Obtiene la constante correspondiente al estado confirmado.
	 * 
	 * @return la cadena de texto "CONFIRMADA"
	 */
	public static String getConfirmada() {
		return CONFIRMADA;
	}

	/**
	 * Obtiene la constante correspondiente al estado cancelado.
	 * 
	 * @return la cadena de texto "CANCELADA"
	 */
	public static String getCancelada() {
		return CANCELADA;
	}
}