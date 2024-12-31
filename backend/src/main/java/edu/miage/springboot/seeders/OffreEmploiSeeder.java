package edu.miage.springboot.seeders;

import edu.miage.springboot.dao.entities.OffreEmploi;
import edu.miage.springboot.dao.repositories.OffreEmploiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;
@Component
public class OffreEmploiSeeder implements CommandLineRunner {
    @Autowired
    private OffreEmploiRepository offreEmploiRepository;
    @Override
    public void run(String... args) throws Exception {
        OffreEmploi o1 = new OffreEmploi();
        o1.setNom("Développeur fullstack");
        o1.setDescription("Nous cherchons un developpeur junior qui se chargera des opérations de developpement et de maintenance pour un de nos emails." +
                "Prerequis: MongoDB,Mysql,VueJs,PostgreSQL");
        o1.setReference("REF3112202401");
        o1.setDatePublication(new Date());

        OffreEmploi o2 = new OffreEmploi();
        o2.setNom("Chef de projet");
        o2.setDescription("En tant que chef il vous sera demandé de planifier les écheances de differents projets de developpement des logiciels"
        +" Compétences attendues: PMP, La gestion des conflits, la communication inter personnelle");
        o2.setReference("REF3112202402");
        o2.setDatePublication(new Date());
        offreEmploiRepository.save(o1);
        offreEmploiRepository.save(o2);
    }
}
