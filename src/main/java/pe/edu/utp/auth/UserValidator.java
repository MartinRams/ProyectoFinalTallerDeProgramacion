package pe.edu.utp.auth;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Map;
import java.util.Scanner;

public class UserValidator {
    private final Map<String, String> USUARIOS;
    private final String RUTA_USUARIOS = System.getProperty("user.dir") + "/src/main/resources/config/usuarios.txt";

    public UserValidator() {
        USUARIOS = new java.util.HashMap<>();
        cargarUsuarios();
    }

    private void cargarUsuarios() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(RUTA_USUARIOS));
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] usuario = linea.split(":");
                if (usuario.length == 2) {
                    String nombre = usuario[0].trim();
                    String contrasena = usuario[1].trim();
                    USUARIOS.put(nombre, contrasena);
                }
            }
            reader.close();

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
        String usuario, contrasena;
        int intentos = 3;

        do {
            System.out.print("Usuario: ");
            usuario = entrada.nextLine().toLowerCase();

            System.out.print("Contraseña: ");
            contrasena = entrada.nextLine();

            if (validarUsuario(usuario, contrasena)) {
                break;

            } else {
                intentos--;
                usuario = "";
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.println("Usuario o contraseña incorrectos.");
                System.out.println("Intentos restantes " + intentos + "." + (intentos != 0 ? "\n" : ""));

            }
        } while (intentos != 0);

        // entrada.close();

        return usuario;


    }
}
