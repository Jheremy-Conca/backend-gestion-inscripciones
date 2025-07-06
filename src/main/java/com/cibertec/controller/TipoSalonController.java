package com.cibertec.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cibertec.service.TipoSalonService;

@RestController
@RequestMapping("/api/tipossalon")
public class TipoSalonController {

    @Autowired
    private TipoSalonService tipoSalonService;

    @GetMapping("/lista")
    public ResponseEntity<Map<String, Object>> listarTiposSalon() {
        return tipoSalonService.listarTiposSalon();
    }
}
