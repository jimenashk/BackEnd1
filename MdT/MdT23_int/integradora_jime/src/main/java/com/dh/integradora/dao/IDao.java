package com.dh.integradora.dao;

import java.util.List;

public interface IDao <T>{

    List<T> listarElementos();
    T buscarId(int id);
    T buscarEmail(String email);
    T guardar(T t);
    T actualizar (T t);
    void eliminar(int id);

}
