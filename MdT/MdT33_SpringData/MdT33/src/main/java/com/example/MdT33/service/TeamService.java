package com.example.MdT33.service;

import com.example.MdT33.entities.Team;
import com.example.MdT33.entities.Repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {
    @Autowired
    TeamRepository repository;

    public Team save(Team e){
        return repository.save(e);
    }
    public List<Team> findAllTeams(){
        return repository.findAll();
    }
    public String delete(Long id){
        repository.deleteById(id);
        return "Ok";
    }
}
