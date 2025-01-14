package edu.miage.springboot.utils.mappers;

import edu.miage.springboot.dao.entities.Candidature;
import edu.miage.springboot.dao.entities.CvEnLigne;
import edu.miage.springboot.web.dtos.CandidatureDTO;
import edu.miage.springboot.web.dtos.CvEnLigneDTO;
import org.mapstruct.Mapper;

import java.util.List;
@Mapper(componentModel = "spring")
public interface CvEnLigneMapper {
    CvEnLigne dtoToEntity(CvEnLigneDTO dto);
    CvEnLigneDTO entityToDto(CvEnLigne entity);
    List<Candidature> dtosToEntities(List<CvEnLigneDTO> dtos);
    List<CvEnLigneDTO> entitiesToDtos(List<CvEnLigne> entities);
}
