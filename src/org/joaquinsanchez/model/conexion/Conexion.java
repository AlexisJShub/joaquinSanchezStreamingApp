package org.joaquinsanchez.model.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private Connection conexion;
    
    private final String BASE_DATOS = "streamingdb_in4cm"; 
    
    private final String URL = "jdbc:mysql://localhost:3306/" + BASE_DATOS + "?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC";
    
    private final String USUARIO = "root";       
    private final String CONTRASENA = "bZ7#qW9!fL";  
    // =========================================================================

    public Connection conectar() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
            return conexion;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("No se pudo establecer la conexion.");
            e.printStackTrace();
            return null;
        }
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

    public void verificarConexion() {
        Connection ejecucionTest = conectar();
        if (ejecucionTest != null) {
            System.out.println("¡Conexion establecida con exito a MySQL!");
            desconectar();
        }
    }
}