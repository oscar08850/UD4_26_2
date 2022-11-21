package com.example.demo.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "suministra")
public class Asignado {

	// Atribitos

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@JoinColumn(name = "cientifico")
	private Cientifico cientifico;

	@ManyToOne
	@JoinColumn(name = "proyecto")
	private Proyecto proyecto;

	// Constructores

	public Asignado() {
	}

	public Asignado(int id, Cientifico pieza, Proyecto proveedor) {
		this.id = id;
		this.cientifico = pieza;
		this.proyecto = proveedor;
	}

	// Getters y Setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Cientifico getCientifico() {
		return cientifico;
	}

	public void setCientifico(Cientifico pieza) {
		this.cientifico = pieza;
	}

	public Proyecto getProyecto() {
		return proyecto;
	}

	public void setProyecto(Proyecto proveedor) {
		this.proyecto = proveedor;
	}

	@Override
	public String toString() {
		return "Asignado [id=" + id + ", cientifico=" + cientifico + ", proyecto=" + proyecto + "]";
	}



}
