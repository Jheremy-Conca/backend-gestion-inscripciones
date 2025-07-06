package com.cibertec.serviceImplement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cibertec.model.Genero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cibertec.repository.GeneroRepository;
import com.cibertec.service.GeneroService;

@Service
public class GeneroServiceImplement implements GeneroService {

    @Autowired
    private GeneroRepository generoRepository;

    @Override
    public List<Genero> findAll() {
        return generoRepository.findAll();
    }

    @Override
    public ResponseEntity<Map<String, Object>> listaGenero() {
        List<Genero> generos = findAll(); 
        Map<String, Object> response = new HashMap<>();

        if (generos.isEmpty()) {
            response.put("mensaje", "No hay generos registrados");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

        response.put("mensaje", "Listado exitoso");
        response.put("generos", generos);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
