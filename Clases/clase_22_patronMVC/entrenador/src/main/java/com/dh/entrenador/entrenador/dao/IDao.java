package com.dh.entrenador.entrenador.dao;

import com.dh.entrenador.entrenador.dominio.Entrenador;

import java.util.List;

public interface IDao <T> {
    List<T> buscarElementos();
}
