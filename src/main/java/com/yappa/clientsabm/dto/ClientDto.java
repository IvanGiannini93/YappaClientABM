package com.yappa.clientsabm.dto;

import java.time.LocalDate;

import com.yappa.clientsabm.model.Client;

public class ClientDto {
	
	private String firstName;
	
	private String lastName;
	
	private LocalDate birthDate;
	
	private String taxId;
	
	private String address;
	
	private String telephoneNumber;
	
	private String email;
	
	public ClientDto() {}
	
	public ClientDto(Client client) {
		this.firstName = client.getFirstName();
		this.lastName = client.getLastName();
		this.birthDate = client.getBirthDate();
		this.taxId = client.getTaxId();
		this.address = client.getAddress();
		this.telephoneNumber = client.getTelephoneNumber();
		this.email = client.getEmail();
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public String getTaxId() {
		return taxId;
	}

	public void setTaxId(String taxId) {
		this.taxId = taxId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
