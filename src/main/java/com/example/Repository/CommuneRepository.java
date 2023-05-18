/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.Repository;

import com.example.Model.Commune;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Carel Njanko
 */
@Repository
public interface CommuneRepository extends JpaRepository<Commune, Integer>{
    @Query("SELECT c FROM Commune c WHERE c.id = :id")
    public Commune getById(@Param("id") int id);
}
