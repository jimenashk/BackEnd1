package com.clase33.clase33.entities.Repository;

import com.clase33.clase33.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
