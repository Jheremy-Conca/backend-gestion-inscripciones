package com.cibertec.controller;

import com.cibertec.model.Curso;
import com.cibertec.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/curso")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @GetMapping("/lista")
    public ResponseEntity<Map<String, Object>> obtenerCursos() {
        return cursoService.listaCursos();
    }

    @PostMapping("/crear")
    public ResponseEntity<Map<String, Object>> crearCurso(@RequestBody Curso curso) {
        return cursoService.crearCurso(curso);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<Map<String, Object>> editarCurso(@PathVariable Long id, @RequestBody Curso curso) {
        return cursoService.editarCurso(id, curso);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> obtenerCursoPorId(@PathVariable Long id) {
        return cursoService.obtenerCurso(id);
    }
}
