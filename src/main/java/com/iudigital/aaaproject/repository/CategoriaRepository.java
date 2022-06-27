package com.iudigital.aaaproject.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iudigital.aaaproject.domain.Categoria;

@Repository
public interface CategoriaRepository extends CrudRepository<Categoria, Integer> {

}
