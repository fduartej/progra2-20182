package edu.usmp.petshop.repository;

import java.util.List;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.Repository;

import edu.usmp.petshop.model.Contact;

public interface ContactRepository 
extends Repository<Contact,Integer>
{

	@CacheEvict(value="contact",allEntries=true)
	Contact save(Contact person);
	
	@Cacheable(value="contact")
	List<Contact> findAll();
	
	Contact findById(Integer id);
	
	void delete(Contact person);
}
