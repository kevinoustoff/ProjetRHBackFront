package com.projet.RH.utils.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.projet.RH.dtos.VilleDTO;
import com.projet.RH.models.Ville;

@Mapper(componentModel = "spring")
public interface VilleMapper {
	 Ville dtoToEntity(VilleDTO dto);
	 VilleDTO entityToDto(Ville entity);
	 List<Ville> dtosToEntities(List<VilleDTO> dtos);
	 List<VilleDTO> entitiesToDtos(List<Ville> entities);


}
