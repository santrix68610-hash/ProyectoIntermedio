package co.edu.unbosque.persistence;

import java.util.ArrayList;

public class ReservaArchivoDAO implements ReservaDAO {
	//String nombreArchivo;
	//DataMapper mapper;
	//ArchivoTexto ArchivoTexto;
	private String convertirARegistro(ReservaDTO reserva) {
	    return reserva.getId() + ";"
	            + reserva.getId() + ";"
	            + reserva.getAlojamiento() + ";"
	            + reserva.getFechaLlegada() + ";"
	            + reserva.getFechaSalida() + ";"
	            + reserva.getNumeroHuespedes() + ";"
	            + reserva.getNumeroNoches() + ";"
	            + reserva.getValorTotal() + ";"
	            + reserva.getEstado();
	}
	@Override
	public ArrayList<ReservaDTO> cargarTodas() {
		
		return new ArrayList<ReservaDTO>();
	}
	@Override
	public ReservaDTO buscarPorId(String id) {
		
		return null;
	}
	@Override
	public boolean guardar(ReservaDTO reserva) {
		
		return false;
	}
	@Override
	public boolean actualizar(ReservaDTO reserva) {
		
		return false;
	}

}
