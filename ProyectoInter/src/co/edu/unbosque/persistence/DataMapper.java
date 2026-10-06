package co.edu.unbosque.persistence;

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
}
