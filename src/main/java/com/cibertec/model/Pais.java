package com.cibertec.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "pais")
public class Pais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPais;

    @Column(nullable = false, length = 100)
    private String nombrePais;

	public Long getIdPais() {
		return idPais;
	}

	public void setIdPais(Long idPais) {
		this.idPais = idPais;
	}

	public String getNombrePais() {
		return nombrePais;
	}

	public void setNombrePais(String nombrePais) {
		this.nombrePais = nombrePais;
	}
    
    
}
