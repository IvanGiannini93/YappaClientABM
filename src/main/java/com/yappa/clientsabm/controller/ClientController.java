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

import com.yappa.clientsabm.dto.ClientDto;
import com.yappa.clientsabm.model.Client;
import com.yappa.clientsabm.service.ClientService;


@RestController
@RequestMapping("/clients")
public class ClientController {

	@Autowired
	private ClientService service;
	
	@GetMapping
	public ResponseEntity<List<Client>> getAll(){
		try {
			return ResponseEntity.ok(service.getAll());
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Client> get(@PathVariable Integer id) {
		try {
			return ResponseEntity.ok(service.get(id));
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return ResponseEntity.noContent().build();
		}
		
	}
	
	@GetMapping("/search")
	public ResponseEntity<List<Client>> search(@RequestParam String firstName){
		try {
			return ResponseEntity.ok(service.search(firstName));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping
	public void insert(@RequestBody Client client) {
		try {
			service.save(client);			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@PutMapping("/{id}")
	public void update(@PathVariable Integer id ,@RequestBody ClientDto clientDto) {
		try {
			service.update(id, clientDto);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
