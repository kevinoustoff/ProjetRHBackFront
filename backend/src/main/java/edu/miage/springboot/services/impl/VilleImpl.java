package edu.miage.springboot.services.impl;

import java.util.List;
import java.util.Optional;


import edu.miage.springboot.dao.repositories.VilleRepository;
import edu.miage.springboot.services.interfaces.VilleService;
import edu.miage.springboot.utils.mappers.VilleMapper;
import edu.miage.springboot.web.dtos.VilleDTO;
import org.springframework.stereotype.Service;

@Service
public class VilleImpl implements VilleService {
	private final VilleRepository villeRepository;
	private final VilleMapper villeMapper;

	public VilleImpl(VilleRepository villeRepository, VilleMapper villeMapper) {
		this.villeRepository = villeRepository;
		this.villeMapper = villeMapper;
	}

	@Override
	public List<VilleDTO> getAll() {
		// TODO Auto-generated method stub
		return villeMapper.entitiesToDtos(villeRepository.findAll());
	}

	@Override
	public Optional<VilleDTO> getById(Long id) {
		// TODO Auto-generated method stub
		return villeRepository.findById(id).map(villeMapper::entityToDto);
	}

	@Override
	public VilleDTO save(VilleDTO ville) {
		// TODO Auto-generated method stub
		return villeMapper.entityToDto(villeRepository.save(villeMapper.dtoToEntity(ville)));
	}

	@Override
	public VilleDTO update(VilleDTO ville) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		villeRepository.deleteById(id);
		
	}

}
