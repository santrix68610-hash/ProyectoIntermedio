
package co.edu.unbosque.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Alojamiento;
import co.edu.unbosque.model.Apartamento;
import co.edu.unbosque.model.Cabaña;
import co.edu.unbosque.model.Casa;
import co.edu.unbosque.model.Finca;
import co.edu.unbosque.model.Huesped;

/**
 * Clase de utilidad encargada de realizar la conversión y mapeo de datos entre
 * los objetos del modelo de dominio y los objetos de transferencia de datos
 * (DTO).
 * 
 * @author Universidad El Bosque
 * @version 1.0
 */
public class DataMapper {

	/**
	 * Convierte un objeto de dominio {@link Huesped} a su respectivo objeto de
	 * transferencia {@link HuespedDTO}.
	 * 
	 * @param huesped el objeto {@link Huesped} que se desea convertir
	 * @return el objeto {@link HuespedDTO} resultante con los datos mapeados
	 */
	public HuespedDTO convertirAHuespedDTO(Huesped huesped) {
		return new HuespedDTO(huesped.getId(), huesped.getNombre(), huesped.getApellido(), huesped.getCorreo(),
				huesped.getTelefono());
	}

	/**
	 * Convierte un objeto de transferencia {@link HuespedDTO} a su respectivo
	 * objeto de dominio {@link Huesped}.
	 * 
	 * @param huespedDTO el objeto {@link HuespedDTO} que se desea convertir
	 * @return el objeto {@link Huesped} resultante con los datos mapeados
	 */
	public Huesped convertirAHuesped(HuespedDTO huespedDTO) {
		return new Huesped(huespedDTO.getId(), huespedDTO.getNombre(), huespedDTO.getApellido(), huespedDTO.getCorreo(),
				huespedDTO.getTelefono());
	}

	/**
	 * Convierte un objeto de dominio {@link Alojamiento} (y sus subclases) a su
	 * respectivo objeto de transferencia {@link AlojamientoDTO}, calculando las
	 * tarifas adicionales correspondientes.
	 * 
	 * @param alojamiento el objeto {@link Alojamiento} que se desea convertir
	 * @return el objeto {@link AlojamientoDTO} resultante, o null si el parámetro
	 *         de entrada es nulo
	 */
	public AlojamientoDTO convertirAAlojamientoDTO(Alojamiento alojamiento) {
		if (alojamiento == null) {
			return null;
		}

		ArrayList<String> servicios = new ArrayList<String>();
		if (alojamiento.getServiciosAdicionales() != null) {
			servicios.addAll(alojamiento.getServiciosAdicionales());
		}

		double tarifaAdicional = alojamiento.calcularValorReserva(1) - alojamiento.calcularValorBase(1);

		return new AlojamientoDTO(alojamiento.getIdAlojamiento(), alojamiento.getNombre(), alojamiento.getCiudad(),
				alojamiento.getTipo(), alojamiento.getUbicacion(), alojamiento.getCapacidad(),
				alojamiento.getPreciopornoche(), alojamiento.isActivo(), alojamiento.getDescripcion(), servicios,
				tarifaAdicional);
	}

	/**
	 * Convierte un objeto de transferencia {@link AlojamientoDTO} a la instancia de
	 * la subclase de {@link Alojamiento} correspondiente según el tipo definido
	 * (Apartamento, Casa, Cabaña o Finca).
	 * 
	 * @param dto el objeto {@link AlojamientoDTO} que se desea convertir
	 * @return una instancia concreta de la subclase de {@link Alojamiento}
	 *         correspondiente, o null si el DTO o su tipo son nulos o no
	 *         reconocidos
	 */
	public Alojamiento convertirAAlojamiento(AlojamientoDTO dto) {
		if (dto == null || dto.getTipo() == null) {
			return null;
		}

		ArrayList<String> servicios = new ArrayList<String>();
		if (dto.getServiciosAdicionales() != null) {
			servicios.addAll(dto.getServiciosAdicionales());
		}

		String tipo = dto.getTipo();

		if (tipo.equalsIgnoreCase("Apartamento")) {
			return new Apartamento(dto.getId(), dto.getNombre(), dto.getCiudad(), tipo, dto.getUbicacion(),
					dto.getCapacidad(), dto.getPrecioPorNoche(), dto.isActivo(), dto.getDescripcion(), servicios,
					"ACTIVO", "INACTIVO");
		} else if (tipo.equalsIgnoreCase("Casa")) {
			return new Casa(dto.getId(), dto.getNombre(), dto.getCiudad(), tipo, dto.getUbicacion(), dto.getCapacidad(),
					dto.getPrecioPorNoche(), dto.isActivo(), dto.getDescripcion(), servicios, "ACTIVO", "INACTIVO",
					dto.getTarifaAdicional());
		} else if (tipo.equalsIgnoreCase("Cabaña")) {
			return new Cabaña(dto.getId(), dto.getNombre(), dto.getCiudad(), tipo, dto.getUbicacion(),
					dto.getCapacidad(), dto.getPrecioPorNoche(), dto.isActivo(), dto.getDescripcion(), servicios,
					"ACTIVO", "INACTIVO", dto.getTarifaAdicional());
		} else if (tipo.equalsIgnoreCase("Finca")) {
			return new Finca(dto.getId(), dto.getNombre(), dto.getCiudad(), tipo, dto.getUbicacion(),
					dto.getCapacidad(), dto.getPrecioPorNoche(), dto.isActivo(), dto.getDescripcion(), servicios,
					"ACTIVO", "INACTIVO", dto.getTarifaAdicional());
		}

		return null;
	}
}