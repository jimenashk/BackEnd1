package farmacia.service;

import farmacia.dao.IDao;
import farmacia.model.Medicamento;

public class MedicamentoService {

    private IDao<Medicamento> medicamentoIDao;

    public MedicamentoService(IDao<Medicamento> medicamentoIDao) {
        this.medicamentoIDao = medicamentoIDao;
    }
    public Medicamento guardar(Medicamento medicamento){
        return medicamentoIDao.guardar(medicamento);

    }

    public  Medicamento buscar(Integer id){
        return medicamentoIDao.buscar(id);
    }

}
