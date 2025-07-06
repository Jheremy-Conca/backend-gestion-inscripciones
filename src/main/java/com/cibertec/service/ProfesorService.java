package com.cibertec.service;

import java.util.Map;

import com.cibertec.model.Profesor;
import org.springframework.http.ResponseEntity;

public interface ProfesorService {
    ResponseEntity<Map<String, Object>> listaProfesores();
    ResponseEntity<Map<String, Object>> crearProfesor(Profesor profesor);
    ResponseEntity<Map<String, Object>> editarProfesor(Long id, Profesor profesor);
    ResponseEntity<Map<String, Object>> obtenerProfesor(Long id);

}