package com.cibertec.service;

import java.util.List;
import java.util.Map;

import com.cibertec.model.Genero;
import org.springframework.http.ResponseEntity;

public interface GeneroService {
    ResponseEntity<Map<String, Object>> listaGenero();
    
    List<Genero> findAll();  // <-- Agrega este método
}
