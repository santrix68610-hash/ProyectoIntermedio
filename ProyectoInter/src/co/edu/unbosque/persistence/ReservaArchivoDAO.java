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
	    ArrayList<ReservaDTO> reservas = cargarTodas();

	    for (int i = 0; i < reservas.size(); i++) {
	        ReservaDTO reserva = reservas.get(i);

	        if (reserva.getId().equals(id)) {
	            return reserva;
	        }
	    }

	    return null;
	}

	@Override
	public boolean guardar(ReservaDTO reserva) throws IOException {
	    ArrayList<ReservaDTO> reservasExistentes = cargarTodas();

	    for (int i = 0; i < reservasExistentes.size(); i++) {
	        if (reservasExistentes.get(i).getId().equals(reserva.getId())) {
	            return false; 
	        }
	    }

	    ArrayList<String> lineas = archivoTexto.leerLineas(nombreArchivo);
	    lineas.add(convertirARegistro(reserva));
	    archivoTexto.escribirLineas(nombreArchivo, lineas);

	    return true;
	}

	@Override
	public boolean actualizar(ReservaDTO reserva) throws IOException {
	    ArrayList<String> lineas = archivoTexto.leerLineas(nombreArchivo);
	    boolean encontrada = false;

	    for (int i = 0; i < lineas.size(); i++) {
	        String[] datos = lineas.get(i).split(";");

	        if (datos.length == 9 && datos[0].equals(reserva.getId())) {
	            lineas.set(i, convertirARegistro(reserva));
	            encontrada = true;
	            break;
	        }
	    }

	    if (!encontrada) {
	        return false;
	    }

	    archivoTexto.escribirLineas(nombreArchivo, lineas);
	    return true;
	}

}
