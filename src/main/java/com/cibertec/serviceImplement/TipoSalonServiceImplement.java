package com.cibertec.serviceImplement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cibertec.model.TipoSalon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cibertec.repository.TipoSalonRepository;
import com.cibertec.service.TipoSalonService;

@Service
public class TipoSalonServiceImplement implements TipoSalonService {

    @Autowired
    private TipoSalonRepository tipoSalonRepository;

    @Override
    public ResponseEntity<Map<String, Object>> listarTiposSalon() {
        List<TipoSalon> tipos = tipoSalonRepository.findAll();
        Map<String, Object> response = new HashMap<>();

        if (tipos.isEmpty()) {
            response.put("mensaje", "No hay tipos de salón registrados");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

        response.put("mensaje", "Listado exitoso");
        response.put("tiposSalon", tipos);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
