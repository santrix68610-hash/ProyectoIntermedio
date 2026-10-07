package co.edu.unbosque.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Alojamiento;
import co.edu.unbosque.model.Apartamento;
import co.edu.unbosque.model.Cabaña;
import co.edu.unbosque.model.Casa;
import co.edu.unbosque.model.Finca;
import co.edu.unbosque.model.Huesped;

public class DataMapper {
	public HuespedDTO convertirAHuespedDTO(Huesped huesped) {
		return new HuespedDTO(huesped.getId(), huesped.getNombre(), huesped.getApellido(), huesped.getCorreo(),
				huesped.getTelefono());
	}

	public Huesped convertirAHuesped(HuespedDTO huespedDTO) {
		return new Huesped(huespedDTO.getId(), huespedDTO.getNombre(), huespedDTO.getApellido(), huespedDTO.getCorreo(),
				huespedDTO.getTelefono());
	}

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
					dto.getarifaAdicional());
		} else if (tipo.equalsIgnoreCase("Cabaña")) {
			return new Cabaña(dto.getId(), dto.getNombre(), dto.getCiudad(), tipo, dto.getUbicacion(),
					dto.getCapacidad(), dto.getPrecioPorNoche(), dto.isActivo(), dto.getDescripcion(), servicios,
					"ACTIVO", "INACTIVO", dto.gettarifaAdicional());
		} else if (tipo.equalsIgnoreCase("Finca")) {
			return new Finca(dto.getId(), dto.getNombre(), dto.getCiudad(), tipo, dto.getUbicacion(),
					dto.getCapacidad(), dto.getPrecioPorNoche(), dto.isActivo(), dto.getDescripcion(), servicios,
					"ACTIVO", "INACTIVO", dto.gettarifaAdicional());
		}

		return null;
	}
}
