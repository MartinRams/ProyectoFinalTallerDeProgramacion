package pe.edu.utp.filters;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import pe.edu.utp.csv.Datos;
import pe.edu.utp.export.ExportacionDatos;
import pe.edu.utp.utils.LimpiezaConsola;

/**
 * Esta clase se encargará de filtrar los datos por una lista de departamentos y mostrar el dinero girado en esos departamentos.
 * También proporcionará la funcionalidad de exportar el informe a un archivo de texto plano.
 *
 * @autor Angelo del Piero Barboza Sánchez
 */
public class FiltroModulo02 {
    /**
     * Genera el reporte del dinero girado en una lista de departamentos.
     *
     * @param entrada Scanner para leer datos desde el teclado.
     * @return Reporte del dinero girado en los departamentos.
     */
    public static String reporte(Scanner entrada) {
        // Declaramos e inicializamos variables
        StringBuilder reporte = new StringBuilder();
        String mensaje = "", departamento;
        List<String> departamentosIntroducidos = new ArrayList<>();
        int opcion;

        do {
            // Limpiamos la consola (en caso de no ser ejecutado en un IDE)
            LimpiezaConsola.limpiarConsola();

            // Mostramos los departamentos
            mostrarDepartamentos();
            System.out.println(" [0] TERMINAR SELECCIÓN");
            System.out.println(" [-1] VOLVER");
            System.out.print(mensaje);

            if (!departamentosIntroducidos.isEmpty()) { // Mostramos los departamentos seleccionados (en caso ya lo haya hecho)
                System.out.print("DEPARTAMENTOS SELECCIONADOS: [");
                for (int i = 0; i < departamentosIntroducidos.size(); i++) {
                    System.out.print(
                            departamentosIntroducidos.get(i) + (i < (departamentosIntroducidos.size() - 1) ? ", " : "]"));
                }
                System.out.println();
            }

            System.out.print("\nSeleccione un departamento: ");
            opcion = entrada.nextInt(); // Solicitamos el ingreso de un departamento
            entrada.nextLine();

            if (opcion < -1 || opcion > Datos.getDepartamentos().size()) { // Validamos el departamento
                System.out.println("Opción inválida.");

            } else if (opcion == 0) { // Validamos si ha terminado de seleccionar departamentos
                break;

            } else if (opcion == -1) { // Validamos si ha decidido volver
                return "";

            } else {
                departamento = Datos.getDepartamentos().get(opcion - 1);

                if (departamentosIntroducidos.contains(departamento)) { // Validamos si ya ha seleccionado el departamento
                    mensaje = "Ya ha seleccionado este departamento.\n";

                } else { // Agregamos el departamento a la lista de departamentos seleccionados (en caso no lo haya hecho)
                    departamentosIntroducidos.add(departamento);
                    Collections.sort(departamentosIntroducidos); // Ordenamos la lista
                    mensaje = "";
                }
            }

        } while (true);

        // Generamos el reporte
        reporte.append("DINERO GIRADO A CADA DEPARTAMENTO\n\n");
        reporte.append("Departamento       Total Girado\n");
        reporte.append("-----------------  ------------\n");

        List<String[]> datos = Datos.getDatos(); // Obtenemos los datos

        for (String[] fila : datos) {
            departamento = fila[3];
            double monto = Double.parseDouble(fila[5]);

            if (departamentosIntroducidos.contains(departamento)) {
                reporte.append(String.format("%-18s  %.2f\n", departamento, monto));
            }
        }

        reporte.append("-----------------  ------------\n");

        // Exportamos el informe si se requiere
        exportarInforme(reporte.toString());

        return reporte.toString();
    }

    /**
     * Muestra los departamentos disponibles.
     */
    private static void mostrarDepartamentos() {
        System.out.println("DEPARTAMENTOS");
        for (int i = 0; i < Datos.getDepartamentos().size(); i++) {
            System.out.printf(" [%d] %s\n", i + 1, Datos.getDepartamentos().get(i));
        }
    }

    /**
     * Exporta el informe a un archivo de texto plano.
     *
     * @param informe Informe a exportar.
     */
    private static void exportarInforme(String informe) {
        ExportacionDatos.exportarReporte("Modulo02", informe);
        System.out.println("El informe se ha exportado con éxito a la siguiente ruta:");
        System.out.println(ExportacionDatos.getRutaArchivo() + "\n");
    }
}


