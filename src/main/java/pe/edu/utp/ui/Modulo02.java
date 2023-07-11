package pe.edu.utp.ui;

import java.util.Scanner;
import pe.edu.utp.export.ExportacionDatos;
import pe.edu.utp.filters.FiltroModulo02;
import pe.edu.utp.utils.LimpiezaConsola;
/**
 * Esta clase se encargará de mostrar la cantidad de dinero girado a cada departamento dado una lista de departamentos.
 * También proporcionará opciones para imprimir el informe por pantalla o exportarlo a un archivo de texto plano.
 *
 * @autor Angelo del Piero Barboza Sánchez
 */
public class Modulo02 {
    public static void despliegueModulo02(Scanner entrada) {
        // Declaramos variables
        String error = "";
        int opcion;

        do {
            // Limpiamos la consola (en caso de no ser ejecutado en un IDE)
            LimpiezaConsola.limpiarConsola();

            // Mostramos las opciones
            OpcionesModulos.mostrarOpciones("MÓDULO 02 - DINERO GIRADO A CADA DEPARTAMENTO", error);

            opcion = entrada.nextByte();
            entrada.nextLine();

            switch (opcion) {
                case 1, 2 -> {
                    String reporte = FiltroModulo02.reporte(entrada);
                    LimpiezaConsola.limpiarConsola();

                    if (!reporte.equals("")) {
                        if (opcion == 1) { // Se imprime el reporte
                            System.out.println(reporte);

                        } else { // Se exporta el informe a un archivo plano
                            ExportacionDatos.exportarReporte("Modulo02", reporte); // Se exporta el reporte
                            System.out.println("El informe se ha exportado con éxito a la siguiente ruta:");
                            System.out.println(ExportacionDatos.getRutaArchivo() + "\n");

                        }

                        System.out.print("Presione ENTER para continuar... "); // Se espera a que el usuario presione ENTER para continuar
                        entrada.nextLine();
                    }
                }
                case 0 -> error = "";
                default -> error = "Error: La opción es inválida.\n";
            }

        } while (opcion != 0);
    }
}

