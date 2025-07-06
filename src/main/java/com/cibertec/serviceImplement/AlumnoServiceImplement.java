package com.cibertec.serviceImplement;

import com.cibertec.model.Alumno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;

import com.cibertec.repository.AlumnoRepository;
import com.cibertec.service.AlumnoService;

import java.util.*;

@Service
public class AlumnoServiceImplement implements AlumnoService {

    @Autowired
    private AlumnoRepository alumnoRepository;

    @Override
    public ResponseEntity<Map<String, Object>> listaAlumnos() {
        List<Alumno> alumnos = alumnoRepository.findAll();
        Map<String, Object> response = new HashMap<>();

        if (alumnos.isEmpty()) {
            response.put("mensaje", "No hay alumnos registrados");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

        response.put("mensaje", "Listado exitoso");
        response.put("alumnos", alumnos);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @Override
    public ResponseEntity<Map<String, Object>> crearAlumno(Alumno alumno) {
        Map<String, Object> response = new HashMap<>();

        // Verificar si el DNI ya existe
        Optional<Alumno> alumnoPorDni = alumnoRepository.findByDni(alumno.getDni());
        if (alumnoPorDni.isPresent()) {
            response.put("mensaje", "Ya existe un alumno con ese DNI");
            return new ResponseEntity<>(response, HttpStatus.CONFLICT);
        }

        // Verificar si el correo ya existe
        Optional<Alumno> alumnoPorCorreo = alumnoRepository.findByCorreo(alumno.getCorreo());
        if (alumnoPorCorreo.isPresent()) {
            response.put("mensaje", "Ya existe un alumno con ese correo");
            return new ResponseEntity<>(response, HttpStatus.CONFLICT);
        }

        alumnoRepository.save(alumno);
        response.put("mensaje", "Alumno creado correctamente");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


    @Override
    public ResponseEntity<Map<String, Object>> editarAlumno(Long id, Alumno alumnoNuevo) {
        Map<String, Object> response = new HashMap<>();
        Optional<Alumno> optionalAlumno = alumnoRepository.findById(id);

        if (optionalAlumno.isEmpty()) {
            response.put("mensaje", "Alumno no encontrado");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

        // Validar DNI duplicado (excluyendo el propio ID)
        Optional<Alumno> alumnoPorDni = alumnoRepository.findByDni(alumnoNuevo.getDni());
        if (alumnoPorDni.isPresent() && !alumnoPorDni.get().getIdAlumno().equals(id)) {
            response.put("mensaje", "Ya existe otro alumno con ese DNI");
            return new ResponseEntity<>(response, HttpStatus.CONFLICT);
        }

        // Validar correo duplicado (excluyendo el propio ID)
        Optional<Alumno> alumnoPorCorreo = alumnoRepository.findByCorreo(alumnoNuevo.getCorreo());
        if (alumnoPorCorreo.isPresent() && !alumnoPorCorreo.get().getIdAlumno().equals(id)) {
            response.put("mensaje", "Ya existe otro alumno con ese correo");
            return new ResponseEntity<>(response, HttpStatus.CONFLICT);
        }

        Alumno alumno = optionalAlumno.get();
        alumno.setNombres(alumnoNuevo.getNombres());
        alumno.setApellidos(alumnoNuevo.getApellidos());
        alumno.setDni(alumnoNuevo.getDni());
        alumno.setGenero(alumnoNuevo.getGenero());
        alumno.setPais(alumnoNuevo.getPais());
        alumno.setDistrito(alumnoNuevo.getDistrito());
        alumno.setTelefono(alumnoNuevo.getTelefono());
        alumno.setCorreo(alumnoNuevo.getCorreo());
        alumno.setEstado(alumnoNuevo.getEstado());

        alumnoRepository.save(alumno);
        response.put("mensaje", "Alumno actualizado correctamente");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    
    @Override
    public ResponseEntity<Map<String, Object>> obtenerAlumno(Long id) {
        Map<String, Object> response = new HashMap<>();
        Optional<Alumno> alumnoOpt = alumnoRepository.findById(id);

        if (alumnoOpt.isEmpty()) {
            response.put("mensaje", "Alumno no encontrado");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

        response.put("mensaje", "Alumno encontrado");
        response.put("alumno", alumnoOpt.get());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
