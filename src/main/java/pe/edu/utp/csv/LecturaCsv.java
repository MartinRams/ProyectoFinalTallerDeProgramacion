package pe.edu.utp.csv;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

/**
 * Esta clase hace la lectura del archivo CSV y devuelve los datos en una lista.
 * @author Martin Alexander Ramos Yampufe
 */
public class LecturaCsv {
    private static final String RUTA_CSV = System.getProperty("user.dir") + "/src/main/resources/Gasto Covid19 2020 (DATASET).csv";
    
    /**
     * Obtenemos los datos del archivo CSV.
     * @return Lista de datos (cada fila de los datos).
     */
    public static List<String[]> obtenerDatos() {
        List<String[]> datos;
        
        try (CSVReader lectorCsv = new CSVReader(new FileReader(RUTA_CSV))) {
            // Leemos el archivo CSV
            lectorCsv.skip(1); // Saltamos la primera línea (cabecera)
            datos = lectorCsv.readAll();
            lectorCsv.close();

        } catch (IOException | CsvException e) { // En caso ocurra un error
            throw new RuntimeException(e);
        } 

        return datos;
    }
}
