package org.joaquinsanchez.model;

public class Usuario {
    private int idUsuario;
    private String username;
    private String correo;

    // Constructor vacio
    public Usuario() {
    }

    // Constructor con parametros
    public Usuario(int idUsuario, String username, String correo) {
        this.idUsuario = idUsuario;
        this.username = username;
        this.correo = correo;
    }

    // Métodos Getters y Setters
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}