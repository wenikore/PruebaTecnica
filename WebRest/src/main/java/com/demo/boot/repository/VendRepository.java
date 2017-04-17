package com.demo.boot.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.boot.model.Vendedores;

@Repository
public interface VendRepository extends CrudRepository<Vendedores, String> {

	List<Vendedores> findByCc(String cedula);
	
	
}
