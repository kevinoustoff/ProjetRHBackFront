package com.projet.RH.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.projet.RH.models.Role;
import com.projet.RH.models.Utilisateur;

public interface UserRoleRepository extends JpaRepository<Role, Long> {
}