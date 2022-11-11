package com.example.demo.controller;

import java.util.List;
import com.example.demo.dto.Sala;
import com.example.demo.service.SalaServiceImpl;

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
public class SalaController {

	@Autowired
	SalaServiceImpl SalaServiceImpl;
	
	//listar todos los Salas
	@GetMapping("/salas")
	public List<Sala> listarSalas(){
		return SalaServiceImpl.listarSalas();
	}
	
	//guardar un Sala
	@PostMapping("/salas")
	public Sala salvarSala(@RequestBody Sala Sala) {//los datos del Sala llegan en formato JSON desde el Request Body
		return SalaServiceImpl.guardarSala(Sala);
	}
	
	//muestro un Sala según el ID indicada
	@GetMapping("/salas/{id}") 
	public Sala SalaXID(@PathVariable(name="id") Long id){ // el id del Sala llega desde la variable del path
		Sala Sala_xid = new Sala();//creo una instancia de la clase Sala
		
		Sala_xid=SalaServiceImpl.SalaXID(id);//busco el Sala según el ID y le asigno los datos a la instancia de la clase Sala
		
		System.out.println("Sala XID: "+Sala_xid);
		
		return Sala_xid;//devuelvo el Sala en formato JSON
	}
	
	//Actualizo los datos de un Sala según el ID indicada
	@PutMapping("/salas/{id}")
	public Sala actualizarSala(@PathVariable(name="id")Long id,@RequestBody Sala Sala) {
		
		Sala Sala_seleccionado= new Sala();
		Sala Sala_actualizado= new Sala();
		
		Sala_seleccionado= SalaServiceImpl.SalaXID(id);
		
		Sala_seleccionado.setNombre(Sala.getNombre());
		Sala_seleccionado.setPelicula(Sala.getPelicula());
		
		Sala_actualizado = SalaServiceImpl.actualizarSala(Sala_seleccionado);
		
		System.out.println("El Sala actualizado es: "+ Sala_actualizado);
		
		return Sala_actualizado;
	}
	
	//borro el Sala indicado por el ID que llega en la variable del path
	@DeleteMapping("/salas/{id}")
	public void eleiminarSala(@PathVariable(name="id")Long id) {
		SalaServiceImpl.eliminarSala(id);
	}
}
