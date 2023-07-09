package pe.edu.utp.ui;

import java.util.Scanner;

import pe.edu.utp.csv.Datos;
import pe.edu.utp.utils.LimpiezaConsola;

/**
 * Esta clase se encargará de mostrar el menú principal del programa y de llamar a los filtros correspondientes.
 * @author Angelo del Piero Barboza Sanchez
 * @autor Junior Aron Delgado Flores
 * @autor Martin Alexander Ramos Yampufe
 */
public class MenuPrincipal {
    /**
     * Despliega el menú principal del programa.
     * @param entrada Scanner para leer datos desde el teclado.
     */
    public static void despliegueMenuPrincipal(Scanner entrada) {
        // Declaramos variables
        String error = "";
        int opcion;

        Datos.cargarDatos();

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
                    Modulo01.despliegueModulo01(entrada);
                    break;

                case 2:
                    error = "";
                    Modulo02.despliegueModulo02(entrada);
                    break;

                case 3:
                    error = "";
                    Modulo03.despliegueModulo03(entrada);
                    break;

                case 4:
                    error = "";
                    Modulo04.despliegueModulo04(entrada);
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
