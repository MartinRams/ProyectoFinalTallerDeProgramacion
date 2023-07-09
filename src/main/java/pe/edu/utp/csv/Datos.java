package pe.edu.utp.csv;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import pe.edu.utp.utils.LimpiezaConsola;

/**
 * Esta clase hace la lectura del archivo CSV y devuelve los datos en una lista.
 * @author Martin Alexander Ramos Yampufe
 */
public class Datos {
    private static final List<String[]> DATOS = LecturaCsv.obtenerDatos();
    private static final List<String> SECTORES = new ArrayList<>();
    private static final List<String> DEPARTAMENTOS = new ArrayList<>();

    /**
     * Obtenemos los datos del archivo CSV.
     */
    public static void cargarDatos() {
        if (SECTORES.isEmpty() && DEPARTAMENTOS.isEmpty() ) {
            for (String[] fila : DATOS) {
                if (!SECTORES.contains(fila[2])) {
                    SECTORES.add(fila[2]);
                }

                if (!DEPARTAMENTOS.contains(fila[3])) {
                    DEPARTAMENTOS.add(fila[3]);
                }

            }
            Collections.sort(DEPARTAMENTOS);
        }
    }

    /**
     * Obtenemos los datos del archivo CSV.
     * @return Lista de datos (todas las filas de los datos).
     */
    public static List<String[]> getDatos() {
        return DATOS;
    }

    /**
     * Obtenemos los valores de la columna 2 de los datos del archivo CSV.
     * @return Lista de sectores.
     */
    public static List<String> getSectores() {
        return SECTORES;
    }
    
    /**
     * Obtenemos los valores de la columna 3 de los datos del archivo CSV.
     * @return Lista de departamentos.
     */
    public static List<String> getDepartamentos() {
        return DEPARTAMENTOS;
    }

    /**
     * Este método imprime los sectores.
     */
    public static void imprimirSectores() {
        LimpiezaConsola.limpiarConsola();
        
        System.out.println("SECTORES:");
            for (int i = 0; i < Datos.getSectores().size(); i++) { // Se recorre la lista de sectores
                System.out.printf(" [%d] %s\n", (i + 1), Datos.getSectores().get(i)); // Se imprime el sector con un número asignado
            }
    }
}
