package com.cibertec.security;

import com.cibertec.model.Auth;
import com.cibertec.serviceImplement.UserDetailImplement;
import com.cibertec.serviceImplement.UsuarioServiceImplement;
import com.cibertec.util.SpringContext;
import com.cibertec.util.Token;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.IOException;
import java.util.Collections;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {
        try {
            Auth authRequest = new ObjectMapper().readValue(request.getReader(), Auth.class);
            UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                    authRequest.getEmail(),
                    authRequest.getPassword(),
                    Collections.emptyList()
            );
            return getAuthenticationManager().authenticate(authToken);
        } catch (IOException e) {
            throw new RuntimeException("Error parsing login request", e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response,
                                            FilterChain chain, Authentication authResult)
            throws IOException, ServletException {
        UserDetailImplement userDetails = (UserDetailImplement) authResult.getPrincipal();
        UsuarioServiceImplement userService = SpringContext.getBean(UsuarioServiceImplement.class);

        userService.actualizarFechaLogin(userDetails.getUsername());

        String jwtToken = Token.crearToken(userDetails.getUser(), userDetails.getUsername());
        response.addHeader("Authorization", "Bearer " + jwtToken);
        response.getWriter().flush();
    }
}
