package com.cibertec.serviceImplement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cibertec.model.Estado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cibertec.repository.EstadoRepository;
import com.cibertec.service.EstadoService;

@Service
public class EstadoServiceImplement implements EstadoService {

    @Autowired
    private EstadoRepository estadoRepository;

    @Override
    public ResponseEntity<Map<String, Object>> listarEstados() {
        List<Estado> estados = estadoRepository.findAll();
        Map<String, Object> response = new HashMap<>();

        if (estados.isEmpty()) {
            response.put("mensaje", "No hay estados registrados");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

        response.put("mensaje", "Listado exitoso");
        response.put("estados", estados);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
