package com.cibertec.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cibertec.service.PaisService;

@RestController
@RequestMapping("/api/pais")
public class PaisController {

    @Autowired
    private PaisService paisService;

    @GetMapping("/lista")
    public ResponseEntity<Map<String, Object>> listarPaises() {
        return paisService.listarPaises();
    }
}
