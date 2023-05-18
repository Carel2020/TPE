/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Controller;

import com.example.Model.Personnel;
import com.example.Service.PersonnelService;
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
@RequestMapping("/Personnel/")
public class PersonnelController {
    private final PersonnelService personnelService;

	@Autowired
	public PersonnelController(PersonnelService personnelService) {
		this.personnelService = personnelService;
	}

	@GetMapping("signup")
	public String showSignUpForm(Personnel personnel) {
		return "add-Personnel";
	}

	@GetMapping("list")
	public String showUpdateForm(Model model) {
		model.addAttribute("Personnel", personnelService.getAllPersonnel());
		return "index";
	}

	@PostMapping("add")
	public String addPersonnel(@Valid Personnel personnel, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "add-Personnel";
		}

		personnelService.createPersonnel(personnel);
		return "redirect:list";
	}

	@GetMapping("edit/{id}")
	public String showUpdateForm(@PathVariable("id") int id, Model model) {
		Personnel personnel;
        personnel = personnelService.getOnePersonnel(id);
                //.orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
		model.addAttribute("Personnel", personnel);
		return "update-Personnel";
	}

	@PostMapping("update/{id}")
	public String updatePersonnel(@PathVariable("id") int id, @Valid Personnel personnel, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			personnel.setId(id);
			return "update-Personnel";
		}

		personnelService.createPersonnel(personnel);
		model.addAttribute("Personnel", personnelService.getAllPersonnel());
		return "index";
	}

	@GetMapping("delete/{id}")
	public String deletePersonnel(@PathVariable("id") int id, Model model) {
		Personnel personnel = personnelService.getOnePersonnel(id);
				//.orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
		personnelService.deletePersonnel(0);
		model.addAttribute("Personnel", personnelService.getAllPersonnel());
		return "index";
	}
}
