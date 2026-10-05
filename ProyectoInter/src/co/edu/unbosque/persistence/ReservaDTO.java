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
	private String idHuesped;
	private String idAlojamiento;


	public ReservaDTO(String id, Huesped huesped, AlojamientoDTO alojamiento, String fechaLlegada, String fechaSalida,
			int numeroHuespedes, int numeroNoches, double valorTotal, String estado, Object getHuesped,
			String idHuesped, String idAlojamiento) {
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
		this.getHuesped = getHuesped;
		this.idHuesped = idHuesped;
		this.idAlojamiento = idAlojamiento;
	}
	
	public ReservaDTO(String string, String string2, String string3, String string4, String string5, int int1, int int2,
			double double1, String string6) {
		// TODO Auto-generated constructor stub
	}

	public String getIdHuesped() {
		return idHuesped;
	}

	public void setIdHuesped(String idHuesped) {
		this.idHuesped = idHuesped;
	}

	public String getIdAlojamiento() {
		return idAlojamiento;
	}

	public void setIdAlojamiento(String idAlojamiento) {
		this.idAlojamiento = idAlojamiento;
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
