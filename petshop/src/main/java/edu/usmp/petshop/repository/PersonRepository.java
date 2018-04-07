package edu.usmp.petshop.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import edu.usmp.petshop.model.Person;
import java.lang.Integer;

public interface PersonRepository 
extends Repository<Person,Integer>
{

	void save(Person person);
	
	List<Person> findAll();
	
	Person findById(Integer id);
}
