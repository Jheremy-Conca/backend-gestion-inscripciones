package com.cibertec.controller;

import com.cibertec.model.Salon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cibertec.service.SalonService;

import java.util.Map;

@RestController
@RequestMapping("/api/salon")
public class SalonController {
    @Autowired
    private SalonService salonService;

    @GetMapping("/lista")
    public ResponseEntity<Map<String, Object>> obtenerSalones() {
        return salonService.listaSalones();
    }

    @PostMapping("/crear")
    public ResponseEntity<Map<String, Object>> crearSalon(@RequestBody Salon salon) {
        return salonService.crearSalon(salon);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<Map<String, Object>> editarSalon(@PathVariable Long id, @RequestBody Salon salon) {
        return salonService.editarSalon(id, salon);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> obtenerSalon(@PathVariable Long id) {
        return salonService.obtenerSalon(id);
    }

}
