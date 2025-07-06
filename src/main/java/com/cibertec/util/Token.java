package com.cibertec.util;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import java.util.*;


public class Token {

    private static final long TOKEN_DURACION = 1500L;

    private static final String TOKEN_SECRETO = "gx3ejrO4sTctYPXSjpdPfVotUfL6bWAd";

    public static String crearToken(String nombre, String email) {
        Date expiracion = new Date(System.currentTimeMillis() + (TOKEN_DURACION * 1000L));
        Map<String, Object> claims = new HashMap<>();
        claims.put("nombre", nombre);

        return Jwts.builder()
                .setSubject(email)
                .setExpiration(expiracion)
                .addClaims(claims)
                .signWith(Keys.hmacShaKeyFor(TOKEN_SECRETO.getBytes()))
                .compact();
    }

    public static UsernamePasswordAuthenticationToken getAuth(String token) {
        try {
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(TOKEN_SECRETO.getBytes())
                    .build()
                    .parseClaimsJws(token)
                    .getBody();

            String email = claims.getSubject();
            return new UsernamePasswordAuthenticationToken(email, null, Collections.emptyList());

        } catch (JwtException | IllegalArgumentException e) {
            System.err.println("Error al validar token: " + e.getMessage());
            return null;
        }
    }
}

