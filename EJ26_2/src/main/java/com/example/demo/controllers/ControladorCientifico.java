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

import com.example.demo.dto.Cientifico;
import com.example.demo.service.CientificoServiceImpl;

@RestController
@RequestMapping("/api")
public class ControladorCientifico {

	@Autowired
	CientificoServiceImpl cientificoServiceImpl;

	@GetMapping("/cientifico")
	public List<Cientifico> listarcientifico() {
		return cientificoServiceImpl.listarCientifico();
	}

	@PostMapping("/cientifico")
	public Cientifico crearCientifico(@RequestBody Cientifico cientifico) {

		return cientificoServiceImpl.crearCientifico(cientifico);

	}

	@GetMapping("/cientifico/{dni}")
	public Cientifico leerCientifico(@PathVariable(name = "dni") String dni) {

		Cientifico cientifico = new Cientifico();

		cientifico = cientificoServiceImpl.leerCientificoByDni(dni);

		System.out.println("Cientifico segun ID: " + cientifico);

		return cientifico;
	}

	@PutMapping("/cientifico/{dni}")
	public Cientifico actualizarCientifico(@PathVariable(name = "dni") String dni, @RequestBody Cientifico cientifico) {

		Cientifico cientifico_seleccionado = new Cientifico();
		Cientifico cientifico_actualizado = new Cientifico();

		cientifico_seleccionado = cientificoServiceImpl.leerCientificoByDni(dni);

		cientifico_seleccionado.setNombre(cientifico.getNombre());

		cientifico_actualizado = cientificoServiceImpl.actualizarCientifico(cientifico_seleccionado);

		System.out.println("El cientifico actualizado es: " + cientifico_actualizado);

		return cientifico_actualizado;
	}

	@DeleteMapping("/cientifico/{dni}")
	public void borrarCientifico(@PathVariable(name = "dni") String dni) {
		cientificoServiceImpl.borrarCientificoByDni(dni);
	}

}