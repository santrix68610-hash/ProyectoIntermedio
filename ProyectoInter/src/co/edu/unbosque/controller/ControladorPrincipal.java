package co.edu.unbosque.controller;

import java.io.IOException;
import java.util.ArrayList;

import co.edu.unbosque.model.Alojamiento;
import co.edu.unbosque.model.AlojamientoServicio;
import co.edu.unbosque.model.Huesped;
import co.edu.unbosque.model.HuespedServicio;
import co.edu.unbosque.model.ReservaServicio;

public class ControladorPrincipal {

	private AlojamientoServicio alojamientoServicio;
    private HuespedServicio huespedServicio;
    private ReservaServicio reservaServicio;
    private VistaConsola vista;

    public ControladorPrincipal() {
        alojamientoServicio = new AlojamientoServicio();
        huespedServicio = new HuespedServicio();
        reservaServicio = new ReservaServicio();
        vista = new VistaConsola();
    }

    public void iniciar() throws IOException {
        alojamientoServicio.cargarDatosIniciales();

        int opcion = -1;

        while (opcion != 0) {
            vista.mostrarMenu();
            opcion = vista.leerEntero("Elige una opción: ");

            if (opcion == 1) {
                vista.mostrarAlojamientos(alojamientoServicio.listarTodos());

            } else if (opcion == 2) {
                String ciudad =
                        vista.leerTexto("Ciudad (Enter para ignorar): ");
                String tipo =
                        vista.leerTexto("Tipo (Enter para ignorar): ");
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

            } else if (opcion == 4) {
                crearReserva();

            } else if (opcion == 5) {
                registrarHuesped();

            } else if (opcion != 0) {
                vista.mostrarMensaje("Opción no válida.");
            }
        }

        vista.mostrarMensaje("Programa terminado.");
    }

    private void crearReserva() throws IOException {
        String id = vista.leerTexto("ID de la reserva: ");
        String idHuesped = vista.leerTexto("ID del huésped: ");
        String idAlojamiento =
                vista.leerTexto("ID del alojamiento: ");
        String fechaLlegada =
                vista.leerTexto("Fecha de llegada: ");
        String fechaSalida =
                vista.leerTexto("Fecha de salida: ");
        int numeroHuespedes =
                vista.leerEntero("Número de huéspedes: ");
        int numeroNoches =
                vista.leerEntero("Número de noches: ");

        boolean creada = reservaServicio.crearReserva(
                id,
                idHuesped,
                idAlojamiento,
                fechaLlegada,
                fechaSalida,
                numeroHuespedes,
                numeroNoches
        );

        if (creada) {
            vista.mostrarMensaje("Reserva creada correctamente.");
        } else {
            vista.mostrarMensaje(
                    "No se pudo crear la reserva. Revisa los IDs, "
                    + "el estado y la capacidad del alojamiento."
            );
        }
    }

    private void registrarHuesped() throws IOException {
        String id = vista.leerTexto("ID del huésped: ");
        String nombre = vista.leerTexto("Nombre: ");
        String apellido = vista.leerTexto("Apellido: ");
        String correo = vista.leerTexto("Correo: ");
        String telefono = vista.leerTexto("Teléfono: ");

        Huesped huesped =
                new Huesped(id, nombre, apellido, correo, telefono);

        boolean guardado = huespedServicio.registrarHuesped(huesped);

        if (guardado) {
            vista.mostrarMensaje("Huésped registrado correctamente.");
        } else {
            vista.mostrarMensaje("No se pudo registrar el huésped.");
        }
    }

    public ReservaServicio getReservaServicio() {
        return reservaServicio;
    }

    public void setReservaServicio(ReservaServicio reservaServicio) {
        this.reservaServicio = reservaServicio;
    }
}