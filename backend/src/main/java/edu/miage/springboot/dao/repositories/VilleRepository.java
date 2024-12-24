package edu.miage.springboot.dao.repositories;

import edu.miage.springboot.dao.entities.Ville;
import org.springframework.data.jpa.repository.JpaRepository;



public interface VilleRepository extends JpaRepository<Ville, Long> {

}
