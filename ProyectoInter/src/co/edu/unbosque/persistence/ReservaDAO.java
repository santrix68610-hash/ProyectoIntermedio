package co.edu.unbosque.persistence;

import java.io.IOException;
import java.util.ArrayList;

public interface ReservaDAO {
	 ArrayList<ReservaDTO> cargarTodas() throws IOException;
	 ReservaDTO buscarPorId(String id) throws IOException;
	 boolean guardar(ReservaDTO reserva) throws IOException;
	 boolean actualizar(ReservaDTO reserva) throws IOException;

}
