package co.edu.unbosque.persistence;

import java.util.ArrayList;
import java.util.List;

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
    private List<String> ServiciosAdicionales = new ArrayList<>();

	public AlojamientoDTO(String id, String nombre, String ciudad, String tipo, String ubicacion, int capacidad,
			double precioPorNoche, boolean activo, String descripcion, List<String> serviciosAdicionales) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.ciudad = ciudad;
		this.tipo = tipo;
		this.ubicacion = ubicacion;
		this.capacidad = capacidad;
		this.precioPorNoche = precioPorNoche;
		this.activo = activo;
		this.descripcion = descripcion;
		ServiciosAdicionales = serviciosAdicionales;
		this.ServiciosAdicionales = new ArrayList<>();
		if (serviciosAdicionales != null) {
		    this.ServiciosAdicionales.addAll(serviciosAdicionales);
		}
	}
	public AlojamientoDTO(String string, String string2, String string3, String string4, String string5, int int1,
			double double1, boolean boolean1, String string6) {
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	public int getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	public double getPrecioPorNoche() {
		return precioPorNoche;
	}
	public void setPrecioPorNoche(double precioPorNoche) {
		this.precioPorNoche = precioPorNoche;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public List<String> getServiciosAdicionales() {
		return ServiciosAdicionales;
	}
	public void setServiciosAdicionales(List<String> serviciosAdicionales) {
		ServiciosAdicionales = serviciosAdicionales;
	}

}
