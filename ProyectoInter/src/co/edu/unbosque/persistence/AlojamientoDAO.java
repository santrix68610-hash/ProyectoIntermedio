package co.edu.unbosque.persistence;

import java.io.IOException;
import java.util.ArrayList;

public interface AlojamientoDAO {
	 	ArrayList<AlojamientoDTO> cargarTodos() throws IOException;
	 	AlojamientoDTO buscarPorId(String id) throws IOException;
	    boolean guardar(AlojamientoDTO alojamiento) throws IOException;
	}

