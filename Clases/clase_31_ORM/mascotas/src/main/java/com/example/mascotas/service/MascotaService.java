package com.example.mascotas.service;

import com.example.mascotas.persistence.entities.Mascotas;

import java.util.List;
import java.util.Optional;

public interface MascotaService {

    List<Mascotas> findAllMascotas();

    Optional<Mascotas> findMascotaById(Long Id);

    Mascotas saveMascota(Mascotas mascotasNew);

    String deleteMascota(Long id);

    String updateMascota (Mascotas mascotasNew);
}
