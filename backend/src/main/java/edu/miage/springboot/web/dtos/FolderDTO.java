package edu.miage.springboot.web.dtos;

import java.util.List;

public class FolderDTO {

    private Long id;
    private String name;
    private List<FileDTO> files;

    public FolderDTO() {
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

    public List<FileDTO> getFiles() {
        return files;
    }

    public void setFiles(List<FileDTO> files) {
        this.files = files;
    }
}
