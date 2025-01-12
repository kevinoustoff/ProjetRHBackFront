package edu.miage.springboot.dao.repositories;

import edu.miage.springboot.dao.entities.CvEnLigne;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CvEnLigneRepository extends JpaRepository<CvEnLigne, Long> {
    Optional<CvEnLigne> findByUserId(Long userId);
}
