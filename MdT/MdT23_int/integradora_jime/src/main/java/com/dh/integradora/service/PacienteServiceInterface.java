package com.dh.integradora.service;

import com.dh.integradora.dominio.Paciente;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PacienteServiceInterface {
    List<Paciente> listarPacientes();

    Paciente buscarXEmail(String Email);

    Paciente guardar(Paciente paciente);

    Paciente actualizar(Paciente paciente);

    Paciente buscar(int id);

    void eliminar(int id);

}
