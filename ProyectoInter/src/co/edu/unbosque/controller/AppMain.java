package co.edu.unbosque.controller;

import java.io.IOException;

/**
 * Clase principal que sirve como punto de entrada de la aplicación.
 * Se encarga de instanciar el controlador principal e iniciar el flujo del sistema.
 * 
 * @author Universidad El Bosque
 * @version 1.0
 */
public class AppMain {

    /**
     * Método principal que ejecuta la aplicación.
     * 
     * @param args argumentos de la línea de comandos recibidos al iniciar el programa
     * @throws IOException si ocurre algún error de entrada o salida durante la inicialización del controlador
     */
    public static void main(String[] args) throws IOException {

        ControladorPrincipal controlador = new ControladorPrincipal();
        controlador.iniciar();
    }
}