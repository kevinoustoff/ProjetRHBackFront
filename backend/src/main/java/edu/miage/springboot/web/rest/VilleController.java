package edu.miage.springboot.web.rest;

import edu.miage.springboot.dao.entities.Ville;
import edu.miage.springboot.services.interfaces.VilleService;
import edu.miage.springboot.web.dtos.VilleDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/villes")
public class VilleController {
    private final VilleService villeService;

    public VilleController(VilleService villeService) {
        this.villeService = villeService;
    }
    @GetMapping
    public ResponseEntity<List<VilleDTO>> getAllVilles() {
        return ResponseEntity.ok(villeService.getAll());
    }
    @PostMapping
    public ResponseEntity<VilleDTO> createVille(@RequestBody VilleDTO villeDTO) {
        return ResponseEntity.ok(villeService.save(villeDTO));
    }
    @GetMapping("/{id}")
    public ResponseEntity<VilleDTO> getVilleById(@PathVariable("id") Long id) {
        return villeService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVille(@PathVariable Long id) {
        villeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
