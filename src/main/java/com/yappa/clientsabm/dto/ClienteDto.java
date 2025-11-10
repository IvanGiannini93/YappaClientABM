package com.yappa.clientsabm.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.yappa.clientsabm.model.Cliente;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;

public class ClienteDto {
	
	private Integer id;
	
	@NotBlank(message = "El nombre es obligatorio")
	private String nombres;
	
	@NotBlank(message = "El apellido es obligatorio")
	private String apellidos;
	
	@NotNull(message = "La fecha de nacimiento es obligatorio")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@Past(message = "Fecha de nacimiento no valida")
	private LocalDate fechaDeNacimiento;
	
	@NotBlank(message = "El CUIT es obligatorio")
	@Pattern(regexp = "^\\d{2}-?\\d{8}-?\\d{1}$", message = "CUIT invalido")
	private String cuit;
	
	@NotBlank(message = "La direccion es obligatorio")
	private String direccion;
	
	@NotBlank(message = "El telefono celular es obligatorio")
	@Pattern(regexp = "^\\d{10}$", message = "El telefono celular debe tener 10 digitos")
	private String telefonoCelular;
	
	@NotBlank(message = "El Email es obligatorio")
	@Email(message = "El correo electronico no es valido")
	private String email;
	
	public ClienteDto() {}
	
	public ClienteDto(Cliente cliente) {
		this.id = cliente.getId();
		this.nombres = cliente.getNombres();
		this.apellidos = cliente.getApellidos();
		this.fechaDeNacimiento = cliente.getFechaDeNacimiento();
		this.cuit = cliente.getCuit();
		this.direccion = cliente.getDireccion();
		this.telefonoCelular = cliente.getTelefonoCelular();
		this.email = cliente.getEmail();
	}
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
