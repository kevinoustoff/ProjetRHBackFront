package edu.miage.springboot.dao.repositories;

import edu.miage.springboot.dao.entities.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<FileEntity, Long> {
}