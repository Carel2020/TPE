/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Controller;

import com.example.Model.Ville;
import com.example.Service.VilleService;
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
@RequestMapping("Ville")
public class VilleController {
    private final VilleService villeService;

	@Autowired
	public VilleController(VilleService villeService) {
		this.villeService = villeService;
	}

	@GetMapping("signup")
	public String showSignUpForm(Ville ville) {
		return "add-Ville";
	}

	@GetMapping("list")
	public String showUpdateForm(Model model) {
		model.addAttribute("Ville", villeService.getAllVille());
		return "index";
	}

	@PostMapping("add")
	public String addVille(@Valid Ville ville, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "add-Ville";
		}

		villeService.createVille(ville);
		return "redirect:list";
	}

	@GetMapping("edit/{id}")
	public String showUpdateForm(@PathVariable("id") int id, Model model) {
		Ville ville;
        ville = villeService.getOneVille(id);
                //.orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
		model.addAttribute("Ville", ville);
		return "update-Ville";
	}

	@PostMapping("update/{id}")
	public String updateVille(@PathVariable("id") int id, @Valid Ville ville, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			ville.setId(id);
			return "update-Ville";
		}

		villeService.createVille(ville);
		model.addAttribute("Ville", villeService.getAllVille());
		return "index";
	}

	@GetMapping("delete/{id}")
	public String deleteVille(@PathVariable("id") int id, Model model) {
		Ville ville = villeService.getOneVille(id);
				//.orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
		villeService.deleteVille(0);
		model.addAttribute("Ville", villeService.getAllVille());
		return "index";
	}
}
