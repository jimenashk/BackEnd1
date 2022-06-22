package com.dh.clase34.demo.repository;

import com.dh.clase34.demo.entities.TechDirector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface TechDirectorRepository extends JpaRepository<TechDirector, Long> {
    //1- para crear un tecnico usas .save(t)

    //ejemplo consulta d tecnico x nombre
    @Query("SELECT t FROM Tecnico t WHERE t.nombre=?1")
    Optional<TechDirector> findTechDirectorByName(String name);

}
