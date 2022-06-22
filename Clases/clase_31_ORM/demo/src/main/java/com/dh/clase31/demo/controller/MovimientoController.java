package com.dh.clase31.demo.controller;

import com.dh.clase31.demo.entities.Movimiento;
import com.dh.clase31.demo.service.MovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movimientos")
public class MovimientoController {
    @Autowired
    MovimientoService service;

    @GetMapping
    public ResponseEntity<List<Movimiento>> traerMovimientos(){
        return ResponseEntity.ok(service.obtenerMovimiento());
    }

    @PostMapping("/guardar")
    public ResponseEntity<String> guardarMovimiento(@RequestBody Movimiento m){
        ResponseEntity<String> respuesta = null;

        if (service.guardarMovimiento(m)!=null){
            respuesta= ResponseEntity.ok("El movimiento fue ingresado con exito");
        }
        else {
            respuesta = ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al guardar el movimiento ");

        }
        return respuesta;
    }
}
