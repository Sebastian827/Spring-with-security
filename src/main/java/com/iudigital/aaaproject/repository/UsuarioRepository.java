package com.iudigital.aaaproject.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iudigital.aaaproject.domain.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {

	Usuario findByEmail(String email);
	
}
