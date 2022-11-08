package com.example.proyectoenfermeras.model.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.util.ArrayList;
@Entity
public class Paciente implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private int identificador;
    @ColumnInfo
    private String nombre;
    @ColumnInfo
    private String apellido;
    @ColumnInfo
    private String url;
    @ColumnInfo
    private ArrayList<Reporte> reportes;

    public Paciente(String nombre, String apellido, String url) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.url = url;
    }

    public Paciente(String nombre, String apellido, String url, ArrayList<Reporte> reportes) {
        this.identificador = 0;
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
