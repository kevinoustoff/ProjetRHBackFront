package edu.miage.springboot.services.impl;

import java.util.List;
import java.util.Optional;


import edu.miage.springboot.services.interfaces.VilleService;
import edu.miage.springboot.web.dtos.VilleDTO;
import org.springframework.stereotype.Service;

@Service
public class VilleImpl implements VilleService {

	@Override
	public List<VilleDTO> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<VilleDTO> getById(Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public VilleDTO save(VilleDTO ville) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VilleDTO update(VilleDTO ville) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

}
