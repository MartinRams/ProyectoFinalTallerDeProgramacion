package pe.edu.utp;

import java.util.Objects;
import java.util.Scanner;
import pe.edu.utp.auth.ValidarUsuario;
import pe.edu.utp.logging.IngresoAuditorio;
import pe.edu.utp.ui.MenuPrincipal;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        ValidarUsuario validarUsuario = new ValidarUsuario();
        MenuPrincipal menuPrincipal = new MenuPrincipal();
        String usuario = validarUsuario.pedirUsuario(entrada);

        try {
            if (!Objects.equals(usuario, "")) {
                menuPrincipal.despliegueMenuPrincipal(entrada);

            } else {
                System.out.println("Usuario no válido.");
            }

        } catch (Exception e) {
            String tipoError = e.getClass().getName();
            String mensajeError = e.getMessage();
            IngresoAuditorio.logError(usuario, tipoError, mensajeError);

        } finally {
            entrada.close();
            System.out.print("\n ¡Hasta pronto!\n");

        }
    }
}