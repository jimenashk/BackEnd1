package com.farmacia.medicamentoAPI;

import com.farmacia.medicamentoAPI.bd.BD;
import com.farmacia.medicamentoAPI.dao.impl.MedicamentoDaoH2;
import com.farmacia.medicamentoAPI.model.Medicamento;
import com.farmacia.medicamentoAPI.service.MedicamentoService;
import org.springframework.boot.SpringApplication;
import com.farmacia.medicamentoAPI.dao.IDao;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MedicamentoApiApplication {

	public static void main(String[] args) throws Exception {
		BD.crearBD();
		MedicamentoService medicamentoService = new MedicamentoService(new MedicamentoDaoH2(new BD()));
		Medicamento medicamento = new Medicamento("Tafirol 1MG", "Lab-DH", 4, 685.5, 5);
		medicamentoService.guardar(medicamento);
		medicamentoService.buscar(1);
	}
}

