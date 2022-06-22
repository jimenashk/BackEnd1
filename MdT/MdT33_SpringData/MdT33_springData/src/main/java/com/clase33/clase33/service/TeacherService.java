package com.clase33.clase33.service;

import com.clase33.clase33.entities.Teacher;
import com.clase33.clase33.entities.Repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TeacherService {
    @Autowired
    TeacherRepository repository;

    public Teacher save(Teacher p){
        return repository.save(p);
    }
    public List<Teacher> findAllTeachers(){
        return repository.findAll();
    }
    public String delete(Long id){
        repository.deleteById(id);
        return "Ok";
    }
}
