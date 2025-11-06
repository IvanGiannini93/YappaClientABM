package com.yappa.clientsabm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yappa.clientsabm.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer>{

}
