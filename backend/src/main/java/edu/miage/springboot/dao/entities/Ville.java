package com.projet.RH.models;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name="ville")
public class Ville {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String ville;

    @Column(nullable = false, length = 10)
    private String codePostal;

    @OneToMany(mappedBy = "ville", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Utilisateur> utilisateurs;

    public Ville() {}

    public Ville(String ville, String codePostal) {
        this.ville = ville;
        this.codePostal = codePostal;
    }

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

    public Set<Utilisateur> getUtilisateurs() {
        return utilisateurs;
    }

    public void setUtilisateurs(Set<Utilisateur> utilisateurs) {
        this.utilisateurs = utilisateurs;
    }
}
