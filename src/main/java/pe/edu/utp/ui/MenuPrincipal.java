package pe.edu.utp.ui;

import java.util.Scanner;

public class MenuPrincipal {
    public void despliegueMenuPrincipal(Scanner entrada) {
        byte opcion;

        do {
            System.out.print("\033[H\033[2J");
            System.out.flush();

            System.out.print("""
                    --------------------------------------------------------
                    MENU PRINCIPAL
                    --------------------------------------------------------
                    1. Dinero girado por mes dado un rango de meses.
                    2. Dinero girado a cada departamento dada una lista de departamentos.
                    3. Dinero girado por sector, dado una lista de meses y sectores.
                    4. Dinero girado a cada departamento dado un sector y un mes.
                    0. FIN DEL PROGRAMA
                    --------------------------------------------------------
                    Ingrese opción [1 - 4]:""");

            System.out.print(" ");

            opcion = (byte) entrada.nextInt();
            entrada.nextLine();

        } while (opcion != 0);

        entrada.close();
    }
}
