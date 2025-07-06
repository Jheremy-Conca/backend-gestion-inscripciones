package com.cibertec.serviceImplement;

import com.cibertec.model.Usuario;
import com.cibertec.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplement implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findOneByEmail(email)
                .orElseThrow(() ->
                        new UsernameNotFoundException("El usuario con email '" + email + "' no se encuentra registrado"));

        return new UserDetailImplement(usuario);
    }
}
