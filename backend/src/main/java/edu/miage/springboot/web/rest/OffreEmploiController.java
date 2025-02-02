package edu.miage.springboot.web.rest;

import edu.miage.springboot.services.interfaces.OffreEmploiService;
import edu.miage.springboot.web.dtos.FolderDTO;
import edu.miage.springboot.web.dtos.OffreEmploiDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/offres")
public class OffreEmploiController {
   private OffreEmploiService offreEmploiService;

   public OffreEmploiController(OffreEmploiService offreEmploiService) {
       this.offreEmploiService = offreEmploiService;
   }
    @GetMapping
    public ResponseEntity<List<OffreEmploiDTO>> getAll() {
        return ResponseEntity.ok(offreEmploiService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OffreEmploiDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(offreEmploiService.getById(id).orElseThrow(()->new EntityNotFoundException()));
    }

    @PostMapping
    public ResponseEntity<OffreEmploiDTO> createOffre(@RequestBody OffreEmploiDTO offreEmploiDTO) {
        OffreEmploiDTO createdOffre = offreEmploiService.save(offreEmploiDTO);
        return ResponseEntity.ok(createdOffre);
    }


}
