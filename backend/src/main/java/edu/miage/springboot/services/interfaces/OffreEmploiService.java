package edu.miage.springboot.services.interfaces;

import java.util.List;
import java.util.Optional;

import edu.miage.springboot.web.dtos.OffreEmploiDTO;

public interface OffreEmploiService {
	public List<OffreEmploiDTO> getAll();

    public Optional<OffreEmploiDTO> getById(Long id);

    public OffreEmploiDTO save(OffreEmploiDTO emploi);

    public OffreEmploiDTO update(OffreEmploiDTO emploi);

    public void deleteById(Long id);


}
