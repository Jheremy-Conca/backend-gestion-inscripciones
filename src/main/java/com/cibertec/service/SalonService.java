package com.cibertec.service;

import java.util.Map;

import com.cibertec.model.Salon;
import org.springframework.http.ResponseEntity;

public interface SalonService {
    ResponseEntity<Map<String, Object>> listaSalones();
	ResponseEntity<Map<String, Object>> crearSalon(Salon salon);
	ResponseEntity<Map<String, Object>> editarSalon(Long id, Salon salonNuevo);
	ResponseEntity<Map<String, Object>> obtenerSalon(Long id);

}