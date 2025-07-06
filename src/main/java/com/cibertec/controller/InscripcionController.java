package com.cibertec.controller;

import com.cibertec.model.Inscripcion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cibertec.service.InscripcionService;

import java.util.Map;

@RestController
@RequestMapping("/api/inscripcion")
public class InscripcionController {

    @Autowired
    private InscripcionService inscripcionService;

    @GetMapping("/lista")
    public ResponseEntity<Map<String, Object>> obtenerInscripciones() {
        return inscripcionService.listaInscripciones();
    }

    @PostMapping("/crear")
    public ResponseEntity<Map<String, Object>> crearInscripcion(@RequestBody Inscripcion inscripcion) {
        return inscripcionService.crearInscripcion(inscripcion);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> obtenerPorId(@PathVariable Long id) {
        return inscripcionService.obtenerInscripcion(id);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<Map<String, Object>> editarInscripcion(
            @PathVariable Long id,
            @RequestBody Inscripcion inscripcion) {
        return inscripcionService.editarInscripcion(id, inscripcion);
    }
}
