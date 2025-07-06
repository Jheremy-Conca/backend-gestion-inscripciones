package com.cibertec.serviceImplement;

import com.cibertec.model.Alumno;
import com.cibertec.model.Curso;
import com.cibertec.model.Estado;
import com.cibertec.model.Inscripcion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;

import com.cibertec.repository.AlumnoRepository;
import com.cibertec.repository.CursoRepository;
import com.cibertec.repository.EstadoRepository;
import com.cibertec.repository.InscripcionRepository;
import com.cibertec.service.InscripcionService;

import java.sql.Timestamp;
import java.util.*;

@Service
public class InscripcionServiceImplement implements InscripcionService{

    @Autowired
    private InscripcionRepository inscripcionRepository;

    @Override
    public ResponseEntity<Map<String, Object>> listaInscripciones() {
        List<Inscripcion> inscripciones = inscripcionRepository.findAll();
        Map<String, Object> response = new HashMap<>();

        if (inscripciones.isEmpty()) {
            response.put("mensaje", "No hay inscripciones registrados");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

        response.put("mensaje", "Listado exitoso");
        response.put("inscripciones", inscripciones);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Autowired
    private AlumnoRepository alumnoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    @Override
    public ResponseEntity<Map<String, Object>> crearInscripcion(Inscripcion inscripcion) {
        Map<String, Object> response = new HashMap<>();
        try {
            // Cargar entidades completas desde la BD
            Alumno alumno = alumnoRepository.findById(inscripcion.getAlumno().getIdAlumno()).orElse(null);
            Curso curso = cursoRepository.findById(inscripcion.getCurso().getIdCurso()).orElse(null);
            Estado estado = estadoRepository.findById(inscripcion.getEstado().getIdEstado()).orElse(null);

            inscripcion.setAlumno(alumno);
            inscripcion.setCurso(curso);
            inscripcion.setEstado(estado);
            inscripcion.setFechaInscripcion(new Timestamp(System.currentTimeMillis()));

            Inscripcion nueva = inscripcionRepository.save(inscripcion);

            response.put("mensaje", "Inscripción creada exitosamente");
            response.put("inscripcion", nueva);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            response.put("mensaje", "Error al crear inscripción");
            response.put("error", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }


    @Override
    public ResponseEntity<Map<String, Object>> editarInscripcion(Long id, Inscripcion datosActualizados) {
        Map<String, Object> response = new HashMap<>();
        Optional<Inscripcion> inscripcionOpt = inscripcionRepository.findById(id);

        if (inscripcionOpt.isPresent()) {
            Inscripcion existente = inscripcionOpt.get();

            // Cargar entidades completas desde la base de datos
            Alumno alumno = alumnoRepository.findById(datosActualizados.getAlumno().getIdAlumno()).orElse(null);
            Curso curso = cursoRepository.findById(datosActualizados.getCurso().getIdCurso()).orElse(null);
            Estado estado = estadoRepository.findById(datosActualizados.getEstado().getIdEstado()).orElse(null);

            // Asignar los nuevos valores
            existente.setAlumno(alumno);
            existente.setCurso(curso);
            existente.setCiclo(datosActualizados.getCiclo());
            existente.setEstado(estado);

            // Actualizar la fecha a la fecha y hora actual
            existente.setFechaInscripcion(new Timestamp(System.currentTimeMillis()));

            // Guardar los cambios
            inscripcionRepository.save(existente);

            response.put("mensaje", "Inscripción actualizada correctamente");
            response.put("inscripcion", existente);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response.put("mensaje", "Inscripción no encontrada");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }


    @Override
    public ResponseEntity<Map<String, Object>> obtenerInscripcion(Long id) {
        Map<String, Object> response = new HashMap<>();
        Optional<Inscripcion> inscripcion = inscripcionRepository.findById(id);

        if (inscripcion.isPresent()) {
            response.put("mensaje", "Inscripción encontrada");
            response.put("inscripcion", inscripcion.get());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response.put("mensaje", "Inscripción no encontrada");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }
}
