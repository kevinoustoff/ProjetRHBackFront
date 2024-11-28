package com.projet.RH.seeders;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.projet.RH.models.Role;
import com.projet.RH.models.Utilisateur;
import com.projet.RH.repositories.UserRoleRepository;
import com.projet.RH.repositories.UserRepository;

import java.util.Set;

@Component
public class UtilisateurSeeder implements CommandLineRunner {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserRoleRepository userRoleRepository;
    @Override
    public void run(String... args) throws Exception {
        Role userRole=new Role();
        userRole.setNom("USER");
        userRole=userRoleRepository.save(userRole);

        Role adminRole=new Role();
        adminRole.setNom("ADMIN");
        adminRole=userRoleRepository.save(adminRole);

        Utilisateur user=new Utilisateur();
        user.setUsername("user");
        user.setPassword(passwordEncoder.encode("123456"));
        user.setRoles(Set.of(userRole));
        userRepository.save(user);

        Utilisateur admin=new Utilisateur();
        admin.setUsername("admin");
        admin.setPassword(passwordEncoder.encode("123456"));
        admin.setRoles(Set.of(userRole,adminRole));
        userRepository.save(admin);

    }
}

