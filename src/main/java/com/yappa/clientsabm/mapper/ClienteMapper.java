package com.yappa.clientsabm.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.yappa.clientsabm.dto.ClienteDto;
import com.yappa.clientsabm.model.Cliente;


@Mapper(componentModel = "spring")
public interface ClienteMapper {
	public void updateClienteFromDto(ClienteDto clienteDto, @MappingTarget Cliente cliente);
}
