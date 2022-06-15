package com.medicamentoAPI2.medicamentoAPI2.dao;

public interface IDao <T>{

    public T guardar(T t);
    public T buscar(Integer id);
    public T buscarTodos();
    void eliminar (Integer id);
    public T actualizar(T t);
}