package com.example.MdT33.service;

import com.example.MdT33.entities.Player;
import com.example.MdT33.entities.Repository.PlayerRepository;
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
    public List<Player> findAllPlayers(){
        return repository.findAll();
    }
    public String delete(Long id){
        repository.deleteById(id);
        return "Ok";
    }
}

