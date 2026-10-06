package co.edu.unbosque.persistence;

import java.io.IOException;
import java.util.ArrayList;

public interface HuespedDAO {
	ArrayList<HuespedDTO> cargarTodos() throws IOException;
	HuespedDTO buscarPorId(String id) throws IOException;
	boolean guardar(HuespedDTO huesped) throws IOException;
}