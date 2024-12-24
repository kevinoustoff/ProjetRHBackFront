package edu.miage.springboot.services.interfaces;

import java.util.List;
import java.util.Optional;

import edu.miage.springboot.web.dtos.CandidatureDTO;

public interface CandidatureService {
	public List<CandidatureDTO> getAll();

    public Optional<CandidatureDTO> getById(Long id);

    public CandidatureDTO save(CandidatureDTO candidature);

    public CandidatureDTO update(CandidatureDTO candidature);

    public void deleteById(Long id);


}
