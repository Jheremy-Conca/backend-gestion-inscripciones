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
@Table(name = "profesor")
public class Profesor {

	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProfesor;

    @Column(nullable = false, length = 100)
    private String nombres;

    @Column(nullable = false, length = 100)
    private String apellidos;

    @Column(nullable = false, unique = true, length = 20)
    private String dni;

    @Column(length = 20)
    private String telefono;

    @Column(length = 100, unique = true)
    private String correo;
    
    @ManyToOne
    @JoinColumn(name = "idGenero", referencedColumnName = "idGenero", nullable = true)
    private Genero genero;

    @ManyToOne
    @JoinColumn(name = "idEstado", referencedColumnName = "idEstado", nullable = true)
    private Estado estado;

    @ManyToOne
    @JoinColumn(name = "idPais", referencedColumnName = "idPais", nullable = true)
    private Pais pais;

    @ManyToOne
    @JoinColumn(name = "idDistrito", referencedColumnName = "idDistrito", nullable = true)
    private Distrito distrito;

	public Long getIdProfesor() {
		return idProfesor;
	}

	public void setIdProfesor(Long idProfesor) {
		this.idProfesor = idProfesor;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public Distrito getDistrito() {
		return distrito;
	}

	public void setDistrito(Distrito distrito) {
		this.distrito = distrito;
	}
    
    
}

