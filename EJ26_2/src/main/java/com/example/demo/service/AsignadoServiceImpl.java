package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IAsignadoDAO;
import com.example.demo.dto.Asignado;

@Service
public class AsignadoServiceImpl implements IAsignadoService{
	
	@Autowired
	IAsignadoDAO iAsignadoDAO;

	@Override
	public List<Asignado> listarAsignado() {
		return iAsignadoDAO.findAll();
	}

	@Override
	public Asignado crearAsignado(Asignado asignado) {
		return iAsignadoDAO.save(asignado);
	}

	@Override
	public Asignado leerAsignadoById(int id) {
		return iAsignadoDAO.findById(id).get();
	}

	@Override
	public Asignado actualizarAsignado(Asignado asignado) {
		return iAsignadoDAO.save(asignado);
	}

	@Override
	public void borrarAsignadoById(int id) {
		iAsignadoDAO.deleteById(id);
	}

}