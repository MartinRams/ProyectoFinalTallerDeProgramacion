package pe.edu.utp.ui;

import java.util.Scanner;

public class MenuPrincipal {
    public static void despliegueMenuPrincipal(Scanner entrada) {
        // Declaramos variables
        String error = "";
        int opcion;

        // Desplegamos el menú principal
        do {
            System.out.print("\033[H\033[2J");
            System.out.flush();

            System.out.printf("""
                    --------------------------------------------------------
                    MENU PRINCIPAL
                    --------------------------------------------------------
                    1. Dinero girado por mes dado un rango de meses.
                    2. Dinero girado a cada departamento dada una lista de departamentos.
                    3. Dinero girado por sector, dado una lista de meses y sectores.
                    4. Dinero girado a cada departamento dado un sector y un mes.
                    0. FIN DEL PROGRAMA
                    --------------------------------------------------------
                    %sIngrese opción [1 - 4]:""", error);

            System.out.print(" ");

            opcion = entrada.nextInt();
            entrada.nextLine();

            switch (opcion) {
                case 1:
                    error = "";
                    new Modulo01().despliegueModulo01(entrada);
                    break;

                case 2:
                    error = "";
                    new Modulo02().despliegueModulo02(entrada);
                    break;

                case 3:
                    error = "";
                    new Modulo03().despliegueModulo03(entrada);
                    break;

                case 4:
                    error = "";
                    new Modulo04().despliegueModulo04(entrada);
                    break;

                case 0:
                    break;

                default:
                    error = "Error: La opción es inválida.\n";
                    break;
            }

        } while (opcion != 0);
    }
}
