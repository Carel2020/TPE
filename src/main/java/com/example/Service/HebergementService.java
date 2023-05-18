/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Service;

import com.example.Model.Hebergement;
import com.example.Repository.HebergementRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Carel Njanko
 */
@Service
public class HebergementService {
    @Autowired
    private HebergementRepository hebergementRepository;
    
    public void createHebergement(Hebergement hebergement) {
        hebergementRepository.save(hebergement);
    }

    public List<Hebergement> getAllHebergement() {
        return hebergementRepository.findAll();
    }

    public Hebergement getOneHebergement(int id) {
        return hebergementRepository.getById(id);
    }

    public void updateHebergement(Hebergement hebergement) {
        if (hebergementRepository.getById(hebergement.getId()) != null) {
            hebergementRepository.save(hebergement);
        }
    }

    public void deleteHebergement(int id) {
        hebergementRepository.deleteById(id);
    }
}
