package com.cibertec.repository;

import com.cibertec.model.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfesorRepository extends JpaRepository<Profesor, Long> {

    Optional<Profesor> findByDni(String dni);
    Optional<Profesor> findByCorreo(String correo);
}
