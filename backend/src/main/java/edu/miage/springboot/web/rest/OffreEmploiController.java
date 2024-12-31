package edu.miage.springboot.web.rest;

import edu.miage.springboot.services.interfaces.OffreEmploiService;
import edu.miage.springboot.web.dtos.FolderDTO;
import edu.miage.springboot.web.dtos.OffreEmploiDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
