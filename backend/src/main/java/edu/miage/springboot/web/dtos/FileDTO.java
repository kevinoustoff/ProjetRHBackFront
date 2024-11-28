package edu.miage.springboot.web.dtos;

public class FileDTO {
    private Long id;
    private String name;

    public FileDTO() {
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
