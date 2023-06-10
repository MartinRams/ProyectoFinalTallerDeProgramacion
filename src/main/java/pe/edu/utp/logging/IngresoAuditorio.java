package pe.edu.utp.logging;

import java.io.IOException;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class IngresoAuditorio {
    // Declaramos variables
    private static final Logger logger = Logger.getLogger(IngresoAuditorio.class.getName());
    private static Date fechaActual = new Date();
    private static String fecha = fechaActual.toString();

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

    // Logeamos el ingreso al auditorio
    public static void logError(String usuario, String tipoError, String mensajeError) {
        logger.warning(String.format("Fecha: %s \nUsuario: %s \nTipo de error: %s \nMensaje de error: %s\n", fecha, usuario, tipoError, mensajeError));
    }
}
