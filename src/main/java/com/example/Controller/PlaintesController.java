/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Controller;

import com.example.Model.Plaintes;
import com.example.Service.PlaintesService;
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
@RequestMapping("Plaintes")
public class PlaintesController {
    private final PlaintesService plaintesService;

	@Autowired
	public PlaintesController(PlaintesService plaintesService) {
		this.plaintesService = plaintesService;
	}

	@GetMapping("signup")
	public String showSignUpForm(Plaintes plaintes) {
		return "add-Plaintes";
	}

	@GetMapping("list")
	public String showUpdateForm(Model model) {
		model.addAttribute("Plaintes", plaintesService.getAllPlaintes());
		return "index";
	}

	@PostMapping("add")
	public String addPlaintes(@Valid Plaintes plaintes, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "add-Plaintes";
		}

		plaintesService.createPlaintes(plaintes);
		return "redirect:list";
	}

	@GetMapping("edit/{id}")
	public String showUpdateForm(@PathVariable("id") int id, Model model) {
		Plaintes plaintes;
        plaintes = plaintesService.getOnePlaintes(id);
                //.orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
		model.addAttribute("Plaintes", plaintes);
		return "update-Plaintes";
	}

	@PostMapping("update/{id}")
	public String updatePlaintes(@PathVariable("id") int id, @Valid Plaintes plaintes, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			plaintes.setId(id);
			return "update-Plaintes";
		}

		plaintesService.createPlaintes(plaintes);
		model.addAttribute("Plaintes", plaintesService.getAllPlaintes());
		return "index";
	}

	@GetMapping("delete/{id}")
	public String deletePlaintes(@PathVariable("id") int id, Model model) {
		Plaintes plaintes = plaintesService.getOnePlaintes(id);
				//.orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
		plaintesService.deletePlaintes(0);
		model.addAttribute("Plaintes", plaintesService.getAllPlaintes());
		return "index";
	}
}
