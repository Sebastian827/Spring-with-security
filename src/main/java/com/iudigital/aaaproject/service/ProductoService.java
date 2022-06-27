package com.iudigital.aaaproject.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iudigital.aaaproject.domain.Producto;
import com.iudigital.aaaproject.repository.ProductoRepository;

@Service
public class ProductoService {

	
	@Autowired
	private ProductoRepository productoRepository;
	
	
	public void crearProducto(Producto producto) {
		
		producto.setFechaCreacion(LocalDateTime.now());
		productoRepository.save(producto);
		
	}
	
	public List<Producto> listarProductos() {
		
		return (List<Producto>) productoRepository.findAll();
		
	}
	
	public void eliminarProducto(int id) {
		productoRepository.deleteById(id);
	}
	
	public void editarProducto(Producto producto) {
		producto.setFechaCreacion(LocalDateTime.now());
		productoRepository.save(producto);
	}
}
