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
import com.app.repo.PersonaRepository;
import com.app.res.Persona;

@RestController
@RequestMapping("/")
public class PersonaController {
	
	@Autowired
	private PersonaRepository dao;
	
	@GetMapping("/persona")
	public List<Persona> getAllPersonas(){
		return dao.findAll();
	}
	
	@GetMapping("/persona/{tlfn}")
	public ResponseEntity<Persona> getPersonaById(@PathVariable(value = "tlfn") String tlfn) throws ResourceNotFoundExcepcion{
		Persona persona = dao.findById(tlfn).orElseThrow(() -> new ResourceNotFoundExcepcion("Persona con ese tlfn no encontrada"));
		return ResponseEntity.ok().body(persona);
	}
	
	@PutMapping("/persona/{id}")
	public ResponseEntity<Persona> updatePersona(@PathVariable(value = "id") String id, @Valid @RequestBody Persona detalles) throws ResourceNotFoundExcepcion{
		Persona persona = dao.findById(id).orElseThrow(() -> new ResourceNotFoundExcepcion("Persona con ese tlfn no encontrada"));
		persona.setNombre(detalles.getNombre());
		persona.setApellidos(detalles.getApellidos());
		persona.setEdad(detalles.getEdad());
		persona.setAltura(detalles.getAltura());
		final Persona personaactualizada = dao.save(persona);
		return ResponseEntity.ok(personaactualizada);
	}
	
	@PostMapping("/persona")
	public ResponseEntity<Persona> insertaPersona(@Valid @RequestBody Persona detalles) throws ResourceNotFoundExcepcion{
		final Persona personaactualizada = dao.save(detalles);
		return ResponseEntity.ok(personaactualizada);
	}
	
	@DeleteMapping("/persona/{id}")
	public Map<String, Boolean> deletePersona(@PathVariable(value = "id") String id) throws ResourceNotFoundExcepcion{
		Persona persona = dao.findById(id).orElseThrow(() -> new ResourceNotFoundExcepcion("Persona con ese tlfn no encontrada"));
		dao.delete(persona);
		Map<String, Boolean> respuesta = new HashMap<>();
		respuesta.put("borrado", Boolean.TRUE);
		return respuesta;
	}

}
