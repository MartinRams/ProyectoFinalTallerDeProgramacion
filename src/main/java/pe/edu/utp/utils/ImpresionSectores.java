package pe.edu.utp.utils;

import pe.edu.utp.csv.Datos;

/**
 * Esta clase imprime los sectores.
 * @author Junior Aron Delgado Flores
 */
public class ImpresionSectores {
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
