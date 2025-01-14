package edu.miage.springboot.dao.repositories;

import edu.miage.springboot.dao.entities.Candidature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface CandidatureRepository extends JpaRepository<Candidature, Long> {
    /**
     * Trouve toutes les candidatures associées à une offre d'emploi donnée.
     * @param offreId L'identifiant de l'offre d'emploi.
     * @return Liste des candidatures associées à cette offre.
     */
    @Query("SELECT c " +
            "FROM Candidature c " +
            "JOIN c.utilisateur u " +
            "JOIN c.offreEmploi o " +
            "WHERE o.id = :offreId")
    List<Candidature> findByOffreEmploi_Id(@Param("offreId") Long offreId);
}
