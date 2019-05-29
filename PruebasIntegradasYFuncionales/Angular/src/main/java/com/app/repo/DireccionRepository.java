package com.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.res.Direccion;

@Repository
public interface DireccionRepository extends JpaRepository<Direccion, String> {

}
