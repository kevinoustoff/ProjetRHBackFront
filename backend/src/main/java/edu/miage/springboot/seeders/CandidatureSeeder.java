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

            Utilisateur utilisateur1 = new Utilisateur();
            utilisateur1.setUsername("candidat");
            utilisateur1.setPassword(passwordEncoder.encode("pass123"));
            utilisateur1.setNom("Bah");
            utilisateur1.setPrenoms("Woury");
            utilisateur1.setEmail("bah.woury@gmail.com");
            utilisateur1.setTelephone("0789765423");
            utilisateur1.setAdresse("123 Rue Strasbourg, Strasbourg");
            userRepository.save(utilisateur1);

            OffreEmploi offreEmploi1 = new OffreEmploi();
            offreEmploi1.setNom("Développeur Angular");
            offreEmploi1.setDescription("Nous recherchons un développeur frontend expérimenté.");
            offreEmploi1.setDatePublication(new Date());
            offreEmploi1.setReference("1234-DEV");
            offreEmploi1.setStatut("en attente");
            offreEmploi1.setDuree("6 mois");
            offreEmploi1.setTypeEmploi("CDI");

             offreEmploiRepository.save(offreEmploi1);

        Candidature candidature1 = new Candidature();
        candidature1.setDateCandidature(LocalDate.now());  // Date actuelle
        candidature1.setLettreMotivation("Je suis très motivé pour ce poste !");
        candidature1.setStatut("En attente");
        candidature1.setUtilisateur(utilisateur1);
        candidature1.setOffreEmploi(offreEmploi1);


            candidatureRepository.save(candidature);
            candidatureRepository.save(candidature1);


    }
}
