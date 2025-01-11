package edu.miage.springboot.seeders;

import edu.miage.springboot.dao.entities.Candidature;
import edu.miage.springboot.dao.entities.OffreEmploi;
import edu.miage.springboot.dao.entities.Utilisateur;
import edu.miage.springboot.dao.repositories.CandidatureRepository;
import edu.miage.springboot.dao.repositories.OffreEmploiRepository;
import edu.miage.springboot.dao.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

@Component
public class CandidatureSeeder implements CommandLineRunner {
    @Autowired
    private CandidatureRepository candidatureRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OffreEmploiRepository offreEmploiRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setUsername("candidat");
        utilisateur.setPassword(passwordEncoder.encode("pass123")); // Encoder le mot de passe
        utilisateur.setNom("Koutou");
        utilisateur.setPrenoms("Patrick");
        utilisateur.setEmail("koutou.patrick@gmail.com");
        utilisateur.setTelephone("0123456789");
        utilisateur.setAdresse("123 Rue Sauvage, Mulhouse");
        userRepository.save(utilisateur);

        OffreEmploi offreEmploi = new OffreEmploi();
        offreEmploi.setNom("Développeur Backend");
        offreEmploi.setDescription("Nous recherchons un développeur backend expérimenté.");
        offreEmploi.setDatePublication(new Date());
        offreEmploi.setReference("REF123456");
        offreEmploi.setStatut("active");
        offreEmploi.setDuree("6 mois");
        offreEmploi.setTypeEmploi("CDD");
         offreEmploiRepository.save(offreEmploi);

            Candidature candidature = new Candidature();
            candidature.setDateCandidature(LocalDate.now());  // Date actuelle
            candidature.setLettreMotivation("Je suis très motivé pour ce poste !");
            candidature.setStatut("En attente");
            candidature.setUtilisateur(utilisateur);
            candidature.setOffreEmploi(offreEmploi);

            candidatureRepository.save(candidature);


    }
}
