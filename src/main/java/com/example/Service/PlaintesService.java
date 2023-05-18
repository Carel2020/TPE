/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Service;

import com.example.Model.Plaintes;
import com.example.Repository.PlaintesRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Carel Njanko
 */
@Service
public class PlaintesService {
    @Autowired
    private PlaintesRepository plaintesRepository;
    
    public void createPlaintes(Plaintes plaintes) {
        plaintesRepository.save(plaintes);
    }

    public List<Plaintes> getAllPlaintes() {
        return plaintesRepository.findAll();
    }

    public Plaintes getOnePlaintes(int id) {
        return plaintesRepository.getById(id);
    }

    public void updatePlaintes(Plaintes plaintes) {
        if (plaintesRepository.getById(plaintes.getId()) != null) {
            plaintesRepository.save(plaintes);
        }
    }

    public void deletePlaintes(int id) {
        plaintesRepository.deleteById(id);
    }
}
