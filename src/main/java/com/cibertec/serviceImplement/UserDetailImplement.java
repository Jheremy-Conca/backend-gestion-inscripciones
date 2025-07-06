package com.cibertec.serviceImplement;

import java.util.Collection;
import java.util.Collections;

import com.cibertec.model.Rol;
import com.cibertec.model.Usuario;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserDetailImplement implements UserDetails {

    private Usuario usuario;

    public UserDetailImplement(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList();
    }

    @Override
    public String getPassword() {
        return usuario.getPassword();
    }

    @Override
    public String getUsername() {
        return usuario.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getUser() {
        return usuario.getNombre(); 
    }

    public Rol getRol() {
        return usuario.getRol();
    }
}
