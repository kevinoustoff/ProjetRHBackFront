package edu.miage.springboot.dao.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "langues")
public class Langue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "cv_id")
    @JsonBackReference
    private CvEnLigne cv;

    private String language;
    private String proficiency; // Par exemple : Débutant, Intermédiaire, Avancé

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CvEnLigne getCv() {
        return cv;
    }

    public void setCv(CvEnLigne cv) {
        this.cv = cv;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getProficiency() {
        return proficiency;
    }

    public void setProficiency(String proficiency) {
        this.proficiency = proficiency;
    }
}
