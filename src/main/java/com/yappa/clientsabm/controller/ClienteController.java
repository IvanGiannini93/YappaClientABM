package com.yappa.clientsabm.controller;

import java.util.List;

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
import com.yappa.clientsabm.model.Cliente;
import com.yappa.clientsabm.service.ClienteService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteService service;
	
	@GetMapping
	public ResponseEntity<List<ClienteDto>> getAll(){
		try {
			return ResponseEntity.ok(service.getAll());
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ClienteDto> get(@PathVariable Integer id) {
		try {
			return ResponseEntity.ok(service.get(id));
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return ResponseEntity.noContent().build();
		}
		
	}
	
	@GetMapping("/search")
	public ResponseEntity<List<ClienteDto>> search(@RequestParam String nombres){
		try {
			return ResponseEntity.ok(service.search(nombres));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping
	public void insert(@Valid @RequestBody ClienteDto clienteDto) {
		try {
			service.save(clienteDto);			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@PutMapping("/{id}")
	public void update(@PathVariable Integer id ,@Valid @RequestBody ClienteDto clienteDto) {
		try {
			service.update(id, clienteDto);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
