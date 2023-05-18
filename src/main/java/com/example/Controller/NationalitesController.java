/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Controller;

import com.example.Model.Nationalites;
import com.example.Service.NationalitesService;
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
@RequestMapping("Nationalites")
public class NationalitesController {
    private final NationalitesService nationalitesService;

	@Autowired
	public NationalitesController(NationalitesService nationalitesService) {
		this.nationalitesService = nationalitesService;
	}

	@GetMapping("signup")
	public String showSignUpForm(Nationalites nationalites) {
		return "add-Nationalites";
	}

	@GetMapping("list")
	public String showUpdateForm(Model model) {
		model.addAttribute("Nationalites", nationalitesService.getAllNationalites());
		return "index";
	}

	@PostMapping("add")
	public String addNationalites(@Valid Nationalites nationalites, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "add-Nationalites";
		}

		nationalitesService.createNationalites(nationalites);
		return "redirect:list";
	}

	@GetMapping("edit/{id}")
	public String showUpdateForm(@PathVariable("id") int id, Model model) {
		Nationalites nationalites;
        nationalites = nationalitesService.getOneNationalites(id);
                //.orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
		model.addAttribute("Nationalites", nationalites);
		return "update-Nationalites";
	}

	@PostMapping("update/{id}")
	public String updateNationalites(@PathVariable("id") int id, @Valid Nationalites nationalites, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			nationalites.setId(id);
			return "update-Nationalites";
		}

		nationalitesService.createNationalites(nationalites);
		model.addAttribute("Nationalites", nationalitesService.getAllNationalites());
		return "index";
	}

	@GetMapping("delete/{id}")
	public String deleteNationalites(@PathVariable("id") int id, Model model) {
		Nationalites nationalites = nationalitesService.getOneNationalites(id);
				//.orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
		nationalitesService.deleteNationalites(0);
		model.addAttribute("Nationalites", nationalitesService.getAllNationalites());
		return "index";
	}
}
