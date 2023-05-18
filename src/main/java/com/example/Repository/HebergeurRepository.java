/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.Repository;

import com.example.Model.Hebergeur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Carel Njanko
 */
@Repository
public interface HebergeurRepository extends JpaRepository<Hebergeur, Integer>{
    @Query("SELECT h FROM Hebergeur h WHERE h.id = :id")
    public Hebergeur getById(@Param("id") int id);
}
