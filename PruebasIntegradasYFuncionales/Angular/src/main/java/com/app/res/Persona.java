package com.app.res;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="agenda")
@Inheritance(strategy=InheritanceType.JOINED)
public class Persona {
	
	private String nombre;
	private String apellidos; 
	private String calle;
	private String telefono;
	private int edad;
	private double altura;
	
	public Persona() {
		super();
	}

	public Persona(String nombre, String apellidos, String calle, String tlfn, int edad, double altura) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.calle = calle;
		this.telefono = tlfn;
		this.edad = edad;
		this.altura = altura;
	}

	public Persona(String string, String string2, String string3, int i, int j) {
		this.nombre = string;
		this.apellidos = string2;
		this.calle = string3;
		this.edad = i;
		this.altura = j;
	}

	@Column(name="nombre")
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Column(name="apellidos")
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	@Column(name="direccion")
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}

	@Id
	@Column(name="telefono")
	public String getTlfn() {
		return telefono;
	}
	public void setTlfn(String tlfn) {
		this.telefono = tlfn;
	}

	@Column(name="edad")
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}

	@Column(name="altura")
	public double getAltura() {
		return altura;
	}
	public void setAltura(double altura) {
		this.altura = altura;
	}

	@Override
	public String toString() {
		return nombre + ", " + apellidos + ", " + calle + ", " + telefono
				+ ", " + edad + ", " + altura;
	}
}
