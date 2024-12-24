package edu.miage.springboot.dao.repositories;




import edu.miage.springboot.dao.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Utilisateur, Long> {
    Utilisateur findByUsername(String username);
}