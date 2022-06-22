package com.dh.clase34.demo.repository;

import com.dh.clase34.demo.entities.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {
}
