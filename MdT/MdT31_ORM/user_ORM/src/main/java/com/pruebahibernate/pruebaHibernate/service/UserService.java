package com.pruebahibernate.pruebaHibernate.service;

import com.pruebahibernate.pruebaHibernate.persistence.entities.Usuario;
import com.pruebahibernate.pruebaHibernate.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {

    @Autowired
    UserRepository repository;

    public String save(Usuario u){
        if(repository.save(u) != null){
            return "OK";
        } else {
            return null;
        }
    }

    public List<Usuario> obtenerTodos() {
        return repository.findAll();
    }

    public String eliminarUsuario(Integer id) {
        if(repository.findById(id).isPresent()){
            String productName = repository.getReferenceById(id).getUsuario();
            repository.deleteById(id);
            return "Usuario id: " + id + " fué eliminado.";
        }
        return "Producto id: " + id + " no fué encontrado.";
    }

    public String modificarUsuario(Usuario u) {
        Integer UsuarioId = u.getId();

        String respuesta = "";

        if(repository.findById(UsuarioId).isPresent()) {
            Usuario usuarioModificar = repository.getReferenceById(UsuarioId);
            usuarioModificar.setUsuario(u.getUsuario());
            usuarioModificar.setPassword(u.getPassword());
            repository.save(usuarioModificar);

            respuesta = "El Usuario con Id: " + UsuarioId  + " fué modificado.";
        } else {
            respuesta = "El Usuario con Id: " + UsuarioId  + " no existe.";
        }
        return respuesta;
    }
}










