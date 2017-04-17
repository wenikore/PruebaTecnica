package com.demo.boot.service;

import java.util.List;
import com.demo.boot.model.Vendedores;

public interface VendeService {

	Vendedores findBycedula(String cedula);

	//no se utiliza
	Vendedores findByid(String id);

	void guardarVendedor(Vendedores vendedores);

	void actualizarVendedor(Vendedores vendedores);

	void eliminarByCCVendedor(String cedula);

	void eliminartodoVendedor();

	List<Vendedores> findBytodovendedores();

	boolean existeVendedor(Vendedores vendedores);

}
