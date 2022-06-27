package com.iudigital.aaaproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.iudigital.aaaproject.domain.Categoria;
import com.iudigital.aaaproject.service.CategoriaService;

@RestController
@RequestMapping(value ="categoria")
@CrossOrigin("*")
public class CategoriaController {
	
	@Autowired
	private CategoriaService categoriaService;

	@PostMapping
	@ResponseStatus(HttpStatus.NO_CONTENT)
    @PreAuthorize("hasAuthority('ADMIN')")
	public void crearCategoria(@RequestBody Categoria categoria) {

		categoriaService.crearCategoria(categoria);

	}

	@GetMapping
    //@PreAuthorize("hasAuthority('ADMIN')")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public List<Categoria> listarCategoria() {

		return categoriaService.listarCategorias();

	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@PostMapping("/delete/{id}")
	public void eliminarCategoria(@PathVariable(name="id") int id) {
		categoriaService.eliminarCategoria(id);
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@PostMapping("/editar")
	public void editarCategoria(@RequestBody Categoria categoria) {
		categoriaService.editarCategoria(categoria);
	}
	
}

