package com.dh.clase34.demo.service;

import com.dh.clase34.demo.entities.Player;
import com.dh.clase34.demo.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Playerservice {

    @Autowired
    PlayerRepository repository;

    public Player save(Player p){
        return repository.save(p);
    }
    public List<Player> findAll(){
        return repository.findAll();
    }
    public String delete(Long id){
        repository.deleteById(id);
        return "Ok";
    }
}

