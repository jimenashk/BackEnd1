package com.medicamentoAPI2.medicamentoAPI2.service;

import com.medicamentoAPI2.medicamentoAPI2.dao.IDao;
import com.medicamentoAPI2.medicamentoAPI2.model.Medicamento;

import java.util.ArrayList;
import java.util.List;

public class MedicamentoService {

    private IDao<Medicamento> medicamentoDao;
    private List<Medicamento> medicamentos = new ArrayList<>();


    public MedicamentoService(IDao<Medicamento> medicamentoDao) {
        this.medicamentoDao = medicamentoDao;
    }

    public Medicamento guardar(Medicamento medicamento) {
        return medicamentoDao.guardar(medicamento);

    }

    public Medicamento buscar(Integer id) {
        return medicamentoDao.buscar(id);
    }


    public List<Medicamento> buscarTodos() {
        //delegar la resp de buscarTodos al DAO
        return (List<Medicamento>) medicamentoDao.buscarTodos();
    }

    public Medicamento actualizar(Medicamento medicamento) {
        return medicamentoDao.actualizar(medicamento);
    }

    public void eliminar(Integer id) {
        medicamentoDao.eliminar(id);

    }

      }

