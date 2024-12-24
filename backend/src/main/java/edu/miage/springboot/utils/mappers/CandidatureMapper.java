package edu.miage.springboot.utils.mappers;;

import java.util.List;
import org.mapstruct.Mapper;

import edu.miage.springboot.web.dtos.CandidatureDTO;
import edu.miage.springboot.dao.entities.Candidature;

@Mapper(componentModel = "spring")
public interface CandidatureMapper {

	 Candidature dtoToEntity(CandidatureDTO dto);
	 CandidatureDTO entityToDto(Candidature entity);
	 List<Candidature> dtosToEntities(List<CandidatureDTO> dtos);
	 List<CandidatureDTO> entitiesToDtos(List<Candidature> entities);

}
