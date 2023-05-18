/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Service;

import com.example.Model.Deplace;
import com.example.Repository.DeplaceRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Carel Njanko
 */
@Service
public class DeplaceService {
    @Autowired
    private DeplaceRepository deplaceRepository;
    
    public void createDeplace(Deplace deplace) {
        deplaceRepository.save(deplace);
    }

    public List<Deplace> getAllDeplace() {
        return deplaceRepository.findAll();
    }

    public Deplace getOneDeplace(int id) {
        return deplaceRepository.getById(id);
    }

    public void updateDeplace(Deplace deplace) {
        if (deplaceRepository.getById(deplace.getId()) != null) {
            deplaceRepository.save(deplace);
        }
    }

    public void deleteDeplace(int id) {
        deplaceRepository.deleteById(id);
    }
}
