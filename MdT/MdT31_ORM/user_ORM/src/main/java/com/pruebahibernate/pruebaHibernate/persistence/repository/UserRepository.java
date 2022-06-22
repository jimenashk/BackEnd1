package com.pruebahibernate.pruebaHibernate.persistence.repository;

import com.pruebahibernate.pruebaHibernate.persistence.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Usuario, Integer> {
}
