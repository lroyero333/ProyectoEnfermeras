package com.example.proyectoenfermeras.model.local;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

public abstract class BaseDatos extends RoomDatabase {

    public abstract PacienteDAO pacienteDAO();

    private static BaseDatos instancia = null;
    public static BaseDatos obtenerInstancia(Context miContexto){
        if(instancia == null){
            instancia = Room.databaseBuilder(miContexto, BaseDatos.class,"proyectoenfermeras.db").allowMainThreadQueries().build();
        }
        return instancia;
    }
}
