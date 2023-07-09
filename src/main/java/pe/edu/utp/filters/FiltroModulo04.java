package pe.edu.utp.filters;

import java.util.List;
import java.util.Scanner;

import pe.edu.utp.csv.Datos;
import pe.edu.utp.utils.LimpiezaConsola;

/**
 * Esta clase se encarga de filtrar los datos por sector y departamento.
 * @author Martin Alexander Ramos Yampufe
 */
public class FiltroModulo04 {
    

    /**
     * Genera el reporte de dinero girado a cada departamento dado un sector y un mes.
     * @param entrada Scanner para leer datos desde el teclado.
     * @return Reporte de dinero girado a cada departamento dado un sector y un mes.
     */
    public static String reporte(Scanner entrada) {
        // Declaramos e inicializamos variables
        StringBuilder reporte = new StringBuilder();
        String sector, mes, departamento;
        double[] subTotales = new double[Datos.getDepartamentos().size()];
        double porcentaje, total = 0, porcentajeTotal = 0;
        int opcion;
        boolean haConcluido = false, haSeleccionado = false;

        // Mostrar los sectores
        do {
            Datos.imprimirSectores();
            System.out.println(" [0] VOLVER");

            System.out.print("\n Seleccione un sector: ");
            opcion = entrada.nextInt();
            entrada.nextLine();

            if (opcion < 0 || opcion > Datos.getSectores().size()) { // Inválidamos cualquier opción que no esté en el rango
                LimpiezaConsola.limpiarConsola();

                System.out.println("Opción inválida.");


            } else if (opcion == 0) {
                haConcluido = true; // El usuario ha decidido volver al menú anterior

            } else {
                sector = Datos.getSectores().get(opcion - 1);

                // Seleccionar mes
                do {
                    LimpiezaConsola.limpiarConsola();
                
                    // Mostrar los meses
                    System.out.println(" Sector seleccionado: " + sector);
                    System.out.println("MESES [1 - 12]");
                    System.out.println(" [0] VOLVER");
                    System.out.print("\n Seleccione un mes: ");
                    opcion = entrada.nextInt(); // Solicitamos al usuario el mes que desea seleccionar
                    entrada.nextLine();

                    if (opcion < 0 || opcion > 12) { // Inválidamos cualquier opción que no esté en el rango
                        LimpiezaConsola.limpiarConsola();
                            
                        System.out.println("Opción inválida.");

                    } else if (opcion == 0) { // El usuario ha decidido volver al menú anterior
                        haSeleccionado = true;

                    } else {
                        haSeleccionado = true;
                        haConcluido = true;
                        mes = String.valueOf(opcion); // Convertimos el número del mes a String

                        // Empieza las construccion del reporte
                        reporte = new StringBuilder("""
                                DEPARTAMENTO      TOTAL       PORC
                                ==================================
                                """);
                        List<String[]> datos = Datos.getDatos(); // Obtenemos los datos del archivo CSV
                        
                        for (int i = 0; i < Datos.getDepartamentos().size(); i++) { // Recorremos todos los departamentos
                            departamento = Datos.getDepartamentos().get(i);

                            // Recorremos los datos para obtener el total de dinero girado a cada departamento
                            for (String[] fila : datos) {
                                if (mes.equals(fila[1]) && sector.equals(fila[2]) && departamento.equals(fila[3])) {
                                    subTotales[i] += Double.parseDouble(fila[5]);
                                }
                            }
                            
                            total += subTotales[i];
                        }

                        for (int i = 0; i < subTotales.length; i++) {
                            if (subTotales[i] != 0) {
                                // En caso de que el nombre del departamento sea mayor a 12 caracteres
                                if (Datos.getDepartamentos().get(i).length() >= 12) {
                                    departamento = Datos.getDepartamentos().get(i).substring(0, 12);

                                } else {
                                    departamento = Datos.getDepartamentos().get(i);
                                    
                                }
                                
                                // Calculamos el porcentaje
                                porcentaje = (subTotales[i] * 100) / total;
                                porcentajeTotal += porcentaje;
                                reporte.append(String.format("""
                                        %-12s %10.2f %9.2f%%
                                        """, departamento, subTotales[i], porcentaje)); // Agregamos los datos al reporte
                            }
                            
                        }

                        reporte.append(String.format("""
                                ==================================
                                TOTAL        %10.2f %9.2f%%
                                """, total, porcentajeTotal)); // Agregamos los totales al reporte

                    } 

                } while (!haSeleccionado);
                
            }

        } while (!haConcluido);
    
        return reporte.toString();
    }
}
