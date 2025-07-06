package com.cibertec.service;

import com.cibertec.model.Usuario;

public interface UsuarioService {
    Usuario crearUsuario(Usuario usuario);
    void actualizarFechaLogin(String email);
}