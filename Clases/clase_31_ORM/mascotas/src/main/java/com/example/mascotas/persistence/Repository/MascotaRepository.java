package com.example.mascotas.persistence.Repository;

import com.example.mascotas.persistence.entities.Mascotas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MascotaRepository extends JpaRepository<Mascotas, Long> {
}
