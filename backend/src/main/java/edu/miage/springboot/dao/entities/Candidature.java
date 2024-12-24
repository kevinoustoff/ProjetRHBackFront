package edu.miage.springboot.dao.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Candidature {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate dateCandidature; // Date de la candidature

    @Column(columnDefinition = "TEXT")
    private String lettreMotivation; // Lettre de motivation

    @Column(nullable = false)
    private String statut; // Statut de la candidature (ex: "en attente", "acceptée", "refusée")

    @ManyToOne
    @JoinColumn(name = "utilisateur_id", nullable = false)
    private Utilisateur utilisateur; // L'utilisateur qui a postulé

    @ManyToOne
    @JoinColumn(name = "offre_id", nullable = false)
    private OffreEmploi offreEmploi; // L'offre pour laquelle on postule
    
    // Constructeurs
    public Candidature() {}

    public Candidature(LocalDate dateCandidature, String lettreMotivation, String statut, Utilisateur utilisateur, OffreEmploi offreEmploi) {
        this.dateCandidature = dateCandidature;
        this.lettreMotivation = lettreMotivation;
        this.statut = statut;
        this.utilisateur = utilisateur;
        this.offreEmploi = offreEmploi;
    }

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDateCandidature() {
        return dateCandidature;
    }

    public void setDateCandidature(LocalDate dateCandidature) {
        this.dateCandidature = dateCandidature;
    }

    public String getLettreMotivation() {
        return lettreMotivation;
    }

    public void setLettreMotivation(String lettreMotivation) {
        this.lettreMotivation = lettreMotivation;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public OffreEmploi getOffreEmploi() {
        return offreEmploi;
    }

    public void setOffreEmploi(OffreEmploi offreEmploi) {
        this.offreEmploi = offreEmploi;
    }
}

