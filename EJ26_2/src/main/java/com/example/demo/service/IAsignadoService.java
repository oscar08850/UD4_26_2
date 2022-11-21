package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Asignado;

public interface IAsignadoService {

	// Metodos del CRUD

	public List<Asignado> listarAsignado(); // Listar All

	public Asignado crearAsignado(Asignado asignado); // CREATE

	public Asignado leerAsignadoById(int id); // READ

	public Asignado actualizarAsignado(Asignado asignado); // UPDATE

	public void borrarAsignadoById(int id);// DELETE

}