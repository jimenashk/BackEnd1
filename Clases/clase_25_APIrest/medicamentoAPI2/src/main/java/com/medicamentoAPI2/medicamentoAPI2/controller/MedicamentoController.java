package com.medicamentoAPI2.medicamentoAPI2.controller;
import com.medicamentoAPI2.medicamentoAPI2.dao.impl.MedicamentoDaoH2;
import com.medicamentoAPI2.medicamentoAPI2.model.Medicamento;
import com.medicamentoAPI2.medicamentoAPI2.service.MedicamentoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medicamentos")
public class MedicamentoController {

    private MedicamentoService medicamentoService = new MedicamentoService(new MedicamentoDaoH2());

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
    @DeleteMapping("/{id}")
    public ResponseEntity eliminar(@PathVariable Integer id){
        ResponseEntity rs = null;

        if(medicamentoService.buscar(id) == null){
            rs = new ResponseEntity(HttpStatus.NOT_FOUND);
        } else {
            medicamentoService.eliminar(id);
            rs = new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return rs;
    }
    @PutMapping("/actualizar")
    public ResponseEntity<Medicamento> actualizar(@RequestBody Medicamento medicamento){
      ResponseEntity rs = null;

      if (medicamentoService.buscar(medicamento.getId()) == null){
          rs = new ResponseEntity(HttpStatus.NOT_FOUND);
          } else {
          rs = new ResponseEntity(medicamentoService.actualizar(medicamento), HttpStatus.OK);

      }
      return rs;
    }
}
