package com.cibertec.controller;

import com.cibertec.model.Alumno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.cibertec.service.AlumnoService;
import java.util.Map;

@RestController
@RequestMapping("/api/alumno")
public class AlumnoController {

    @Autowired
    private AlumnoService alumnoService;

    @GetMapping("/lista")
    public ResponseEntity<Map<String, Object>> obtenerAlumnos() {
        return alumnoService.listaAlumnos();
    }

    @PostMapping("/crear")
    public ResponseEntity<Map<String, Object>> crearAlumno(@RequestBody Alumno alumno) {
        return alumnoService.crearAlumno(alumno);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<Map<String, Object>> editarAlumno(@PathVariable Long id, @RequestBody Alumno alumno) {
        return alumnoService.editarAlumno(id, alumno);
    }
    
    
    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> obtenerAlumnoPorId(@PathVariable Long id) {
        return alumnoService.obtenerAlumno(id);
    }

}
