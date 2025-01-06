package edu.miage.springboot.web.rest;

import edu.miage.springboot.dao.entities.Role;
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

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtService jwtService;

    @PostMapping("/login")
    public AuthResponseDTO AuthenticateAndGetToken(@RequestBody AuthRequestDTO authRequestDTO) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequestDTO.getUsername(), authRequestDTO.getPassword()));
        if (authentication.isAuthenticated()) {
            Set<Role> roles = authentication.getAuthorities().stream()
                    .map(authority -> new Role(authority.getAuthority())) // Créez une instance de Role avec le nom de l'autorité
                    .collect(Collectors.toSet());
            return new AuthResponseDTO(jwtService.GenerateToken(authRequestDTO.getUsername()),authRequestDTO.getUsername(),roles);
        } else {
            throw new UsernameNotFoundException("invalid user request..!!");
        }
    }
}
