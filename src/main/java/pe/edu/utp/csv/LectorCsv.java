package pe.edu.utp.csv;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

public class LectorCsv {
    private static final String RUTA_CSV = System.getProperty("user.dir") + "\\src\\main\\resources\\Gasto Covid19 2020 (DATASET).csv";
    
    public static List<String[]> obtenerDatos() {
        List<String[]> datosOriginales;
        List<String[]> datos = new ArrayList<>();
        
        try (CSVReader lectorCsv = new CSVReader(new FileReader(RUTA_CSV))) {
            // Leemos el archivo CSV
            datosOriginales = lectorCsv.readAll();

            // Eliminamos la primera fila (cabecera)
            for (int i = 1; i < datosOriginales.size(); i++) {
                datos.add(datosOriginales.get(i));
                
            }

        } catch (IOException | CsvException e) {
            throw new RuntimeException(e);
        }

        return datos;
    }
}
