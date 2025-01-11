package edu.miage.springboot.web.rest;

import edu.miage.springboot.dao.entities.CvEnLigne;
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

    @Autowired
    public CvEnLigneController(CvEnLigneService cvService) {
        this.cvService = cvService;
    }

    @PostMapping
    public ResponseEntity<CvEnLigne> createCv(@RequestBody CvEnLigne cv) {
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

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCv(@PathVariable Long id) {
        cvService.deleteCv(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
