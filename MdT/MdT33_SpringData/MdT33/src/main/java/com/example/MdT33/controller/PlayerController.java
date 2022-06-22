package com.example.MdT33.controller;

import com.example.MdT33.entities.Player;
import com.example.MdT33.service.Playerservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/players")
public class PlayerController {

    @Autowired
    Playerservice service;

    @GetMapping
    public ResponseEntity<List<Player>> getPlayer(){
        return ResponseEntity.ok(service.findAllPlayers());
    }
    @PostMapping("/create")
    public ResponseEntity<Player> create(@RequestBody Player p){
        return ResponseEntity.ok(service.save(p));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePlayer(@PathVariable Long id){
        ResponseEntity<String> resp= null;

        if (service.delete(id)!=null){
            resp= ResponseEntity.ok("Player with id: " + id + "was deleted successfully.");
        }
        else{
            resp = ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ERROR, player with id: " + id +" could not be deleted. ");
        }
        return resp;
    }
}

