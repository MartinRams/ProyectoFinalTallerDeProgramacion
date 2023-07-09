package pe.edu.utp.auth;

import java.io.BufferedReader;
import java.io.Console;
import java.io.FileReader;
import java.util.Map;
import java.util.Scanner;

import pe.edu.utp.utils.LimpiezaConsola;

/**
 * Esta clase se encarga de hacer las vadilaciones de los usuarios.
 * @author Martin Alexander Ramos Yampufe
 */
public class ValidacionUsuario {
    // Declaramos variables
    private final Map<String, String> USUARIOS;
    private final String RUTA_USUARIOS = System.getProperty("user.dir") + "/src/main/resources/config/usuarios.txt";

    // Constructor
    public ValidacionUsuario() {
        USUARIOS = new java.util.HashMap<>();
        cargarUsuarios();
    }

    /**
     * Cargamos a memoria los usuarios y contraseñas.
     * @throws Exception Si no se puede leer el archivo.
     */
    private void cargarUsuarios() {
        try {
            BufferedReader lector = new BufferedReader(new FileReader(RUTA_USUARIOS));
            String linea;
            while ((linea = lector.readLine()) != null) {
                String[] usuario = linea.split("=");
                if (usuario.length == 2) {
                    String nombre = usuario[0].trim();
                    String contrasena = usuario[1].trim();
                    USUARIOS.put(nombre, contrasena);
                }
            }
            lector.close();

        } catch (Exception e) {
            System.out.println("Error al cargar usuarios.");
        }
    }

    /**
     * Validamos el usuario y contraseña.
     * @param nombre Nombre ingresado.
     * @param contrasena Contraseña ingresada.
     * @return True si el usuario y contraseña son correctos, false en caso contrario.
     */
    public boolean validarUsuario(String nombre, String contrasena) {
        if (USUARIOS.containsKey(nombre)) {
            return USUARIOS.get(nombre).equals(contrasena); // Validamos la contraseña
        }
        return false;
    }

    /**
     * Pedimos el usuario y contraseña.
     * @param entrada
     * @return El nombre de usuario ingresado.
     */
    public String pedirUsuario(Scanner entrada) {
        Console consola = System.console();
        String usuarioIngresado, contrasenaIngresada;
        int intentos = 4;

        do {
            System.out.print("Usuario: ");
            usuarioIngresado = entrada.nextLine().toLowerCase();

            // En caso de usar una consola, la contraseña no se mostrará en pantalla
            if (consola == null) {
                System.out.print("Contraseña: ");
                contrasenaIngresada = entrada.nextLine();

            } else {
                contrasenaIngresada = new String(consola.readPassword("Contraseña: "));
                
            }

            if (validarUsuario(usuarioIngresado, contrasenaIngresada)) {
                break;

            } else { // En caso de que el usuario o contraseña sean incorrectos se decrementa la cantidad de intentos
                intentos--;
                usuarioIngresado = "";
                LimpiezaConsola.limpiarConsola();
                System.out.println("Usuario o contraseña incorrectos.");
                System.out.println("Intentos restantes " + intentos + "." + (intentos != 0 ? "\n" : ""));

            }
        } while (intentos != 0);

        return usuarioIngresado;
    }
}
