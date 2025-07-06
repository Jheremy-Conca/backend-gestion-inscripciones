package com.cibertec.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "tiposalon")
public class TipoSalon {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTipoSalon;
    
    private String descripcionSalon;

	public Long getIdTipoSalon() {
		return idTipoSalon;
	}

	public void setIdTipoSalon(Long idTipoSalon) {
		this.idTipoSalon = idTipoSalon;
	}

	public String getDescripcionSalon() {
		return descripcionSalon;
	}

	public void setDescripcionSalon(String descripcionSalon) {
		this.descripcionSalon = descripcionSalon;
	}

    
}
