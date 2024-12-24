package edu.miage.springboot.services.interfaces;

import java.util.List;
import java.util.Optional;


import edu.miage.springboot.web.dtos.UtilisateurDTO;

public interface UtilisateurService {
	public List<UtilisateurDTO> getAll();

    public Optional<UtilisateurDTO> getById(Long id);

    public UtilisateurDTO save(UtilisateurDTO utilisateur);

    public UtilisateurDTO update(UtilisateurDTO utilisateur);

    public void deleteById(Long id);

}
