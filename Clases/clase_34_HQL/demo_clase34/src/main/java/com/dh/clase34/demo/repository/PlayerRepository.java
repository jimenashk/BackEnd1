package com.dh.clase34.demo.repository;

import com.dh.clase34.demo.entities.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
        }
