package com.demo.boot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vendedores")
public class Vendedores {

	@Id
	@Column(name = "cedula")
	private String cc;

	@Column(name = "nombre_vendedor")
	private String nombrevendedor;

	@Column(name = "apellido_vendedor")
	private String apellidovendedor;

	public Vendedores() {
	}

	public Vendedores(String cc, String nombrevendedor, String apellidovendedor) {
		this.nombrevendedor = nombrevendedor;
		this.apellidovendedor = apellidovendedor;
	}

	public String getCc() {
		return cc;
	}

	public void setCc(String cc) {
		this.cc = cc;
	}

	public String getNombrevendedor() {
		return nombrevendedor;
	}

	public void setNombrevendedor(String nombrevendedor) {
		this.nombrevendedor = nombrevendedor;
	}

	public String getApellidovendedor() {
		return apellidovendedor;
	}

	public void setApellidovendedor(String apellidovendedor) {
		this.apellidovendedor = apellidovendedor;
	}

	@Override
	public String toString() {
		return "Vendedores [id=" + cc + ", nombrevendedor=" + nombrevendedor + ", apellidovendedor=" + apellidovendedor
				+ "]";
	}

}
