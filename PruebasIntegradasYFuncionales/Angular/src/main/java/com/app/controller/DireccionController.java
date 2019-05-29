package com.app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.error.ResourceNotFoundExcepcion;
import com.app.repo.DireccionRepository;
import com.app.res.Direccion;

@RestController
@RequestMapping("/")
public class DireccionController {
	
	@Autowired
	private DireccionRepository dao;
	
	@GetMapping("/direccion")
	public List<Direccion> getAllDirecciones(){
		return dao.findAll();
	}
	
	@GetMapping("/direccion/{id}")
	public ResponseEntity<Direccion> getDireccionById(@PathVariable(value = "id") String id) throws ResourceNotFoundExcepcion{
		Direccion direccion = dao.findById(id).orElseThrow(() -> new ResourceNotFoundExcepcion("Dirección no encontrada"));
		return ResponseEntity.ok().body(direccion);
	}
	
	@PutMapping("/direccion/{id}")
	public ResponseEntity<Direccion> updateDireccion(@PathVariable(value = "id") String id, @Valid @RequestBody Direccion detalles) throws ResourceNotFoundExcepcion{
		Direccion direccion = dao.findById(id).orElseThrow(() -> new ResourceNotFoundExcepcion("Direccion no encontrada"));
		direccion.setCalle(detalles.getCalle());
		direccion.setNumero(detalles.getNumero());
		final Direccion direccionactualizada = dao.save(direccion);
		return ResponseEntity.ok(direccionactualizada);
	}
	
	@PostMapping("/direccion")
	public ResponseEntity<Direccion> insertaDireccion(@Valid @RequestBody Direccion detalles) throws ResourceNotFoundExcepcion{
		final Direccion direccionactualizada = dao.save(detalles);
		return ResponseEntity.ok(direccionactualizada);
	}
	
	@DeleteMapping("/direccion/{id}")
	public Map<String, Boolean> deleteDireccion(@PathVariable(value = "id") String id) throws ResourceNotFoundExcepcion{
		Direccion direccion = dao.findById(id).orElseThrow(() -> new ResourceNotFoundExcepcion("Direccion no encontrada"));
		dao.delete(direccion);
		Map<String, Boolean> respuesta = new HashMap<>();
		respuesta.put("borrado", Boolean.TRUE);
		return respuesta;
	}

}
