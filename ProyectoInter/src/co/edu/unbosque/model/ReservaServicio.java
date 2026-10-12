
package co.edu.unbosque.model;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

import co.edu.unbosque.persistence.ReservaArchivoDAO;
import co.edu.unbosque.persistence.ReservaDAO;
import co.edu.unbosque.persistence.ReservaDTO;

/**
 * Clase de servicio encargada de la lógica de negocio relacionada con las reservas,
 * incluyendo la validación de datos, verificación de disponibilidad, cálculo de costos,
 * creación, consulta y cancelación de reservas.
 * 
 * @author Universidad El Bosque
 * @version 1.0
 */
public class ReservaServicio {
	
	private ReservaDAO reservaDAO;
    private HuespedServicio huespedServicio;
    private AlojamientoServicio alojamientoServicio;
    private boolean alojamientosCargados;

    /**
     * Constructor de la clase ReservaServicio.
     * Inicializa el objeto de acceso a datos de reservas, los servicios requeridos de huéspedes
     * y alojamientos, y establece la bandera de control de carga en falso.
     */
    public ReservaServicio() {
        reservaDAO = new ReservaArchivoDAO();
        huespedServicio = new HuespedServicio();
        alojamientoServicio = new AlojamientoServicio();
        alojamientosCargados = false;
    }

    /**
     * Valida los parámetros de entrada, verifica la existencia del huésped y la disponibilidad del alojamiento,
     * calcula el valor total de la estancia y registra la nueva reserva en el sistema.
     * 
     * @param id identificador único de la reserva
     * @param idHuesped identificador único del huésped que realiza la reserva
     * @param idAlojamiento identificador único del alojamiento a reservar
     * @param fechaLlegada fecha de llegada en formato de texto (ej. AAAA-MM-DD)
     * @param fechaSalida fecha de salida en formato de texto (ej. AAAA-MM-DD)
     * @param numeroHuespedes cantidad de huéspedes que ocuparán el alojamiento
     * @param numeroNoches número total de noches de la estancia
     * @return true si la reserva se crea y guarda exitosamente; false si hay datos inválidos, fechas erróneas, huésped no encontrado o alojamiento inactivo/sin capacidad
     * @throws IOException si ocurre algún error de entrada o salida durante la validación o almacenamiento
     */
    public boolean crearReserva(
            String id,
            String idHuesped,
            String idAlojamiento,
            String fechaLlegada,
            String fechaSalida,
            int numeroHuespedes,
            int numeroNoches) throws IOException {

        if (id == null || id.trim().isEmpty()
                || idHuesped == null || idHuesped.trim().isEmpty()
                || idAlojamiento == null || idAlojamiento.trim().isEmpty()
                || fechaLlegada == null || fechaLlegada.trim().isEmpty()
                || fechaSalida == null || fechaSalida.trim().isEmpty()
                || numeroHuespedes <= 0
                || numeroNoches <= 0) {
            return false;
        }

        if (!fechasValidas(fechaLlegada, fechaSalida)) {
            return false;
        }

        Huesped huesped = huespedServicio.buscarPorId(idHuesped);

        if (huesped == null) {
            return false;
        }

        if (!alojamientosCargados) {
            alojamientoServicio.cargarDatosIniciales();
            alojamientosCargados = true;
        }

        Alojamiento alojamiento =
                alojamientoServicio.consultarDetalle(idAlojamiento);

        if (alojamiento == null || !alojamiento.isActivo()) {
            return false;
        }

        if (!alojamiento.PuedeResivir(numeroHuespedes)) {
            return false;
        }

        double valorTotal =
                alojamiento.calcularValorReserva(numeroNoches);

        ReservaDTO reserva = new ReservaDTO(
                id.trim(),
                idHuesped.trim(),
                idAlojamiento.trim(),
                fechaLlegada.trim(),
                fechaSalida.trim(),
                numeroHuespedes,
                numeroNoches,
                valorTotal,
                Reserva.CONFIRMADA
        );

        return reservaDAO.guardar(reserva);
    }

    /**
     * Valida que las fechas ingresadas tengan un formato correcto y que la fecha de salida sea posterior a la de llegada.
     * 
     * @param fechaLlegada fecha de llegada a validar
     * @param fechaSalida fecha de salida a validar
     * @return true si el formato es correcto y la fecha de salida es posterior a la de llegada; false en caso contrario
     */
    private boolean fechasValidas(
            String fechaLlegada, String fechaSalida) {
        try {
            LocalDate llegada = LocalDate.parse(fechaLlegada.trim());
            LocalDate salida = LocalDate.parse(fechaSalida.trim());

            return salida.isAfter(llegada);
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    /**
     * Consulta y retorna una lista con todas las reservas registradas en el sistema.
     * 
     * @return un {@link ArrayList} de objetos {@link ReservaDTO} con todas las reservas almacenadas
     * @throws IOException si ocurre algún error de entrada o salida al cargar los datos desde la persistencia
     */
    public ArrayList<ReservaDTO> consultarReservas() throws IOException {
        return reservaDAO.cargarTodas();
    }

    /**
     * Busca y retorna una reserva específica a partir de su identificador único.
     * 
     * @param id el identificador único de la reserva a buscar
     * @return el objeto {@link ReservaDTO} correspondiente si se encuentra; o null en caso contrario
     * @throws IOException si ocurre algún error de entrada o salida al consultar los datos
     */
    public ReservaDTO buscarPorId(String id) throws IOException {
        if (id == null || id.trim().isEmpty()) {
            return null;
        }

        return reservaDAO.buscarPorId(id.trim());
    }

    /**
     * Cancela una reserva existente cambiando su estado a "CANCELADA", 
     * siempre y cuando la reserva exista y no se encuentre cancelada previamente.
     * 
     * @param id el identificador único de la reserva que se desea cancelar
     * @return true si la reserva fue encontrada, no estaba cancelada y se actualizó correctamente; false en caso contrario
     * @throws IOException si ocurre algún error de entrada o salida durante la actualización en la persistencia
     */
    public boolean cancelarReserva(String id) throws IOException {
        if (id == null || id.trim().isEmpty()) {
            return false;
        }

        ReservaDTO reserva = reservaDAO.buscarPorId(id.trim());

        if (reserva == null) {
            return false;
        }

        if (Reserva.CANCELADA.equals(reserva.getEstado())) {
            return false;
        }

        reserva.setEstado(Reserva.CANCELADA);
        return reservaDAO.actualizar(reserva);
    }
}