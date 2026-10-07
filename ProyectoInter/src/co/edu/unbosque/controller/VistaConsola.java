package co.edu.unbosque.controller;

import java.util.ArrayList;
import java.util.Scanner;

import co.edu.unbosque.model.Alojamiento;

public class VistaConsola {
	private Scanner teclado = new Scanner(System.in);

    public void mostrarMenu() {
        System.out.println("\n--- MENÚ DE ALOJAMIENTOS ---");
        System.out.println("1. Consultar todos");
        System.out.println("2. Buscar por ciudad, tipo o capacidad");
        System.out.println("3. Consultar detalle por ID");
        System.out.println("0. Salir");
    }

    public int leerEntero(String mensaje) {
        System.out.print(mensaje);
        int numero = teclado.nextInt();
        teclado.nextLine();
        return numero;
    }

    public String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return teclado.nextLine();
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

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

    public void mostrarDetalle(Alojamiento alojamiento) {
        System.out.println("ID: " + alojamiento.getIdAlojamiento());
        System.out.println("Nombre: " + alojamiento.getNombre());
        System.out.println("Ciudad: " + alojamiento.getCiudad());
        System.out.println("Tipo: " + alojamiento.getTipo());
        System.out.println("Ubicación: " + alojamiento.getUbicacion());
        System.out.println("Capacidad: " + alojamiento.getCapacidad());
        System.out.println("Precio por noche: " + alojamiento.getPreciopornoche());
        System.out.println("Estado: " +
                (alojamiento.isActivo() ? "ACTIVO" : "INACTIVO"));
        System.out.println("Descripción: " + alojamiento.getDescripcion());
    }
}