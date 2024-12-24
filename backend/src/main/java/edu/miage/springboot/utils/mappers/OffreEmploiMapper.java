package edu.miage.springboot.utils.mappers;

import java.util.List;

import edu.miage.springboot.dao.entities.OffreEmploi;
import edu.miage.springboot.web.dtos.OffreEmploiDTO;
import org.mapstruct.Mapper;



@Mapper(componentModel = "spring")
public interface OffreEmploiMapper {
	 OffreEmploi dtoToEntity(OffreEmploiDTO dto);
	 OffreEmploiDTO entityToDto(OffreEmploi entity);
	 List<OffreEmploi> dtosToEntities(List<OffreEmploiDTO> dtos);
	 List<OffreEmploiDTO> entitiesToDtos(List<OffreEmploi> entities);

}
