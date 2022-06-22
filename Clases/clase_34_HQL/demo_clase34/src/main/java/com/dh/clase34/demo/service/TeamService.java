package com.dh.clase34.demo.service;

import com.dh.clase34.demo.entities.Team;
import com.dh.clase34.demo.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {
    @Autowired
    TeamRepository repository;

    public Team save(Team t){
        return repository.save(t);
    }
    public List<Team> findAll(){
        return repository.findAll();
    }
    public String delete(Long id){
        repository.deleteById(id);
        return "Ok";
    }
}
