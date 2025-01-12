package edu.miage.springboot.web.rest;

import edu.miage.springboot.dao.entities.*;
import edu.miage.springboot.dao.repositories.UtilisateurRepository;
import edu.miage.springboot.services.interfaces.CvEnLigneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cvsenligne")
public class CvEnLigneController {
    private final CvEnLigneService cvService;
    private final UtilisateurRepository utilisateurRepository;

    @Autowired
    public CvEnLigneController(CvEnLigneService cvService, UtilisateurRepository utilisateurRepository) {
        this.cvService = cvService;
        this.utilisateurRepository = utilisateurRepository;
    }

    @PostMapping
    public ResponseEntity<CvEnLigne> createCv(@RequestBody CvEnLigne cv) {
        // Récupérer l'utilisateur par son ID
        Utilisateur user = utilisateurRepository.findById(cv.getUser().getId())
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));
        // Associer l'utilisateur au CV
        // Associer chaque certification au CV
        if (cv.getCertifications() != null) {
            for (Certification certification : cv.getCertifications()) {
                certification.setCv(cv);
            }
        }

        if (cv.getCompetences() != null)
        {
            for (Competence competence : cv.getCompetences()) {
                competence.setCv(cv);
            }
        }

        if (cv.getLangues() != null)
        {
            for (Langue langue : cv.getLangues()) {
                langue.setCv(cv);
            }
        }

        if (cv.getExperiences() != null)
        {
            for (Experience experience : cv.getExperiences()) {
                experience.setCv(cv);
            }
        }

        if (cv.getFormations() != null)
        {
            for (Formation formation : cv.getFormations()) {
                formation.setCv(cv);
            }
        }
        cv.setUser(user);
        CvEnLigne createdCv = cvService.createCv(cv);
        return new ResponseEntity<>(createdCv, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CvEnLigne> updateCv(@PathVariable Long id, @RequestBody CvEnLigne cv) {
        CvEnLigne updatedCv = cvService.updateCv(id, cv);
        return new ResponseEntity<>(updatedCv, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CvEnLigne> getCvById(@PathVariable Long id) {
        CvEnLigne cv = cvService.getCvById(id);
        return new ResponseEntity<>(cv, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CvEnLigne>> getAllCvs() {
        List<CvEnLigne> cvs = cvService.getAllCvs();
        return new ResponseEntity<>(cvs, HttpStatus.OK);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<CvEnLigne> getCvByUserId(@PathVariable Long id) {
        CvEnLigne cv = cvService.getCvByUserId(id);
        return new ResponseEntity<>(cv, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCv(@PathVariable Long id) {
        cvService.deleteCv(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
