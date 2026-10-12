package co.edu.unbosque.model;

import java.io.IOException;
import java.util.ArrayList;

import co.edu.unbosque.persistence.AlojamientoArchivoDAO;
import co.edu.unbosque.persistence.AlojamientoDAO;
import co.edu.unbosque.persistence.AlojamientoDTO;
import co.edu.unbosque.persistence.DataMapper;

/**
 * Clase de servicio encargada de la lógica de negocio relacionada con los alojamientos,
 * incluyendo la carga inicial de datos, listado, búsqueda avanzada por filtros y consulta de detalles.
 * 
 * @author Universidad El Bosque
 * @version 1.0
 */
public class AlojamientoServicio {

	private AlojamientoDAO alojamientoDAO;
	private DataMapper dataMapper;
	private ArrayList<Alojamiento> alojamientos;

	/**
	 * Constructor de la clase AlojamientoServicio.
	 * Inicializa el objeto de acceso a datos (DAO), el mapeador de datos y la lista en memoria de alojamientos.
	 */
	public AlojamientoServicio() {
		alojamientoDAO = new AlojamientoArchivoDAO();
		dataMapper = new DataMapper();
		alojamientos = new ArrayList<Alojamiento>();
	}

	/**
	 * Carga los datos iniciales de los alojamientos desde la capa de persistencia,
	 * limpiando la lista actual y convirtiendo los DTOs en objetos de tipo {@link Alojamiento}.
	 * 
	 * @throws IOException si ocurre algún error de entrada o salida al cargar los datos desde el archivo
	 */
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

	/**
	 * Retorna una copia de la lista con todos los alojamientos almacenados en memoria.
	 * 
	 * @return un {@link ArrayList} con todos los alojamientos registrados
	 */
	public ArrayList<Alojamiento> listarTodos() {
		return new ArrayList<Alojamiento>(alojamientos);
	}

	/**
	 * Busca alojamientos que coincidan con los criterios especificados (ciudad, tipo, capacidad mínima y precio máximo).
	 * Los parámetros vacíos, nulos o con valores menores o iguales a cero son ignorados en el filtro.
	 * 
	 * @param ciudad ciudad donde se desea buscar el alojamiento (puede ser nula o vacía para ignorar)
	 * @param tipo tipo de alojamiento (puede ser nulo o vacío para ignorar)
	 * @param capacidadMinima capacidad mínima de huéspedes requerida (0 o menor para ignorar)
	 * @param precioMaximo precio máximo por noche permitido (0 o menor para ignorar)
	 * @return una lista con los alojamientos que cumplen con los criterios de búsqueda
	 */
	public ArrayList<Alojamiento> buscar(String ciudad, String tipo, int capacidadMinima, double precioMaximo) {

		ArrayList<Alojamiento> encontrados = new ArrayList<Alojamiento>();

		for (int i = 0; i < alojamientos.size(); i++) {
			Alojamiento alojamiento = alojamientos.get(i);

			boolean coincideCiudad = ciudad == null || ciudad.trim().isEmpty()
					|| alojamiento.getCiudad().equalsIgnoreCase(ciudad.trim());

			boolean coincideTipo = tipo == null || tipo.trim().isEmpty()
					|| alojamiento.getTipo().equalsIgnoreCase(tipo.trim());

			boolean cumpleCapacidad = capacidadMinima <= 0 || alojamiento.getCapacidad() >= capacidadMinima;

			boolean cumplePrecio = precioMaximo <= 0 || alojamiento.getPreciopornoche() <= precioMaximo;

			if (coincideCiudad && coincideTipo && cumpleCapacidad && cumplePrecio) {
				encontrados.add(alojamiento);
			}
		}

		return encontrados;
	}

	/**
	 * Consulta y retorna un alojamiento específico buscando por su identificador único.
	 * 
	 * @param id el identificador único del alojamiento a buscar
	 * @return el objeto {@link Alojamiento} correspondiente si se encuentra; o null en caso contrario
	 */
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