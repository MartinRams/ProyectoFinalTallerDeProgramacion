package pe.edu.utp.filters;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import pe.edu.utp.utils.LimpiezaConsola;

public class FiltroModulo04 {
    private static final List<String> SECTORES = new ArrayList<>();
    private static final List<String> DEPARTAMENTOS = new ArrayList<>();
    protected static String sector, mes, departamento;
    protected static double[] subTotales;
    protected static double subTotal, porcentaje, total = 0, porcentajeTotal = 0;
    protected static int opcion;

    public static String reporte(Scanner entrada, List<String[]> datos) {
        // Declaramos e inicializamos variables
        StringBuilder reporte = new StringBuilder();
        boolean haConcluido = false, haSeleccionado = false;

        LimpiezaConsola.limpiarConsola();

        // Filtramos los sectores y departamentos
        for (String[] dato : datos) {
            if (!SECTORES.contains(dato[2])) {
                SECTORES.add(dato[2]);
            }

            if (!DEPARTAMENTOS.contains(dato[3])) {
                DEPARTAMENTOS.add(dato[3]);
            }
        }
        Collections.sort(DEPARTAMENTOS);

        // Creamos arrays paralelos
        subTotales = new double[DEPARTAMENTOS.size()];

        // Mostrar los sectores
        do {
            System.out.println("SECTORES:");
            for (int i = 0; i < SECTORES.size(); i++) {
                System.out.printf(" [%d] %s\n", (i + 1), SECTORES.get(i));
            }
            System.out.println(" [0] VOLVER");

            System.out.print("\n Seleccione un sector: ");
            opcion = entrada.nextInt();
            entrada.nextLine();

            if (opcion < 0 || opcion > SECTORES.size()) {
                LimpiezaConsola.limpiarConsola();

                System.out.println("Opción inválida.");
            

            } else if (opcion == 0) {
                haConcluido = true;

            } else {
                sector = SECTORES.get(opcion - 1);

                // Seleccionar mes
                do {
                    LimpiezaConsola.limpiarConsola();
                
                    // Mostrar los meses
                    System.out.println(" Sector seleccionado: " + sector);
                    System.out.println("MESES [1 - 12]");
                    System.out.println(" [0] VOLVER");
                    System.out.print("\n Seleccione un mes: ");
                    opcion = entrada.nextInt();
                    entrada.nextLine();

                    if (opcion < 0 || opcion > SECTORES.size()) {
                        System.out.print("\033[H\033[2J");
                        System.out.flush();
                            
                        System.out.println("Opción inválida.");

                    } else if (opcion == 0) {
                        haSeleccionado = true;

                    } else {
                        haSeleccionado = true;
                        haConcluido = true;
                        mes = String.valueOf(opcion);

                        // Empieza las construccion del reporte
                        reporte = new StringBuilder("""
                                DEPARTAMENTO      TOTAL       PORC
                                ==================================
                                """);
                        
                        for (int i = 0; i < DEPARTAMENTOS.size(); i++) {
                            subTotal = 0;
                            departamento = DEPARTAMENTOS.get(i);

                            for (Object[] dato : datos) {
                                if (mes.equals(dato[1]) && sector.equals(dato[2]) && departamento.equals(dato[3])) {
                                    subTotal += Double.parseDouble(dato[5].toString());
                                }
                            }
                            
                            total += subTotal;
                            subTotales[i] = subTotal;
                        }

                        for (int i = 0; i < DEPARTAMENTOS.size(); i++) {
                            if (subTotales[i] != 0) {
                                // En caso de que el nombre del departamento sea mayor a 12 caracteres
                                if (DEPARTAMENTOS.get(i).length() >= 12) {
                                    departamento = DEPARTAMENTOS.get(i).substring(0, 12);

                                } else {
                                    departamento = DEPARTAMENTOS.get(i);
                                    
                                }

                                porcentaje = (subTotales[i] * 100) / total;
                                porcentajeTotal += porcentaje;
                                reporte.append(String.format("""
                                        %-12s %10.2f %9.2f%%
                                        """, departamento, subTotales[i], porcentaje));
                            }
                            
                        }

                        reporte.append(String.format("""
                                ==================================
                                TOTAL       %10.2f %9.2f%%
                                """, total, porcentajeTotal));

                    } 
                } while (!haSeleccionado);

            }

        } while (!haConcluido);
    
        return reporte.toString();
    }
}
