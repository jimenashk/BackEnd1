package com.dh.clase31.demo.service;

import com.dh.clase31.demo.entities.Movimiento;
import com.dh.clase31.demo.repository.MovimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MovimientoService {
    @Autowired
    MovimientoRepository repository; //inyeccion d la dependencia

    public List<Movimiento> obtenerMovimiento() {
        return repository.findAll();
    }

    public String guardarMovimiento(Movimiento m) {
        repository.save(m);
        return "Movimiento guardado";
    }
}

