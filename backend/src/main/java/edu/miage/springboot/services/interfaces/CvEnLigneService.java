package edu.miage.springboot.services.interfaces;

import edu.miage.springboot.dao.entities.CvEnLigne;

import java.util.List;

public interface CvEnLigneService {
    CvEnLigne createCv(CvEnLigne cv);
    CvEnLigne updateCv(Long id, CvEnLigne cv);
    CvEnLigne getCvById(Long id);
    List<CvEnLigne> getAllCvs();
    void deleteCv(Long id);
}
