package pe.edu.utp.ui;

import java.util.Scanner;

public class Modulo04 {
    public void despliegueModulo04(Scanner entrada) {
        // Declaramos variables
        String error = "";
        int opcion;

        do {
            System.out.print("\033[H\033[2J");
            System.out.flush();
    
            OpcionesModulos.mostrarOpciones(
                "MÓDULO GIRADO A CADA DEPARTAMENTO DADO UN SECTOR Y UN MES"
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
