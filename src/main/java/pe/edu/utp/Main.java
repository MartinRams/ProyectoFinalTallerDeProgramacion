package pe.edu.utp;

import java.util.Objects;
import java.util.Scanner;
import pe.edu.utp.auth.UserValidator;
import pe.edu.utp.logging.AuditorioLogger;
import pe.edu.utp.ui.MenuPrincipal;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        UserValidator userValidator = new UserValidator();
        MenuPrincipal menuPrincipal = new MenuPrincipal();
        String usuario = userValidator.pedirUsuario(entrada);

        try {
            if (!Objects.equals(usuario, "")) {
                menuPrincipal.despliegueMenuPrincipal(entrada);

            } else {
                System.out.println("Usuario no válido.");
            }

        } catch (Exception e) {
            String tipoError = "Error en ejecución.";
            String mensajeError = e.getMessage();
            AuditorioLogger.logError(usuario, tipoError, mensajeError);

        } finally {
            entrada.close();
            System.out.print("\n ¡Hasta pronto!\n");

        }
    }
}