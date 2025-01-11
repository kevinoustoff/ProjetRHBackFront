package edu.miage.springboot.dao.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "cvsEnLigne")
public class CvEnLigne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Utilisateur user;


    private String title;

    @Column(length = 1000)
    private String summary;

    @OneToMany(mappedBy = "cv", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Experience> experiences; // Liste des expériences

    @OneToMany(mappedBy = "cv", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Formation> formations; // Liste des formations

    @OneToMany(mappedBy = "cv", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Competence> competences; // Liste des compétences

    @OneToMany(mappedBy = "cv", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Langue> langues; // Liste des langues

    @Column(length = 1000)
    private String localisation; // Localisation

    @OneToMany(mappedBy = "cv", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Certification> certifications; // Liste des certifications

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "coordonnees_id")
    private Coordonnees coordonnees;

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Utilisateur getUser() {
        return user;
    }

    public void setUser(Utilisateur user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public List<Experience> getExperiences() {
        return experiences;
    }

    public void setExperiences(List<Experience> experiences) {
        this.experiences = experiences;
    }

    public List<Formation> getFormations() {
        return formations;
    }

    public void setFormations(List<Formation> formations) {
        this.formations = formations;
    }

    public List<Competence> getCompetences() {
        return competences;
    }

    public void setCompetences(List<Competence> competences) {
        this.competences = competences;
    }

    public List<Langue> getLangues() {
        return langues;
    }

    public void setLangues(List<Langue> langues) {
        this.langues = langues;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }


    public List<Certification> getCertifications() {
        return certifications;
    }

    public void setCertifications(List<Certification> certifications) {
        this.certifications = certifications;
    }

    public Coordonnees getCoordonnees() {
        return coordonnees;
    }

    public void setCoordonnees(Coordonnees coordonnees) {
        this.coordonnees = coordonnees;
    }
}
