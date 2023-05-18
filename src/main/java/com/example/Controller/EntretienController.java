/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Controller;

import com.example.Model.Entretien;
import com.example.Service.EntretienService;
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
@RequestMapping("Entretien")
public class EntretienController {
    private final EntretienService entretienService;
    
    @Autowired
	public EntretienController(EntretienService entretienService) {
		this.entretienService = entretienService;
	}

	@GetMapping("signup")
	public String showSignUpForm(Entretien entretien) {
		return "add-Entretien";
	}

	@GetMapping("list")
	public String showUpdateForm(Model model) {
		model.addAttribute("Entretien", entretienService.getAllEntretien());
		return "index";
	}

	@PostMapping("add")
	public String addEntretien(@Valid Entretien entretien, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "add-Entretien";
		}

		entretienService.createEntretien(entretien);
		return "redirect:list";
	}

	@GetMapping("edit/{id}")
	public String showUpdateForm(@PathVariable("id") int id, Model model) {
		Entretien entretien;
        entretien = entretienService.getOneEntretien(id);
                //.orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
		model.addAttribute("Entretien", entretien);
		return "update-Entretien";
	}

	@PostMapping("update/{id}")
	public String updateEntretien(@PathVariable("id") int id, @Valid Entretien entretien, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			entretien.setId(id);
			return "update-Entretien";
		}

		entretienService.createEntretien(entretien);
		model.addAttribute("entretien", entretienService.getAllEntretien());
		return "index";
	}

	@GetMapping("delete/{id}")
	public String deleteEntretien(@PathVariable("id") int id, Model model) {
		Entretien entretien = entretienService.getOneEntretien(id);
				//.orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
		entretienService.deleteEntretien(0);
		model.addAttribute("Entretien", entretienService.getAllEntretien());
		return "index";
	}
}
