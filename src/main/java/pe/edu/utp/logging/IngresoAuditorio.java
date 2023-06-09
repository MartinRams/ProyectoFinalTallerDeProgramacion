package pe.edu.utp.logging;

import java.io.IOException;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * Esta clase se encarga de escribir en el archivo auditorio.log las excepciones atrapadas.
 * @author Junior Aron Delgado Flores
 */
public class IngresoAuditorio {
    // Declaramos variables
    private static final Logger logger = Logger.getLogger(IngresoAuditorio.class.getName());
    private static final String FECHA = new Date().toString();

    // Atrapamos excepciones al escribir en auditorio.log
    static {
        try {
            FileHandler fileHandler = new FileHandler(System.getProperty("user.dir") + "/logs/auditorio.log", true);
            SimpleFormatter formatter = new SimpleFormatter();
            fileHandler.setFormatter(formatter);
            logger.addHandler(fileHandler);

        } catch (IOException e) {
            System.out.println("Error al escribir en auditorio.log");

        }
    }

    /**
     * Escribimos en auditorio.log el error atrapado.
     * @param usuario Nombre del usuario que ingresó.
     * @param tipoError Tipo de error atrapado.
     * @param mensajeError Mensaje del error atrapado.
     */
    public static void logError(String usuario, String tipoError, String mensajeError) {
        logger.warning(String.format("Fecha: %s \nUsuario: %s \nTipo de error: %s \nMensaje de error: %s\n", FECHA, usuario, tipoError, mensajeError));

    }
}
