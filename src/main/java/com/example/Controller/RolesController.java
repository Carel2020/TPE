/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Controller;

import com.example.Model.Roles;
import com.example.Service.RolesService;
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
@RequestMapping("Roles")
public class RolesController {
    private final RolesService rolesService;

	@Autowired
	public RolesController(RolesService rolesService) {
		this.rolesService = rolesService;
	}

	@GetMapping("signup")
	public String showSignUpForm(Roles roles) {
		return "add-Roles";
	}

	@GetMapping("list")
	public String showUpdateForm(Model model) {
		model.addAttribute("Roles", rolesService.getAllRoles());
		return "index";
	}

	@PostMapping("add")
	public String addRoles(@Valid Roles roles, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "add-Roles";
		}

		rolesService.createRoles(roles);
		return "redirect:list";
	}

	@GetMapping("edit/{id}")
	public String showUpdateForm(@PathVariable("id") int id, Model model) {
		Roles roles;
        roles = rolesService.getOneRoles(id);
                //.orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
		model.addAttribute("Roles", roles);
		return "update-Roles";
	}

	@PostMapping("update/{id}")
	public String updateRoles(@PathVariable("id") int id, @Valid Roles roles, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			roles.setId(id);
			return "update-Roles";
		}

		rolesService.createRoles(roles);
		model.addAttribute("Roles", rolesService.getAllRoles());
		return "index";
	}

	@GetMapping("delete/{id}")
	public String deleteRoles(@PathVariable("id") int id, Model model) {
		Roles roles = rolesService.getOneRoles(id);
				//.orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
		rolesService.deleteRoles(0);
		model.addAttribute("Roles", rolesService.getAllRoles());
		return "index";
	}
}
