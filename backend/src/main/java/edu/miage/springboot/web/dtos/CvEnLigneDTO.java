package edu.miage.springboot.web.dtos;

import edu.miage.springboot.dao.entities.*;
import jakarta.persistence.*;

import java.util.List;

public class CvEnLigneDTO {
    private Long id;
    private Long userId; // ID de l'utilisateur
    private String title;
    private String summary;
    private List<ExperienceDTO> experiences;
    private List<FormationDTO> formations;
    private List<CompetenceDTO> competences;
    private List<LangueDTO> langues;
    private String localisation;
    private List<CertificationDTO> certifications;
    private CoordonneesDTO coordonnees;

    public CoordonneesDTO getCoordonnees() {
        return coordonnees;
    }

    public void setCoordonnees(CoordonneesDTO coordonnees) {
        this.coordonnees = coordonnees;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public List<ExperienceDTO> getExperiences() {
        return experiences;
    }

    public void setExperiences(List<ExperienceDTO> experiences) {
        this.experiences = experiences;
    }

    public List<FormationDTO> getFormations() {
        return formations;
    }

    public void setFormations(List<FormationDTO> formations) {
        this.formations = formations;
    }

    public List<CompetenceDTO> getCompetences() {
        return competences;
    }

    public void setCompetences(List<CompetenceDTO> competences) {
        this.competences = competences;
    }

    public List<LangueDTO> getLangues() {
        return langues;
    }

    public void setLangues(List<LangueDTO> langues) {
        this.langues = langues;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public List<CertificationDTO> getCertifications() {
        return certifications;
    }

    public void setCertifications(List<CertificationDTO> certifications) {
        this.certifications = certifications;
    }
}
