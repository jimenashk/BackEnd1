package com.dh.medicamentos.dao;

import java.util.List;
//para que tome objetos genericos
public interface IDao <T>{

    // la T es tipo de dato generico
    public T guardar(T t);
    public T buscar(Integer id);
    public List<T> buscarTodos();
}
