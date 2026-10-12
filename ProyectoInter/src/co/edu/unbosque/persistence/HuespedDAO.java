package co.edu.unbosque.persistence;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Interfaz de acceso a datos (DAO) para la gestión y persistencia 
 * de los registros de huéspedes en el sistema.
 * 
 * @author Universidad El Bosque
 * @version 1.0
 */
public interface HuespedDAO {
	
	/**
	 * Carga y retorna todos los registros de huéspedes almacenados en la persistencia.
	 * 
	 * @return un {@link ArrayList} con todos los objetos {@link HuespedDTO} encontrados
	 * @throws IOException si ocurre algún error de entrada o salida durante la lectura de los datos
	 */
	ArrayList<HuespedDTO> cargarTodos() throws IOException;
	
	/**
	 * Busca y retorna un huésped específico en la persistencia a partir de su identificador único.
	 * 
	 * @param id el identificador único del huésped a buscar
	 * @return el objeto {@link HuespedDTO} correspondiente si se encuentra; o null en caso contrario
	 * @throws IOException si ocurre algún error de entrada o salida al consultar los datos
	 */
	HuespedDTO buscarPorId(String id) throws IOException;
	
	/**
	 * Guarda un nuevo registro de huésped en la capa de persistencia.
	 * 
	 * @param huesped el objeto {@link HuespedDTO} que se desea almacenar
	 * @return true si el huésped se guardó exitosamente; false en caso contrario
	 * @throws IOException si ocurre algún error de entrada o salida durante la escritura de los datos
	 */
	boolean guardar(HuespedDTO huesped) throws IOException;
}