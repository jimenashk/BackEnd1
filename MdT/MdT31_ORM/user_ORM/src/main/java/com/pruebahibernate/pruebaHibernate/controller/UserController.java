package com.pruebahibernate.pruebaHibernate.controller;

import com.pruebahibernate.pruebaHibernate.persistence.entities.Usuario;
import com.pruebahibernate.pruebaHibernate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @RestController
    @RequestMapping("/usuarios")
    public class UserController {

        @Autowired
        UserService service;

        @PostMapping("/crear")
        public ResponseEntity<String> crear(@RequestBody Usuario m){
            ResponseEntity<String> respuesta = null;

            if(service.save(m) != null){
                respuesta = ResponseEntity.ok("El usuario fue registrado con éxito");
            }else{
                respuesta = ResponseEntity.internalServerError().body("ERROR: EL USUARIO no fue encontrado");
            }

            return respuesta;
        }

        @RequestMapping(value = "/todos", method = RequestMethod.GET, produces = "application/json")
        public List<Usuario> getUsuario() {
            return service.obtenerTodos();
        }

        @DeleteMapping(value = "/eliminar/{id}")
        public String deleteUsuario(@PathVariable Integer id) {
            return service.eliminarUsuario(id);
        }

        @PutMapping(value = "/modificar")
        public String updateProduct(Usuario usuario){
            return service.modificarUsuario(usuario);
        }



    }