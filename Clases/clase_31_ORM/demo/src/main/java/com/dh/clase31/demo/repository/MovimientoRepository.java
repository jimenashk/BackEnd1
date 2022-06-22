package com.dh.clase31.demo.repository;

import com.dh.clase31.demo.entities.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovimientoRepository extends JpaRepository<Movimiento, Long> {

}
