package com.example.StudenthHibernate.persistence.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@ToString
@Getter
@Setter
@Entity
public class Student {
@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private Integer dni;
    private String name;
    private String lastname;
}
