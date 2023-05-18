/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Controller;

import com.example.Model.Hebergement;
import com.example.Service.HebergementService;
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
@RequestMapping("Hebergement")
public class HebergementController {
    private final HebergementService hebergementService;

	@Autowired
	public HebergementController(HebergementService hebergementService) {
		this.hebergementService = hebergementService;
	}

	@GetMapping("signup")
	public String showSignUpForm(Hebergement hebergement) {
		return "add-Hebergement";
	}

	@GetMapping("list")
	public String showUpdateForm(Model model) {
		model.addAttribute("Hebergement", hebergementService.getAllHebergement());
		return "index";
	}

	@PostMapping("add")
	public String addHebergement(@Valid Hebergement hebergement, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "add-Hebergement";
		}

		hebergementService.createHebergement(hebergement);
		return "redirect:list";
	}

	@GetMapping("edit/{id}")
	public String showUpdateForm(@PathVariable("id") int id, Model model) {
		Hebergement hebergement;
        hebergement = hebergementService.getOneHebergement(id);
                //.orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
		model.addAttribute("Hebergement", hebergement);
		return "update-Hebergement";
	}

	@PostMapping("update/{id}")
	public String updateHebergement(@PathVariable("id") int id, @Valid Hebergement hebergement, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			hebergement.setId(id);
			return "update-Hebergement";
		}

		hebergementService.createHebergement(hebergement);
		model.addAttribute("hebergement", hebergementService.getAllHebergement());
		return "index";
	}

	@GetMapping("delete/{id}")
	public String deleteHebergement(@PathVariable("id") int id, Model model) {
		Hebergement hebergement = hebergementService.getOneHebergement(id);
				//.orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
		hebergementService.deleteHebergement(0);
		model.addAttribute("Hebergement", hebergementService.getAllHebergement());
		return "index";
	}
}
