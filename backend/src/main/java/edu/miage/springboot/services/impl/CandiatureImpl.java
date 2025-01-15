package edu.miage.springboot.services.impl;

import java.util.List;
import java.util.Optional;


import edu.miage.springboot.dao.entities.Candidature;
import edu.miage.springboot.dao.entities.OffreEmploi;
import edu.miage.springboot.dao.entities.Utilisateur;
import edu.miage.springboot.dao.repositories.CandidatureRepository;
import edu.miage.springboot.dao.repositories.OffreEmploiRepository;
import edu.miage.springboot.dao.repositories.UserRepository;
import edu.miage.springboot.services.interfaces.CandidatureService;
import edu.miage.springboot.utils.mappers.CandidatureMapper;
import edu.miage.springboot.web.dtos.CandidatureDTO;
import org.springframework.stereotype.Service;

@Service
public class CandiatureImpl implements CandidatureService {
	private CandidatureRepository candidatureRepository;
	private UserRepository userRepository;
	private OffreEmploiRepository  emploiRepository;

	private CandidatureMapper candidatureMapper;


	public CandiatureImpl(CandidatureRepository candidatureRepository,
						  UserRepository userRepository,
						  OffreEmploiRepository emploiRepository,
						  CandidatureMapper candidatureMapper) {
		this.candidatureRepository = candidatureRepository;
		this.userRepository = userRepository;
		this.emploiRepository = emploiRepository;
		this.candidatureMapper = candidatureMapper;
	}

	@Override
	public List<CandidatureDTO> getAll() {
		// TODO Auto-generated method stub
		return candidatureMapper.entitiesToDtos(candidatureRepository.findAll());
	}

	@Override
	public Optional<CandidatureDTO> getById(Long id) {
		// TODO Auto-generated method stub
		return candidatureRepository.findById(id).map(candidatureMapper::entityToDto);
	}

	@Override
	public CandidatureDTO save(CandidatureDTO candidatureDTO) {
		// TODO Auto-generated method stub
		Utilisateur utilisateur = userRepository.findById(candidatureDTO.getUtilisateurId())
				.orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));

		OffreEmploi offreEmploi = emploiRepository.findById(candidatureDTO.getOffreEmploiId())
				.orElseThrow(() -> new RuntimeException("Offre d'emploi non trouvée"));

		Candidature candidature = candidatureMapper.dtoToEntity(candidatureDTO);
		candidature.setUtilisateur(utilisateur);
		candidature.setOffreEmploi(offreEmploi);

		return candidatureMapper.entityToDto(candidatureRepository.save(candidature));
	}

	@Override
	public CandidatureDTO update(CandidatureDTO candidature) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Récupère toutes les candidatures associées à une offre d'emploi donnée.
	 * @param offreId L'identifiant de l'offre d'emploi.
	 * @return Liste des candidatures pour cette offre.
	 */
	public List<CandidatureDTO> getCandidaturesByOffre(Long offreId) {

		return  candidatureMapper.entitiesToDtos(candidatureRepository.findByOffreEmploi_Id(offreId));
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		candidatureRepository.deleteById(id);
		
	}

}
