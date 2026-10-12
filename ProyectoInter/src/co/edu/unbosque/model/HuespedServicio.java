
package co.edu.unbosque.model;

import java.io.IOException;
import java.util.ArrayList;

import co.edu.unbosque.persistence.DataMapper;
import co.edu.unbosque.persistence.HuespedArchivoDAO;
import co.edu.unbosque.persistence.HuespedDAO;
import co.edu.unbosque.persistence.HuespedDTO;

/**
 * Clase de servicio encargada de la lógica de negocio relacionada con los huéspedes,
 * incluyendo las validaciones de registro, búsqueda por identificador y consulta general de todos los registros.
 * 
 * @author Universidad El Bosque
 * @version 1.0
 */
public class HuespedServicio {
	
	private HuespedDAO huespedDAO;
	private DataMapper dataMapper;

	/**
	 * Constructor de la clase HuespedServicio.
	 * Inicializa el objeto de acceso a datos (DAO) y el mapeador de datos para los huéspedes.
	 */
	public HuespedServicio() {
		huespedDAO = new HuespedArchivoDAO();
		dataMapper = new DataMapper();
	}

	/**
	 * Valida que los datos del huésped sean correctos y completos, verifica que el identificador no exista previamente
	 * y procede a registrarlo y almacenarlo en la capa de persistencia.
	 * 
	 * @param huesped el objeto {@link Huesped} que se desea registrar
	 * @return true si el huésped se registró y guardó exitosamente; false si hay datos incompletos, vacíos o el ID ya existe
	 * @throws IOException si ocurre algún error de entrada o salida durante la validación o almacenamiento
	 */
	public boolean registrarHuesped(Huesped huesped) throws IOException {
		if (huesped == null || huesped.getId() == null || huesped.getId().trim().isEmpty()
				|| huesped.getNombre() == null || huesped.getNombre().trim().isEmpty() || huesped.getApellido() == null
				|| huesped.getApellido().trim().isEmpty() || huesped.getCorreo() == null
				|| huesped.getCorreo().trim().isEmpty() || huesped.getTelefono() == null
				|| huesped.getTelefono().trim().isEmpty()) {
			return false;
		}

		String id = huesped.getId().trim();

		if (huespedDAO.buscarPorId(id) != null) {
			return false;
		}

		huesped.setId(id);

		HuespedDTO huespedDTO = dataMapper.convertirAHuespedDTO(huesped);

		return huespedDAO.guardar(huespedDTO);
	}

	/**
	 * Busca un huésped específico en la capa de persistencia a partir de su identificador único.
	 * 
	 * @param id el identificador único del huésped a buscar
	 * @return el objeto {@link Huesped} correspondiente si se encuentra; o null en caso contrario
	 * @throws IOException si ocurre algún error de entrada o salida al consultar los datos
	 */
	public Huesped buscarPorId(String id) throws IOException {
		HuespedDTO huespedDTO = huespedDAO.buscarPorId(id);

		if (huespedDTO == null) {
			return null;
		}

		return dataMapper.convertirAHuesped(huespedDTO);
	}

	/**
	 * Consulta y retorna una lista con todos los huéspedes que se encuentran registrados en el sistema.
	 * 
	 * @return un {@link ArrayList} de objetos {@link Huesped} con todos los registros almacenados
	 * @throws IOException si ocurre algún error de entrada o salida al cargar los datos desde la persistencia
	 */
	public ArrayList<Huesped> consultarTodos() throws IOException {
		ArrayList<Huesped> huespedes = new ArrayList<Huesped>();
		ArrayList<HuespedDTO> huespedesDTO = huespedDAO.cargarTodos();

		for (int i = 0; i < huespedesDTO.size(); i++) {
			Huesped huesped = dataMapper.convertirAHuesped(huespedesDTO.get(i));

			if (huesped != null) {
				huespedes.add(huesped);
			}
		}

		return huespedes;
	}
}