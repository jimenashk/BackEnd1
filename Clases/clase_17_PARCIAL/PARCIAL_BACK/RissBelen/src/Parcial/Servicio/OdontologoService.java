package Parcial.Servicio;

import Parcial.Dao.IDao;
import Parcial.Modelo.Odontologo;

import java.util.List;

public class OdontologoService {
    private IDao<Odontologo> odontologoIDao;

    public OdontologoService(IDao<Odontologo> odontologoIDao) {

        this.odontologoIDao = odontologoIDao;
    }
    public IDao<Odontologo> getOdontologoIDao(){
       return this.odontologoIDao=odontologoIDao;

    }

    public Odontologo guardar (Odontologo odontologo) {
        return odontologoIDao.guardar(odontologo);

    }

    public List<Odontologo> listar(){
        return odontologoIDao.listar();
    }
}
