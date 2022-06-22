package com.example.StudenthHibernate.controller;

import com.example.StudenthHibernate.persistence.entities.Student;
import com.example.StudenthHibernate.service.StudentServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {
    private final StudentServiceImpl studentService;

    StudentController (StudentServiceImpl studentService) {
        this.studentService = studentService;
    }
    @RequestMapping(value = "/students", method = RequestMethod.GET, produces = "application/json")
    public List<Student> getStudents(){
        return studentService.findAllStudents();
    }

    @GetMapping (value = "/student/{id}")
    public Optional<Student> getStudentsById(@PathVariable Long id){
        return studentService.findStudentById(id);

    }

    @PostMapping(value ="/student/add")
    public Student addStudent(Student student){
        return studentService.saveStudent(student);
    }

    @DeleteMapping(value = "/student/delete/{id}")
    public String deleteStudent(@PathVariable Long id){
        return studentService.deleteStudent(id);
    }

    //http://localhost:8080/student/update (UPDATE)
    @PostMapping(value = "/student/update")
    public String updateStudent( Student studentNew){
        return studentService.updateStudent((studentNew));
    }

}
