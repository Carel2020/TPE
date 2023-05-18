/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Service;

import com.example.Model.Nationalites;
import com.example.Repository.NationalitesRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Carel Njanko
 */
@Service
public class NationalitesService {
    @Autowired
    private NationalitesRepository nationalitesRepository;
    
    public void createNationalites(Nationalites nationalites) {
        nationalitesRepository.save(nationalites);
    }

    public List<Nationalites> getAllNationalites() {
        return nationalitesRepository.findAll();
    }

    public Nationalites getOneNationalites(int id) {
        return nationalitesRepository.getById(id);
    }

    public void updateNationalites(Nationalites nationalites) {
        if (nationalitesRepository.getById(nationalites.getId()) != null) {
            nationalitesRepository.save(nationalites);
        }
    }

    public void deleteNationalites(int id) {
        nationalitesRepository.deleteById(id);
    }
}
