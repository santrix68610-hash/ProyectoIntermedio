package co.edu.unbosque.model;

import java.io.IOException;
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

	public boolean crearReserva(String id, String idHuesped, String idAlojamiento, String fechaLlegada,
			String fechaSalida, int numeroHuespedes, int numeroNoches) throws IOException {

		if (id == null || id.trim().isEmpty() || fechaLlegada == null || fechaSalida == null || numeroNoches <= 0) {
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

		Alojamiento alojamiento = alojamientoServicio.consultarDetalle(idAlojamiento);

		if (alojamiento == null || !alojamiento.isActivo()) {
			return false;
		}

		if (!alojamiento.PuedeResivir(numeroHuespedes)) {
			return false;
		}

		double valorTotal = alojamiento.calcularValorReserva(numeroNoches);

		ReservaDTO reserva = new ReservaDTO(id, idHuesped, idAlojamiento, fechaLlegada, fechaSalida, numeroHuespedes,
				numeroNoches, valorTotal, Reserva.CONFIRMADA);

		return reservaDAO.guardar(reserva);
	}

	public ArrayList<ReservaDTO> consultarReservas() throws IOException {
		return reservaDAO.cargarTodas();
	}

	public ReservaDTO buscarPorId(String id) throws IOException {
		return reservaDAO.buscarPorId(id);
	}

	public boolean cancelarReserva(String id) throws IOException {
		ReservaDTO reserva = reservaDAO.buscarPorId(id);

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
