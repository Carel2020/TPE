/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Service;

import com.example.Model.Personnel;
import com.example.Repository.PersonnelRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Carel Njanko
 */
@Service
public class PersonnelService {
    @Autowired
    private PersonnelRepository personnelRepository;
    
    public void createPersonnel(Personnel personnel) {
        personnelRepository.save(personnel);
    }

    public List<Personnel> getAllPersonnel() {
        return personnelRepository.findAll();
    }

    public Personnel getOnePersonnel(int id) {
        return personnelRepository.getById(id);
    }

    public void updatePersonnel(Personnel personnel) {
        if (personnelRepository.getById(personnel.getId()) != null) {
            personnelRepository.save(personnel);
        }
    }

    public void deletePersonnel(int id) {
        personnelRepository.deleteById(id);
    }
}
