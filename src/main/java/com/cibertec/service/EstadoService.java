package com.cibertec.service;

import java.util.Map;
import org.springframework.http.ResponseEntity;

public interface EstadoService {
    ResponseEntity<Map<String, Object>> listarEstados();
}
