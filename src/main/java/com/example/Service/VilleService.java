/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Service;

import com.example.Model.Ville;
import com.example.Repository.VilleRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Carel Njanko
 */
@Service
public class VilleService {
    @Autowired
    private VilleRepository villeRepository;
    
    public void createVille(Ville ville) {
        villeRepository.save(ville);
    }

    public List<Ville> getAllVille() {
        return villeRepository.findAll();
    }

    public Ville getOneVille(int id) {
        return villeRepository.getById(id);
    }

    public void updateVille(Ville ville) {
        if (villeRepository.getById(ville.getId()) != null) {
            villeRepository.save(ville);
        }
    }

    public void deleteVille(int id) {
        villeRepository.deleteById(id);
    }
}
