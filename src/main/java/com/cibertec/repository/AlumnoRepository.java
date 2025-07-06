package com.cibertec.repository;

import com.cibertec.model.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AlumnoRepository extends JpaRepository<Alumno, Long> {
    Optional<Alumno> findByDni(String dni);
    Optional<Alumno> findByCorreo(String correo);
    Optional<Alumno> findById(Long id); 


}
