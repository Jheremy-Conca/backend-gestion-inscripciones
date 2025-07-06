package com.cibertec.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cibertec.service.GeneroService;

@RestController
@RequestMapping("/api/genero") // Ruta base para acceder a los métodos
public class GeneroController {

    @Autowired
    private GeneroService generoService;

    // Endpoint para listar todos los géneros
    @GetMapping("/lista")
    public ResponseEntity<Map<String, Object>> listarGeneros() {
        return generoService.listaGenero();
    }
}
