package co.edu.unbosque.model;

import java.util.ArrayList;
import java.util.List;

abstract class Alojamiento {
    private String idAlojamiento;
    private String Nombre;
    private String Ciudad;
    private String Tipo;
    private String Ubicacion;
    private int Capacidad;
    private double Preciopornoche;
    private boolean activo;
    private String descripcion;
    private List<String> ServiciosAdicionales = new ArrayList<>();
    public String Activo;
    public String Inactivo;
    public Alojamiento(String idAlojamiento, String nombre, String ciudad, String tipo, String ubicacion, int capacidad,
            double preciopornoche, boolean activo, String descripcion, List<String> serviciosAdicionales,
            String activo2, String inactivo) {
        super();
		this.idAlojamiento = idAlojamiento;
		Nombre = nombre;
		Ciudad = ciudad;
		Tipo = tipo;
		Ubicacion = ubicacion;
		Capacidad = capacidad;
		Preciopornoche = preciopornoche;
		this.activo = activo;
		this.descripcion = descripcion;
		ServiciosAdicionales = serviciosAdicionales;
		Activo = activo2;
		Inactivo = inactivo;
    }
    public double calcularValorBase(int noches) {

        return noches*Preciopornoche;
    }
    public double calcularValorReserva(int noches) {

        return calcularValorBase(noches);
        }
    public boolean PuedeResivir(int numeroHuespedes) {

        if(numeroHuespedes <= Capacidad &&  numeroHuespedes > 0) {
            return true;
        }
        else {

        return false;
        }
    }

	public String getIdAlojamiento() {
		return idAlojamiento;
	}
	public void setIdAlojamiento(String idAlojamiento) {
		this.idAlojamiento = idAlojamiento;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getCiudad() {
		return Ciudad;
	}
	public void setCiudad(String ciudad) {
		Ciudad = ciudad;
	}
	public String getTipo() {
		return Tipo;
	}
	public void setTipo(String tipo) {
		Tipo = tipo;
	}
	public String getUbicacion() {
		return Ubicacion;
	}
	public void setUbicacion(String ubicacion) {
		Ubicacion = ubicacion;
	}
	public int getCapacidad() {
		return Capacidad;
	}
	public void setCapacidad(int capacidad) {
		Capacidad = capacidad;
	}
	public double getPreciopornoche() {
		return Preciopornoche;
	}
	public void setPreciopornoche(double preciopornoche) {
		Preciopornoche = preciopornoche;
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
	public String getActivo() {
		return Activo;
	}
	public void setActivo(String activo) {
		Activo = activo;
	}
	public String getInactivo() {
		return Inactivo;
	}
	public void setInactivo(String inactivo) {
		Inactivo = inactivo;
	}
	public String getEstado() {
        if (activo) {
            return "ACTIVO";
        } else {
            return "INACTIVO";
        }
    }
}