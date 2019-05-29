package com.app.res;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "direcciones")
public class Direccion {
	
	private String dni;
	private String calle;
	private int numero;
	
	public Direccion(String dni, String calle, int numero) {
		super();
		this.dni = dni;
		this.calle = calle;
		this.numero = numero;
	}
	
	public Direccion() {
		super();
	}
	
	@Id
	@Column(name="dni")
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	@Column(name="calle")
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	
	@Column(name="numero")
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}

	@Override
	public String toString() {
		return dni + ", " + calle + ", " + numero;
	}
		
}
