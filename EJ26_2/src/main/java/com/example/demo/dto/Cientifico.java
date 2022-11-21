package com.example.demo.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "cientificos")
public class Cientifico {

	// Atribitos

	@Id
	private String dni;
	@Column(name = "nom_apels")
	private String nomApels;

	@OneToMany
	@JoinColumn(name = "id")
	private List<Asignado> asignado;

	// Constructores
	public Cientifico() {

	}

	public Cientifico(String dni, String nombre, List<Asignado> suministras) {
		this.dni = dni;
		this.nomApels = nombre;
		this.asignado = suministras;
	}

	// Getters y Setters

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nomApels;
	}

	public void setNombre(String nombre) {
		this.nomApels = nombre;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Suministra")
	public List<Asignado> getAsignados() {
		return asignado;
	}

	public void setSuministras(List<Asignado> asignado) {
		this.asignado = asignado;
	}

	@Override
	public String toString() {
		return "Cientifico [dni=" + dni + ", nomApels=" + nomApels + ", asignado=" + asignado + "]";
	}

}
