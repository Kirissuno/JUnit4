package com.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.res.Persona;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, String> {
	
}
