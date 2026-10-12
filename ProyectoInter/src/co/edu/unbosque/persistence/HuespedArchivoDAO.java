package co.edu.unbosque.persistence;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Clase de persistencia encargada de gestionar el almacenamiento y recuperación 
 * de los datos de huéspedes en un archivo de texto, implementando la interfaz {@link HuespedDAO}.
 * 
 * @author Universidad El Bosque
 * @version 1.0
 */
public class HuespedArchivoDAO implements HuespedDAO {
	
	/** Nombre del archivo de texto donde se almacenan los registros de huéspedes. */
	private String nombreArchivo = "huespedes.txt";
	
	/** Instancia auxiliar para la lectura y escritura de líneas en archivos de texto. */
	private ArchivoTexto archivoTexto = new ArchivoTexto();

	/**
	 * Convierte un objeto {@link HuespedDTO} en una cadena de texto estructurada con punto y coma (;)
	 * para su posterior almacenamiento en el archivo.
	 * 
	 * @param huesped el objeto {@link HuespedDTO} a convertir
	 * @return una cadena de texto con los atributos del huésped separados por delimitadores
	 */
	private String convertirARegistro(HuespedDTO huesped) {
		return huesped.getId() + ";" + huesped.getNombre() + ";" + huesped.getApellido() + ";" + huesped.getCorreo()
				+ ";" + huesped.getTelefono();
	}

	/**
	 * Carga y lee todos los registros de huéspedes almacenados en el archivo de texto,
	 * validando su estructura de cinco campos y convirtiéndolos en objetos {@link HuespedDTO}.
	 * 
	 * @return un {@link ArrayList} con todos los objetos {@link HuespedDTO} válidos encontrados en el archivo
	 * @throws IOException si ocurre algún error de entrada o salida durante la lectura del archivo
	 */
	@Override
	public ArrayList<HuespedDTO> cargarTodos() throws IOException {
		ArrayList<HuespedDTO> huespedes = new ArrayList<HuespedDTO>();
		ArrayList<String> lineas = archivoTexto.leerLineas(nombreArchivo);

		for (int i = 0; i < lineas.size(); i++) {
			String[] datos = lineas.get(i).split(";", -1);

			if (datos.length == 5) {
				HuespedDTO huesped = new HuespedDTO(datos[0], datos[1], datos[2], datos[3], datos[4]);

				huespedes.add(huesped);
			}
		}

		return huespedes;
	}

	/**
	 * Busca un huésped específico en el archivo de texto a partir de su identificador único.
	 * 
	 * @param id el identificador único del huésped a buscar
	 * @return el objeto {@link HuespedDTO} correspondiente si se encuentra; o null en caso contrario
	 * @throws IOException si ocurre algún error de entrada o salida al leer los datos
	 */
	@Override
	public HuespedDTO buscarPorId(String id) throws IOException {
		ArrayList<HuespedDTO> huespedes = cargarTodos();

		for (int i = 0; i < huespedes.size(); i++) {
			HuespedDTO huesped = huespedes.get(i);

			if (huesped.getId().equals(id)) {
				return huesped;
			}
		}

		return null;
	}

	/**
	 * Verifica que el identificador del huésped no exista previamente en el archivo de texto,
	 * y de no existir, procede a agregarlo y guardarlo de forma persistente.
	 * 
	 * @param huesped el objeto {@link HuespedDTO} que se desea guardar
	 * @return true si el huésped se guardó con éxito; false si el ID ya existe en el registro
	 * @throws IOException si ocurre algún error de entrada o salida durante la lectura o escritura en el archivo
	 */
	@Override
	public boolean guardar(HuespedDTO huesped) throws IOException {
		ArrayList<String> lineas = archivoTexto.leerLineas(nombreArchivo);

		for (int i = 0; i < lineas.size(); i++) {
			String[] datos = lineas.get(i).split(";", -1);

			if (datos.length == 5 && datos[0].equals(huesped.getId())) {
				return false;
			}
		}

		lineas.add(convertirARegistro(huesped));
		archivoTexto.escribirLineas(nombreArchivo, lineas);

		return true;
	}
}