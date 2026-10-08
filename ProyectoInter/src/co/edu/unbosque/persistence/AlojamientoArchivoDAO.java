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

	private boolean textoValido(String texto) {
		return texto != null && !texto.trim().isEmpty();
	}

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