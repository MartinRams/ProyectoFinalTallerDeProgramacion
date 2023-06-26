package pe.edu.utp.utils;

public class LimpiezaConsola {
    public static void limpiarConsola() {
        // Hacemos tres saltos de línea para no saturar la terminal
        System.out.println("\n\n");

        // Limpiamos la consola (en caso de no ser ejecutado en un IDE)
        System.out.print("\033[H\033[2J");
        System.out.flush();
        
    }
}