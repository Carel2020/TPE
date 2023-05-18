/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Controller;

import com.example.Model.Hebergeur;
import com.example.Service.HebergeurService;
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
@RequestMapping("Hebergeur")
public class HebergeurController {
    private final HebergeurService hebergeurService;

	@Autowired
	public HebergeurController(HebergeurService hebergeurService) {
		this.hebergeurService = hebergeurService;
	}

	@GetMapping("signup")
	public String showSignUpForm(Hebergeur hebergeur) {
		return "add-Hebergeur";
	}

	@GetMapping("list")
	public String showUpdateForm(Model model) {
		model.addAttribute("Hebergeur", hebergeurService.getAllHebergeur());
		return "index";
	}

	@PostMapping("add")
	public String addHebergeur(@Valid Hebergeur hebergeur, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "add-Hebergeur";
		}

		hebergeurService.createHebergeur(hebergeur);
		return "redirect:list";
	}

	@GetMapping("edit/{id}")
	public String showUpdateForm(@PathVariable("id") int id, Model model) {
		Hebergeur hebergeur;
        hebergeur = hebergeurService.getOneHebergeur(id);
                //.orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
		model.addAttribute("Hebergeur", hebergeur);
		return "update-Hebergeur";
	}

	@PostMapping("update/{id}")
	public String updateHebergeur(@PathVariable("id") int id, @Valid Hebergeur hebergeur, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			hebergeur.setId(id);
			return "update-Hebergeur";
		}

		hebergeurService.createHebergeur(hebergeur);
		model.addAttribute("Hebergeur", hebergeurService.getAllHebergeur());
		return "index";
	}

	@GetMapping("delete/{id}")
	public String deleteHebergeur(@PathVariable("id") int id, Model model) {
		Hebergeur hebergeur = hebergeurService.getOneHebergeur(id);
				//.orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
		hebergeurService.deleteHebergeur(0);
		model.addAttribute("Hebergeur", hebergeurService.getAllHebergeur());
		return "index";
	}
}
