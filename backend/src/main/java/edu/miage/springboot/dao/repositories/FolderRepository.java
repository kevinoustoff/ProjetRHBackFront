package edu.miage.springboot.dao.repositories;

import edu.miage.springboot.dao.entities.FolderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FolderRepository extends JpaRepository<FolderEntity, Long> {
}