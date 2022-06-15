package com.clase22.springmvc.services;

import com.clase22.springmvc.model.Usuario;

public class UsuarioService {
    public Usuario crearUsuario(){
        Usuario usuario = new Usuario("Diego", 22);
        return usuario;
    }
}
