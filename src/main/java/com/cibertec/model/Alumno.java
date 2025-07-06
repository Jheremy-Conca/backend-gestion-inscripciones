package com.cibertec.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "alumno")
public class Alumno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAlumno;

    @Column(nullable = false, length = 100)
    private String nombres;

    @Column(nullable = false, length = 100)
    private String apellidos;

    @Column(nullable = false, unique = true, length = 20)
    private String dni;

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

    @Column(length = 20)
    private String telefono;

    @Column(unique = true)
    private String correo;

	public Long getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(Long idAlumno) {
		this.idAlumno = idAlumno;
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


    
}
