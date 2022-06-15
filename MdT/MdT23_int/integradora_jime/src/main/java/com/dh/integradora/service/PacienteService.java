package com.dh.integradora.service;

import com.dh.integradora.dao.IDao;
import com.dh.integradora.dominio.Paciente;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//se encarga d implementar la interface d service
//tiene q listar los pacientes
//buscar un paciente x email
@Service
public class PacienteService implements PacienteServiceInterface{
   private IDao<Paciente> pacienteIDao;
    private List<Paciente> pacientes = new ArrayList<>();


    //necesito un contructor para poder instanciar el idao

    public PacienteService(IDao<Paciente> pacienteIDao) {
        this.pacienteIDao = pacienteIDao;
    }

    //metodos

    @Override
    public List<Paciente> listarPacientes() {
        return pacienteIDao.listarElementos();
    }

    @Override
    public Paciente buscarXEmail(String email) {return pacienteIDao.buscarEmail(email); }

    @Override
    public Paciente guardar(Paciente paciente) {
        return pacienteIDao.guardar(paciente);
    }

    @Override
    public Paciente actualizar(Paciente paciente) { return pacienteIDao.actualizar(paciente);
    }

    @Override
    public Paciente buscar(int id) {
        return pacienteIDao.buscarId(id);
    }

    @Override
    public void eliminar(int id) {
        pacienteIDao.eliminar(id);

    }
}
