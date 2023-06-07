package pe.edu.utp.auth;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Map;
import java.util.Scanner;

public class UserValidator {
    private Map<String, String> usuarios;
    private String rutaUsuarios = System.getProperty("user.dir") + "/src/main/resources/config/usuarios.txt";

    public UserValidator() {
        usuarios = new java.util.HashMap<>();
        cargarUsuarios();
    }

    private void cargarUsuarios() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(rutaUsuarios));
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] usuario = linea.split(":");
                if (usuario.length == 2) {
                    String nombre = usuario[0].trim();
                    String contrasena = usuario[1].trim();
                    usuarios.put(nombre, contrasena);
                }
            }
            reader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean validarUsuario(String nombre, String contrasena) {
        if (usuarios.containsKey(nombre)) {
            if (usuarios.get(nombre).equals(contrasena)) {
                return true;
            }
        }
        return false;
    }

    public String pedirUsuario(Scanner entrada) {
        String usuario = "", contrasena;
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
                System.out.println("Intentos restantes " + intentos + "." + (intentos != 0 ? "\n": ""));
                
            }
        } while (intentos != 0);

        // entrada.close();

        return usuario;
        
        
    }
}
