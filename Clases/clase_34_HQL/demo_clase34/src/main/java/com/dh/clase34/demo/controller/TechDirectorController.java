package com.dh.clase34.demo.controller;

import com.dh.clase34.demo.entities.Player;
import com.dh.clase34.demo.entities.TechDirector;
import com.dh.clase34.demo.service.Playerservice;
import com.dh.clase34.demo.service.TechDirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/techdirectors")

public class TechDirectorController {
    @Autowired
    TechDirectorService service;

    @GetMapping
    public ResponseEntity<List<TechDirector>> getTechDirector(){
        return ResponseEntity.ok(service.findAll());
    }
    @PostMapping("/create")
    public ResponseEntity<TechDirector> create(@RequestBody TechDirector t){return ResponseEntity.ok(service.save(t));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        ResponseEntity<String> resp= null;

        if (service.delete(id)!=null){
            resp= ResponseEntity.ok("Tech-director with id: " + id + "was deleted successfully.");
        }
        else{
            resp = ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ERROR, tech-director with id: " + id +" could not be deleted. ");
        }
        return resp;
    }
}
