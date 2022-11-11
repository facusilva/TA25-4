package com.example.demo.dto;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="sala")
public class Sala {

	//atributos de la entidad
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	
	@OneToMany
	@JoinColumn(name="sala")
	private List<Pelicula> pelicula;

	
	//constructores
	
	public Sala() {
		
	}
	
	public Sala(Long id, String nombre, List<Pelicula> pelicula) {
		this.id = id;
		this.nombre = nombre;
		this.pelicula = pelicula;
	}

	
	//getters y setters
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "sala")
	public List<Pelicula> getPelicula() {
		return pelicula;
	}

	public void setPelicula(List<Pelicula> pelicula) {
		this.pelicula = pelicula;
	}

	
	
	
	
	
}
