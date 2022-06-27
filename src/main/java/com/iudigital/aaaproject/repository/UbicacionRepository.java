package com.iudigital.aaaproject.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.iudigital.aaaproject.domain.Ubicacion;

@Service
public  interface UbicacionRepository extends CrudRepository<Ubicacion, Integer> {
 
}
