package org.joaquinsanchez.model.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private Connection conexion;
    
    // Configuración de la base de datos de tu script
    private final String URL = "jdbc:mysql://localhost:3306/streamingdb_in4cm";
    private final String USER = "root";
    private final String PASSWORD = ""; // Si tu MySQL tiene contraseña, ponla aquí (ej: "admin")

    public Connection conectar() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            System.out.println("Error: No se encontro el Driver de MySQL.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Error: No se pudo conectar a la base de datos.");
            e.printStackTrace();
        }
        return conexion;
    }

    public void desconectar() {
        try {
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}