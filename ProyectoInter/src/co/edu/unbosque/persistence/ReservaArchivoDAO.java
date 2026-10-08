package co.edu.unbosque.persistence;

import java.io.IOException;
import java.util.ArrayList;

public class ReservaArchivoDAO implements ReservaDAO {

	private String nombreArchivo = "reservas.txt";
	private ArchivoTexto archivoTexto = new ArchivoTexto();

	private String convertirARegistro(ReservaDTO reserva) {
		return reserva.getId() + ";" + reserva.getIdHuesped() + ";" + reserva.getIdAlojamiento() + ";"
				+ reserva.getFechaLlegada() + ";" + reserva.getFechaSalida() + ";" + reserva.getNumeroHuespedes() + ";"
				+ reserva.getNumeroNoches() + ";" + reserva.getValorTotal() + ";" + reserva.getEstado();
	}

	private boolean textoValido(String texto) {
		return texto != null && !texto.trim().isEmpty();
	}

	@Override
	public ArrayList<ReservaDTO> cargarTodas() throws IOException {
		ArrayList<ReservaDTO> reservas = new ArrayList<ReservaDTO>();
		ArrayList<String> lineas = archivoTexto.leerLineas(nombreArchivo);

		for (String linea : lineas) {
			String[] datos = linea.split(";", -1);

			if (datos.length != 9) {
				continue;
			}

			if (!textoValido(datos[0]) || !textoValido(datos[1]) || !textoValido(datos[2]) || !textoValido(datos[3])
					|| !textoValido(datos[4]) || !textoValido(datos[8])) {
				continue;
			}

			int numeroHuespedes;
			int numeroNoches;
			double valorTotal;

			try {
				numeroHuespedes = Integer.parseInt(datos[5].trim());
				numeroNoches = Integer.parseInt(datos[6].trim());
				valorTotal = Double.parseDouble(datos[7].trim());
			} catch (NumberFormatException e) {
				continue;
			}

			if (numeroHuespedes <= 0 || numeroNoches <= 0 || valorTotal < 0 || Double.isNaN(valorTotal)
					|| Double.isInfinite(valorTotal)) {
				continue;
			}

			ReservaDTO reserva = new ReservaDTO(datos[0].trim(), datos[1].trim(), datos[2].trim(), datos[3].trim(),
					datos[4].trim(), numeroHuespedes, numeroNoches, valorTotal, datos[8].trim());

			reservas.add(reserva);
		}

		return reservas;
	}

	@Override
	public ReservaDTO buscarPorId(String id) throws IOException {
		if (!textoValido(id)) {
			return null;
		}

		ArrayList<ReservaDTO> reservas = cargarTodas();

		for (ReservaDTO reserva : reservas) {
			if (reserva.getId().equals(id.trim())) {
				return reserva;
			}
		}

		return null;
	}

	@Override
	public boolean guardar(ReservaDTO reserva) throws IOException {
		if (reserva == null || !textoValido(reserva.getId())) {
			return false;
		}

		ArrayList<String> lineas = archivoTexto.leerLineas(nombreArchivo);
		String idBuscado = reserva.getId().trim();

		for (String linea : lineas) {
			String[] datos = linea.split(";", -1);

			if (datos.length > 0 && datos[0].trim().equals(idBuscado)) {
				return false;
			}
		}

		lineas.add(convertirARegistro(reserva));
		archivoTexto.escribirLineas(nombreArchivo, lineas);
		return true;
	}

	@Override
	public boolean actualizar(ReservaDTO reserva) throws IOException {
		if (reserva == null || !textoValido(reserva.getId())) {
			return false;
		}

		ArrayList<String> lineas = archivoTexto.leerLineas(nombreArchivo);
		String idBuscado = reserva.getId().trim();
		boolean encontrada = false;

		for (int i = 0; i < lineas.size(); i++) {
			String[] datos = lineas.get(i).split(";", -1);

			if (datos.length == 9 && datos[0].trim().equals(idBuscado)) {
				lineas.set(i, convertirARegistro(reserva));
				encontrada = true;
				break;
			}
		}

		if (!encontrada) {
			return false;
		}

		archivoTexto.escribirLineas(nombreArchivo, lineas);
		return true;
	}
}