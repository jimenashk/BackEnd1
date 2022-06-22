package com.clase33.clase33.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@ToString
@Getter
@Setter
@Table(name= "teachers")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column
    private String name;
    @Column
    private String title;

    @OneToMany(mappedBy = "teacher", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    //un profesor va a tener muchos alumnos, para eso hacemos una coleccion con SET
    private Set<Student> students = new HashSet<>();

    public Teacher() {
    }
}
