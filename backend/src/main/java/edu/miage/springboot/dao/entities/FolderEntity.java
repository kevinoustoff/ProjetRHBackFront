package edu.miage.springboot.dao.entities;

import jakarta.persistence.*;
import org.springframework.context.annotation.Lazy;

import java.util.List;

@Entity
@Table(name = "folders")
public class FolderEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "folder", orphanRemoval = true, fetch = FetchType.LAZY)
    private List<FileEntity> files;

    public List<FileEntity> getFiles() {
        return files;
    }

    public void setFiles(List<FileEntity> files) {
        this.files = files;
    }

    public FolderEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
