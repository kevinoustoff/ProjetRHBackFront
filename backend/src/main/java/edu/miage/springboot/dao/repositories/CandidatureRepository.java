package com.projet.RH.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projet.RH.models.Candidature;

public interface CandidatureRepository extends JpaRepository<Candidature, Long> {

}
