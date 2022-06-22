package com.example.StudenthHibernate.service;

import com.example.StudenthHibernate.persistence.entities.Student;

import java.util.List;
import java.util.Optional;

public interface IStudentService {
    List<Student> findAllStudents();

    Optional<Student> findStudentById(Long Id);

    Student saveStudent(Student studentNew);

    String deleteStudent(Long id);

    String updateStudent (Student studentNew);
}
