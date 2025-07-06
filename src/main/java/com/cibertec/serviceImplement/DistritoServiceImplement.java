package com.cibertec.serviceImplement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cibertec.model.Distrito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cibertec.repository.DistritoRepository;
import com.cibertec.service.DistritoService;

@Service
public class DistritoServiceImplement implements DistritoService {

    @Autowired
    private DistritoRepository distritoRepository;

    @Override
    public ResponseEntity<Map<String, Object>> listarDistritos() {
        List<Distrito> distritos = distritoRepository.findAll();
        Map<String, Object> response = new HashMap<>();

        if (distritos.isEmpty()) {
            response.put("mensaje", "No hay distritos registrados");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

        response.put("mensaje", "Listado exitoso");
        response.put("distritos", distritos);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
