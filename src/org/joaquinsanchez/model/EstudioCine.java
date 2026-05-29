package org.joaquinsanchez.model;

public class EstudioCine {
    private int idEstudio;
    private String nombreEstudio;
    private String pais;
    private String sedeCentral;

    // Constructor vacio
    public EstudioCine() {
    }

    // Constructor con parametros
    public EstudioCine(int idEstudio, String nombreEstudio, String pais, String sedeCentral) {
        this.idEstudio = idEstudio;
        this.nombreEstudio = nombreEstudio;
        this.pais = pais;
        this.sedeCentral = sedeCentral;
    }

    // Métodos Getters y Setters
    public int getIdEstudio() {
        return idEstudio;
    }

    public void setIdEstudio(int idEstudio) {
        this.idEstudio = idEstudio;
    }

    public String getNombreEstudio() {
        return nombreEstudio;
    }

    public void setNombreEstudio(String nombreEstudio) {
        this.nombreEstudio = nombreEstudio;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getSedeCentral() {
        return sedeCentral;
    }

    public void setSedeCentral(String sedeCentral) {
        this.sedeCentral = sedeCentral;
    }
}