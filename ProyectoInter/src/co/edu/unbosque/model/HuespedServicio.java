package co.edu.unbosque.model;

import java.io.IOException;
import java.util.ArrayList;

import co.edu.unbosque.persistence.DataMapper;
import co.edu.unbosque.persistence.HuespedArchivoDAO;
import co.edu.unbosque.persistence.HuespedDAO;
import co.edu.unbosque.persistence.HuespedDTO;

public class HuespedServicio {
	private HuespedDAO huespedDAO;
	private DataMapper dataMapper;

	public HuespedServicio() {
		huespedDAO = new HuespedArchivoDAO();
		dataMapper = new DataMapper();
	}

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

	public Huesped buscarPorId(String id) throws IOException {
		HuespedDTO huespedDTO = huespedDAO.buscarPorId(id);

		if (huespedDTO == null) {
			return null;
		}

		return dataMapper.convertirAHuesped(huespedDTO);
	}

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
