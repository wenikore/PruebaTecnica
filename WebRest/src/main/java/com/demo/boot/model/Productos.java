package com.demo.boot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author wenikore
 *
 */
@Entity
@Table(name = "Producto")
public class Productos {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cod_producto")
	private int id;

	@Column(name = "nomb_producto")
	private String nombProducto;

	@Column(name = "descr_producto")
	private String dscrProducto;

	@Column(name = "valor_producto")
	private String valorProducto;

	public Productos() {
	}

	public Productos(String nombProducto, String dscrProducto, String valorProducto) {
		this.nombProducto = nombProducto;
		this.dscrProducto = dscrProducto;
		this.valorProducto = valorProducto;
	}

	public String getNombProducto() {
		return nombProducto;
	}

	public void setNombProducto(String nombProducto) {
		this.nombProducto = nombProducto;
	}

	public String getDscrProducto() {
		return dscrProducto;
	}

	public void setDscrProducto(String dscrProducto) {
		this.dscrProducto = dscrProducto;
	}

	public String getValorProducto() {
		return valorProducto;
	}

	public void setValorProducto(String valorProducto) {
		this.valorProducto = valorProducto;
	}

	@Override
	public String toString() {
		return "Productos [id=" + id + ", nombProducto=" + nombProducto + ", dcripProducto=" + dscrProducto
				+ ", valorProducto=" + valorProducto + "]";
	}

}
