package edu.usmp.petshop.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import edu.usmp.petshop.repository.ContactRepository;
import edu.usmp.petshop.model.Contact;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class ContactController {
	
	@Autowired
	private ContactRepository contactRepository;
	
    @GetMapping("/contacts")
    public List<Contact> getAllTodos() {
        return contactRepository.findAll();
    }

    @PostMapping("/contacts")
    public Contact create(@Valid @RequestBody Contact contact) {
        return contactRepository.save(contact);
    }

}
