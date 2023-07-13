package pe.edu.utp.filters;

import java.util.List;
import java.util.Scanner;

import pe.edu.utp.csv.Datos;
import pe.edu.utp.utils.LimpiezaConsola;
import pe.edu.utp.utils.MostrarMeses;

/**
 * Esta clase se encarga de filtrar los datos por rango de meses y calcular la cantidad total de dinero girado
 * dado un rango de meses.
 * @author Junior Aron Delgado Flores
 */
public class FiltroModulo01 {

    public static String reporte(Scanner entrada) {
        // Declaramos e inicializamos variables
        int mesMin,mesMax;
        StringBuilder reporte = new StringBuilder();
        boolean haConcluido = false, haSeleccionado = false;
        double[] dineroMes = new double[12];
        int i=1,j=0;
    
        double AcumuladorMesesTotal=0;
        LimpiezaConsola.limpiarConsola();

        // Filtramos el valor de los meses y dinero girado para hacer una comparativa
        List<String[]> datos = Datos.getDatos();
        for (String[] fila : datos) {
            //Se convierte los valores de String a double, extraidos del List Datos
            double Fila1 = Double.parseDouble(fila[1]);
            double Fila5 = Double.parseDouble(fila[5]);
            

            //Se efectua la condicion donde se acumula el dinero girado que corresponde a un mes
            //y se almacena dentro de una posicion del array creado para los 12 meses
            
            if (Fila1==i) {
                dineroMes[j]+=Fila5;  
            }//Esto se efectua en caso de que la primera condicion sea falsa, para no perder un valor
            else if (Fila1==i+1) { 
                dineroMes[j+1]+=Fila5;
                //Acumuladores que aplicaran en el siguiente recorrido
                j++;
                i++;
            }
        }

        // Mostrar los sectores
        do {
            //Mostramos los meses llamando a la clase mostrarMeses
            MostrarMeses.mostrarMeses();

            //Se solicitan los limites del rango de meses
            System.out.print("\nIngrese desde que numero de mes desea revisar: ");
            mesMin = entrada.nextInt();
            entrada.nextLine();
        
            if (mesMin < 0 || mesMin > 12) {
                LimpiezaConsola.limpiarConsola();

                System.out.println("Opción inválida.");


            } else if (mesMin == 0) {
                haConcluido = true;

            } else {
                // Seleccionar mes
                do {
                    LimpiezaConsola.limpiarConsola();
                    // Mostrar los meses
                    MostrarMeses.mostrarMeses();
                    System.out.print("\nIngrese hasta que numero de mes desea revisar: ");
                    mesMax = entrada.nextInt();
                    entrada.nextLine();

                    
                    if (mesMax < mesMin || mesMax > 12) {
                        LimpiezaConsola.limpiarConsola();
                            
                        System.out.println("Opción inválida.");

                    } else if (mesMax == 0) {
                        haSeleccionado = true;

                    } else {
                        haSeleccionado = true;
                        haConcluido = true;

                        //Hacemos el conteo del Total para basarnos en el porcentaje del reporte
                        if(mesMin==mesMax){
                            AcumuladorMesesTotal = dineroMes[mesMin-1];
                        }else{
                            for (int n=mesMin-1; n<=mesMax-1; n++) {
                                AcumuladorMesesTotal+=dineroMes[n];
                            }
                        }

                        // Empieza las construccion del reporte
                        reporte = new StringBuilder("""
                                MES             TOTAL          PORC
                                ===================================
                                """);
                        if (mesMin==mesMax) {
                            MostrarMeses FormateadorMes = new MostrarMeses(mesMin);
                            reporte.append(String.format("""
                                %-10s   %13.2f 100.00%%
                            """,FormateadorMes.getMonthString(), dineroMes[mesMin-1]));
                        }else{
                            //Nuestro contador sera m
                            for (int m = mesMin; m <= mesMax; m++) {
                                MostrarMeses FormateadorMes = new MostrarMeses(m);
                                reporte.append(String.format("""
                                %-10s   %13.2f %6.2f%%
                                """, FormateadorMes.getMonthString(), dineroMes[m-1], (dineroMes[m-1] / AcumuladorMesesTotal) * 100));
                            }
                        }
                        reporte.append(String.format("""
                                ===================================
                                TOTAL        %13.2f 100.00%%
                                """, AcumuladorMesesTotal));

                    } 
                } while (!haSeleccionado);
            }

        } while (!haConcluido);
    
        return reporte.toString();
    }
}
