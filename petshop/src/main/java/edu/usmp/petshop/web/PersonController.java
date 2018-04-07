package edu.usmp.petshop.web;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import edu.usmp.petshop.model.Person;
import edu.usmp.petshop.repository.PersonRepository;

@Controller
public class PersonController {
	
	@Autowired
	private PersonRepository personRepository;

	@GetMapping("/person/new")
	public String initCreationForm(Model model) {
		model.addAttribute("person", new Person());
		return "personForm";
	}
	
	@PostMapping("/person/new")
	public String submitForm(@Valid Person person,
			BindingResult bindingResult) {
		if(bindingResult.hasFieldErrors()) {
			return "personForm";
		}
		person.setPhone(person.getPhone() + 5);
		personRepository.save(person);
		return "resultForm";
	}
	
	@GetMapping("/person/list")
	public String list(Map<String, Object> model) {
		List<Person> persons =personRepository.findAll();
		model.put("persons", persons);
		return "listPerson";
	}
	
	@GetMapping("/person/{personId}/edit")
	public String edit(@PathVariable("personId") int personId, 
			Model model){
		Person person =personRepository.findById(personId);
		model.addAttribute(person);
		return "editPerson";
	}
	
	@PostMapping("/person/{personId}/edit")
	public String update(
			@Valid Person person,
			BindingResult bindingResult,
			@PathVariable("personId") int personId){
		if(bindingResult.hasFieldErrors()) {
			return "redirect:/person/{personId}/edit";
		}
		person.setId(personId);
		personRepository.save(person);
		return "redirect:/person/list";
	}
	
}