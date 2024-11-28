package com.projet.RH.dtos;

import java.util.HashSet;
import java.util.Set;



public class UtilisateurDTO {
	private Long id;

	private String nom;

	private String prenoms;
	
	private String username;

	private String password;

	private String email;

	private String telephone;

	private String adresse;
	private VilleDTO ville; // Référence à la ville de 
	 private Set<RoleDTO> roles = new HashSet<>();
	 
	// Getters et Setters
		public Long getId() {
			return id;
		}

		public String getNom() {
			return nom;
		}

		public String getPrenoms() {
			return prenoms;
		}

		public String getPassword() {
			return password;
		}

		public String getEmail() {
			return email;
		}

		public String getTelephone() {
			return telephone;
		}

		public String getAdresse() {
			return adresse;
		}

		public VilleDTO getVille() {
			return ville;
		}

		public void setVille(VilleDTO ville) {
			this.ville = ville;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public void setNom(String nom) {
			this.nom = nom;
		}

		public void setPrenoms(String prenoms) {
			this.prenoms = prenoms;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public void setTelephone(String telephone) {
			this.telephone = telephone;
		}

		public void setAdresse(String adresse) {
			this.adresse = adresse;
		}
		
		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}
		public Set<RoleDTO> getRoles() {
	        return roles;
	    }

	    public void setRoles(Set<RoleDTO> roles) {
	        this.roles = roles;
	    }

}
