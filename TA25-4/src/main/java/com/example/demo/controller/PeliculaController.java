package com.example.demo.controller;

import java.util.List;
import com.example.demo.dto.Pelicula;
import com.example.demo.service.PeliculaServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PeliculaController {

	@Autowired
	PeliculaServiceImpl PeliculaServiceImpl;
	
	//listar todos los Peliculas
	@GetMapping("/peliculas")
	public List<Pelicula> listarPeliculas(){
		return PeliculaServiceImpl.listarPeliculas();
	}
	
	//guardar un Pelicula
	@PostMapping("/peliculas")
	public Pelicula salvarPelicula(@RequestBody Pelicula Pelicula) {//los datos del Pelicula llegan en formato JSON desde el Request Body
		return PeliculaServiceImpl.guardarPelicula(Pelicula);
	}
	
	//muestro un Pelicula según el ID indicada
	@GetMapping("/peliculas/{id}") 
	public Pelicula PeliculaXID(@PathVariable(name="id") Long id){ // el id del Pelicula llega desde la variable del path
		Pelicula Pelicula_xid = new Pelicula();//creo una instancia de la clase Pelicula
		
		Pelicula_xid=PeliculaServiceImpl.PeliculaXID(id);//busco el Pelicula según el ID y le asigno los datos a la instancia de la clase Pelicula
		
		System.out.println("Pelicula XID: "+Pelicula_xid);
		
		return Pelicula_xid;//devuelvo el Pelicula en formato JSON
	}
	
	//Actualizo los datos de un Pelicula según el ID indicada
	@PutMapping("/peliculas/{id}")
	public Pelicula actualizarPelicula(@PathVariable(name="id")Long id,@RequestBody Pelicula Pelicula) {
		
		Pelicula Pelicula_seleccionado= new Pelicula();
		Pelicula Pelicula_actualizado= new Pelicula();
		
		Pelicula_seleccionado= PeliculaServiceImpl.PeliculaXID(id);
		
		Pelicula_seleccionado.setNombre(Pelicula.getNombre());
		Pelicula_seleccionado.setCalificacion_edad(Pelicula.getCalificacion_edad());
		Pelicula_seleccionado.setSala(Pelicula.getSala());
		
		Pelicula_actualizado = PeliculaServiceImpl.actualizarPelicula(Pelicula_seleccionado);
		
		System.out.println("El Pelicula actualizado es: "+ Pelicula_actualizado);
		
		return Pelicula_actualizado;
	}
	
	//borro el Pelicula indicado por el ID que llega en la variable del path
	@DeleteMapping("/peliculas/{id}")
	public void eleiminarPelicula(@PathVariable(name="id")Long id) {
		PeliculaServiceImpl.eliminarPelicula(id);
	}
}
