package com.example.MdT33.controller;

import com.example.MdT33.entities.Team;
import com.example.MdT33.service.TeamService;
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
        return ResponseEntity.ok(service.findAllTeams());
    }
    @PostMapping("/create")
    public ResponseEntity<Team> create(@RequestBody Team t){
        return ResponseEntity.ok(service.save(t));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        ResponseEntity<String> resp= null;

        if (service.delete(id)!=null){
            resp= ResponseEntity.ok("Team with id: " + id + "was deleted successfully..");
        }
        else{
            resp = ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ERROR, team with id: " + id +" could not be deleted. ");
        }
        return resp;
    }
}
