package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ICientificoDAO;
import com.example.demo.dto.Cientifico;

@Service
public class CientificoServiceImpl implements ICientificoService{
	
	@Autowired
	ICientificoDAO iCientificoDAO;

	@Override
	public List<Cientifico> listarCientifico() {
		return iCientificoDAO.findAll();
	}

	@Override
	public Cientifico crearCientifico(Cientifico cientifico) {
		return iCientificoDAO.save(cientifico);
	}

	@Override
	public Cientifico leerCientificoByDni(String id) {
		return iCientificoDAO.findById(id).get();
	}

	@Override
	public Cientifico actualizarCientifico(Cientifico cientifico) {
		return iCientificoDAO.save(cientifico);
	}

	@Override
	public void borrarCientificoByDni(String dni) {
		iCientificoDAO.deleteById(dni);
	}

}