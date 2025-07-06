// 6. UsuarioController.java
package com.cibertec.controller;

import com.cibertec.model.Usuario;
import com.cibertec.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/register")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Usuario> crearUsuario(@RequestBody Usuario usuario) {
        Usuario creado = usuarioService.crearUsuario(usuario);
        return ResponseEntity.ok(creado);
    }
}
