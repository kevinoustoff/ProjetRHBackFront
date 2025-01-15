package edu.miage.springboot.web.rest;

import edu.miage.springboot.dao.entities.*;
import edu.miage.springboot.dao.repositories.UtilisateurRepository;
import edu.miage.springboot.services.interfaces.CvEnLigneService;
import edu.miage.springboot.utils.mappers.CvEnLigneMapper;
import edu.miage.springboot.web.dtos.CvEnLigneDTO;
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
    private final CvEnLigneMapper cvEnLigneMapper;

    @Autowired
    public CvEnLigneController(CvEnLigneService cvService, UtilisateurRepository utilisateurRepository, CvEnLigneMapper cvEnLigneMapper) {
        this.cvService = cvService;
        this.utilisateurRepository = utilisateurRepository;
        this.cvEnLigneMapper = cvEnLigneMapper;
    }

    @PostMapping
    public ResponseEntity<CvEnLigneDTO> createCv(@RequestBody CvEnLigneDTO cvDto) {
        // Convertir le DTO en entité
        CvEnLigne cv = cvEnLigneMapper.dtoToEntity(cvDto);

        // Récupérer l'utilisateur par son ID
        Utilisateur user = utilisateurRepository.findById(cvDto.getUserId())
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));

        cv.setUser(user); // Associer l'utilisateur au CV
        if (cv.getCertifications() != null) {
            for (Certification certification : cv.getCertifications()) {
                certification.setCv(cv);
            }
        }
        if (cv.getCompetences() != null) {
            for (Competence competence : cv.getCompetences()) {
                competence.setCv(cv);
            }
        }
        if (cv.getLangues() != null) {
            for (Langue langue : cv.getLangues()) {
                langue.setCv(cv);
            }
        }
        if (cv.getExperiences() != null) {
            for (Experience experience : cv.getExperiences()) {
                experience.setCv(cv);
            }
        }
        if (cv.getFormations() != null) {
            for (Formation formation : cv.getFormations()) {
                formation.setCv(cv);
            }}

            CvEnLigne createdCv = cvService.createCv(cv);
            CvEnLigneDTO createdCvDto = cvEnLigneMapper.entityToDto(createdCv); // Convertir l'entité créée en DTO
            return new ResponseEntity<>(createdCvDto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CvEnLigneDTO> updateCv(@PathVariable Long id, @RequestBody CvEnLigneDTO cvDto) {
        CvEnLigne cv = cvEnLigneMapper.dtoToEntity(cvDto);
        Utilisateur user = utilisateurRepository.findById(cvDto.getUserId())
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));

        cv.setUser(user);
        if (cv.getCertifications() != null) {
            for (Certification certification : cv.getCertifications()) {
                certification.setCv(cv);
            }
        }
        if (cv.getCompetences() != null) {
            for (Competence competence : cv.getCompetences()) {
                competence.setCv(cv);
            }
        }
        if (cv.getLangues() != null) {
            for (Langue langue : cv.getLangues()) {
                langue.setCv(cv);
            }
        }
        if (cv.getExperiences() != null) {
            for (Experience experience : cv.getExperiences()) {
                experience.setCv(cv);
            }
        }
        if (cv.getFormations() != null) {
            for (Formation formation : cv.getFormations()) {
                formation.setCv(cv);
            }}
        CvEnLigne updatedCv = cvService.updateCv(id, cv);
        CvEnLigneDTO updatedCvDto = cvEnLigneMapper.entityToDto(updatedCv);
        return new ResponseEntity<>(updatedCvDto, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CvEnLigneDTO> getCvById(@PathVariable Long id) {
        CvEnLigne cv = cvService.getCvById(id);
        CvEnLigneDTO cvDTO = cvEnLigneMapper.entityToDto(cv); // Convertir l'entité en DTO
        return new ResponseEntity<>(cvDTO, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CvEnLigneDTO>> getAllCvs() {
        List<CvEnLigne> cvs = cvService.getAllCvs();
        List<CvEnLigneDTO> cvDtos = cvEnLigneMapper.entitiesToDtos(cvs); // Convertir la liste d'entités en liste de DTOs
        return new ResponseEntity<>(cvDtos, HttpStatus.OK);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<CvEnLigneDTO> getCvByUserId(@PathVariable Long id) {
        CvEnLigne cv = cvService.getCvByUserId(id);
        CvEnLigneDTO cvDTO = cvEnLigneMapper.entityToDto(cv); // Convertir l'entité en DTO
        return new ResponseEntity<>(cvDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCv(@PathVariable Long id) {
        cvService.deleteCv(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
