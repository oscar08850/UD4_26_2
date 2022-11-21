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

import com.example.demo.dto.Asignado;
import com.example.demo.service.AsignadoServiceImpl;

@RestController
@RequestMapping("/api")
public class ControladorAsignado {

	@Autowired
	AsignadoServiceImpl asignadoServiceImpl;

	@GetMapping("/asignado")
	public List<Asignado> listarasignado() {
		return asignadoServiceImpl.listarAsignado();
	}

	@PostMapping("/asignado")
	public Asignado crearAsignado(@RequestBody Asignado asignado) {

		return asignadoServiceImpl.crearAsignado(asignado);

	}

	@GetMapping("/asignado/{id}")
	public Asignado leerAsignado(@PathVariable(name = "id") int id) {

		Asignado asignado = new Asignado();

		asignado = asignadoServiceImpl.leerAsignadoById(id);

		System.out.println("Asignado segun ID: " + asignado);

		return asignado;
	}

	@PutMapping("/asignado/{id}")
	public Asignado actualizarAsignado(@PathVariable(name = "id") int id, @RequestBody Asignado asignado) {

		Asignado asignado_seleccionado = new Asignado();
		Asignado asignado_actualizado = new Asignado();

		asignado_seleccionado = asignadoServiceImpl.leerAsignadoById(id);

		asignado_seleccionado.setCientifico(asignado.getCientifico());
		asignado_seleccionado.setProyecto(asignado.getProyecto());

		asignado_actualizado = asignadoServiceImpl.actualizarAsignado(asignado_seleccionado);

		System.out.println("El asignado actualizado es: " + asignado_actualizado);

		return asignado_actualizado;
	}

	@DeleteMapping("/asignado/{id}")
	public void borrarAsignado(@PathVariable(name = "id") int id) {
		asignadoServiceImpl.borrarAsignadoById(id);
	}

}