package pe.edu.utp.ui;

import java.util.Scanner;

public class Modulo01 {
    public void despliegueModulo01(Scanner entrada) {
        // Declaramos variables
        String error = "";
        int opcion;

        do {
            System.out.print("\033[H\033[2J");
            System.out.flush();
    
            // Despliegue de opciones
            OpcionesModulos.mostrarOpciones(
                "MÓDULO 01 - DINERO GIRADO POR MES EN RANGO DE MESES"
                , error);

            opcion = entrada.nextByte();
            entrada.nextLine();

            switch (opcion) {
                case 1:
                    // Método para imprimir pantalla
                    error = "";
                    break;
                case 2:
                    // Método para exportar a archivo plano
                    error = "";
                    break;
                case 0:
                    error = "";
                    break;
                default:
                    error = "Error: La opción es inválida.\n";
                    break;
            }

        } while (opcion != 0);
    }
}
