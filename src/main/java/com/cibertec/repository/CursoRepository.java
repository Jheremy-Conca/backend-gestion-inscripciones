package com.cibertec.repository;

import com.cibertec.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CursoRepository extends JpaRepository<Curso, Long> {
    Optional<Curso> findByNombreCurso(String nombreCurso);
}
