package co.edu.unbosque.controller;

import java.io.IOException;
import java.util.ArrayList;

import co.edu.unbosque.model.Alojamiento;
import co.edu.unbosque.model.AlojamientoServicio;
import co.edu.unbosque.model.ReservaServicio;

public class ControladorPrincipal {

    private AlojamientoServicio alojamientoServicio;
    private VistaConsola vista;
    private ReservaServicio reservaServicio = new ReservaServicio();

    public ControladorPrincipal() {
        alojamientoServicio = new AlojamientoServicio();
        vista = new VistaConsola();
    }

    public void iniciar() throws IOException {
        alojamientoServicio.cargarDatosIniciales();

        int opcion = -1;

        while (opcion != 0) {
            vista.mostrarMenu();
            opcion = vista.leerEntero("Elige una opción: ");

            if (opcion == 1) {
                vista.mostrarAlojamientos(
                        alojamientoServicio.listarTodos());

            } else if (opcion == 2) {
                String ciudad = vista.leerTexto(
                        "Ciudad (Enter para ignorar): ");
                String tipo = vista.leerTexto(
                        "Tipo (Enter para ignorar): ");
                int huespedes = vista.leerEntero(
                        "Cantidad de huéspedes (0 para ignorar): ");

                ArrayList<Alojamiento> encontrados =
                        alojamientoServicio.buscar(ciudad, tipo, huespedes);

                vista.mostrarAlojamientos(encontrados);

            } else if (opcion == 3) {
                String id = vista.leerTexto("ID del alojamiento: ");
                Alojamiento alojamiento =
                        alojamientoServicio.consultarDetalle(id);

                if (alojamiento == null) {
                    vista.mostrarMensaje("No se encontró ese ID.");
                } else {
                    vista.mostrarDetalle(alojamiento);
                }

            } else if (opcion != 0) {
                vista.mostrarMensaje("Opción no válida.");
            }
        }

        vista.mostrarMensaje("Programa terminado.");
    }

	public ReservaServicio getReservaServicio() {
		return reservaServicio;
	}

	public void setReservaServicio(ReservaServicio reservaServicio) {
		this.reservaServicio = reservaServicio;
	}
}
