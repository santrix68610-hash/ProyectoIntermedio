package co.edu.unbosque.model;

import java.util.ArrayList;

import co.edu.unbosque.persistence.ReservaDTO;

public class ReporteServicio {
	public int contarReservasConfirmadas(ArrayList<ReservaDTO> reservas) {
		int total = 0;

		if (reservas == null) {
			return total;
		}

		for (int i = 0; i < reservas.size(); i++) {
			if (Reserva.CONFIRMADA.equals(reservas.get(i).getEstado())) {
				total++;
			}
		}

		return total;
	}

	public int contarReservasCanceladas(ArrayList<ReservaDTO> reservas) {
		int total = 0;

		if (reservas == null) {
			return total;
		}

		for (int i = 0; i < reservas.size(); i++) {
			if (Reserva.CANCELADA.equals(reservas.get(i).getEstado())) {
				total++;
			}
		}

		return total;
	}

	public double calcularIngresosConfirmados(ArrayList<ReservaDTO> reservas) {
		double ingresos = 0;

		if (reservas == null) {
			return ingresos;
		}

		for (int i = 0; i < reservas.size(); i++) {
			ReservaDTO reserva = reservas.get(i);

			if (Reserva.CONFIRMADA.equals(reserva.getEstado())) {
				ingresos = ingresos + reserva.getValorTotal();
			}
		}

		return ingresos;
	}
}
