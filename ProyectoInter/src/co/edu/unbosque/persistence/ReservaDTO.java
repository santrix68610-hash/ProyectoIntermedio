package co.edu.unbosque.persistence;

import co.edu.unbosque.model.Huesped;

public class ReservaDTO {

	public static final String CONFIRMADA = "CONFIRMADA";
	public static final String CANCELADA = "CANCELADA";

	private String id;
	private Huesped huesped;
	private AlojamientoDTO alojamiento;
	private String fechaLlegada;
	private String fechaSalida;
	private int numeroHuespedes;
	private int numeroNoches;
	private double valorTotal;
	private String estado;
	public Object getHuesped;

	public ReservaDTO(String id, Huesped huesped, AlojamientoDTO alojamiento, String fechaLlegada, String fechaSalida,
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
	public Object getGetHuesped() {
		return getHuesped;
	}
	public void setGetHuesped(Object getHuesped) {
		this.getHuesped = getHuesped;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Huesped getHuesped() {
		return huesped;
	}
	public void setHuesped(Huesped huesped) {
		this.huesped = huesped;
	}
	public AlojamientoDTO getAlojamiento() {
		return alojamiento;
	}
	public void setAlojamiento(AlojamientoDTO alojamiento) {
		this.alojamiento = alojamiento;
	}
	public String getFechaLlegada() {
		return fechaLlegada;
	}
	public void setFechaLlegada(String fechaLlegada) {
		this.fechaLlegada = fechaLlegada;
	}
	public String getFechaSalida() {
		return fechaSalida;
	}
	public void setFechaSalida(String fechaSalida) {
		this.fechaSalida = fechaSalida;
	}
	public int getNumeroHuespedes() {
		return numeroHuespedes;
	}
	public void setNumeroHuespedes(int numeroHuespedes) {
		this.numeroHuespedes = numeroHuespedes;
	}
	public int getNumeroNoches() {
		return numeroNoches;
	}
	public void setNumeroNoches(int numeroNoches) {
		this.numeroNoches = numeroNoches;
	}
	public double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public static String getConfirmada() {
		return CONFIRMADA;
	}
	public static String getCancelada() {
		return CANCELADA;
	}
	public String getidAlojamiento() {
		// TODO Auto-generated method stub
		return null;
	}
	


}
