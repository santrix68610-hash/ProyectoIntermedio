package co.edu.unbosque.persistence;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Clase de utilidad encargada de gestionar operaciones básicas de lectura y
 * escritura de archivos de texto plano línea por línea.
 * 
 * @author Universidad El Bosque
 * @version 1.0
 */
public class ArchivoTexto {

	/**
	 * Lee todas las líneas de un archivo de texto plano especificado, omitiendo las
	 * líneas vacías o aquellas que solo contengan espacios en blanco. Si el archivo
	 * no existe, retorna una lista vacía.
	 * 
	 * @param nombreArchivo la ruta o nombre del archivo de texto que se desea leer
	 * @return un {@link ArrayList} de cadenas de texto con las líneas válidas
	 *         leídas del archivo
	 * @throws IOException si ocurre algún error de entrada o salida durante la
	 *                     lectura del archivo
	 */
	public ArrayList<String> leerLineas(String nombreArchivo) throws IOException {
		ArrayList<String> lineas = new ArrayList<String>();
		File archivo = new File(nombreArchivo);

		if (!archivo.exists()) {
			return lineas;
		}

		BufferedReader lector = new BufferedReader(new FileReader(archivo));
		String linea = lector.readLine();

		while (linea != null) {
			if (!linea.trim().isEmpty()) {
				lineas.add(linea);
			}
			linea = lector.readLine();
		}

		lector.close();
		return lineas;
	}

	/**
	 * Escribe una lista de líneas de texto en un archivo plano, guardando cada
	 * elemento en una nueva línea independiente.
	 * 
	 * @param nombreArchivo la ruta o nombre del archivo de texto donde se va a
	 *                      escribir
	 * @param lineas        el {@link ArrayList} de cadenas de texto que se desea
	 *                      almacenar en el archivo
	 * @throws IOException si ocurre algún error de entrada o salida durante la
	 *                     escritura en el archivo
	 */
	public void escribirLineas(String nombreArchivo, ArrayList<String> lineas) throws IOException {
		BufferedWriter escritor = new BufferedWriter(new FileWriter(nombreArchivo));

		for (int i = 0; i < lineas.size(); i++) {
			escritor.write(lineas.get(i));
			escritor.newLine();
		}

		escritor.close();
	}
}