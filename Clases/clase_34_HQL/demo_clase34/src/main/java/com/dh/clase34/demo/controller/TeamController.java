package com.dh.clase34.demo.controller;

import com.dh.clase34.demo.entities.Team;
import com.dh.clase34.demo.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teams")
public class TeamController {
    @Autowired
    TeamService service;

    @GetMapping
    public ResponseEntity<List<Team>> getTeam(){
        return ResponseEntity.ok(service.findAll());
    }
    @PostMapping("/create")
    public ResponseEntity<Team> create(@RequestBody Team t){
        return ResponseEntity.ok(service.save(t));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        ResponseEntity<String> resp= null;

        if (service.delete(id)!=null){
            resp= ResponseEntity.ok("Team with id: " + id + "was deleted successfully.");
        }
        else{
            resp = ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ERROR, team with id: " + id +" could not be deleted. ");
        }
        return resp;
    }
}
