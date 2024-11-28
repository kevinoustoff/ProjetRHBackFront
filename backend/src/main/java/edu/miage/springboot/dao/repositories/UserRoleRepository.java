package edu.miage.springboot.dao.repositories;

import edu.miage.springboot.dao.entities.UserRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRoleEntity, Long> {
}