package com.yappa.clientsabm.model;

import java.time.LocalDate;

import org.hibernate.annotations.GenericGenerator;

import com.yappa.clientsabm.dto.ClienteDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nombres;
	
	private String apellidos;
	
	@Column(name = "fechadenacimiento")
	private LocalDate fechaDeNacimiento;
	
	private String cuit;
	
	private String direccion;
	
	@Column(name = "telefonocelular")
	private String telefonoCelular;
	
	private String email;

	
	public Cliente() {}
	
	public Cliente(String nombres, String apellidos, LocalDate fechaDeNacimiento, String cuit, String direccion,
			String telefonoCelular, String email) {
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.cuit = cuit;
		this.direccion = direccion;
		this.telefonoCelular = telefonoCelular;
		this.email = email;
	}
	
	public Cliente(ClienteDto clienteDto) {
		this.nombres = clienteDto.getNombres();
		this.apellidos = clienteDto.getApellidos();
		this.fechaDeNacimiento = clienteDto.getFechaDeNacimiento();
		this.cuit = clienteDto.getCuit();
		this.direccion = clienteDto.getDireccion();
		this.telefonoCelular = clienteDto.getTelefonoCelular();
		this.email = clienteDto.getEmail();
	}


	public Integer getId() {
		return id;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
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
