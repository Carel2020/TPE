/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Controller;

import com.example.Model.Rue;
import com.example.Service.RueService;
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
@RequestMapping("Rue")
public class RueController {
    private final RueService rueService;

	@Autowired
	public RueController(RueService rueService) {
		this.rueService = rueService;
	}

	@GetMapping("signup")
	public String showSignUpForm(Rue rue) {
		return "add-Rue";
	}

	@GetMapping("list")
	public String showUpdateForm(Model model) {
		model.addAttribute("Rue", rueService.getAllRue());
		return "index";
	}

	@PostMapping("add")
	public String addRue(@Valid Rue rue, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "add-Rue";
		}

		rueService.createRue(rue);
		return "redirect:list";
	}

	@GetMapping("edit/{id}")
	public String showUpdateForm(@PathVariable("id") int id, Model model) {
		Rue rue;
        rue = rueService.getOneRue(id);
                //.orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
		model.addAttribute("Rue", rue);
		return "update-Rue";
	}

	@PostMapping("update/{id}")
	public String updateRue(@PathVariable("id") int id, @Valid Rue rue, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			rue.setId(id);
			return "update-Rue";
		}

		rueService.createRue(rue);
		model.addAttribute("Rue", rueService.getAllRue());
		return "index";
	}

	@GetMapping("delete/{id}")
	public String deleteRue(@PathVariable("id") int id, Model model) {
		Rue rue = rueService.getOneRue(id);
				//.orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
		rueService.deleteRue(0);
		model.addAttribute("Rue", rueService.getAllRue());
		return "index";
	}
}
