package co.edu.unbosque.persistence;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase de persistencia encargada de gestionar el almacenamiento y recuperación 
 * de los datos de alojamientos en un archivo de texto, implementando la interfaz {@link AlojamientoDAO}.
 * 
 * @author Universidad El Bosque
 * @version 1.0
 */
public class AlojamientoArchivoDAO implements AlojamientoDAO {

	/** Nombre del archivo de texto donde se almacenan los registros de alojamientos. */
	private String nombreArchivo = "alojamientos.txt";
	
	/** Instancia auxiliar para la lectura y escritura de líneas en archivos de texto. */
	private ArchivoTexto archivoTexto = new ArchivoTexto();

	/**
	 * Convierte un objeto {@link AlojamientoDTO} en una cadena de texto estructurada con punto y coma (;)
	 * para su posterior almacenamiento en el archivo.
	 * 
	 * @param alojamiento el objeto {@link AlojamientoDTO} a convertir
	 * @return una cadena de texto con los atributos del alojamiento separados por delimitadores
	 */
	private String convertirARegistro(AlojamientoDTO alojamiento) {
		String servicios = "";
		List<String> listaServicios = alojamiento.getServiciosAdicionales();

		if (listaServicios != null) {
			for (int i = 0; i < listaServicios.size(); i++) {
				if (i > 0) {
					servicios += ",";
				}
				servicios += listaServicios.get(i);
			}
		}

		return alojamiento.getId() + ";" + alojamiento.getNombre() + ";" + alojamiento.getCiudad() + ";"
				+ alojamiento.getTipo() + ";" + alojamiento.getUbicacion() + ";" + alojamiento.getCapacidad() + ";"
				+ alojamiento.getPrecioPorNoche() + ";" + alojamiento.isActivo() + ";" + alojamiento.getDescripcion()
				+ ";" + alojamiento.getTarifaAdicional() + ";" + servicios;
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
	 * Carga y lee todos los registros de alojamientos almacenados en el archivo de texto,
	 * validando su formato, tipos de datos y convirtiéndolos en objetos {@link AlojamientoDTO}.
	 * 
	 * @return un {@link ArrayList} con todos los objetos {@link AlojamientoDTO} válidos encontrados en el archivo
	 * @throws IOException si ocurre algún error de entrada o salida durante la lectura del archivo
	 */
	@Override
	public ArrayList<AlojamientoDTO> cargarTodos() throws IOException {
		ArrayList<AlojamientoDTO> alojamientos = new ArrayList<AlojamientoDTO>();
		ArrayList<String> lineas = archivoTexto.leerLineas(nombreArchivo);

		for (String linea : lineas) {
			String[] datos = linea.split(";", -1);

			if (datos.length != 11 && datos.length != 9) {
				continue;
			}

			if (!textoValido(datos[0]) || !textoValido(datos[1]) || !textoValido(datos[2]) || !textoValido(datos[3])
					|| !textoValido(datos[4])) {
				continue;
			}

			String activoTexto = datos[7].trim();

			if (!activoTexto.equalsIgnoreCase("true") && !activoTexto.equalsIgnoreCase("false")) {
				continue;
			}

			int capacidad;
			double precioPorNoche;
			double tarifaAdicional = 0.0;

			try {
				capacidad = Integer.parseInt(datos[5].trim());
				precioPorNoche = Double.parseDouble(datos[6].trim());

				if (datos.length == 11) {
					tarifaAdicional = Double.parseDouble(datos[9].trim());
				}
			} catch (NumberFormatException e) {
				continue;
			}

			if (capacidad <= 0 || precioPorNoche < 0 || tarifaAdicional < 0 || Double.isNaN(precioPorNoche)
					|| Double.isInfinite(precioPorNoche) || Double.isNaN(tarifaAdicional)
					|| Double.isInfinite(tarifaAdicional)) {
				continue;
			}

			boolean activo = Boolean.parseBoolean(activoTexto);
			ArrayList<String> servicios = new ArrayList<String>();

			if (datos.length == 11 && !datos[10].trim().isEmpty()) {
				String[] serviciosLeidos = datos[10].split(",");

				for (String servicio : serviciosLeidos) {
					if (!servicio.trim().isEmpty()) {
						servicios.add(servicio.trim());
					}
				}
			}

			AlojamientoDTO alojamiento = new AlojamientoDTO(datos[0].trim(), datos[1].trim(), datos[2].trim(),
					datos[3].trim(), datos[4].trim(), capacidad, precioPorNoche, activo, datos[8].trim(), servicios,
					tarifaAdicional);

			alojamientos.add(alojamiento);
		}

		return alojamientos;
	}

	/**
	 * Busca un alojamiento específico en el archivo de texto a partir de su identificador único.
	 * 
	 * @param id el identificador único del alojamiento a buscar
	 * @return el objeto {@link AlojamientoDTO} correspondiente si se encuentra; o null en caso contrario
	 * @throws IOException si ocurre algún error de entrada o salida al leer los datos
	 */
	@Override
	public AlojamientoDTO buscarPorId(String id) throws IOException {
		if (id == null || id.trim().isEmpty()) {
			return null;
		}

		ArrayList<AlojamientoDTO> alojamientos = cargarTodos();

		for (AlojamientoDTO alojamiento : alojamientos) {
			if (alojamiento.getId().equalsIgnoreCase(id.trim())) {
				return alojamiento;
			}
		}

		return null;
	}

	/**
	 * Valida que el alojamiento sea válido y que su identificador no exista previamente,
	 * procediendo a agregarlo y guardarlo en el archivo de texto.
	 * 
	 * @param alojamiento el objeto {@link AlojamientoDTO} que se desea guardar
	 * @return true si el alojamiento se guardó con éxito; false si el objeto es nulo, inválido o el ID ya existe
	 * @throws IOException si ocurre algún error de entrada o salida durante la escritura en el archivo
	 */
	@Override
	public boolean guardar(AlojamientoDTO alojamiento) throws IOException {
		if (alojamiento == null || !textoValido(alojamiento.getId())) {
			return false;
		}

		ArrayList<String> lineas = archivoTexto.leerLineas(nombreArchivo);
		String idBuscado = alojamiento.getId().trim();

		for (String linea : lineas) {
			String[] datos = linea.split(";", -1);

			if (datos.length > 0 && datos[0].trim().equalsIgnoreCase(idBuscado)) {
				return false;
			}
		}

		lineas.add(convertirARegistro(alojamiento));
		archivoTexto.escribirLineas(nombreArchivo, lineas);
		return true;
	}
}