package edu.miage.springboot.seeders;

import edu.miage.springboot.dao.entities.Ville;
import edu.miage.springboot.dao.repositories.VilleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class VilleSeeder implements CommandLineRunner {
    @Autowired
    private VilleRepository villeRepository;
    @Override
    public void run(String... args) throws Exception {
        if(villeRepository.count() == 0) {
            Ville paris = new Ville("Paris", "75000");
            Ville lyon = new Ville("Lyon", "69000");
            Ville strasbourg = new Ville("Strasbourg", "67000");
            villeRepository.save(paris);
            villeRepository.save(lyon);
            villeRepository.save(strasbourg);
        }

    }
}
