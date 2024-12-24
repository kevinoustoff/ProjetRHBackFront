package edu.miage.springboot.dao.repositories;

import edu.miage.springboot.dao.entities.Candidature;
import org.springframework.data.jpa.repository.JpaRepository;



public interface CandidatureRepository extends JpaRepository<Candidature, Long> {

}
