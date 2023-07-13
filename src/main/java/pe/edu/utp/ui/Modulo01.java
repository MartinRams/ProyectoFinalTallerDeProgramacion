package pe.edu.utp.ui;

import java.util.Scanner;

import pe.edu.utp.export.ExportacionDatos;
import pe.edu.utp.filters.FiltroModulo01;
import pe.edu.utp.utils.LimpiezaConsola;

/**
 * Esta clase se encarga de mostrar las opciones del módulo 01 y de llamar a las clases correspondientes para su ejecución.
 * @autor Junior Aron Delgado Flores
 */
public class Modulo01 {
    /**
     * Despliega las opciones del módulo 01.
     * @param entrada Scanner para leer datos desde el teclado.
     * @param datos Lista de datos obtenidos desde el archivo CSV.
     */
    public static void despliegueModulo01(Scanner entrada) {
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
                     String reporte = FiltroModulo01.reporte(entrada);
                    LimpiezaConsola.limpiarConsola();

                     if (!reporte.equals("")) {
                         if (opcion == 1) { // Se imprime el reporte
                             System.out.println(reporte);                

                         } else { // Se exporta el informe a un archivo plano
                             ExportacionDatos.exportarReporte("Modulo01", reporte); // Se exporta el reporte
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
