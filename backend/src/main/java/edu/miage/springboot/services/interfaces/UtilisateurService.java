package com.projet.RH.services.interfaces;

import java.util.List;
import java.util.Optional;


import com.projet.RH.dtos.UtilisateurDTO;

public interface UtilisateurService {
	public List<UtilisateurDTO> getAll();

    public Optional<UtilisateurDTO> getById(Long id);

    public UtilisateurDTO save(UtilisateurDTO utilisateur);

    public UtilisateurDTO update(UtilisateurDTO utilisateur);

    public void deleteById(Long id);

}
