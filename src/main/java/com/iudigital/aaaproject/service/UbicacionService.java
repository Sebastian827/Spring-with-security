package com.iudigital.aaaproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iudigital.aaaproject.domain.Ubicacion;
import com.iudigital.aaaproject.repository.UbicacionRepository;

@Service
public class UbicacionService {

	@Autowired
	private UbicacionRepository ubicacionRepository;
	
	public void crearUbicacion(Ubicacion ubicacion) {
		ubicacionRepository.save(ubicacion);
	}
	
	public List<Ubicacion> listarUbicaciones(){
		return (List<Ubicacion>) ubicacionRepository.findAll();
	}
	
	public void eliminarUbicacion(int id) {
		ubicacionRepository.deleteById(id);
	}
	public void editarUbicacion(Ubicacion ubicacion) {
		ubicacionRepository.save(ubicacion);
	}
	
}
