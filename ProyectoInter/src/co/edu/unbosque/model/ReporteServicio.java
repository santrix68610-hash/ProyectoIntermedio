
package co.edu.unbosque.model;

import java.util.ArrayList;

import co.edu.unbosque.persistence.ReservaDTO;

/**
 * Clase de servicio encargada de generar reportes y estadísticas sobre las reservas del sistema,
 * tales como el conteo de reservas según su estado (confirmadas o canceladas) y el cálculo de ingresos financieros.
 * 
 * @author Universidad El Bosque
 * @version 1.0
 */
public class ReporteServicio {

	/**
	 * Cuenta el número total de reservas que se encuentran en estado confirmado dentro de la lista proporcionada.
	 * 
	 * @param reservas la lista de objetos {@link ReservaDTO} a evaluar
	 * @return el número total de reservas confirmadas
	 */
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

	/**
	 * Cuenta el número total de reservas que se encuentran en estado cancelado dentro de la lista proporcionada.
	 * 
	 * @param reservas la lista de objetos {@link ReservaDTO} a evaluar
	 * @return el número total de reservas canceladas
	 */
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

	/**
	 * Calcula el valor monetario total de los ingresos generados únicamente por las reservas confirmadas.
	 * 
	 * @param reservas la lista de objetos {@link ReservaDTO} a evaluar
	 * @return el monto total acumulado de los ingresos de las reservas confirmadas
	 */
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