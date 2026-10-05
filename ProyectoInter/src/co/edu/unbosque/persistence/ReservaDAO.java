package co.edu.unbosque.persistence;

import java.util.ArrayList;

public interface ReservaDAO {
	 ArrayList<ReservaDTO> cargarTodas();
	 ReservaDTO buscarPorId(String id);
	 boolean guardar(ReservaDTO reserva);
	 boolean actualizar(ReservaDTO reserva);

}
