package com.yappa.clientsabm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yappa.clientsabm.dto.ClienteDto;
import com.yappa.clientsabm.mapper.ClienteMapper;
import com.yappa.clientsabm.model.Cliente;
import com.yappa.clientsabm.repository.ClienteRepository;
import com.yappa.clientsabm.service.ClienteService;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class ClienteServiceImpl implements ClienteService{

	@Autowired ClienteRepository repository;
	
	@Autowired ClienteMapper mapper;
	
	
	@Override
	@Transactional
	public void save(Cliente cliente) {
		repository.save(cliente);
	}

	@Override
	public Cliente get(Integer id) {
		return repository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Cliente not found with id: " + id));
	}

	@Override
	public List<Cliente> getAll() {
		return repository.findAll();
	}

	@Override
	public List<Cliente> search(String nombres) {
		return repository.findByNombres(nombres);
	}

	@Override
	@Transactional
	public void update(Integer id, ClienteDto clienteUpdate) {
		Cliente clienteActual = get(id);
		mapper.updateClienteFromDto(clienteUpdate, clienteActual);
		save(clienteActual);
	}

}
