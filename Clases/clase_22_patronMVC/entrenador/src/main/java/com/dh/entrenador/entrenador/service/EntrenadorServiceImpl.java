package com.dh.entrenador.entrenador.service;

import com.dh.entrenador.entrenador.dao.IDao;
import com.dh.entrenador.entrenador.dominio.Entrenador;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EntrenadorServiceImpl implements EntrenadorServiceInterface {
    private IDao<Entrenador> entrenadorIDao;

    public EntrenadorServiceImpl(IDao<Entrenador> entrenadorIDao) {
        this.entrenadorIDao = entrenadorIDao;
    }

    @Override
    public List<Entrenador> listaEntrenadores() {
        return entrenadorIDao.buscarElementos();
    }
}
