package com.cibertec.serviceImplement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cibertec.model.Pais;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cibertec.repository.PaisRepository;
import com.cibertec.service.PaisService;

@Service
public class PaisServiceImplement implements PaisService {

    @Autowired
    private PaisRepository paisRepository;

    @Override
    public ResponseEntity<Map<String, Object>> listarPaises() {
        List<Pais> paises = paisRepository.findAll();
        Map<String, Object> response = new HashMap<>();

        if (paises.isEmpty()) {
            response.put("mensaje", "No hay países registrados");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

        response.put("mensaje", "Listado exitoso");
        response.put("paises", paises);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
