package com.cibertec.model;

import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "inscripcion")
public class Inscripcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idInscripcion;
	
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idAlumno", referencedColumnName = "idAlumno", nullable = false)
    private Alumno alumno;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idCurso", referencedColumnName = "idCurso", nullable = false)
    private Curso curso;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idEstado", referencedColumnName = "idEstado", nullable = true)
    private Estado estado;

    private int ciclo;
	
    
    
    private Timestamp fechaInscripcion;


	public Long getIdInscripcion() {
		return idInscripcion;
	}


	public void setIdInscripcion(Long idInscripcion) {
		this.idInscripcion = idInscripcion;
	}


	public Alumno getAlumno() {
		return alumno;
	}


	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}


	public Curso getCurso() {
		return curso;
	}


	public void setCurso(Curso curso) {
		this.curso = curso;
	}


	public int getCiclo() {
		return ciclo;
	}


	public void setCiclo(int ciclo) {
		this.ciclo = ciclo;
	}


	public Estado getEstado() {
		return estado;
	}


	public void setEstado(Estado estado) {
		this.estado = estado;
	}


	public Timestamp getFechaInscripcion() {
		return fechaInscripcion;
	}


	public void setFechaInscripcion(Timestamp fechaInscripcion) {
		this.fechaInscripcion = fechaInscripcion;
	}
    
    
    
}
