package com.cibertec.service;

import com.cibertec.model.Curso;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface CursoService {
    ResponseEntity<Map<String, Object>> listaCursos();
    ResponseEntity<Map<String, Object>> crearCurso(Curso curso);
    ResponseEntity<Map<String, Object>> editarCurso(Long id, Curso curso);
    ResponseEntity<Map<String, Object>> obtenerCurso(Long id);
}
