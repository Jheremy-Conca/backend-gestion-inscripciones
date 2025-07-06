package com.cibertec.serviceImplement;

import com.cibertec.model.Profesor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;

import com.cibertec.repository.ProfesorRepository;
import com.cibertec.service.ProfesorService;

import java.util.*;

@Service
public class ProfesorServiceImplement implements ProfesorService{

    @Autowired
    private ProfesorRepository profesorRepository;

    @Override
    public ResponseEntity<Map<String, Object>> listaProfesores() {
        List<Profesor> profesores = profesorRepository.findAll();
        Map<String, Object> response = new HashMap<>();

        if (profesores.isEmpty()) {
            response.put("mensaje", "No hay profesores registrados");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

        response.put("mensaje", "Listado exitoso");
        response.put("profesores", profesores);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    
    @Override
    public ResponseEntity<Map<String, Object>> crearProfesor(Profesor profesor) {
        Map<String, Object> response = new HashMap<>();

        Optional<Profesor> profPorDni = profesorRepository.findByDni(profesor.getDni());
        if (profPorDni.isPresent()) {
            response.put("mensaje", "Ya existe un profesor con ese DNI");
            return new ResponseEntity<>(response, HttpStatus.CONFLICT);
        }

        Optional<Profesor> profPorCorreo = profesorRepository.findByCorreo(profesor.getCorreo());
        if (profPorCorreo.isPresent()) {
            response.put("mensaje", "Ya existe un profesor con ese correo");
            return new ResponseEntity<>(response, HttpStatus.CONFLICT);
        }

        profesorRepository.save(profesor);
        response.put("mensaje", "Profesor creado correctamente");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


    @Override
    public ResponseEntity<Map<String, Object>> editarProfesor(Long id, Profesor profesorNuevo) {
        Map<String, Object> response = new HashMap<>();
        Optional<Profesor> optionalProfesor = profesorRepository.findById(id);

        if (optionalProfesor.isEmpty()) {
            response.put("mensaje", "Profesor no encontrado");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

        // Validar DNI único excluyendo al profesor actual
        Optional<Profesor> profPorDni = profesorRepository.findByDni(profesorNuevo.getDni());
        if (profPorDni.isPresent() && !profPorDni.get().getIdProfesor().equals(id)) {
            response.put("mensaje", "Ya existe otro profesor con ese DNI");
            return new ResponseEntity<>(response, HttpStatus.CONFLICT);
        }

        // Validar correo único excluyendo al profesor actual
        Optional<Profesor> profPorCorreo = profesorRepository.findByCorreo(profesorNuevo.getCorreo());
        if (profPorCorreo.isPresent() && !profPorCorreo.get().getIdProfesor().equals(id)) {
            response.put("mensaje", "Ya existe otro profesor con ese correo");
            return new ResponseEntity<>(response, HttpStatus.CONFLICT);
        }

        Profesor profesor = optionalProfesor.get();
        profesor.setNombres(profesorNuevo.getNombres());
        profesor.setApellidos(profesorNuevo.getApellidos());
        profesor.setDni(profesorNuevo.getDni());
        profesor.setGenero(profesorNuevo.getGenero());
        profesor.setPais(profesorNuevo.getPais());
        profesor.setDistrito(profesorNuevo.getDistrito());
        profesor.setTelefono(profesorNuevo.getTelefono());
        profesor.setCorreo(profesorNuevo.getCorreo());
        profesor.setEstado(profesorNuevo.getEstado());

        profesorRepository.save(profesor);
        response.put("mensaje", "Profesor actualizado correctamente");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    
    @Override
    public ResponseEntity<Map<String, Object>> obtenerProfesor(Long id) {
        Map<String, Object> response = new HashMap<>();
        Optional<Profesor> optionalProfesor = profesorRepository.findById(id);

        if (optionalProfesor.isEmpty()) {
            response.put("mensaje", "Profesor no encontrado");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

        response.put("mensaje", "Profesor encontrado");
        response.put("profesor", optionalProfesor.get());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
