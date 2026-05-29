package org.joaquinsanchez.view;

import java.util.List;
import java.util.Scanner;
import org.joaquinsanchez.model.EstudioCine;

public class EstudioCineView {
    private final Scanner leer = new Scanner(System.in);

    public int mostrarMenu() {
        System.out.println("\n--- GESTION DE ESTUDIOS DE CINE ---");
        System.out.println("1. Registrar nuevo estudio");
        System.out.println("2. Listar todos los estudios");
        System.out.println("3. Buscar un estudio por ID");
        System.out.println("4. Actualizar un estudio");
        System.out.println("5. Eliminar un estudio");
        System.out.println("6. Regresar al menu principal");
        System.out.print("Seleccione una opcion: ");
        return Integer.parseInt(leer.nextLine());
    }

    public int solicitarID() {
        System.out.print("Ingrese el ID del estudio: ");
        return Integer.parseInt(leer.nextLine());
    }

    public String solicitarNombre() {
        System.out.print("Ingrese el nombre del estudio: ");
        return leer.nextLine();
    }

    public String solicitarPais() {
        System.out.print("Ingrese el pais: ");
        return leer.nextLine();
    }

    public String solicitarSedeCentral() {
        System.out.print("Ingrese la sede central: ");
        return leer.nextLine();
    }

    public void mostrarTodos(List<EstudioCine> estudios) {
        System.out.println("\n+++ LISTA DE ESTUDIOS DE CINE +++");
        System.out.printf("%-6s %-30s %-20s %-30s%n", "ID", "NOMBRE", "PAIS", "SEDE CENTRAL");
        System.out.println("------------------------------------------------------------------------------------------");
        for (EstudioCine e : estudios) {
            System.out.printf("%-6d %-30s %-20s %-30s%n",
                    e.getIdEstudio(),
                    e.getNombreEstudio(),
                    e.getPais(),
                    e.getSedeCentral());
        }
    }

    public void mostrarEstudio(EstudioCine estudio) {
        System.out.println("\nDETALLE DEL ESTUDIO");
        System.out.println("ID          : " + estudio.getIdEstudio());
        System.out.println("NOMBRE      : " + estudio.getNombreEstudio());
        System.out.println("PAIS        : " + estudio.getPais());
        System.out.println("SEDE CENTRAL: " + estudio.getSedeCentral());
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}