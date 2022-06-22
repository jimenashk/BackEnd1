package com.pruebahibernate.pruebaHibernate.persistence.entities;

import javax.persistence.*;

@Entity
@Table
public class Usuario {
@Id
@SequenceGenerator(name = "usuario_sequence", sequenceName = "usuario_sequence")
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario_sequence")
    private Integer id;
@Column
    private String usuario;
@Column
    private  String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", usuario='" + usuario + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
