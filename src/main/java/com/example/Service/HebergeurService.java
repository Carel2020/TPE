/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Service;

import com.example.Model.Hebergeur;
import com.example.Repository.HebergeurRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Carel Njanko
 */
@Service
public class HebergeurService {
    @Autowired
    private HebergeurRepository hebergeurRepository;
    
    public void createHebergeur(Hebergeur hebergeur) {
        hebergeurRepository.save(hebergeur);
    }

    public List<Hebergeur> getAllHebergeur() {
        return hebergeurRepository.findAll();
    }

    public Hebergeur getOneHebergeur(int id) {
        return hebergeurRepository.getById(id);
    }

    public void updateHebergeur(Hebergeur hebergeur) {
        if (hebergeurRepository.getById(hebergeur.getId()) != null) {
            hebergeurRepository.save(hebergeur);
        }
    }

    public void deleteHebergeur(int id) {
        hebergeurRepository.deleteById(id);
    }
}
