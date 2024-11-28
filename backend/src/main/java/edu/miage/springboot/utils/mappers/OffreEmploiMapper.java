package com.projet.RH.utils.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.projet.RH.dtos.OffreEmploiDTO;
import com.projet.RH.models.OffreEmploi;

@Mapper(componentModel = "spring")
public interface OffreEmploiMapper {
	 OffreEmploi dtoToEntity(OffreEmploiDTO dto);
	 OffreEmploiDTO entityToDto(OffreEmploi entity);
	 List<OffreEmploi> dtosToEntities(List<OffreEmploiDTO> dtos);
	 List<OffreEmploiDTO> entitiesToDtos(List<OffreEmploi> entities);

}
