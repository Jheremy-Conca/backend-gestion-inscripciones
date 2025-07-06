package com.cibertec.service;

import java.util.Map;
import org.springframework.http.ResponseEntity;

public interface DistritoService {
    ResponseEntity<Map<String, Object>> listarDistritos();
}
