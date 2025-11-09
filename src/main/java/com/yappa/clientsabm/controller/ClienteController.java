package com.yappa.clientsabm.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yappa.clientsabm.dto.ClienteDto;
import com.yappa.clientsabm.service.ClienteService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/clientes")
public class ClienteController {

	private static final Logger LOG = LoggerFactory.getLogger(ClienteController.class);
	
	@Autowired
	private ClienteService service;
	
	@GetMapping
	public ResponseEntity<List<ClienteDto>> getAll(){
		LOG.info("GET /clientes");
		try {
			return ResponseEntity.ok(service.getAll());
		} catch (Exception e) {
			LOG.error(e.getMessage());
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ClienteDto> get(@PathVariable Integer id) {
		LOG.info("GET /clientes/{id}");
		try {
			return ResponseEntity.ok(service.get(id));
		} catch (Exception e) {
			LOG.error(e.getMessage());
			return ResponseEntity.noContent().build();
		}
		
	}
	
	@GetMapping("/search")
	public ResponseEntity<List<ClienteDto>> search(@RequestParam String nombres){
		LOG.info("GET /clientes/search");
		try {
			return ResponseEntity.ok(service.search(nombres));
		} catch (Exception e) {
			LOG.error(e.getMessage());
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping
	public void insert(@Valid @RequestBody ClienteDto clienteDto) {
		LOG.info("POST /clientes");
		try {
			service.save(clienteDto);			
		} catch (Exception e) {
			LOG.error(e.getMessage());
		}
	}
	
	@PutMapping("/{id}")
	public void update(@PathVariable Integer id ,@Valid @RequestBody ClienteDto clienteDto) {
		LOG.info("PUT /clientes/{id}");
		try {
			service.update(id, clienteDto);
		} catch (Exception e) {
			LOG.error(e.getMessage());
		}
	}
}
