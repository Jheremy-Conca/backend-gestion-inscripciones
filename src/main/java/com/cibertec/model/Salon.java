package com.cibertec.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "salon")
public class Salon {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idSalon;
    
    @Column(nullable = false, unique = true)
    private String numeroSalon;
    
    private int piso;
    
    private int capacidad;
    
    @ManyToOne
    @JoinColumn(name = "idTipoSalon", referencedColumnName = "idTipoSalon", nullable = true)
    private TipoSalon tipoSalon;
    
    @ManyToOne
    @JoinColumn(name = "idEstado", referencedColumnName = "idEstado", nullable = true)
    private Estado estado;

	public Long getIdSalon() {
		return idSalon;
	}

	public void setIdSalon(Long idSalon) {
		this.idSalon = idSalon;
	}

	public String getNumeroSalon() {
		return numeroSalon;
	}

	public void setNumeroSalon(String numeroSalon) {
		this.numeroSalon = numeroSalon;
	}

	public int getPiso() {
		return piso;
	}

	public void setPiso(int piso) {
		this.piso = piso;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public TipoSalon getTipoSalon() {
		return tipoSalon;
	}

	public void setTipoSalon(TipoSalon tipoSalon) {
		this.tipoSalon = tipoSalon;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

    
    
}
