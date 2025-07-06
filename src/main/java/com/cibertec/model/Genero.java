package com.cibertec.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "genero")
public class Genero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idGenero;

    @Column(nullable = false, length = 50)
    private String descripcionGenero;

	public Long getIdGenero() {
		return idGenero;
	}

	public void setIdGenero(Long idGenero) {
		this.idGenero = idGenero;
	}

	public String getDescripcionGenero() {
		return descripcionGenero;
	}

	public void setDescripcionGenero(String descripcionGenero) {
		this.descripcionGenero = descripcionGenero;
	}
    
    
}
