package com.projet.RH.utils.mappers;

import java.util.List;
import org.mapstruct.Mapper;

import com.projet.RH.dtos.CandidatureDTO;
import com.projet.RH.models.Candidature;

@Mapper(componentModel = "spring")
public interface CandidatureMapper {

	 Candidature dtoToEntity(CandidatureDTO dto);
	 CandidatureDTO entityToDto(Candidature entity);
	 List<Candidature> dtosToEntities(List<CandidatureDTO> dtos);
	 List<CandidatureDTO> entitiesToDtos(List<Candidature> entities);

}
