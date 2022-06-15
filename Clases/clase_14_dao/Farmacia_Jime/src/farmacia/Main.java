package farmacia;

import farmacia.bd.BD;
import farmacia.dao.impl.MedicamentoDaoH2;
import farmacia.model.Medicamento;
import farmacia.service.MedicamentoService;

public class Main {
    public static void main(String[] args) throws Exception {
        //crear base de datos
        BD.crearBD();
        MedicamentoService medicamentoService = new MedicamentoService(new MedicamentoDaoH2());
        Medicamento medicamento = new Medicamento("Tafirol 1MG", "Lab-DH", 4, 685.5, 5);
        medicamentoService.guardar(medicamento);
        medicamentoService.buscar(1);
    }
}
