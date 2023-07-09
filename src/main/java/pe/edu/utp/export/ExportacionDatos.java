package pe.edu.utp.export;

import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Esta clase se encarga de exportar los datos a un archivo de texto plano.
 * @author Angelo del Piero Sanchez Barboza
 */
public class ExportacionDatos {
    private static final String RUTA_A_EXPORTAR = System.getProperty("user.dir") + "/exports";
    private static final SimpleDateFormat FORMATO_FECHA = new SimpleDateFormat("yyyyMMdd_HHmmss");
    private static final String FECHA = FORMATO_FECHA.format(new Date());

    /**
     * Exportamos el reporte a un archivo de texto plano.
     * @param nombreArchivo Nombre del archivo a exportar.
     * @param reporte Texto a exportar.
     */
    public static void exportarReporte(String nombreArchivo, String reporte) {
        try  {
            // Creamos el texto plano donde se exportará el reporte
            File archivo = new File(RUTA_A_EXPORTAR + "/" + nombreArchivo +"_" +FECHA + ".txt");

            // Escribimos el reporte en el archivo
            FileWriter escritor = new FileWriter(archivo);
            escritor.write(reporte);
            escritor.close();

        } catch (Exception e) { // En caso ocurra un error
            e.printStackTrace();
            
        }
    }
}
