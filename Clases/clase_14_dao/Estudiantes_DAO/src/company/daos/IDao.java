package company.daos;

import java.util.List;

public interface IDao <T>{

    public T guardad(T t);
    public void eliminar(Long id);
    public T buscar(Long id);
    public List<T> buscarTodos();
}
