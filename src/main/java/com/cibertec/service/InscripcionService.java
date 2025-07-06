package com.cibertec.service;

import java.util.Map;

import com.cibertec.model.Inscripcion;
import org.springframework.http.ResponseEntity;

public interface InscripcionService {
    ResponseEntity<Map<String, Object>> listaInscripciones();
    ResponseEntity<Map<String, Object>> crearInscripcion(Inscripcion inscripcion);
    ResponseEntity<Map<String, Object>> editarInscripcion(Long id, Inscripcion inscripcion);
    ResponseEntity<Map<String, Object>> obtenerInscripcion(Long id);
}