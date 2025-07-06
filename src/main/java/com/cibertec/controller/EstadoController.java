package com.cibertec.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cibertec.service.EstadoService;

@RestController
@RequestMapping("/api/estado")
public class EstadoController {

    @Autowired
    private EstadoService estadoService;

    @GetMapping("/lista")
    public ResponseEntity<Map<String, Object>> listarEstados() {
        return estadoService.listarEstados();
    }
}
