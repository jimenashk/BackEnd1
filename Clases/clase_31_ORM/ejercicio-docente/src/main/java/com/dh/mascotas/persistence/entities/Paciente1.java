package com.dh.mascotas.persistence.entities;

import javax.persistence.*;

    @Entity
    public class Paciente1 {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Integer id;
        @Column
        private String nombre;
        @Column
        private String apellido;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getApellido() {
            return apellido;
        }

        public void setApellido(String apellido) {
            this.apellido = apellido;
        }
    }
