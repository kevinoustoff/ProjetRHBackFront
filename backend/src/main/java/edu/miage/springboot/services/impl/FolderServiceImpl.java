package edu.miage.springboot.services.impl;

import edu.miage.springboot.dao.repositories.FolderRepository;
import edu.miage.springboot.services.interfaces.FolderService;
import edu.miage.springboot.utils.mappers.FolderMapper;
import edu.miage.springboot.web.dtos.FolderDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FolderServiceImpl implements FolderService {

    private FolderRepository folderRepository;
    private FolderMapper folderMapper;

    public FolderServiceImpl(FolderRepository folderRepository,FolderMapper folderMapper) {
        this.folderRepository = folderRepository;
        this.folderMapper=folderMapper;
    }

    @Override
    public List<FolderDTO> getAll() {
        return folderMapper.entitiesToDtos(folderRepository.findAll());
    }

    @Override
    public Optional<FolderDTO> getById(Long id) {
        return folderRepository.findById(id).map(folderMapper::entityToDto);
    }

    @Override
    public FolderDTO save(FolderDTO folder) {
        return null;
    }

    @Override
    public FolderDTO update(FolderDTO folderDTO) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
