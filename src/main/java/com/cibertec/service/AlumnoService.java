package com.cibertec.service;

import java.util.Map;

import com.cibertec.model.Alumno;
import org.springframework.http.ResponseEntity;


public interface AlumnoService {
    ResponseEntity<Map<String, Object>> listaAlumnos();
    ResponseEntity<Map<String, Object>> crearAlumno(Alumno alumno);
    ResponseEntity<Map<String, Object>> editarAlumno(Long id, Alumno alumno);
    ResponseEntity<Map<String, Object>> obtenerAlumno(Long id);


}
