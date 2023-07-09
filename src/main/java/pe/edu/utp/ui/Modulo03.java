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

                    // Se imprime el reporte
                    if (opcion == 1) {
                        LimpiezaConsola.limpiarConsola();
                        System.out.println(reporte);
                        
                        if (!reporte.equals("")) {
                            System.out.print("Presione cualquier ENTER para continuar... ");
                            entrada.nextLine();
                        }

                    } else { // Se exporta el informe a un archivo plano
                        ExportacionDatos.exportarReporte("Modulo03", reporte); // Se exporta el reporte
                    }
                }
                case 0 -> error = "";
                default -> error = "Error: La opción es inválida.\n";
            }

        } while (opcion != 0);
    }
}
