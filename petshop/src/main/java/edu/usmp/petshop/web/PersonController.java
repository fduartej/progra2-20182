package edu.usmp.petshop.web;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import edu.usmp.petshop.model.Person;

@Controller
public class PersonController {

	@GetMapping("/new")
	public String initCreationForm(Model model) {
		model.addAttribute("person", new Person());
		return "personForm";
	}
	
	@PostMapping("/new")
	public String submitForm(@Valid Person person,
			BindingResult bindingResult) {
		if(bindingResult.hasFieldErrors()) {
			return "personForm";
		}
		person.setPhone(person.getPhone() + 5);
		return "resultForm";
	}
}