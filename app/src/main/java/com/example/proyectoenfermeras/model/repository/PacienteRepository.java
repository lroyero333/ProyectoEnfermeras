package com.example.proyectoenfermeras.model.repository;

import android.content.Context;

import com.example.proyectoenfermeras.model.entities.Paciente;
import com.example.proyectoenfermeras.model.local.BaseDatos;
import com.example.proyectoenfermeras.model.local.PacienteDAO;

import java.util.List;

public class PacienteRepository {

    PacienteDAO miPacienteDAO;

    public PacienteRepository(Context miContexto) {
        BaseDatos miBaseDatos = BaseDatos.obtenerInstancia(miContexto);
        this.miPacienteDAO = miBaseDatos.pacienteDAO();
    }

    public List<Paciente> obtenerTodoPacientes(){
        return miPacienteDAO.obtenerTodo();
    }

    public void insertarPaciente(Paciente miPaciente){
        miPacienteDAO.insertarElemento(miPaciente);
    }

    public void editarPaciente(Paciente miPaciente){
        miPacienteDAO.edit(miPaciente);
    }

    public void eliminarPaciente(Paciente miPaciente){
        miPacienteDAO.eliminar(miPaciente);
    }

    public Paciente consultarPacientePorIdentificador(int identificador){
        return miPacienteDAO.obtenerPorIdentificador(identificador);
    }
}
