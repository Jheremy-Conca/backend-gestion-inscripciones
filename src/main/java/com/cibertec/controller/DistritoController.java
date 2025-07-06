package com.cibertec.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cibertec.service.DistritoService;

@RestController
@RequestMapping("/api/distrito")
public class DistritoController {

    @Autowired
    private DistritoService distritoService;

    @GetMapping("/lista")
    public ResponseEntity<Map<String, Object>> listarDistritos() {
        return distritoService.listarDistritos();
    }
}
