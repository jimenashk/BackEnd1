package com.farmacia.medicamentoAPI.controller;

import com.farmacia.medicamentoAPI.bd.BD;
import com.farmacia.medicamentoAPI.dao.impl.MedicamentoDaoH2;
import com.farmacia.medicamentoAPI.model.Medicamento;
import com.farmacia.medicamentoAPI.service.MedicamentoService;
import org.springframework.web.bind.annotation.*;

@RestController
public class MedicamentoController {

    private MedicamentoService medicamentoService = new MedicamentoService(new MedicamentoDaoH2(new BD()));

    @PostMapping("/registrar")
    public Medicamento guardar(@RequestBody Medicamento medicamento){
        return medicamentoService.guardar(medicamento);
    }
    @GetMapping("/id")
    //si cambio el nombre del dato id, (pongo identificador en vez de id)
    //debo especificarle al pathvariable que es "id"
    public Medicamento buscar(@PathVariable("id") Integer identificador){
        return medicamentoService.buscar(identificador);
    }
}
