package edu.miage.springboot.utils.mappers;

import java.util.List;

import org.mapstruct.Mapper;


import edu.miage.springboot.web.dtos.UtilisateurDTO;
import edu.miage.springboot.dao.entities.Utilisateur;

@Mapper(componentModel = "spring")
public interface UtilisateurMapper {
	
	 Utilisateur dtoToEntity(UtilisateurDTO dto);
	 UtilisateurDTO entityToDto(Utilisateur entity);
	 List<Utilisateur> dtosToEntities(List<UtilisateurDTO> dtos);
	 List<UtilisateurDTO> entitiesToDtos(List<Utilisateur> entities);

}
