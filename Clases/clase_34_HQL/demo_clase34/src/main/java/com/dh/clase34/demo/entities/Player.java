package com.dh.clase34.demo.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "players")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column
    private String name;
    @Column
    private String position;
    @Column
    private int number;
    @Column
    private String favoriteClub;
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "techdirector_id")
    private TechDirector techDirector;

    public Player(){}
}
