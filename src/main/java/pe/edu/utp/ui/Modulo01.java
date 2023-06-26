package pe.edu.utp.ui;

import java.util.List;
import java.util.Scanner;

import pe.edu.utp.utils.LimpiezaConsola;

public class Modulo01 {
    public static void despliegueModulo01(Scanner entrada, List<String[]> datos) {
        // Declaramos variables
        String error = "";
        int opcion;

        do {
            // Se limpia la consola (Solo si no es ejecutado en un IDE)
            LimpiezaConsola.limpiarConsola();

            // Despliegue de opciones
            OpcionesModulos.mostrarOpciones(
                    "MÓDULO 01 - DINERO GIRADO POR MES EN RANGO DE MESES", error);

            opcion = entrada.nextByte();
            entrada.nextLine();

            switch (opcion) {
                case 1, 2 -> {
                    // String reporte = FiltroModulo01.reporte(entrada, datos);

                    // Se imprime el reporte
                    if (opcion == 1) {
                        LimpiezaConsola.limpiarConsola();

                        // // System.out.println(reporte);
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
