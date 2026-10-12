package co.edu.unbosque.persistence;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Clase de persistencia encargada de gestionar el almacenamiento, recuperación 
 * y actualización de los registros de reservas en un archivo de texto, implementando la interfaz {@link ReservaDAO}.
 * 
 * @author Universidad El Bosque
 * @version 1.0
 */
public class ReservaArchivoDAO implements ReservaDAO {

	/** Nombre del archivo de texto donde se almacenan los registros de reservas. */
	private String nombreArchivo = "reservas.txt";
	
	/** Instancia auxiliar para la lectura y escritura de líneas en archivos de texto. */
	private ArchivoTexto archivoTexto = new ArchivoTexto();

	/**
	 * Convierte un objeto {@link ReservaDTO} en una cadena de texto estructurada con punto y coma (;)
	 * para su posterior almacenamiento en el archivo.
	 * 
	 * @param reserva el objeto {@link ReservaDTO} a convertir
	 * @return una cadena de texto con los atributos de la reserva separados por delimitadores
	 */
	private String convertirARegistro(ReservaDTO reserva) {
		return reserva.getId() + ";" + reserva.getIdHuesped() + ";" + reserva.getIdAlojamiento() + ";"
				+ reserva.getFechaLlegada() + ";" + reserva.getFechaSalida() + ";" + reserva.getNumeroHuespedes() + ";"
				+ reserva.getNumeroNoches() + ";" + reserva.getValorTotal() + ";" + reserva.getEstado();
	}

	/**
	 * Valida que una cadena de texto no sea nula ni contenga únicamente espacios en blanco.
	 * 
	 * @param texto la cadena de texto a validar
	 * @return true si el texto es válido y no está vacío; false en caso contrario
	 */
	private boolean textoValido(String texto) {
		return texto != null && !texto.trim().isEmpty();
	}

	/**
	 * Carga y lee todos los registros de reservas almacenados en el archivo de texto,
	 * validando su estructura, formato numérico y convirtiéndolos en objetos {@link ReservaDTO}.
	 * 
	 * @return un {@link ArrayList} con todos los objetos {@link ReservaDTO} válidos encontrados en el archivo
	 * @throws IOException si ocurre algún error de entrada o salida durante la lectura del archivo
	 */
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

	/**
	 * Busca una reserva específica en el archivo de texto a partir de su identificador único.
	 * 
	 * @param id el identificador único de la reserva a buscar
	 * @return el objeto {@link ReservaDTO} correspondiente si se encuentra; o null en caso contrario
	 * @throws IOException si ocurre algún error de entrada o salida al leer los datos
	 */
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

	/**
	 * Valida que la reserva sea válida y que su identificador no exista previamente,
	 * procediendo a agregarla y guardarla en el archivo de texto.
	 * 
	 * @param reserva el objeto {@link ReservaDTO} que se desea guardar
	 * @return true si la reserva se guardó con éxito; false si el objeto es nulo, inválido o el ID ya existe
	 * @throws IOException si ocurre algún error de entrada o salida durante la escritura en el archivo
	 */
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

	/**
	 * Actualiza un registro de reserva existente en el archivo de texto a partir del identificador de la reserva.
	 * 
	 * @param reserva el objeto {@link ReservaDTO} con los datos actualizados
	 * @return true si la reserva fue encontrada y actualizada con éxito; false en caso contrario
	 * @throws IOException si ocurre algún error de entrada o salida durante la modificación del archivo
	 */
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