package com.cibertec.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "estado")
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEstado;

    @Column(nullable = false, length = 50)
    private String descripcionEstado;

	public Long getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(Long idEstado) {
		this.idEstado = idEstado;
	}

	public String getDescripcionEstado() {
		return descripcionEstado;
	}

	public void setDescripcionEstado(String descripcionEstado) {
		this.descripcionEstado = descripcionEstado;
	}
    
    
}
