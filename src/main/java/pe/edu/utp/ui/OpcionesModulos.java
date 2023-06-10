package pe.edu.utp.ui;

public class OpcionesModulos {
    public static void mostrarOpciones(String nombreModulo, String error) {
        System.out.printf("""
                    --------------------------------------------------------
                    %s
                    --------------------------------------------------------
                    1. Imprimir por pantalla.
                    2. Exportar a archivo plano
                    0. Volver al Menú Principal
                    --------------------------------------------------------
                    %sIngrese opción [1 - 2]:""", nombreModulo, error);
    
        System.out.print(" ");
    }

    public class mostrarOpciones {
    }
}
