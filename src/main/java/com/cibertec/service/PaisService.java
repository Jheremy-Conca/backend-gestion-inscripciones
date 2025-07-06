package com.cibertec.service;

import java.util.Map;
import org.springframework.http.ResponseEntity;

public interface PaisService {
    ResponseEntity<Map<String, Object>> listarPaises();
}
