package edu.miage.springboot.dao.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@Entity
@Table(name="roles")
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nom;
	
	public Role() {
		// TODO Auto-generated constructor stub
	}
	public Role(String nom) {
		// TODO Auto-generated constructor stub
		this.nom=nom;
	}

	public Long getId() {
		return id;
	}
	@JsonProperty("name")
	public String getNom() {
		return nom;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@JsonProperty("name")
	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public String toString() {
		return "Role{name='" + nom + "'}";
	}
	
}
