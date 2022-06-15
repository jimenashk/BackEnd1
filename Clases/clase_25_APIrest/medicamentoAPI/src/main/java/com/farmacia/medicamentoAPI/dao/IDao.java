package com.farmacia.medicamentoAPI.dao;

public interface IDao <T>{
    T guardar(T t);
    T buscar(Integer id);

}
