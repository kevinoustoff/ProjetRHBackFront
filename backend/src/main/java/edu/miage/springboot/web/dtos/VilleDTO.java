package com.projet.RH.dtos;

import java.util.Set;

public class VilleDTO {
	
	    private Long id;
	    private String ville;
	    private String codePostal;
	    private Set<UtilisateurDTO> utilisateurs;

	    // Getters et Setters
	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public String getVille() {
	        return ville;
	    }

	    public void setVille(String ville) {
	        this.ville = ville;
	    }

	    public String getCodePostal() {
	        return codePostal;
	    }

	    public void setCodePostal(String codePostal) {
	        this.codePostal = codePostal;
	    }

	    public Set<UtilisateurDTO> getUtilisateurs() {
	        return utilisateurs;
	    }

	    public void setUtilisateurs(Set<UtilisateurDTO> utilisateurs) {
	        this.utilisateurs = utilisateurs;
	    }

}
