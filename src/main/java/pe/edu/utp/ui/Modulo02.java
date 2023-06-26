package pe.edu.utp.ui;

import java.util.List;
import java.util.Scanner;

import pe.edu.utp.utils.LimpiezaConsola;

public class Modulo02 {
    public static void despliegueModulo02(Scanner entrada, List<String[]> datos) {
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
                        System.out.println("\n");
                        System.out.print("\033[H\033[2J");
                        System.out.flush();

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
