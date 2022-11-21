package com.example.demo.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Proyecto;
import com.example.demo.service.ProyectoServiceImpl;

@RestController
@RequestMapping("/api")
public class ControladorProyecto {

	@Autowired
	ProyectoServiceImpl proyectoServiceImpl;

	@GetMapping("/proyecto")
	public List<Proyecto> listarproyecto() {
		return proyectoServiceImpl.listarProyecto();
	}

	@PostMapping("/proyecto")
	public Proyecto crearProyecto(@RequestBody Proyecto proyecto) {

		return proyectoServiceImpl.crearProyecto(proyecto);

	}

	@GetMapping("/proyecto/{id}")
	public Proyecto leerProyecto(@PathVariable(name = "id") int id) {

		Proyecto proyecto = new Proyecto();

		proyecto = proyectoServiceImpl.leerProyectoById(id);

		System.out.println("Proyecto segun ID: " + proyecto);

		return proyecto;
	}

	@PutMapping("/proyecto/{id}")
	public Proyecto actualizarProyecto(@PathVariable(name = "id") int id, @RequestBody Proyecto proyecto) {

		Proyecto proyecto_seleccionado = new Proyecto();
		Proyecto proyecto_actualizado = new Proyecto();

		proyecto_seleccionado = proyectoServiceImpl.leerProyectoById(id);

		proyecto_seleccionado.setNombre(proyecto.getNombre());
		proyecto_seleccionado.setHoras(proyecto.getHoras());

		proyecto_actualizado = proyectoServiceImpl.actualizarProyecto(proyecto_seleccionado);

		System.out.println("El proyecto actualizado es: " + proyecto_actualizado);

		return proyecto_actualizado;
	}

	@DeleteMapping("/proyecto/{id}")
	public void borrarProyecto(@PathVariable(name = "id") int id) {
		proyectoServiceImpl.borrarProyectoById(id);
	}

}