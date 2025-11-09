package com.yappa.clientsabm.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

	@Autowired 
	private ClienteRepository repository;
	
	@Autowired 
	private ClienteMapper mapper;
	
	
	@Override
	@Transactional
	public void save(ClienteDto clienteDto) {
		try {
			repository.save(new Cliente(clienteDto));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public ClienteDto get(Integer id) {
		Cliente cliente = repository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("No existe un cliente con id: " + id));
		return new ClienteDto(cliente);
	}

	@Override
	public List<ClienteDto> getAll() {
		List<Cliente> clientes = repository.findAll();
		return clientes.stream()
				.map(ClienteDto::new)
				.collect(Collectors.toList());
	}

	@Override
	public List<ClienteDto> search(String nombres) {
		List<Cliente> clientes = repository.findByNombres(nombres);
		return clientes.stream()
				.map(ClienteDto::new)
				.collect(Collectors.toList());
	}

	@Override
	@Transactional
	public void update(Integer id, ClienteDto clienteUpdate) {
		try{
			Cliente clienteActual = repository.findById(id)
					.orElseThrow(() -> new EntityNotFoundException("No existe un cliente con id: " + id));
			mapper.updateClienteFromDto(clienteUpdate, clienteActual);
			repository.save(clienteActual);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
