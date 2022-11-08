package com.example.proyectoenfermeras.model.local;

import androidx.room.ColumnInfo;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Entity;
import androidx.room.Insert;
import androidx.room.PrimaryKey;
import androidx.room.Query;
import androidx.room.Update;

import com.example.proyectoenfermeras.model.entities.Paciente;

import java.io.Serializable;
import java.util.List;

@Dao
public interface PacienteDAO {

    @Query("select * from paciente")
    List<Paciente> obtenerTodo();

    @Insert
    void insertarElemento(Paciente miPaciente);

    @Update
    void edit(Paciente miPaciente);

    @Delete
    void eliminar(Paciente miPaciente);

    @Query("select * from paciente where identificador = :parametro")
    Paciente obtenerPorIdentificador(int parametro);


}
