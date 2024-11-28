package edu.miage.springboot.utils.mappers;

import edu.miage.springboot.dao.entities.FileEntity;
import edu.miage.springboot.web.dtos.FileDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FileMapper {
    FileEntity dtoToEntity(FileDTO dto);
    FileDTO entityToDto(FileEntity entity);
    List<FileEntity> dtosToEntities(List<FileDTO> dtos);
    List<FileDTO> entitiesToDtos(List<FileEntity> entities);
}
