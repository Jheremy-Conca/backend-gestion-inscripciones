package com.cibertec.repository;

import java.util.Optional;

import com.cibertec.model.Salon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalonRepository extends JpaRepository<Salon, Long> {
	Optional<Salon> findByNumeroSalon(String numeroSalon);

}