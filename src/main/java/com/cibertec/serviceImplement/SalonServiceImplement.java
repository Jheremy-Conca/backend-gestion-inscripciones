package com.cibertec.serviceImplement;

import com.cibertec.model.Salon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;

import com.cibertec.repository.SalonRepository;
import com.cibertec.service.SalonService;

import java.util.*;

@Service
public class SalonServiceImplement implements SalonService {

    @Autowired
    private SalonRepository salonRepository;

    @Override
    public ResponseEntity<Map<String, Object>> listaSalones() {
        List<Salon> salones = salonRepository.findAll();
        Map<String, Object> response = new HashMap<>();

        if (salones.isEmpty()) {
            response.put("mensaje", "No hay salones registrados");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

        response.put("mensaje", "Listado exitoso");
        response.put("salones", salones);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Map<String, Object>> crearSalon(Salon salon) {
        Map<String, Object> response = new HashMap<>();

        Optional<Salon> salonExistente = salonRepository.findByNumeroSalon(salon.getNumeroSalon());
        if (salonExistente.isPresent()) {
            response.put("mensaje", "Ya existe un salón con ese número");
            return new ResponseEntity<>(response, HttpStatus.CONFLICT);
        }

        salonRepository.save(salon);
        response.put("mensaje", "Salón creado correctamente");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


    @Override
    public ResponseEntity<Map<String, Object>> editarSalon(Long id, Salon salonNuevo) {
        Map<String, Object> response = new HashMap<>();
        Optional<Salon> optionalSalon = salonRepository.findById(id);

        if (optionalSalon.isEmpty()) {
            response.put("mensaje", "Salón no encontrado");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

        // Validar que el número de salón no esté repetido en otro registro
        Optional<Salon> salonExistente = salonRepository.findByNumeroSalon(salonNuevo.getNumeroSalon());
        if (salonExistente.isPresent() && !salonExistente.get().getIdSalon().equals(id)) {
            response.put("mensaje", "Ya existe otro salón con ese número");
            return new ResponseEntity<>(response, HttpStatus.CONFLICT);
        }

        Salon salon = optionalSalon.get();
        salon.setNumeroSalon(salonNuevo.getNumeroSalon());
        salon.setPiso(salonNuevo.getPiso());
        salon.setCapacidad(salonNuevo.getCapacidad());
        salon.setTipoSalon(salonNuevo.getTipoSalon());
        salon.setEstado(salonNuevo.getEstado());

        salonRepository.save(salon);
        response.put("mensaje", "Salón actualizado correctamente");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    
    @Override
    public ResponseEntity<Map<String, Object>> obtenerSalon(Long id) {
        Map<String, Object> response = new HashMap<>();
        Optional<Salon> optionalSalon = salonRepository.findById(id);

        if (optionalSalon.isEmpty()) {
            response.put("mensaje", "Salón no encontrado");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

        response.put("mensaje", "Salón encontrado");
        response.put("salon", optionalSalon.get());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
