/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.Repository;

import com.example.Model.Personnel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Carel Njanko
 */
@Repository
public interface PersonnelRepository extends JpaRepository<Personnel, Integer>{
    @Query("SELECT p FROM Personnel p WHERE p.id = :id")
    public Personnel getById(@Param("id") int id);
}
