package edu.miage.springboot.web.rest;

import edu.miage.springboot.dao.entities.Utilisateur;
import edu.miage.springboot.dao.repositories.UtilisateurRepository;
import edu.miage.springboot.security.JwtService;
import edu.miage.springboot.web.dtos.AuthRequestDTO;
import edu.miage.springboot.web.dtos.AuthResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.GrantedAuthority;


import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private UtilisateurRepository userRepository;

    @PostMapping("/login")
    public AuthResponseDTO AuthenticateAndGetToken(@RequestBody AuthRequestDTO authRequestDTO) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequestDTO.getUsername(), authRequestDTO.getPassword()));
        if (authentication.isAuthenticated()) {
            Utilisateur user = userRepository.findByUsername(authRequestDTO.getUsername());
            // Récupérer les rôles de l'utilisateur
            List<String> roles = authentication.getAuthorities().stream()
                    .map(GrantedAuthority::getAuthority)
                    .collect(Collectors.toList());

            // Générer le token avec les rôles
            String token = jwtService.generateToken(authRequestDTO.getUsername(),user.getId(), roles);
            return new AuthResponseDTO(token);
        } else {
            throw new UsernameNotFoundException("invalid user request..!!");
        }
    }
}

