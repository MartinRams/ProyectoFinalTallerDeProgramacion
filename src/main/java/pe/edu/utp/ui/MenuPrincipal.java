package pe.edu.utp.ui;

import java.util.List;
import java.util.Scanner;

import pe.edu.utp.csv.LecturaCsv;
import pe.edu.utp.utils.LimpiezaConsola;

public class MenuPrincipal {
    public static void despliegueMenuPrincipal(Scanner entrada) {
        // Declaramos variables
        String error = "";
        int opcion;

        List<String[]> datos = LecturaCsv.obtenerDatos();

        // Desplegamos el menú principal
        do {
            // Limpiamos la consola (en caso de no ser ejecutado en un IDE)
            LimpiezaConsola.limpiarConsola();

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
                    Modulo01.despliegueModulo01(entrada, datos);
                    break;

                case 2:
                    error = "";
                    Modulo02.despliegueModulo02(entrada, datos);
                    break;

                case 3:
                    error = "";
                    Modulo03.despliegueModulo03(entrada, datos);
                    break;

                case 4:
                    error = "";
                    Modulo04.despliegueModulo04(entrada, datos);
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
