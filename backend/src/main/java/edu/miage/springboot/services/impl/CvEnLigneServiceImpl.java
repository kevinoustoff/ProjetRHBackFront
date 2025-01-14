package edu.miage.springboot.services.impl;

import edu.miage.springboot.dao.entities.CvEnLigne;
import edu.miage.springboot.dao.repositories.CvEnLigneRepository;
import edu.miage.springboot.services.interfaces.CvEnLigneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CvEnLigneServiceImpl implements CvEnLigneService {

    private final CvEnLigneRepository cvRepository;

    @Autowired
    public CvEnLigneServiceImpl(CvEnLigneRepository cvRepository) {
        this.cvRepository = cvRepository;
    }

    @Override
    public CvEnLigne createCv(CvEnLigne cv) {
        return cvRepository.save(cv);
    }

    @Override
    public CvEnLigne updateCv(Long id, CvEnLigne cv) {
        Optional<CvEnLigne> existingCv = cvRepository.findById(id);
        if (existingCv.isPresent()) {
            cv.setId(id); // Assurez-vous que l'ID reste le même
            return cvRepository.save(cv);
        } else {
            throw new RuntimeException("CV not found with id " + id);
        }
    }

    @Override
    public CvEnLigne getCvById(Long id) {
        return cvRepository.findById(id).orElseThrow(() -> new RuntimeException("CV not found with id " + id));
    }

    @Override
    public List<CvEnLigne> getAllCvs() {
        return cvRepository.findAll();
    }

    @Override
    public CvEnLigne getCvByUserId(Long id) {
        return cvRepository.findByUserId(id).orElseThrow(() -> new RuntimeException("CV non trouvé pour l'utilisateur avec l'ID " + id));
    }

    @Override
    public void deleteCv(Long id) {
        cvRepository.deleteById(id);
    }
}
