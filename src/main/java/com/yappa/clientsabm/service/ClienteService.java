package com.yappa.clientsabm.service;

import java.util.List;

import com.yappa.clientsabm.dto.ClienteDto;
import com.yappa.clientsabm.model.Cliente;

public interface ClienteService {

	public void save(ClienteDto clienteDto);
	
	public ClienteDto get(Integer id);
	
	public List<ClienteDto> getAll();
	
	public List<ClienteDto> search(String nombres);
	
	public void update(Integer id, ClienteDto clienteUpdate);
}
