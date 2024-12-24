package edu.miage.springboot.utils.mappers;

import java.util.List;

import edu.miage.springboot.dao.entities.Ville;
import edu.miage.springboot.web.dtos.VilleDTO;
import org.mapstruct.Mapper;



@Mapper(componentModel = "spring")
public interface VilleMapper {
	 Ville dtoToEntity(VilleDTO dto);
	 VilleDTO entityToDto(Ville entity);
	 List<Ville> dtosToEntities(List<VilleDTO> dtos);
	 List<VilleDTO> entitiesToDtos(List<Ville> entities);


}
