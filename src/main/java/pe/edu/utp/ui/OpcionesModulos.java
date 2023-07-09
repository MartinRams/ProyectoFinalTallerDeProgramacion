package pe.edu.utp.ui;

/**
 * Esta clase muestra las opciones de cada módulo
 * @author Martin Alexander Ramos Yampufe
 */
public class OpcionesModulos {

    /**
     * Este método muestra el nombre del módulo, las opciones y un mensaje de error.
     * @param nombreModulo Nombre del módulo.
     * @param error Mensaje de error.
     */
    public static void mostrarOpciones(String nombreModulo, String error) {
        // Imprimimos las opciones y el nombre del módulo
        System.out.printf("""
                    --------------------------------------------------------
                    %s
                    --------------------------------------------------------
                    1. Imprimir por pantalla.
                    2. Exportar a archivo plano.
                    0. Volver al Menú Principal
                    --------------------------------------------------------
                    %sIngrese opción [1 - 2]:""", nombreModulo, error);
    
        System.out.print(" ");
    }
}
