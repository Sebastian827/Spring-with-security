package com.iudigital.aaaproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.iudigital.aaaproject.domain.Usuario;
import com.iudigital.aaaproject.service.UsuarioService;

@RestController
@RequestMapping(value = "usuario")
@CrossOrigin("*")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;

	@PostMapping
	@ResponseStatus(HttpStatus.NO_CONTENT)
    @PreAuthorize("hasAuthority('ADMIN')")
	public void crearUsuario(@RequestBody Usuario usuario) {
		
		usuarioService.crearUsuario(usuario);

	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping
	public List<Usuario> listarUsuarios() {

		return usuarioService.listarUsuarios();

	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("/delete/{id}")
	public void eliminarUsuario(@PathVariable(name="id") int id) {
		usuarioService.eliminarUsuario(id);
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("/listarPorId/{id}")
	public Usuario listarUsuarioPorId(@PathVariable(name="id") int id) {
		return usuarioService.listarUsuarioPorId(id);
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@PostMapping("/editar")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void editarUsuario(@RequestBody Usuario  usuario) {
		usuarioService.editarUsuario(usuario);
	}
	
	
}