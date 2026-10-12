package co.edu.unbosque.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase abstracta que representa de manera genérica un alojamiento dentro del sistema.
 * Contiene los atributos, constructores y métodos comunes para la gestión de alojamientos.
 * 
 * @author Universidad El Bosque
 * @version 1.0
 */
public abstract class Alojamiento {
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

    /**
     * Constructor de la clase Alojamiento.
     * 
     * @param idAlojamiento identificador único del alojamiento
     * @param nombre nombre comercial del alojamiento
     * @param ciudad ciudad donde se encuentra ubicado
     * @param tipo tipo de alojamiento (ej. Hotel, Cabaña, Apartamento)
     * @param ubicacion dirección o ubicación exacta del alojamiento
     * @param capacidad número máximo de huéspedes que puede recibir
     * @param preciopornoche costo por noche de estancia
     * @param activo estado booleano que indica si el alojamiento está disponible u operativo
     * @param descripcion descripción detallada del alojamiento
     * @param serviciosAdicionales lista de servicios adicionales que ofrece
     * @param activo2 representación en texto para el estado activo
     * @param inactivo representación en texto para el estado inactivo
     */
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

    /**
     * Calcula el valor base de la estancia multiplicando el número de noches por el precio por noche.
     * 
     * @param noches cantidad de noches de la reserva
     * @return el valor base calculado de la estancia
     */
    public double calcularValorBase(int noches) {
        return noches * Preciopornoche;
    }

    /**
     * Calcula el valor total de la reserva basado en el número de noches.
     * 
     * @param noches cantidad de noches de la reserva
     * @return el valor total de la reserva
     */
    public double calcularValorReserva(int noches) {
        return calcularValorBase(noches);
    }

    /**
     * Verifica si el alojamiento tiene la capacidad suficiente para recibir un determinado número de huéspedes.
     * 
     * @param numeroHuespedes cantidad de huéspedes a alojar
     * @return true si el número de huéspedes es mayor a cero y menor o igual a la capacidad; false en caso contrario
     */
    public boolean PuedeResivir(int numeroHuespedes) {
        if (numeroHuespedes <= Capacidad && numeroHuespedes > 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Obtiene el identificador único del alojamiento.
     * 
     * @return el ID del alojamiento
     */
    public String getIdAlojamiento() {
        return idAlojamiento;
    }

    /**
     * Establece el identificador único del alojamiento.
     * 
     * @param idAlojamiento el nuevo ID a asignar
     */
    public void setIdAlojamiento(String idAlojamiento) {
        this.idAlojamiento = idAlojamiento;
    }

    /**
     * Obtiene el nombre del alojamiento.
     * 
     * @return el nombre del alojamiento
     */
    public String getNombre() {
        return Nombre;
    }

    /**
     * Establece el nombre del alojamiento.
     * 
     * @param nombre el nuevo nombre a asignar
     */
    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    /**
     * Obtiene la ciudad del alojamiento.
     * 
     * @return la ciudad
     */
    public String getCiudad() {
        return Ciudad;
    }

    /**
     * Establece la ciudad del alojamiento.
     * 
     * @param ciudad la nueva ciudad a asignar
     */
    public void setCiudad(String ciudad) {
        Ciudad = ciudad;
    }

    /**
     * Obtiene el tipo de alojamiento.
     * 
     * @return el tipo de alojamiento
     */
    public String getTipo() {
        return Tipo;
    }

    /**
     * Establece el tipo de alojamiento.
     * 
     * @param tipo el nuevo tipo a asignar
     */
    public void setTipo(String tipo) {
        Tipo = tipo;
    }

    /**
     * Obtiene la ubicación exacta del alojamiento.
     * 
     * @return la ubicación
     */
    public String getUbicacion() {
        return Ubicacion;
    }

    /**
     * Establece la ubicación del alojamiento.
     * 
     * @param ubicacion la nueva ubicación a asignar
     */
    public void setUbicacion(String ubicacion) {
        Ubicacion = ubicacion;
    }

    /**
     * Obtiene la capacidad máxima de huéspedes.
     * 
     * @return la capacidad máxima
     */
    public int getCapacidad() {
        return Capacidad;
    }

    /**
     * Establece la capacidad máxima de huéspedes.
     * 
     * @param capacidad la nueva capacidad a asignar
     */
    public void setCapacidad(int capacidad) {
        Capacidad = capacidad;
    }

    /**
     * Obtiene el precio por noche del alojamiento.
     * 
     * @return el precio por noche
     */
    public double getPreciopornoche() {
        return Preciopornoche;
    }

    /**
     * Establece el precio por noche del alojamiento.
     * 
     * @param preciopornoche el nuevo precio por noche a asignar
     */
    public void setPreciopornoche(double preciopornoche) {
        Preciopornoche = preciopornoche;
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
     * Establece el estado booleano de actividad del alojamiento.
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
        return ServiciosAdicionales;
    }

    /**
     * Establece la lista de servicios adicionales del alojamiento.
     * 
     * @param serviciosAdicionales la nueva lista de servicios a asignar
     */
    public void setServiciosAdicionales(List<String> serviciosAdicionales) {
        ServiciosAdicionales = serviciosAdicionales;
    }

    /**
     * Obtiene la etiqueta de texto para el estado activo.
     * 
     * @return el texto de activo
     */
    public String getActivo() {
        return Activo;
    }

    /**
     * Establece la etiqueta de texto para el estado activo.
     * 
     * @param activo el texto a asignar
     */
    public void setActivo(String activo) {
        Activo = activo;
    }

    /**
     * Obtiene la etiqueta de texto para el estado inactivo.
     * 
     * @return el texto de inactivo
     */
    public String getInactivo() {
        return Inactivo;
    }

    /**
     * Establece la etiqueta de texto para el estado inactivo.
     * 
     * @param inactivo el texto a asignar
     */
    public void setInactivo(String inactivo) {
        Inactivo = inactivo;
    }

    /**
     * Obtiene una representación en texto del estado actual del alojamiento ("ACTIVO" o "INACTIVO").
     * 
     * @return una cadena de texto indicando si está activo o inactivo
     */
    public String getEstado() {
        if (activo) {
            return "ACTIVO";
        } else {
            return "INACTIVO";
        }
    }
}