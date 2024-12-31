package edu.miage.springboot.services.impl;

import java.util.List;
import java.util.Optional;


import edu.miage.springboot.services.interfaces.CandidatureService;
import edu.miage.springboot.web.dtos.CandidatureDTO;
import org.springframework.stereotype.Service;

@Service
public class CandiatureImpl implements CandidatureService {

	@Override
	public List<CandidatureDTO> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<CandidatureDTO> getById(Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public CandidatureDTO save(CandidatureDTO candidature) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CandidatureDTO update(CandidatureDTO candidature) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

}
