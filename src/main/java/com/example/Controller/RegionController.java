/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Controller;

import com.example.Model.Region;
import com.example.Service.RegionService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Carel Njanko
 */
@RestController
@RequestMapping("Region")
public class RegionController {
    private final RegionService regionService;

	@Autowired
	public RegionController(RegionService regionService) {
		this.regionService = regionService;
	}

	@GetMapping("signup")
	public String showSignUpForm(Region region) {
		return "add-Region";
	}

	@GetMapping("list")
	public String showUpdateForm(Model model) {
		model.addAttribute("Region", regionService.getAllRegion());
		return "index";
	}

	@PostMapping("add")
	public String addRegion(@Valid Region region, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "add-Region";
		}

		regionService.createRegion(region);
		return "redirect:list";
	}

	@GetMapping("edit/{id}")
	public String showUpdateForm(@PathVariable("id") int id, Model model) {
		Region region;
        region = regionService.getOneRegion(id);
                //.orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
		model.addAttribute("Region", region);
		return "update-Region";
	}

	@PostMapping("update/{id}")
	public String updateRegion(@PathVariable("id") int id, @Valid Region region, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			region.setId(id);
			return "update-Region";
		}

		regionService.createRegion(region);
		model.addAttribute("Region", regionService.getAllRegion());
		return "index";
	}

	@GetMapping("delete/{id}")
	public String deleteRegion(@PathVariable("id") int id, Model model) {
		Region region = regionService.getOneRegion(id);
				//.orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
		regionService.deleteRegion(0);
		model.addAttribute("Region", regionService.getAllRegion());
		return "index";
	}
}
