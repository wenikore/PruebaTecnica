package com.demo.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.boot.model.Vendedores;
import com.demo.boot.repository.VendRepository;

@Service("vendeService")
@Transactional
public class vendServiceImp implements VendeService {

	@Autowired
	private VendRepository repositorio;

	@Override
	public Vendedores findBycedula(String ccBuscar) {
		return repositorio.findOne(ccBuscar);
	}

	@Override
	public Vendedores findByid(String id) {
		return repositorio.findOne(id);
	}

	@Override
	public void guardarVendedor(Vendedores vendedores) {
		repositorio.save(vendedores);
	}

	@Override
	public void actualizarVendedor(Vendedores vendedores) {
		guardarVendedor(vendedores);

	}

	@Override
	public void eliminarByCCVendedor(String cedula) {
		repositorio.delete(cedula);
	}

	@Override
	public void eliminartodoVendedor() {
		repositorio.deleteAll();
	}

	@Override
	public List<Vendedores> findBytodovendedores() {
		// TODO Auto-generated method stub
		return (List<Vendedores>) repositorio.findAll();
	}

	@Override
	public boolean existeVendedor(Vendedores vendedores) {
		return findBycedula(vendedores.getCc()) != null;
	}

}
