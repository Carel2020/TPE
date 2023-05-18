/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Service;

import com.example.Model.Rue;
import com.example.Repository.RueRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Carel Njanko
 */
@Service
public class RueService {
    @Autowired
    private RueRepository rueRepository;
    
    public void createRue(Rue rue) {
        rueRepository.save(rue);
    }

    public List<Rue> getAllRue() {
        return rueRepository.findAll();
    }

    public Rue getOneRue(int id) {
        return rueRepository.getById(id);
    }

    public void updateRue(Rue rue) {
        if (rueRepository.getById(rue.getId()) != null) {
            rueRepository.save(rue);
        }
    }

    public void deleteRue(int id) {
        rueRepository.deleteById(id);
    }
}
