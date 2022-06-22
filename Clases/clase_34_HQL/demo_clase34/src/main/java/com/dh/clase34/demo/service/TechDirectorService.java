package com.dh.clase34.demo.service;

import com.dh.clase34.demo.entities.Player;
import com.dh.clase34.demo.entities.TechDirector;
import com.dh.clase34.demo.repository.TechDirectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TechDirectorService {
    @Autowired
    TechDirectorRepository repository;

    public TechDirector addPlayer(Player p, Long id) {
        Optional<TechDirector> tec=repository.findById(id);
        if(tec.isPresent()){
            //guardamos en un jugador un tecnico asignado
            p.setTechDirector(tec.get());
            tec.get().getPlayers().add(p);
            return repository.save(tec.get());
        }
        else
            return null;
        }

        public Optional<TechDirector> findTechDirectorByName(String name){
            return repository.findTechDirectorByName(name);
        }
    public TechDirector save(TechDirector t){
        return repository.save(t);
    }

    public List<TechDirector> findAll(){
        return repository.findAll();
    }

    public String delete(Long id){ repository.deleteById(id);
        return "Ok";
    }


    }
