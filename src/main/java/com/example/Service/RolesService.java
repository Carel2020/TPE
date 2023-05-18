/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Service;

import com.example.Model.Roles;
import com.example.Repository.RolesRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Carel Njanko
 */
@Service
public class RolesService {
    @Autowired
    private RolesRepository rolesRepository;
    
    public void createRoles(Roles roles) {
        rolesRepository.save(roles);
    }

    public List<Roles> getAllRoles() {
        return rolesRepository.findAll();
    }

    public Roles getOneRoles(int id) {
        return rolesRepository.getById(id);
    }

    public void updateRoles(Roles roles) {
        if (rolesRepository.getById(roles.getId()) != null) {
            rolesRepository.save(roles);
        }
    }

    public void deleteRoles(int id) {
        rolesRepository.deleteById(id);
    }
}
