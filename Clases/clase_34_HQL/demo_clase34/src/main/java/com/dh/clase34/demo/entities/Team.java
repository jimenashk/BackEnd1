package com.dh.clase34.demo.entities;

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
@Table(name = "teams")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column
    private String name;
    @Column
    private String city;

    @OneToMany(mappedBy = "team", fetch = FetchType.LAZY)
    //un Equipo va a tener muchos jugadores, por eso una coleccion con SET
    private Set<Player> players = new HashSet<>();

    public Team(){}
}
