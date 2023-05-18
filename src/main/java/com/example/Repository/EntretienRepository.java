/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.Repository;

import com.example.Model.Entretien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Carel Njanko
 */
@Repository
public interface EntretienRepository extends JpaRepository<Entretien, Integer>{
    @Query("SELECT e FROM Entretien e WHERE e.id = :id")
    public Entretien getById(@Param("id") int id);
}
