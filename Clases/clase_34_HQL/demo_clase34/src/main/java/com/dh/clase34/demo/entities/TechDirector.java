package com.dh.clase34.demo.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name= "techdirectors")
public class TechDirector {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column
    private String name;
    @Column
    private int age;
    @OneToMany(mappedBy = "techDirector", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Player> players = new HashSet<>();

    public TechDirector(){}
}
