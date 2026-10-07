package co.edu.unbosque.model;

import java.io.IOException;
import java.util.ArrayList;

import co.edu.unbosque.persistence.AlojamientoArchivoDAO;
import co.edu.unbosque.persistence.AlojamientoDAO;
import co.edu.unbosque.persistence.AlojamientoDTO;
import co.edu.unbosque.persistence.DataMapper;

public class AlojamientoServicio {

	private AlojamientoDAO alojamientoDAO;
	private DataMapper dataMapper;
	private ArrayList<Alojamiento> alojamientos;

	public AlojamientoServicio() {
		alojamientoDAO = new AlojamientoArchivoDAO();
		dataMapper = new DataMapper();
		alojamientos = new ArrayList<Alojamiento>();
	}

	public void cargarDatosIniciales() throws IOException {
		alojamientos.clear();

		ArrayList<AlojamientoDTO> listaDTO = alojamientoDAO.cargarTodos();

		for (int i = 0; i < listaDTO.size(); i++) {
			Alojamiento alojamiento = dataMapper.convertirAAlojamiento(listaDTO.get(i));

			if (alojamiento != null) {
				alojamientos.add(alojamiento);
			}
		}
	}

	public ArrayList<Alojamiento> listarTodos() {
		return new ArrayList<Alojamiento>(alojamientos);
	}

	public ArrayList<Alojamiento> buscar(String ciudad, String tipo, int numeroHuespedes) {

		ArrayList<Alojamiento> encontrados = new ArrayList<Alojamiento>();

		for (int i = 0; i < alojamientos.size(); i++) {
			Alojamiento alojamiento = alojamientos.get(i);

			boolean coincideCiudad = true;
			boolean coincideTipo = true;
			boolean tieneCapacidad = true;

			if (ciudad != null && !ciudad.trim().isEmpty()) {
				coincideCiudad = alojamiento.getCiudad().equalsIgnoreCase(ciudad.trim());
			}

			if (tipo != null && !tipo.trim().isEmpty()) {
				coincideTipo = alojamiento.getTipo().equalsIgnoreCase(tipo.trim());
			}

			if (numeroHuespedes > 0) {
				tieneCapacidad = alojamiento.PuedeResivir(numeroHuespedes);
			}

			if (coincideCiudad && coincideTipo && tieneCapacidad) {
				encontrados.add(alojamiento);
			}
		}

		return encontrados;
	}

	public Alojamiento consultarDetalle(String id) {
		for (int i = 0; i < alojamientos.size(); i++) {
			Alojamiento alojamiento = alojamientos.get(i);

			if (alojamiento.getIdAlojamiento().equals(id)) {
				return alojamiento;
			}
		}

		return null;
	}
}