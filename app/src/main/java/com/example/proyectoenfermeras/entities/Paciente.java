package com.example.proyectoenfermeras.entities;

import java.util.ArrayList;

public class Paciente {

    private String nombre;
    private String apellido;
    private String url;
    private ArrayList<Reporte> reportes;

    public Paciente(String nombre, String apellido, String url) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.url = url;
    }

    public Paciente(String nombre, String apellido, String url, ArrayList<Reporte> reportes) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.url = url;
        this.reportes = reportes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ArrayList<Reporte> getReportes() {
        return reportes;
    }

    public void setReportes(ArrayList<Reporte> reportes) {
        this.reportes = reportes;
    }
}
