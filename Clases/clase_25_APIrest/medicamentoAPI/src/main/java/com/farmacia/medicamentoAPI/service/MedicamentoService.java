package com.farmacia.medicamentoAPI.service;

import com.farmacia.medicamentoAPI.dao.IDao;
import com.farmacia.medicamentoAPI.dao.impl.MedicamentoDaoH2;
import com.farmacia.medicamentoAPI.model.Medicamento;

public class MedicamentoService {

    public MedicamentoDaoH2 medicamentoService;
    private IDao<Medicamento> medicamentoIDao;

    public MedicamentoService(IDao<Medicamento> medicamentoIDao) {
        this.medicamentoIDao = medicamentoIDao;
    }
    public Medicamento guardar(Medicamento medicamento){
        return medicamentoIDao.guardar(medicamento);

    }

    public  Medicamento buscar(Integer id){
        return medicamentoIDao.buscar(id);
    }

}
