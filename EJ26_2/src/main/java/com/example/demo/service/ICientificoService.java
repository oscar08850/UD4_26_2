package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Cientifico;

public interface ICientificoService {

	// Metodos del CRUD

	public List<Cientifico> listarCientifico(); // Listar All

	public Cientifico crearCientifico(Cientifico cientifico); // CREATE

	public Cientifico leerCientificoByDni(String dni); // READ

	public Cientifico actualizarCientifico(Cientifico cientifico); // UPDATE

	public void borrarCientificoByDni(String dni);// DELETE


}