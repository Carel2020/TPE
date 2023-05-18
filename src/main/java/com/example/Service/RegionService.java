/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Service;

import com.example.Model.Region;
import com.example.Repository.RegionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Carel Njanko
 */
@Service
public class RegionService {
    @Autowired
    private RegionRepository regionRepository;
    
    public void createRegion(Region region) {
        regionRepository.save(region);
    }

    public List<Region> getAllRegion() {
        return regionRepository.findAll();
    }

    public Region getOneRegion(int id) {
        return regionRepository.getById(id);
    }

    public void updateRegion(Region region) {
        if (regionRepository.getById(region.getId()) != null) {
            regionRepository.save(region);
        }
    }

    public void deleteRegion(int id) {
        regionRepository.deleteById(id);
    }
}
