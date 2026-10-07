package co.edu.unbosque.model;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

import co.edu.unbosque.persistence.ReservaArchivoDAO;
import co.edu.unbosque.persistence.ReservaDAO;
import co.edu.unbosque.persistence.ReservaDTO;

public class ReservaServicio {
	private ReservaDAO reservaDAO;
    private HuespedServicio huespedServicio;
    private AlojamientoServicio alojamientoServicio;
    private boolean alojamientosCargados;

    public ReservaServicio() {
        reservaDAO = new ReservaArchivoDAO();
        huespedServicio = new HuespedServicio();
        alojamientoServicio = new AlojamientoServicio();
        alojamientosCargados = false;
    }

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

    public ArrayList<ReservaDTO> consultarReservas() throws IOException {
        return reservaDAO.cargarTodas();
    }

    public ReservaDTO buscarPorId(String id) throws IOException {
        if (id == null || id.trim().isEmpty()) {
            return null;
        }

        return reservaDAO.buscarPorId(id.trim());
    }

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