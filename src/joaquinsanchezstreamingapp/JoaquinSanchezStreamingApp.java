package joaquinsanchezstreamingapp;
//Proyecto hecho por: JoaquinSanchez
//Carne:2026117
//CodigoAcademico:IN4CM
//FUNDACION KINAL

import java.util.Scanner;
import org.joaquinsanchez.controller.EstudioCineController;
import org.joaquinsanchez.controller.UsuarioController;
import org.joaquinsanchez.model.conexion.Conexion;

public class JoaquinSanchezStreamingApp {
    public static void main(String[] args) {
        Conexion conexionDB = new Conexion();
        conexionDB.verificarConexion();

        EstudioCineController estudioCtrl = new EstudioCineController();
        UsuarioController usuarioCtrl = new UsuarioController();
        Scanner leer = new Scanner(System.in);

        int opcion = 0;
        do {
            System.out.println("\n=================================");
            System.out.println("      STREAMING APP - KINAL      ");
            System.out.println("=================================");
            System.out.println("1. Gestionar Estudios de Cine");
            System.out.println("2. Gestionar Usuarios");
            System.out.println("3. Salir de la aplicacion");
            System.out.print("Seleccione una opcion: ");
            try {
                opcion = Integer.parseInt(leer.nextLine());
                switch (opcion) {
                    case 1:
                        estudioCtrl.ejecutar();
                        break;
                    case 2:
                        usuarioCtrl.ejecutar();
                        break;
                    case 3:
                        System.out.println("Finalizando la aplicacion...");
                        break;
                    default:
                        System.out.println("Opcion invalida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un numero valido.");
            }
        } while (opcion != 3);
    }
}