package com.yappa.clientsabm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yappa.clientsabm.dto.ClientDto;
import com.yappa.clientsabm.mapper.ClientMapper;
import com.yappa.clientsabm.model.Client;
import com.yappa.clientsabm.repository.ClientRepository;
import com.yappa.clientsabm.service.ClientService;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class ClientServiceImpl implements ClientService{

	@Autowired ClientRepository repository;
	
	@Autowired ClientMapper mapper;
	
	
	@Override
	@Transactional
	public void save(Client client) {
		repository.save(client);
	}

	@Override
	public Client get(Integer id) {
		return repository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Client not found with id: " + id));
	}

	@Override
	public List<Client> getAll() {
		return repository.findAll();
	}

	@Override
	public List<Client> search(String name) {
		return repository.findByFirstName(name);
	}

	@Override
	@Transactional
	public void update(Integer id, ClientDto clientUpdate) {
		Client myClient = get(id);
		mapper.updateClientFromDto(clientUpdate, myClient);
		save(myClient);
	}

}
