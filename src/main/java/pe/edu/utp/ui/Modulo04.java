package pe.edu.utp.ui;

import java.util.List;
import java.util.Scanner;

import pe.edu.utp.filters.FiltroModulo04;


public class Modulo04 {
    public static void despliegueModulo04(Scanner entrada, List<String[]> datos) {
        // Declaramos variables
        String error = "";
        int opcion;

        do {
            // Se limpia la consola (Solo si no es ejecutado en un IDE)
            System.out.print("\033[H\033[2J");
            System.out.flush();
            
            // Se muestran las opciones
            OpcionesModulos.mostrarOpciones(
                "MÓDULO 04 - DINERO GIRADO A CADA DEPARTAMENTO DADO UN SECTOR Y UN MES"
                , error);
            opcion = entrada.nextByte();
            entrada.nextLine();

            switch (opcion) {
                case 1, 2 -> {
                    String reporte = FiltroModulo04.reporte(entrada, datos);

                    // Se imprime el reporte
                    if (opcion == 1) {
                        System.out.print("\033[H\033[2J");
                        System.out.flush();

                        System.out.println(reporte);
                        if (!reporte.equals("")) {
                            System.out.print("Presione cualquier ENTER para continuar... ");
                            entrada.nextLine();
                        }

                    } else {  // Se exporta el informe a un archivo plano

                    }
                }
                case 0 -> error = "";
                default -> error = "Error: La opción es inválida.\n";
            }

        } while (opcion != 0);
    }
}
