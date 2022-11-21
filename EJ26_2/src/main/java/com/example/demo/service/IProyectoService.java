package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Proyecto;

public interface IProyectoService {

	// Metodos del CRUD

	public List<Proyecto> listarProyecto(); // Listar All

	public Proyecto crearProyecto(Proyecto proyecto); // CREATE

	public Proyecto leerProyectoById(int id); // READ

	public Proyecto actualizarProyecto(Proyecto proyecto); // UPDATE

	public void borrarProyectoById(int id);// DELETE

}