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
@Table(name = "curso")
public class Curso {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCurso;
    
    @Column(nullable = false, unique = true)
    private String nombreCurso;
    
    @ManyToOne
    @JoinColumn(name = "idProfesor", referencedColumnName = "idProfesor", nullable = true)
    private Profesor profesor;
    
    @ManyToOne
    @JoinColumn(name = "idSalon", referencedColumnName = "idSalon", nullable = true)
    private Salon salon;
    
    @ManyToOne
    @JoinColumn(name = "idEstado", referencedColumnName = "idEstado", nullable = true)
    private Estado estado;
    
    private int vacantes;

	public Long getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(Long idCurso) {
		this.idCurso = idCurso;
	}

	public String getNombreCurso() {
		return nombreCurso;
	}

	public void setNombreCurso(String nombreCurso) {
		this.nombreCurso = nombreCurso;
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	public Salon getSalon() {
		return salon;
	}

	public void setSalon(Salon salon) {
		this.salon = salon;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public int getVacantes() {
		return vacantes;
	}

	public void setVacantes(int vacantes) {
		this.vacantes = vacantes;
	}

    

}
