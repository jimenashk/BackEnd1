package com.example.mascotas.controller;

import com.example.mascotas.persistence.Repository.MascotaRepository;
import com.example.mascotas.persistence.entities.Mascotas;
import com.example.mascotas.service.MascotaService;
import com.example.mascotas.service.MascotaServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
public class MascotaController {

        private final MascotaServiceImpl mascotaService;

        MascotaController (MascotaServiceImpl mascotaService) {
            this.mascotaService = mascotaService;
        }
        @RequestMapping(value = "/mascotas", method = RequestMethod.GET, produces = "application/json")
        public List<Mascotas> getMascotas(){
            return mascotaService.findAllMascotas();
        }

        @GetMapping(value = "/mascota/{id}")
        public Optional<Mascotas> getMascotasById(@PathVariable Long id){
            return mascotaService.findMascotaById(id);

        }

        @PostMapping(value ="/mascota/add")
        public Mascotas addMascota(Mascotas mascota){
            return mascotaService.saveMascota(mascota);
        }

        @DeleteMapping(value = "/mascota/delete/{id}")
        public String deleteStudent(@PathVariable Long id){
            return mascotaService.deleteMascota(id);
        }

        //http://localhost:8080/student/update (UPDATE)
        @PostMapping(value = "/mascota/update")
        public String updateMascota( Mascotas mascotaNew){
            return mascotaService.updateMascota((mascotaNew));        }

    }
