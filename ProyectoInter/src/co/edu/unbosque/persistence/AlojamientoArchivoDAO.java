package co.edu.unbosque.persistence;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AlojamientoArchivoDAO implements AlojamientoDAO {

	private String nombreArchivo = "alojamientos.txt";
	private ArchivoTexto archivoTexto = new ArchivoTexto();

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

	@Override
	public ArrayList<AlojamientoDTO> cargarTodos() throws IOException {
		ArrayList<AlojamientoDTO> alojamientos = new ArrayList<AlojamientoDTO>();
		ArrayList<String> lineas = archivoTexto.leerLineas(nombreArchivo);

		for (String linea : lineas) {
			String[] datos = linea.split(";", -1);

			if (datos.length == 11) {
				ArrayList<String> servicios = new ArrayList<String>();

				if (!datos[10].trim().isEmpty()) {
					String[] serviciosLeidos = datos[10].split(",");

					for (String servicio : serviciosLeidos) {
						servicios.add(servicio);
					}
				}

				AlojamientoDTO alojamiento = new AlojamientoDTO(datos[0], datos[1], datos[2], datos[3], datos[4],
						Integer.parseInt(datos[5]), Double.parseDouble(datos[6]), Boolean.parseBoolean(datos[7]),
						datos[8], servicios, Double.parseDouble(datos[9]));

				alojamientos.add(alojamiento);

			} else if (datos.length == 9) {
				AlojamientoDTO alojamiento = new AlojamientoDTO(datos[0], datos[1], datos[2], datos[3], datos[4],
						Integer.parseInt(datos[5]), Double.parseDouble(datos[6]), Boolean.parseBoolean(datos[7]),
						datos[8], new ArrayList<String>(), 0.0);

				alojamientos.add(alojamiento);
			}
		}

		return alojamientos;
	}

	@Override
	public AlojamientoDTO buscarPorId(String id) throws IOException {
		ArrayList<AlojamientoDTO> alojamientos = cargarTodos();

		for (AlojamientoDTO alojamiento : alojamientos) {
			if (alojamiento.getId().equals(id)) {
				return alojamiento;
			}
		}

		return null;
	}

	@Override
	public boolean guardar(AlojamientoDTO alojamiento) throws IOException {
		ArrayList<String> lineas = archivoTexto.leerLineas(nombreArchivo);

		for (String linea : lineas) {
			String[] datos = linea.split(";", -1);

			if (datos.length > 0 && datos[0].equals(alojamiento.getId())) {
				return false;
			}
		}

		lineas.add(convertirARegistro(alojamiento));
		archivoTexto.escribirLineas(nombreArchivo, lineas);
		return true;
	}
}