package com.cibertec.service;

import java.util.Map;
import org.springframework.http.ResponseEntity;

public interface TipoSalonService {
    ResponseEntity<Map<String, Object>> listarTiposSalon();
}
