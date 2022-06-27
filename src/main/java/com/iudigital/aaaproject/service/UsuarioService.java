package com.iudigital.aaaproject.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.iudigital.aaaproject.domain.Usuario;
import com.iudigital.aaaproject.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public List<Usuario> listarUsuarios() {
		
		return (List<Usuario>) usuarioRepository.findAll();
		
	}
	
	public void crearUsuario(Usuario usuario) {
		
		usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
		usuario.setFechaCreacion(LocalDateTime.now());
		usuarioRepository.save(usuario);
		
	}
	public void eliminarUsuario(int id) {
		usuarioRepository.deleteById(id);
	}
	
	public Usuario listarUsuarioPorId(int id) {
		Optional<Usuario> userss = usuarioRepository.findById(id);
		return userss.get();
	}
	public void editarUsuario(Usuario usuario) {
		usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
		usuario.setFechaCreacion(LocalDateTime.now());
		usuarioRepository.save(usuario);
	}
	
}