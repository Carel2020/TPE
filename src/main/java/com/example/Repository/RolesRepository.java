/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.Repository;

import com.example.Model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Carel Njanko
 */
@Repository
public interface RolesRepository extends JpaRepository<Roles, Integer>{
    @Query("SELECT r FROM Roles r WHERE r.id = :id")
    public Roles getById(@Param("id") int id);
}
