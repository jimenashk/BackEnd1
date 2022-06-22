package com.producto.productoHibernate.persistence.repository;

import com.producto.productoHibernate.persistence.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
