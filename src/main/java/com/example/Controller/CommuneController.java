/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Controller;

import com.example.Model.Commune;
import com.example.Service.CommuneService;
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
@RequestMapping(value = "/Commune")
public class CommuneController {
    private final CommuneService communeService;

	@Autowired
	public CommuneController(CommuneService communeService) {
		this.communeService = communeService;
	}

	@GetMapping("signup")
	public String showSignUpForm(Commune commune) {
		return "add-commune";
	}

	@GetMapping("list")
	public String showUpdateForm(Model model) {
		model.addAttribute("commune", communeService.getAllCommune());
		return "index";
	}

	@PostMapping("add")
	public String addCommune(@Valid Commune commune, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "add-commune";
		}

		communeService.createCommune(commune);
		return "redirect:list";
	}

	@GetMapping("edit/{id}")
	public String showUpdateForm(@PathVariable("id") int id, Model model) {
		Commune commune;
        commune = communeService.getOneCommune(id);
                //.orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
		model.addAttribute("commune", commune);
		return "update-commune";
	}

	@PostMapping("update/{id}")
	public String updateCommune(@PathVariable("id") int id, @Valid Commune commune, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			commune.setId(id);
			return "update-commune";
		}

		communeService.createCommune(commune);
		model.addAttribute("commune", communeService.getAllCommune());
		return "index";
	}

	@GetMapping("delete/{id}")
	public String deleteCommune(@PathVariable("id") int id, Model model) {
		Commune commune = communeService.getOneCommune(id);
				//.orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
		communeService.deleteCommune(0);
		model.addAttribute("commune", communeService.getAllCommune());
		return "index";
	}
}
