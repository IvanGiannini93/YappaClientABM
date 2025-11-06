package com.yappa.clientsabm.service;

import java.util.List;

import com.yappa.clientsabm.model.Client;

public interface ClientService {

	public void insert(Client client);
	
	public Client get(Integer id);
	
	public List<Client> getAll();
	
	public List<Client> search(String name);
	
	public void update(Integer id);
}
