/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Controller;

import com.example.Model.Deplace;
import com.example.Service.DeplaceService;
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
@RequestMapping("Deplace")
public class DeplaceController {
    private final DeplaceService deplaceService;

	@Autowired
	public DeplaceController(DeplaceService deplaceService) {
		this.deplaceService = deplaceService;
	}

	@GetMapping("signup")
	public String showSignUpForm(Deplace deplace) {
		return "add-Deplace";
	}

	@GetMapping("list")
	public String showUpdateForm(Model model) {
		model.addAttribute("Deplace", deplaceService.getAllDeplace());
		return "index";
	}

	@PostMapping("add")
	public String addDeplace(@Valid Deplace deplace, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "add-Deplace";
		}

		deplaceService.createDeplace(deplace);
		return "redirect:list";
	}

	@GetMapping("edit/{id}")
	public String showUpdateForm(@PathVariable("id") int id, Model model) {
		Deplace deplace;
        deplace = deplaceService.getOneDeplace(id);
                //.orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
		model.addAttribute("Deplace", deplace);
		return "update-Deplace";
	}

	@PostMapping("update/{id}")
	public String updateDeplace(@PathVariable("id") int id, @Valid Deplace deplace, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			deplace.setId(id);
			return "update-Deplace";
		}

		deplaceService.createDeplace(deplace);
		model.addAttribute("deplace", deplaceService.getAllDeplace());
		return "index";
	}

	@GetMapping("delete/{id}")
	public String deleteDeplace(@PathVariable("id") int id, Model model) {
		Deplace deplace = deplaceService.getOneDeplace(id);
				//.orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
		deplaceService.deleteDeplace(0);
		model.addAttribute("Deplace", deplaceService.getAllDeplace());
		return "index";
	}
}
