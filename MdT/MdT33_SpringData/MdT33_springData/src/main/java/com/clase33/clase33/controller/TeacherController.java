package com.clase33.clase33.controller;

import com.clase33.clase33.entities.Teacher;
import com.clase33.clase33.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teachers")
public class TeacherController {
    @Autowired
    TeacherService service;

    @GetMapping
    public ResponseEntity<List<Teacher>> getTeacher(){
        return ResponseEntity.ok(service.findAllTeachers());
    }

    @PostMapping("/create")
    public ResponseEntity<Teacher> create(@RequestBody Teacher t){
        return ResponseEntity.ok(service.save(t));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        ResponseEntity<String> respuesta = null;

        if (service.delete(id) != null){
            respuesta = ResponseEntity.ok("Teacher with id: " + id + "was deleted successfully.");
        }
        else{
            respuesta = ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ERROR, teacher with id: " + id + " could not be deleted. ");
        }
        return respuesta;
    }
}
