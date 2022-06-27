package com.iudigital.aaaproject.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.iudigital.aaaproject.domain.Producto;

@Service
public interface ProductoRepository extends CrudRepository<Producto, Integer> {

}
