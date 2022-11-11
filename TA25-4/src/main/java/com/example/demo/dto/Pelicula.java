package com.example.demo.dto;

import javax.persistence.*;

@Entity
@Table(name="pelicula")
public class Pelicula {

	//atributos de la entidad
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private int calificacion_edad;
	
	@ManyToOne
	@JoinColumn(name="sala")
	private Sala sala;

	
	//constructores
	
	public Pelicula() {
		
	}
	
	
	public Pelicula(Long id, String nombre, int calificacion_edad, Sala sala) {
		this.id = id;
		this.nombre = nombre;
		this.calificacion_edad = calificacion_edad;
		this.sala = sala;
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


	public int getCalificacion_edad() {
		return calificacion_edad;
	}


	public void setCalificacion_edad(int calificacion_edad) {
		this.calificacion_edad = calificacion_edad;
	}


	public Sala getSala() {
		return sala;
	}


	public void setSala(Sala sala) {
		this.sala = sala;
	}

}
