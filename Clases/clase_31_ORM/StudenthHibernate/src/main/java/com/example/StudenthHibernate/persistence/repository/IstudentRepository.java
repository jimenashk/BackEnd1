package com.example.StudenthHibernate.persistence.repository;

import com.example.StudenthHibernate.persistence.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IstudentRepository extends JpaRepository<Student, Long> {
    }


