package com.projet.RH.repositories;


import com.projet.RH.models.Utilisateur;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Utilisateur, Long> {
    Utilisateur findByUsername(String username);
}