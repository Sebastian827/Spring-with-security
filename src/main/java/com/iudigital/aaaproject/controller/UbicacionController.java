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
import com.iudigital.aaaproject.domain.Ubicacion;
import com.iudigital.aaaproject.service.CategoriaService;
import com.iudigital.aaaproject.service.UbicacionService;

@RestController
@RequestMapping(value ="ubicacion")
@CrossOrigin("*")
public class UbicacionController {
	
	@Autowired
	private UbicacionService ubicacionservice;
	
	@PostMapping
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void crearUbicacion(@RequestBody Ubicacion ubicacion) {

		ubicacionservice.crearUbicacion(ubicacion);

	}
	@GetMapping("/listar")
	public List<Ubicacion> listarUbicacion(){
		return ubicacionservice.listarUbicaciones();
	}
	
	@PostMapping("/eliminar/{id}")
	public void eliminarUbicacion(@PathVariable(name="id") int id) {
		ubicacionservice.eliminarUbicacion(id);
	}
	
	@PostMapping("/editar")
	public void editarUbicacion(@RequestBody Ubicacion ubicacion) {
		ubicacionservice.editarUbicacion(ubicacion);
	}

}
