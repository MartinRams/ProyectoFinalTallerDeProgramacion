package pe.edu.utp.ui;

import java.util.Scanner;

import pe.edu.utp.utils.LimpiezaConsola;

/**
 * Esta clase se encargará de mostrar la cantidad de dinero girado a cada departamento dada una lista de departamentos.
 * @autor Angelo del Piero Barboza Sanchez
 */
public class Modulo02 {
    /**
     * Despliega el menú del módulo 02.
     * @param entrada Scanner para leer datos desde el teclado.
     * @param datos Lista de datos.
     */
    public static void despliegueModulo02(Scanner entrada) {
        // Declaramos variables
        String error = "";
        int opcion;

        do {
            // Limpiamos la consola (en caso de no ser ejecutado en un IDE)
            LimpiezaConsola.limpiarConsola();

            OpcionesModulos.mostrarOpciones(
                    "MÓDULO 02 - DINERO GIRADO A CADA DEPARTAMENTO DADA UNA LISTA DE DEPARTAMENTOS", error);

            opcion = entrada.nextByte();
            entrada.nextLine();

            switch (opcion) {
                case 1, 2 -> {
                    // String reporte = FiltroModulo02.reporte(entrada, datos);

                    // Se imprime el reporte
                    if (opcion == 1) {
                        LimpiezaConsola.limpiarConsola();

                        // System.out.println(reporte);
                        // if (!reporte.equals("")) {
                        // System.out.print("Presione cualquier ENTER para continuar... ");
                        // entrada.nextLine();
                        // }

                    } else { // Se exporta el informe a un archivo plano

                    }
                }
                case 0 -> error = "";
                default -> error = "Error: La opción es inválida.\n";
            }
        } while (opcion != 0);
    }
}
