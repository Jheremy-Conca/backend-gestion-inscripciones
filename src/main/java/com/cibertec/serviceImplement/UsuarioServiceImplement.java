package com.cibertec.serviceImplement;

import com.cibertec.model.Usuario;
import com.cibertec.repository.UsuarioRepository;
import com.cibertec.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class UsuarioServiceImplement implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Usuario crearUsuario(Usuario usuario) {
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        usuario.setFechaRegistro(new Timestamp(System.currentTimeMillis()));
        return usuarioRepository.save(usuario);
    }

    @Override
    public void actualizarFechaLogin(String email) {
        usuarioRepository.findOneByEmail(email).ifPresent(usuario -> {
            usuario.setFechaRegistro(new Timestamp(System.currentTimeMillis()));
            usuarioRepository.save(usuario);
        });
    }

}