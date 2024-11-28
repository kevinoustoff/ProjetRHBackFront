package com.projet.RH.utils.mappers;

import java.util.List;

import org.mapstruct.Mapper;


import com.projet.RH.dtos.UtilisateurDTO;
import com.projet.RH.models.Utilisateur;

@Mapper(componentModel = "spring")
public interface UtilisateurMapper {
	
	 Utilisateur dtoToEntity(UtilisateurDTO dto);
	 UtilisateurDTO entityToDto(Utilisateur entity);
	 List<Utilisateur> dtosToEntities(List<UtilisateurDTO> dtos);
	 List<UtilisateurDTO> entitiesToDtos(List<Utilisateur> entities);

}
