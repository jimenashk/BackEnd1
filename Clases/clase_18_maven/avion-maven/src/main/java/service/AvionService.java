package service;


import dh.avion.daos.IDao;
import model.Avion;

import java.util.List;

public class AvionService {

    private IDao<Avion> avionIDao;

    public AvionService(IDao<Avion> avionIDao) {this.avionIDao = avionIDao;}

    public void setAvionIdao(IDao<Avion> avionIDao){this.avionIDao = avionIDao;}
    public void eliminarAvion(Long id){avionIDao.eliminar(id);}
    public Avion registrarAvion(Avion e) {return avionIDao.guardar(e);}
    public Avion buscarAvion(Long id){return avionIDao.buscar(id);}
    public List<Avion> buscarTodos(){return avionIDao.buscarTodos();}
}


