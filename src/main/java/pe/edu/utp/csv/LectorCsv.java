package pe.edu.utp.csv;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

public class LectorCsv {
    private static final String RUTA_CSV = System.getProperty("user.dir") + "\\src\\main\\resources\\Gasto Covid19 2020 (DATASET).csv";
    
    public static List<String[]> obtenerDatos() {
        List<String[]> datos;
        
        try (CSVReader lectorCsv = new CSVReader(new FileReader(RUTA_CSV))) {
            // Leemos el archivo CSV
            lectorCsv.skip(1); // Saltamos la primera línea (cabecera)
            datos = lectorCsv.readAll();

        } catch (IOException | CsvException e) {
            throw new RuntimeException(e);
        }

        return datos;
    }
}
