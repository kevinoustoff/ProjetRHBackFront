package edu.miage.springboot.web.rest;

import edu.miage.springboot.dao.entities.Candidature;
import edu.miage.springboot.services.interfaces.CandidatureService;
import edu.miage.springboot.web.dtos.CandidatureDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/candidatures")
public class CandidatureController {
    @Autowired
    private CandidatureService candidatureService;

    @GetMapping
    public ResponseEntity<List<CandidatureDTO>> getAllCandidatures() {
        return ResponseEntity.ok(candidatureService.getAll());
    }

    @PostMapping
    public ResponseEntity<CandidatureDTO> addCandidature(@RequestBody  CandidatureDTO candidatureDTO) {
        return  ResponseEntity.ok(candidatureService.save(candidatureDTO));
    }

    @GetMapping("/by-offres/{id}")
    public ResponseEntity<List<CandidatureDTO>>getCandidaturesByOffreId(@PathVariable("id") Long id) {
        List<CandidatureDTO> candidatures = candidatureService.getCandidaturesByOffre(id);
        System.err.println("Candidatures trouvées : " + candidatures.size());
        return ResponseEntity.ok(candidatureService.getCandidaturesByOffre(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CandidatureDTO> getCandidatureById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(candidatureService.getById(id)
                .orElseThrow(()->new EntityNotFoundException()));

    }




}
