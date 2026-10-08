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
    private List<String> serviciosAdicionales;
    private double tarifaAdicional;

    public AlojamientoDTO(String id, String nombre, String ciudad, String tipo,
            String ubicacion, int capacidad, double precioPorNoche,
            boolean activo, String descripcion,
            List<String> serviciosAdicionales, double tarifaAdicional) {

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

    public AlojamientoDTO(String id, String nombre, String ciudad, String tipo,
            String ubicacion, int capacidad, double precioPorNoche,
            boolean activo, String descripcion) {

        this(id, nombre, ciudad, tipo, ubicacion, capacidad, precioPorNoche,
                activo, descripcion, new ArrayList<String>(), 0.0);
    }

    // Conserva también el constructor que ya existía en el archivo publicado.
    public AlojamientoDTO(double tarifaAdicional, String id, String nombre,
            String ciudad, String tipo, String ubicacion, int capacidad,
            double precioPorNoche, boolean activo, String descripcion,
            List<String> serviciosAdicionales) {

        this(id, nombre, ciudad, tipo, ubicacion, capacidad, precioPorNoche,
                activo, descripcion, serviciosAdicionales, tarifaAdicional);
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
        return serviciosAdicionales;
    }

    public void setServiciosAdicionales(List<String> serviciosAdicionales) {
        this.serviciosAdicionales = new ArrayList<String>();
        if (serviciosAdicionales != null) {
            this.serviciosAdicionales.addAll(serviciosAdicionales);
        }
    }

    public double getTarifaAdicional() {
        return tarifaAdicional;
    }

    public void setTarifaAdicional(double tarifaAdicional) {
        this.tarifaAdicional = tarifaAdicional;
    }
}