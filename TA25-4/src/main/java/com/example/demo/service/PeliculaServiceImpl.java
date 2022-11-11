package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IPeliculaDAO;
import com.example.demo.dto.Pelicula;

@Service 
public class PeliculaServiceImpl implements IPeliculaService{

	@Autowired
	IPeliculaDAO iPeliculaDAO;
	
	@Override
	public List<Pelicula> listarPeliculas() {
		// TODO Auto-generated method stub
		return iPeliculaDAO.findAll();
	}

	@Override
	public Pelicula guardarPelicula(Pelicula Pelicula) {
		// TODO Auto-generated method stub
			return iPeliculaDAO.save(Pelicula); //guardo el nuevo Pelicula	
	}

	@Override
	public Pelicula PeliculaXID(Long id) {
		// TODO Auto-generated method stub
		return iPeliculaDAO.findById(id).get();
	}

	@Override
	public Pelicula actualizarPelicula(Pelicula Pelicula) {
		// TODO Auto-generated method stub
		return iPeliculaDAO.save(Pelicula);
	}

	@Override
	public void eliminarPelicula(Long id) {
		iPeliculaDAO.deleteById(id);
		
	}

}
