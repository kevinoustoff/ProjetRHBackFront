package edu.miage.springboot.services.impl;

import edu.miage.springboot.dao.repositories.FolderRepository;
import edu.miage.springboot.dao.repositories.OffreEmploiRepository;
import edu.miage.springboot.services.interfaces.OffreEmploiService;
import edu.miage.springboot.utils.mappers.FolderMapper;
import edu.miage.springboot.utils.mappers.OffreEmploiMapper;
import edu.miage.springboot.web.dtos.OffreEmploiDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class OffreEmploiImpl implements OffreEmploiService {
	private OffreEmploiRepository offreEmploiRepository;
	private OffreEmploiMapper offreEmploiMapper;

	public OffreEmploiImpl(OffreEmploiRepository offreEmploiRepository,OffreEmploiMapper offreEmploiMapper) {
		this.offreEmploiRepository = offreEmploiRepository;
		this.offreEmploiMapper = offreEmploiMapper;
	}
	@Override
	public List<OffreEmploiDTO> getAll() {
		// TODO Auto-generated method stub
		return offreEmploiMapper.entitiesToDtos(offreEmploiRepository.findAll());
	}

	@Override
	public Optional<OffreEmploiDTO> getById(Long id) {
		// TODO Auto-generated method stub
		return offreEmploiRepository.findById(id).map(offreEmploiMapper::entityToDto);
	}

	@Override
	public OffreEmploiDTO save(OffreEmploiDTO emploi) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OffreEmploiDTO update(OffreEmploiDTO emploi) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

}
