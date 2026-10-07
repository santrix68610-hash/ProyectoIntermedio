package co.edu.unbosque.persistence;

import java.io.IOException;
import java.util.ArrayList;

public class HuespedArchivoDAO implements HuespedDAO {
	private String nombreArchivo = "huespedes.txt";
	private ArchivoTexto archivoTexto = new ArchivoTexto();

	private String convertirARegistro(HuespedDTO huesped) {
		return huesped.getId() + ";" + huesped.getNombre() + ";" + huesped.getApellido() + ";" + huesped.getCorreo()
				+ ";" + huesped.getTelefono();
	}

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
