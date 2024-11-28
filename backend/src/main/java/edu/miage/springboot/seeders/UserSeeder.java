package edu.miage.springboot.seeders;

import edu.miage.springboot.dao.entities.UserEntity;
import edu.miage.springboot.dao.entities.UserRoleEntity;
import edu.miage.springboot.dao.repositories.UserRepository;
import edu.miage.springboot.dao.repositories.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class UserSeeder implements CommandLineRunner {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserRoleRepository userRoleRepository;
    @Override
    public void run(String... args) throws Exception {
        UserRoleEntity userRole=new UserRoleEntity();
        userRole.setName("USER");
        userRole=userRoleRepository.save(userRole);

        UserRoleEntity adminRole=new UserRoleEntity();
        adminRole.setName("ADMIN");
        adminRole=userRoleRepository.save(adminRole);

        UserEntity user=new UserEntity();
        user.setUsername("user");
        user.setPassword(passwordEncoder.encode("123456"));
        user.setRoles(Set.of(userRole));
        userRepository.save(user);

        UserEntity admin=new UserEntity();
        admin.setUsername("admin");
        admin.setPassword(passwordEncoder.encode("123456"));
        admin.setRoles(Set.of(userRole,adminRole));
        userRepository.save(admin);

    }
}
