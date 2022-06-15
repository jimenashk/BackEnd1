package com.clase22.springmvc.controller;

import com.clase22.springmvc.model.Usuario;
import com.clase22.springmvc.services.UsuarioService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {

    private UsuarioService usuarioService = new UsuarioService();

    //creacion del primer endpoint
    @GetMapping("/")
    public Usuario crearUsuario(){
        return usuarioService.crearUsuario();
    }

    @GetMapping("crear2")
    public Usuario crearUsuario2 (){
        Usuario usuario = new Usuario("Alicia", 45);
        return usuario;
    }
}
