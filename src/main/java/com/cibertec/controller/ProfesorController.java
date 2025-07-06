package com.cibertec.controller;

import com.cibertec.model.Profesor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.cibertec.service.ProfesorService;
import java.util.Map;

@RestController
@RequestMapping("/api/profesor")
public class ProfesorController {
    @Autowired
    private ProfesorService profesorService;

    @GetMapping("/lista")
    public ResponseEntity<Map<String, Object>> obtenerProfesores() {
        return profesorService.listaProfesores();
    }
    
    @PostMapping("/crear")
    public ResponseEntity<Map<String, Object>> crearProfesor(@RequestBody Profesor profesor) {
        return profesorService.crearProfesor(profesor);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<Map<String, Object>> editarProfesor(@PathVariable Long id, @RequestBody Profesor profesor) {
        return profesorService.editarProfesor(id, profesor);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> obtenerProfesor(@PathVariable Long id) {
        return profesorService.obtenerProfesor(id);
    }

}

