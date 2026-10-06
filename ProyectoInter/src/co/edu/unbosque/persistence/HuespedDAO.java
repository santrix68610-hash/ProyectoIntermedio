package co.edu.unbosque.persistence;

import java.io.IOException;
import java.util.ArrayList;

public interface HuespedDAO {
	 ArrayList<HuespedDTO> cargarTodas() throws IOException;
	 ReservaDTO buscarPorId(String id) throws IOException;
	 boolean guardar(HuespedDTO reserva) throws IOException;

}