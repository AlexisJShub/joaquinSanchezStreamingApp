package org.joaquinsanchez.view;

import java.util.List;
import java.util.Scanner;
import org.joaquinsanchez.model.Usuario;

public class UsuarioView {
    private final Scanner leer = new Scanner(System.in);

    public int mostrarMenu() {
        System.out.println("\n--- GESTION DE USUARIOS ---");
        System.out.println("1. Registrar nuevo usuario");
        System.out.println("2. Listar todos los usuarios");
        System.out.println("3. Buscar un usuario por ID");
        System.out.println("4. Actualizar un usuario");
        System.out.println("5. Eliminar un usuario");
        System.out.println("6. Regresar al menu principal");
        System.out.print("Seleccione una opcion: ");
        return Integer.parseInt(leer.nextLine());
    }

    public int solicitarID() {
        System.out.print("Ingrese el ID del usuario: ");
        return Integer.parseInt(leer.nextLine());
    }

    public String solicitarUsername() {
        System.out.print("Ingrese el username: ");
        return leer.nextLine();
    }

    public String solicitarCorreo() {
        System.out.print("Ingrese el correo electronico: ");
        return leer.nextLine();
    }

    public String solicitarContrasena() {
        System.out.print("Ingrese la contrasena: ");
        return leer.nextLine();
    }

    public void mostrarTodos(List<Usuario> usuarios) {
        System.out.println("\n+++ LISTA DE USUARIOS +++");
        System.out.printf("%-10s %-25s %-35s%n", "ID", "USERNAME", "CORREO");
        System.out.println("----------------------------------------------------------------------");
        for (Usuario u : usuarios) {
            System.out.printf("%-10d %-25s %-35s%n",
                    u.getIdUsuario(),
                    u.getUsername(),
                    u.getCorreo());
        }
    }

    public void mostrarUsuario(Usuario usuario) {
        System.out.println("\nDETALLE DEL USUARIO");
        System.out.println("ID      : " + usuario.getIdUsuario());
        System.out.println("USERNAME: " + usuario.getUsername());
        System.out.println("CORREO  : " + usuario.getCorreo());
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}