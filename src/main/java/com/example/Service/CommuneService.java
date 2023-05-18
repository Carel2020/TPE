/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Service;

import com.example.Model.Commune;
import com.example.Repository.CommuneRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Carel Njanko
 */
@Service
public class CommuneService {
    @Autowired
    private CommuneRepository communeRepository;
    
    public void createCommune(Commune commune) {
        communeRepository.save(commune);
    }

    public List<Commune> getAllCommune() {
        return communeRepository.findAll();
    }

    public Commune getOneCommune(int id) {
        return communeRepository.getById(id);
    }

    public void updateCommune(Commune commune) {
        if (communeRepository.getById(commune.getId()) != null) {
            communeRepository.save(commune);
        }
    }

    public void deleteCommune(int id) {
        communeRepository.deleteById(id);
    }
    
}
