package edu.miage.springboot.dao.repositories;


import edu.miage.springboot.dao.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UserRoleRepository extends JpaRepository<Role, Long> {

}