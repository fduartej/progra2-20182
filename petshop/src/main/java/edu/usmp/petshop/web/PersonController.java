package edu.usmp.petshop.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	public String submitForm(@ModelAttribute Person person) {
		
		person.setPhone(person.getPhone() + 5);
		
		return "resultForm";
	}
}