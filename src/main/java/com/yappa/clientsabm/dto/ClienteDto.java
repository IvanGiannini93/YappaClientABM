package com.yappa.clientsabm.dto;

import java.time.LocalDate;

import com.yappa.clientsabm.model.Cliente;

public class ClienteDto {
	
	private String nomrbes;
	
	private String apellidos;
	
	private LocalDate fechaDeNacimiento;
	
	private String cuit;
	
	private String direccion;
	
	private String telefonoCelular;
	
	private String email;
	
	public ClienteDto() {}
	
	public ClienteDto(Cliente client) {
		this.nomrbes = client.getNombres();
		this.apellidos = client.getApellidos();
		this.fechaDeNacimiento = client.getFechaDeNacimiento();
		this.cuit = client.getCuit();
		this.direccion = client.getDireccion();
		this.telefonoCelular = client.getTelefonoCelular();
		this.email = client.getEmail();
	}

	public String getNomrbes() {
		return nomrbes;
	}

	public void setNomrbes(String nomrbes) {
		this.nomrbes = nomrbes;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public LocalDate getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}

	public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}

	public String getCuit() {
		return cuit;
	}

	public void setCuit(String cuit) {
		this.cuit = cuit;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefonoCelular() {
		return telefonoCelular;
	}

	public void setTelefonoCelular(String telefonoCelular) {
		this.telefonoCelular = telefonoCelular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
}
