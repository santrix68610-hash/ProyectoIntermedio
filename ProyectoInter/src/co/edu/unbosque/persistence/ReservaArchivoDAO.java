package co.edu.unbosque.persistence;

import java.io.IOException;
import java.util.ArrayList;

public class ReservaArchivoDAO implements ReservaDAO {
	private String nombreArchivo = "reservas.txt";
	private ArchivoTexto archivoTexto = new ArchivoTexto();

	private String convertirARegistro(ReservaDTO reserva) {
		return reserva.getId() + ";" + reserva.getIdHuesped() + ";" + reserva.getIdAlojamiento() + ";"
				+ reserva.getFechaLlegada() + ";" + reserva.getFechaSalida() + ";" + reserva.getNumeroHuespedes() + ";"
				+ reserva.getNumeroNoches() + ";" + reserva.getValorTotal() + ";" + reserva.getEstado();
	}

	@Override
	public ArrayList<ReservaDTO> cargarTodas() throws IOException {
		ArrayList<ReservaDTO> reservas = new ArrayList<ReservaDTO>();
		ArrayList<String> lineas = archivoTexto.leerLineas(nombreArchivo);

		for (String linea : lineas) {
			String[] datos = linea.split(";");

			if (datos.length == 9) {
				ReservaDTO reserva = new ReservaDTO(datos[0], datos[1], datos[2], datos[3], datos[4],
						Integer.parseInt(datos[5]), Integer.parseInt(datos[6]), Double.parseDouble(datos[7]), datos[8]);

				reservas.add(reserva);
			}
		}

		return reservas;
	}

	@Override
	public ReservaDTO buscarPorId(String id) throws IOException {
		ArrayList<ReservaDTO> iDsearch = cargarTodas();
		for(i=0; i<iDsearch.size(); i++){
			if (iDsearch.getId().equals(id)) {
	            return iDsearch;
	        }
		}
		
		return null;
	}

	@Override
	public boolean guardar(ReservaDTO reserva) throws IOException {
		return false;
	}

	@Override
	public boolean actualizar(ReservaDTO reserva) throws IOException {
		return false;
	}
}
