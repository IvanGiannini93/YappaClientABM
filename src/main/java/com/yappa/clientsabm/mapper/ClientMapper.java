package com.yappa.clientsabm.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

import com.yappa.clientsabm.dto.ClientDto;
import com.yappa.clientsabm.model.Client;


@Mapper(componentModel = "spring")
public interface ClientMapper {
	public void updateClientFromDto(ClientDto clientDto, @MappingTarget Client client);
}
