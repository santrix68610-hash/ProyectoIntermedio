package co.edu.unbosque.persistence;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Interfaz de acceso a datos (DAO) para la gestión y persistencia 
 * de los registros de alojamientos en el sistema.
 * 
 * @author Universidad El Bosque
 * @version 1.0
 */
public interface AlojamientoDAO {
	
	/**
	 * Carga y retorna todos los registros de alojamientos almacenados en la persistencia.
	 * 
	 * @return un {@link ArrayList} con todos los objetos {@link AlojamientoDTO} encontrados
	 * @throws IOException si ocurre algún error de entrada o salida durante la lectura de los datos
	 */
	ArrayList<AlojamientoDTO> cargarTodos() throws IOException;
	
	/**
	 * Busca y retorna un alojamiento específico en la persistencia a partir de su identificador único.
	 * 
	 * @param id el identificador único del alojamiento a buscar
	 * @return el objeto {@link AlojamientoDTO} correspondiente si se encuentra; o null en caso contrario
	 * @throws IOException si ocurre algún error de entrada o salida al consultar los datos
	 */
	AlojamientoDTO buscarPorId(String id) throws IOException;
	
	/**
	 * Guarda un nuevo registro de alojamiento en la capa de persistencia.
	 * 
	 * @param alojamiento el objeto {@link AlojamientoDTO} que se desea almacenar
	 * @return true si el alojamiento se guardó exitosamente; false en caso contrario
	 * @throws IOException si ocurre algún error de entrada o salida durante la escritura de los datos
	 */
	boolean guardar(AlojamientoDTO alojamiento) throws IOException;
}