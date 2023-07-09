package pe.edu.utp.ui;

import java.util.Scanner;

import pe.edu.utp.export.ExportacionDatos;
import pe.edu.utp.filters.FiltroModulo03;
import pe.edu.utp.utils.LimpiezaConsola;

/**
 * Esta clase se encargará de mostrar la cantidad de dinero girado por cada sector, dado una lista de meses y una lista de sectores.
 * @author Martin Alexander Ramos Yampufe
 */
public class Modulo03 {
    public static void despliegueModulo03(Scanner entrada) {
        // Declaramos variables
        String error = "";
        int opcion;

        do {
            // Limpiamos la consola (en caso de no ser ejecutado en un IDE)
            LimpiezaConsola.limpiarConsola();

            OpcionesModulos.mostrarOpciones(
                    "MÓDULO 03 - DINERO GIRADO POR SECTOR, DADO UNA LISTA DE MESES Y SECTORES", error);

            opcion = entrada.nextByte();
            entrada.nextLine();

            switch (opcion) {
                case 1, 2 -> {
                    String reporte = FiltroModulo03.reporte(entrada);

                    LimpiezaConsola.limpiarConsola();

                    if (!reporte.equals("")) {
                        if (opcion == 1) { // Se imprime el reporte
                            System.out.println(reporte);                

                        } else { // Se exporta el informe a un archivo plano
                            ExportacionDatos.exportarReporte("Modulo03", reporte); // Se exporta el reporte
                            System.out.println("El reporte se ha exportado con éxito a la siguiente ruta:");
                            System.out.println(ExportacionDatos.getRutaArchivo() + "\n");

                        }

                        System.out.print("Presione cualquier ENTER para continuar... "); // Se espera a que el usuario presione ENTER para continuar
                        entrada.nextLine();
                    }
                }
                case 0 -> error = "";
                default -> error = "Error: La opción es inválida.\n";
            }

        } while (opcion != 0);
    }
}
