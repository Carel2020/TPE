/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Service;

import com.example.Model.Entretien;
import com.example.Repository.EntretienRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Carel Njanko
 */
@Service
public class EntretienService {
    @Autowired
    private EntretienRepository entretienRepository;
    
    public void createEntretien(Entretien entretien) {
        entretienRepository.save(entretien);
    }

    public List<Entretien> getAllEntretien() {
        return entretienRepository.findAll();
    }

    public Entretien getOneEntretien(int id) {
        return entretienRepository.getById(id);
    }

    public void updateEntretien(Entretien entretien) {
        if (entretienRepository.getById(entretien.getId()) != null) {
            entretienRepository.save(entretien);
        }
    }

    public void deleteEntretien(int id) {
        entretienRepository.deleteById(id);
    }
}
