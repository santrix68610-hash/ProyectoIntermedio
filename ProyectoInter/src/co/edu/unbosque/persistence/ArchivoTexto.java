package co.edu.unbosque.persistence;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ArchivoTexto {
	public ArrayList<String> leerLineas(String nombreArchivo) throws IOException {
	    ArrayList<String> lineas = new ArrayList<String>();
	    File archivo = new File(nombreArchivo);

	    if (!archivo.exists()) {
	        return lineas;
	    }

	    BufferedReader lector = new BufferedReader(new FileReader(archivo));
	    String linea = lector.readLine();

	    while (linea != null) {
	        if (!linea.trim().isEmpty()) {
	            lineas.add(linea);
	        }
	        linea = lector.readLine();
	    }

	    lector.close();
	    return lineas;
	}
}