package co.edu.unbosque.persistence;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Interfaz de acceso a datos (DAO) para la gestión y persistencia 
 * de los registros de reservas en el sistema.
 * 
 * @author Universidad El Bosque
 * @version 1.0
 */
public interface ReservaDAO {
	
	/**
	 * Carga y retorna todas las reservas almacenadas en la capa de persistencia.
	 * 
	 * @return un {@link ArrayList} con todos los objetos {@link ReservaDTO} encontrados
	 * @throws IOException si ocurre algún error de entrada o salida durante la lectura de los datos
	 */
	ArrayList<ReservaDTO> cargarTodas() throws IOException;
	
	/**
	 * Busca y retorna una reserva específica en la persistencia a partir de su identificador único.
	 * 
	 * @param id el identificador único de la reserva a buscar
	 * @return el objeto {@link ReservaDTO} correspondiente si se encuentra; o null en caso contrario
	 * @throws IOException si ocurre algún error de entrada o salida al consultar los datos
	 */
	ReservaDTO buscarPorId(String id) throws IOException;
	
	/**
	 * Guarda un nuevo registro de reserva en la capa de persistencia.
	 * 
	 * @param reserva el objeto {@link ReservaDTO} que se desea almacenar
	 * @return true si la reserva se guardó exitosamente; false en caso contrario
	 * @throws IOException si ocurre algún error de entrada o salida durante la escritura de los datos
	 */
	boolean guardar(ReservaDTO reserva) throws IOException;
	
	/**
	 * Actualiza un registro de reserva existente en la capa de persistencia.
	 * 
	 * @param reserva el objeto {@link ReservaDTO} con los datos actualizados
	 * @return true si la reserva fue encontrada y actualizada exitosamente; false en caso contrario
	 * @throws IOException si ocurre algún error de entrada o salida durante la modificación de los datos
	 */
	boolean actualizar(ReservaDTO reserva) throws IOException;
}