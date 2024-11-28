package com.projet.RH.services.interfaces;

import java.util.List;
import java.util.Optional;

import com.projet.RH.dtos.VilleDTO;

public interface VilleService {
	public List<VilleDTO> getAll();

    public Optional<VilleDTO> getById(Long id);

    public VilleDTO save(VilleDTO ville);

    public VilleDTO update(VilleDTO ville);

    public void deleteById(Long id);

	

}
