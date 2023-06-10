package pe.edu.utp;

import java.util.Objects;
import java.util.Scanner;
import pe.edu.utp.auth.ValidarUsuario;
import pe.edu.utp.logging.IngresoAuditorio;
import pe.edu.utp.ui.MenuPrincipal;

public class Main {
    public static void main(String[] args) {
        // Declaramos variables.
        String usuario = "";

        // Iniciamos programa
        try (Scanner entrada = new Scanner(System.in)) {
            // Pedimos el usuario.
            usuario = new ValidarUsuario().pedirUsuario(entrada);

            // Despliegue del menú principal al inciar sesión correctamente.
            if (!Objects.equals(usuario, "")) {
                MenuPrincipal.despliegueMenuPrincipal(entrada);

            } else {
                System.out.println("Usuario inválido.");

            }

        } catch (Exception e) {
            if (Objects.equals(usuario, "")) {
                usuario = "Desconocido";
            }

            // Registramos error
            String tipoError = e.getClass().getName();
            String mensajeError = e.getMessage();
            IngresoAuditorio.logError(usuario, tipoError, mensajeError);

        } finally {
            System.out.print("\n ¡Hasta pronto!\n");

        }
    }
}