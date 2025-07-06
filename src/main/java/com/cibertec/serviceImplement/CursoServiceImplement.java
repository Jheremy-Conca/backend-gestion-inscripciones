package com.cibertec.serviceImplement;

import com.cibertec.model.Curso;
import com.cibertec.repository.CursoRepository;
import com.cibertec.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CursoServiceImplement implements CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    @Override
    public ResponseEntity<Map<String, Object>> listaCursos() {
        List<Curso> cursos = cursoRepository.findAll();
        Map<String, Object> response = new HashMap<>();

        if (cursos.isEmpty()) {
            response.put("mensaje", "No hay cursos registrados");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

        response.put("mensaje", "Listado exitoso");
        response.put("cursos", cursos);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Map<String, Object>> crearCurso(Curso curso) {
        Map<String, Object> response = new HashMap<>();

        Optional<Curso> cursoExistente = cursoRepository.findByNombreCurso(curso.getNombreCurso());
        if (cursoExistente.isPresent()) {
            response.put("mensaje", "Ya existe un curso con ese nombre");
            return new ResponseEntity<>(response, HttpStatus.CONFLICT);
        }

        cursoRepository.save(curso);
        response.put("mensaje", "Curso creado correctamente");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Map<String, Object>> editarCurso(Long id, Curso cursoNuevo) {
        Map<String, Object> response = new HashMap<>();
        Optional<Curso> optionalCurso = cursoRepository.findById(id);

        if (optionalCurso.isEmpty()) {
            response.put("mensaje", "Curso no encontrado");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

        Optional<Curso> cursoExistente = cursoRepository.findByNombreCurso(cursoNuevo.getNombreCurso());
        if (cursoExistente.isPresent() && !cursoExistente.get().getIdCurso().equals(id)) {
            response.put("mensaje", "Ya existe otro curso con ese nombre");
            return new ResponseEntity<>(response, HttpStatus.CONFLICT);
        }

        Curso curso = optionalCurso.get();
        curso.setNombreCurso(cursoNuevo.getNombreCurso());
        curso.setProfesor(cursoNuevo.getProfesor());
        curso.setSalon(cursoNuevo.getSalon());
        curso.setEstado(cursoNuevo.getEstado());
        curso.setVacantes(cursoNuevo.getVacantes());

        cursoRepository.save(curso);
        response.put("mensaje", "Curso actualizado correctamente");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Map<String, Object>> obtenerCurso(Long id) {
        Map<String, Object> response = new HashMap<>();
        Optional<Curso> cursoOpt = cursoRepository.findById(id);

        if (cursoOpt.isEmpty()) {
            response.put("mensaje", "Curso no encontrado");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

        response.put("mensaje", "Curso encontrado");
        response.put("curso", cursoOpt.get());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
