package co.edu.unbosque.controller;

import java.util.ArrayList;
import java.util.Scanner;

import co.edu.unbosque.model.Alojamiento;
import co.edu.unbosque.model.Huesped;
import co.edu.unbosque.persistence.ReservaDTO;

/**
 * Vista de consola de la aplicación encargada de gestionar la interacción con el usuario,
 * mostrando menús, detalles, listados, reportes y leyendo los datos ingresados por teclado.
 * 
 * @author Universidad El Bosque
 * @version 1.0
 */
public class VistaConsola {

	/**
	 * Instancia de {@link Scanner} utilizada para capturar las entradas de datos del usuario desde la consola.
	 */
	private Scanner teclado = new Scanner(System.in);

	/**
	 * Muestra en la consola el menú principal con las diferentes opciones de gestión del sistema de alojamientos.
	 */
	public void mostrarMenu() {
		System.out.println("\n--- MENÚ DE ALOJAMIENTOS ---");
		System.out.println("1. Consultar todos los alojamientos");
		System.out.println("2. Buscar por ciudad, tipo, capacidad y precio");
		System.out.println("3. Consultar detalle por ID");
		System.out.println("4. Crear reserva");
		System.out.println("5. Registrar huésped");
		System.out.println("6. Consultar reservas");
		System.out.println("7. Cancelar reserva");
		System.out.println("8. Consultar huéspedes");
		System.out.println("9. Reporte de reservas por estado");
		System.out.println("10. Reporte de ingresos confirmados");
		System.out.println("0. Salir");
	}

	/**
	 * Solicita y lee un número entero ingresado por el usuario mediante la consola, 
	 * validando que la entrada sea correcta y volviendo a solicitarla en caso de error.
	 * 
	 * @param mensaje el texto o instrucción que se muestra al usuario antes de capturar el dato
	 * @return el número entero ingresado y validado
	 */
	public int leerEntero(String mensaje) {
		int numero = 0;
		boolean valido = false;

		while (!valido) {
			System.out.print(mensaje);

			if (teclado.hasNextInt()) {
				numero = teclado.nextInt();
				teclado.nextLine();
				valido = true;
			} else {
				System.out.println("Ingresa un número entero válido.");
				teclado.nextLine();
			}
		}

		return numero;
	}

	/**
	 * Solicita y lee un valor decimal (double) correspondiente a un precio o cantidad numérica,
	 * validando que sea un número válido y mayor o igual a cero.
	 * 
	 * @param mensaje el texto o instrucción que se muestra al usuario antes de capturar el dato
	 * @return el número decimal ingresado, validado y no negativo
	 */
	public double leerDouble(String mensaje) {
		double numero = 0;
		boolean valido = false;

		while (!valido) {
			System.out.print(mensaje);

			if (teclado.hasNextDouble()) {
				numero = teclado.nextDouble();
				teclado.nextLine();

				if (numero >= 0) {
					valido = true;
				} else {
					System.out.println("El precio no puede ser negativo.");
				}
			} else {
				System.out.println("Ingresa un número válido.");
				teclado.nextLine();
			}
		}

		return numero;
	}

	/**
	 * Solicita y lee una cadena de texto ingresada por el usuario a través de la consola.
	 * 
	 * @param mensaje el texto o instrucción que se muestra al usuario antes de capturar el texto
	 * @return la cadena de texto ingresada por el usuario
	 */
	public String leerTexto(String mensaje) {
		System.out.print(mensaje);
		return teclado.nextLine();
	}

	/**
	 * Muestra un mensaje genérico en la consola.
	 * 
	 * @param mensaje la cadena de texto con el mensaje a mostrar
	 */
	public void mostrarMensaje(String mensaje) {
		System.out.println(mensaje);
	}

	/**
	 * Muestra en la consola el listado completo de alojamientos o un mensaje de advertencia 
	 * en caso de que la lista se encuentre vacía.
	 * 
	 * @param alojamientos la lista de objetos {@link Alojamiento} que se desea mostrar
	 */
	public void mostrarAlojamientos(ArrayList<Alojamiento> alojamientos) {
		if (alojamientos.size() == 0) {
			mostrarMensaje("No se encontraron alojamientos.");
		} else {
			for (int i = 0; i < alojamientos.size(); i++) {
				mostrarDetalle(alojamientos.get(i));
				System.out.println("-------------------------");
			}
		}
	}

	/**
	 * Muestra en la consola todos los detalles específicos de un alojamiento determinado.
	 * 
	 * @param alojamiento el objeto {@link Alojamiento} del cual se desplegarán sus atributos
	 */
	public void mostrarDetalle(Alojamiento alojamiento) {
		System.out.println("ID: " + alojamiento.getIdAlojamiento());
		System.out.println("Nombre: " + alojamiento.getNombre());
		System.out.println("Ciudad: " + alojamiento.getCiudad());
		System.out.println("Tipo: " + alojamiento.getTipo());
		System.out.println("Ubicación: " + alojamiento.getUbicacion());
		System.out.println("Capacidad: " + alojamiento.getCapacidad());
		System.out.println("Precio por noche: " + alojamiento.getPreciopornoche());
		System.out.println("Estado: " + (alojamiento.isActivo() ? "ACTIVO" : "INACTIVO"));
		System.out.println("Descripción: " + alojamiento.getDescripcion());
	}

	/**
	 * Muestra en la consola el listado detallado de todas las reservas registradas o un mensaje 
	 * indicando que no hay reservas almacenadas.
	 * 
	 * @param reservas la lista de objetos {@link ReservaDTO} a mostrar
	 */
	public void mostrarReservas(ArrayList<ReservaDTO> reservas) {
		if (reservas.size() == 0) {
			mostrarMensaje("No hay reservas guardadas.");
		} else {
			for (int i = 0; i < reservas.size(); i++) {
				ReservaDTO reserva = reservas.get(i);

				System.out.println("ID: " + reserva.getId());
				System.out.println("ID huésped: " + reserva.getIdHuesped());
				System.out.println("ID alojamiento: " + reserva.getIdAlojamiento());
				System.out.println("Llegada: " + reserva.getFechaLlegada());
				System.out.println("Salida: " + reserva.getFechaSalida());
				System.out.println("Huéspedes: " + reserva.getNumeroHuespedes());
				System.out.println("Noches: " + reserva.getNumeroNoches());
				System.out.println("Valor total: " + reserva.getValorTotal());
				System.out.println("Estado: " + reserva.getEstado());
				System.out.println("-------------------------");
			}
		}
	}

	/**
	 * Muestra en la consola el listado de todos los huéspedes registrados en el sistema o 
	 * un mensaje si la lista se encuentra vacía.
	 * 
	 * @param huespedes la lista de objetos {@link Huesped} a mostrar
	 */
	public void mostrarHuespedes(ArrayList<Huesped> huespedes) {
		if (huespedes.size() == 0) {
			mostrarMensaje("No hay huéspedes registrados.");
		} else {
			for (int i = 0; i < huespedes.size(); i++) {
				Huesped huesped = huespedes.get(i);

				System.out.println("ID: " + huesped.getId());
				System.out.println("Nombre: " + huesped.getNombre());
				System.out.println("Apellido: " + huesped.getApellido());
				System.out.println("Correo: " + huesped.getCorreo());
				System.out.println("Teléfono: " + huesped.getTelefono());
				System.out.println("-------------------------");
			}
		}
	}

	/**
	 * Muestra en la consola un reporte resumido con la cantidad de reservas confirmadas y canceladas.
	 * 
	 * @param confirmadas el número total de reservas confirmadas
	 * @param canceladas el número total de reservas canceladas
	 */
	public void mostrarReporteEstadosReservas(int confirmadas, int canceladas) {
		System.out.println("\n--- REPORTE DE RESERVAS POR ESTADO ---");
		System.out.println("Reservas confirmadas: " + confirmadas);
		System.out.println("Reservas canceladas: " + canceladas);
	}

	/**
	 * Muestra en la consola el reporte financiero con el valor total de los ingresos obtenidos 
	 * por las reservas confirmadas.
	 * 
	 * @param ingresos el valor monetario total de los ingresos confirmados
	 */
	public void mostrarReporteIngresosConfirmados(double ingresos) {
		System.out.println("\n--- REPORTE DE INGRESOS ---");
		System.out.println("Ingresos de reservas confirmadas: $" + ingresos);
	}
}