package pe.edu.utp.filters;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import pe.edu.utp.csv.Datos;
import pe.edu.utp.utils.ImpresionSectores;
import pe.edu.utp.utils.LimpiezaConsola;

/**
 * Esta clase se encargará de mostrar la cantidad de dinero girado por sectorIntroducido,
 * dado una lista de meses y sectores.
 * 
 * @author Martin Alexander Ramos Yampufe
 * @author Angelo del Piero Barboza Sanchez
 */
public class FiltroModulo03 {
    /**
     * Este método se encargará de mostrar la cantidad de dinero girado por sector,
     * @param entrada Scanner para leer datos desde el teclado.
     * @return Reporte con la cantidad de dinero girado por sector.
     */
    public static String reporte(Scanner entrada) {
        // Declaramos e inicializamos variables
        StringBuilder reporte = new StringBuilder();
        String mensaje = "", sector, mes;
        List<Integer> sectoresIntroducidos = new ArrayList<>(), mesesIntroducidos = new ArrayList<>();
        int sectorIntroducido = 0, mesIntroducido = 0;
        double porcentaje, total = 0, porcentajeTotal = 0;
        boolean haConcluido, haSeleccionado = false;

        do {
            do {
                // Mostramos los sectores
                LimpiezaConsola.limpiarConsola();
                ImpresionSectores.imprimirSectores();
                System.out.println(" [0] TERMINAR SELECCIÓN");
                System.out.println(" [-1] VOLVER");
                System.out.print(mensaje);

                if (!sectoresIntroducidos.isEmpty()) { // Mostramos los sectores seleccionados (en caso ya lo haya hecho)
                    System.out.print("SECTORES SELECCIONADOS: [");
                    for (int i = 0; i < sectoresIntroducidos.size(); i++) {
                        System.out.print(
                                sectoresIntroducidos.get(i) + (i < (sectoresIntroducidos.size() - 1) ? ", " : "]"));
                    }
                    System.out.println();
                }

                System.out.print("\n Seleccione un sector: ");
                sectorIntroducido = entrada.nextInt(); // Solicitamos el ingreso de un sector
                entrada.nextLine();
                
                haSeleccionado = false;
                haConcluido = false;
                if (sectorIntroducido < -1 || sectorIntroducido > Datos.getSectores().size()) { // Validamos el sector
                    System.out.println("Opción inválida.");

                } else if (sectorIntroducido == 0) { // Validamos si ha terminado de seleccionar sectores
                    haSeleccionado = true;
                    mensaje = "";

                } else if (sectorIntroducido == -1) { // Validamos si ha decidido volver
                    haConcluido = true;

                } else {
                    if (sectoresIntroducidos.contains(sectorIntroducido)) { // Validamos si ya ha seleccionado el sector
                        mensaje = "Ya ha seleccionado este sectorIntroducido.\n";

                    } else { // Agregamos el sector a la lista de sectores seleccionados (en caso no lo haya hecho)
                        sectoresIntroducidos.add(sectorIntroducido);
                        Collections.sort(sectoresIntroducidos); // Ordenamos la lista

                    }
                }

            } while (sectorIntroducido > 0 || sectorIntroducido < -1); 

            if (haSeleccionado && !sectoresIntroducidos.isEmpty()) { // Validamos si ha introducido sectores
                do {
                    // Mostramos los meses
                    LimpiezaConsola.limpiarConsola();
                    System.out.print("SECTORES SELECCIONADOS: [");

                    for (int i = 0; i < sectoresIntroducidos.size(); i++) { // Mostramos los sectores seleccionados
                        System.out.print(
                                sectoresIntroducidos.get(i) + (i < (sectoresIntroducidos.size() - 1) ? ", " : "]"));
                    }
                    System.out.println();

                    if (!mesesIntroducidos.isEmpty()) { // Mostramos los meses seleccionados (en caso ya lo haya hecho)
                        System.out.print("MESES SELECCIONADOS: [");
                        for (int i = 0; i < mesesIntroducidos.size(); i++) { // Mostramos los meses seleccionados
                            System.out.print(
                                    mesesIntroducidos.get(i) + (i < (mesesIntroducidos.size() - 1) ? ", " : "]"));
                        }
                        System.out.println();
                    }

                    
                    System.out.println("MESES [1 - 12]");
                    System.out.println(" [0] TERMINAR SELECCIÓN");
                    System.out.println(" [-1] VOLVER");
                    System.out.print(mensaje);
                    System.out.print("\n Seleccione un mes: ");
                    mesIntroducido = entrada.nextInt(); // Solicitamos el ingreso de un mes
                    entrada.nextLine();

                    if (mesIntroducido < -1 || mesIntroducido > 12) { // Validamos el mes
                        System.out.println("Mes inválido.");

                    } else {
                        if (mesesIntroducidos.contains(mesIntroducido)) { // Validamos si ya ha seleccionado el mes
                            mensaje = "Ya ha seleccionado este mes.\n";

                        } else if (mesIntroducido == 0) { // Validamos si ha terminado de seleccionar meses
                            haConcluido = true;

                        } else if (mesIntroducido == -1) { // Desea volver al menu anterior
                            haConcluido = true;
                            break;

                        } else { // Agregamos el mes a la lista de meses seleccionados (en caso no lo haya hecho)
                            mesesIntroducidos.add(mesIntroducido);
                            Collections.sort(mesesIntroducidos);

                        }
                    }

                } while (mesIntroducido < -1 || mesIntroducido > 0);
            }

        } while (!haConcluido);

        if (sectorIntroducido == 0 && mesIntroducido == 0) { // Validamos si el usuario haya finalizado
            double[] subTotales = new double[sectoresIntroducidos.size()];
            reporte = new StringBuilder("""
                    SECTOR                                TOTAL       PORC
                    ======================================================
                    """);  // Iniciamos la creación del reporte
            
            List<String[]> datos = Datos.getDatos(); // Obtenemos los datos
            for (int i = 0; i < sectoresIntroducidos.size(); i++) { // Recorremos los sectores seleccionados
                sector = Datos.getSectores().get(sectoresIntroducidos.get(i) - 1);

                for (Integer mesesIntroducido : mesesIntroducidos) { // Recorremos los meses seleccionados
                    mes = mesesIntroducido.toString();

                    for (String[] fila : datos) { // Recorremos cada fila para empezar una comparación
                        if (sector.equals(fila[2]) && mes.equals(fila[1])) { // Validamos si el sector y el mes coinciden
                            total += Double.parseDouble(fila[5]);
                            subTotales[i] += Double.parseDouble(fila[5]); // Sumamos el total del sector y mes

                        }
                    }
                }
            }

            for (int i = 0; i < sectoresIntroducidos.size(); i++) { // Recorremos los sectores seleccionados
                sector = Datos.getSectores().get(sectoresIntroducidos.get(i) - 1);

                // Realizamos el calculo de los porcentajes
                porcentaje = (subTotales[i] / total) * 100;
                porcentajeTotal += porcentaje;

                // Agregamos los datos al reporte
                reporte.append(String.format("%-32s %10.2f %9.2f%%\n", sector, subTotales[i], porcentaje));
            }

        // Agregamos los totales al reporte
        reporte.append(String.format("""
                            ======================================================
                            TOTAL                            %10.2f %9.2f%%
                            """, total, porcentajeTotal));
        }
        
        return reporte.toString();
    }
}
