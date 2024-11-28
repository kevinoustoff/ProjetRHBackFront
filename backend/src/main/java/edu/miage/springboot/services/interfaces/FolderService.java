package edu.miage.springboot.services.interfaces;

import edu.miage.springboot.web.dtos.FolderDTO;

import java.util.List;
import java.util.Optional;

public interface FolderService {

    public List<FolderDTO> getAll();

    public Optional<FolderDTO> getById(Long id);

    public FolderDTO save(FolderDTO folder);

    public FolderDTO update(FolderDTO folderDTO);

    public void deleteById(Long id);
}
