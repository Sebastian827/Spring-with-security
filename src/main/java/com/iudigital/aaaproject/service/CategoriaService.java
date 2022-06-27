package com.iudigital.aaaproject.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iudigital.aaaproject.domain.Categoria;
import com.iudigital.aaaproject.repository.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public List<Categoria> listarCategorias() {
		
		return (List<Categoria>) categoriaRepository.findAll();
		
	}
	
	public void crearCategoria(Categoria categoria) {
		
		categoria.setFechaCreacion(LocalDateTime.now());
		categoriaRepository.save(categoria);
		
	}
	
	public void eliminarCategoria(int id) {
		categoriaRepository.deleteById(id);
	}
	
	public void editarCategoria(Categoria categoria) {
		categoria.setFechaCreacion(LocalDateTime.now());
		categoriaRepository.save(categoria);
	}
	
}