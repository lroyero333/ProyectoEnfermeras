package com.example.proyectoenfermeras.entities;

public class Reporte {

    private String comentario;
    private String informante;

    public Reporte(String comentario, String informante) {
        this.comentario = comentario;
        this.informante = informante;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getInformante() {
        return informante;
    }

    public void setInformante(String informante) {
        this.informante = informante;
    }
}
