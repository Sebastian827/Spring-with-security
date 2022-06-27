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

import com.iudigital.aaaproject.domain.Producto;
import com.iudigital.aaaproject.service.ProductoService;

@RestController
@RequestMapping(value = "producto")
@CrossOrigin("*")
public class ProductoController {

	@Autowired
	private ProductoService productoService;

	@PostMapping
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PreAuthorize("hasAuthority('SELLER')")
	public void crearProducto(@RequestBody Producto producto) {

		productoService.crearProducto(producto);

	}

	@GetMapping
	@PreAuthorize("hasAuthority('SELLER')")
	public List<Producto> listarProducto() {

		return productoService.listarProductos();

	}
	@PostMapping("/eliminar/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PreAuthorize("hasAuthority('SELLER')")
	public void eliminarProducto(@PathVariable(name="id") int id) {
		productoService.eliminarProducto(id);
	}
	
	@PostMapping("/editar")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PreAuthorize("hasAuthority('SELLER')")
	public void editaeProducto(@RequestBody Producto producto) {
		productoService.editarProducto(producto);
	}
	
	

}


