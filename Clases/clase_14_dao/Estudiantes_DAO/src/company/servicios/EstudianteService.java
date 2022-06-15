package company.servicios;

import company.daos.IDao;
import company.entidades.Estudiante;

import java.util.List;

public class EstudianteService {

    private IDao<Estudiante> estudianteIDao;

    public IDao<Estudiante> getEstudianteIDao() {
        return estudianteIDao;
    }

    public void setEstudianteIDao(IDao<Estudiante> estudianteIDao) {
        this.estudianteIDao = estudianteIDao;
    }
    public Estudiante guardarEstudiante(Estudiante e){
        //delegar la responsabilidad de guardar al DAO
        return estudianteIDao.guardad(e);
    }
    public void eliminarEstudiante(Long id){
        //delegar la responsabilidad de eliminar al DAO
        estudianteIDao.eliminar(id);
    }
    public Estudiante buscarEstudiante(Long id){
        //delegar la responsabilidad de buscar al DAO
        return estudianteIDao.buscar(id);
    }
    public List<Estudiante> buscarTodos(){
        //delegar la responsabilidad de buscar a todos al DAO
        return estudianteIDao.buscarTodos();
    }
}
