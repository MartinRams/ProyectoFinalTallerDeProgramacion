package pe.edu.utp.auth;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Map;
import java.util.Scanner;

public class ValidarUsuario {
    private final Map<String, String> USUARIOS;
    private final String RUTA_USUARIOS = System.getProperty("user.dir") + "/src/main/resources/config/usuarios.txt";

    public ValidarUsuario() {
        USUARIOS = new java.util.HashMap<>();
        cargarUsuarios();
    }

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
            e.printStackTrace();
        }
    }

    public boolean validarUsuario(String nombre, String contrasena) {
        if (USUARIOS.containsKey(nombre)) {
            return USUARIOS.get(nombre).equals(contrasena);
        }
        return false;
    }

    public String pedirUsuario(Scanner entrada) {
        String usuarioIngresado, contrasenaIngresado;
        int intentos = 3;

        do {
            System.out.print("Usuario: ");
            usuarioIngresado = entrada.nextLine().toLowerCase();

            System.out.print("Contraseña: ");
            contrasenaIngresado = entrada.nextLine();

            if (validarUsuario(usuarioIngresado, contrasenaIngresado)) {
                break;

            } else {
                intentos--;
                usuarioIngresado = "";
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.println("Usuario o contraseña incorrectos.");
                System.out.println("Intentos restantes " + intentos + "." + (intentos != 0 ? "\n" : ""));

            }
        } while (intentos != 0);

        return usuarioIngresado;

    }
}
