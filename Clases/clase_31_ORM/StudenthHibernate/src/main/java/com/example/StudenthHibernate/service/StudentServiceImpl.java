package com.example.StudenthHibernate.service;

import com.example.StudenthHibernate.persistence.entities.Student;
import com.example.StudenthHibernate.persistence.repository.IstudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements IStudentService{
    private final IstudentRepository studentRepository;
 public StudentServiceImpl(IstudentRepository studentRepository){
     this.studentRepository = studentRepository;
 }
    @Override
    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> findStudentById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public Student saveStudent(Student studentNew) {
        if(studentNew != null){
            return studentRepository.save(studentNew);
        }
        return new Student();
    }

    @Override
    public String deleteStudent(Long id) {
        if(studentRepository.findById(id).isPresent()){
            studentRepository.deleteById(id);
            return "Student with id: " + id + " delete";
        }
        return "student with id: "+id + " dont exist";
    }

    @Override
    public String updateStudent(Student studentNew) {
        return null;
    }
}
