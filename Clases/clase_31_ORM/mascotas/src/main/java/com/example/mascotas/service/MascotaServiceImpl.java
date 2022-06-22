package com.example.mascotas.service;

import com.example.mascotas.persistence.Repository.MascotaRepository;
import com.example.mascotas.persistence.entities.Mascotas;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class MascotaServiceImpl implements MascotaService {
    private final MascotaRepository mascotaRepository;
    public MascotaServiceImpl(MascotaRepository mascotaRepository){
        this.mascotaRepository = mascotaRepository;
    }
    @Override
    public List<Mascotas> findAllMascotas() {
        return mascotaRepository.findAll();
    }

    @Override
    public Optional<Mascotas> findMascotaById(Long id) {
        return mascotaRepository.findById(id);
    }

    @Override
    public Mascotas saveMascota(Mascotas mascotasNew) {
        if(mascotasNew != null){
            return mascotaRepository.save(mascotasNew);
        }
        return new Mascotas();
    }

    @Override
    public String deleteMascota(Long id) {
        if(mascotaRepository.findById(id).isPresent()){
            mascotaRepository.deleteById(id);
            return "Mascota with id: " + id + " delete";
        }
        return "Mascota with id: "+id + " dont exist";
    }

    @Override
    public String updateMascota(Mascotas mascotasNew) {
        return null;
    }
}
