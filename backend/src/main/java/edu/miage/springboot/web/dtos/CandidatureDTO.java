package edu.miage.springboot.web.dtos;

import java.time.LocalDate;
public class CandidatureDTO {
	private Long id; // Identifiant unique de la candidature

   
    private LocalDate dateCandidature; // Date de la candidature

    
    private String lettreMotivation; // Lettre de motivation du candidat

   
    private String statut; // Statut de la candidature (Ex: "En attente", "Acceptée", "Refusée")

    
    private UtilisateurDTO utilisateur;

    
    private OffreEmploiDTO offreEmploi;

    private Long utilisateurId;

    private Long offreEmploiId;

    public Long getUtilisateurId() {
        return utilisateurId;
    }

    public void setUtilisateurId(Long utilisateurId) {
        this.utilisateurId = utilisateurId;
    }

    public Long getOffreEmploiId() {
        return offreEmploiId;
    }

    public void setOffreEmploiId(Long offreEmploiId) {
        this.offreEmploiId = offreEmploiId;
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

	public UtilisateurDTO getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(UtilisateurDTO utilisateur) {
		this.utilisateur = utilisateur;
	}

	public OffreEmploiDTO getOffreEmploi() {
		return offreEmploi;
	}

	public void setOffreEmploi(OffreEmploiDTO offreEmploi) {
		this.offreEmploi = offreEmploi;
	}
    

   
}
