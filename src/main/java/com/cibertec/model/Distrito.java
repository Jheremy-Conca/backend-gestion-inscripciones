package com.cibertec.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "distrito")
public class Distrito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDistrito;

    @Column(nullable = false, length = 100)
    private String nombreDistrito;

	public Long getIdDistrito() {
		return idDistrito;
	}

	public void setIdDistrito(Long idDistrito) {
		this.idDistrito = idDistrito;
	}

	public String getNombreDistrito() {
		return nombreDistrito;
	}

	public void setNombreDistrito(String nombreDistrito) {
		this.nombreDistrito = nombreDistrito;
	}
    
    
}


