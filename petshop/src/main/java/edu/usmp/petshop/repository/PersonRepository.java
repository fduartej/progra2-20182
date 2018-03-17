package edu.usmp.petshop.repository;

import org.springframework.data.repository.Repository;

import edu.usmp.petshop.model.Person;

public interface PersonRepository 
extends Repository<Person,Integer>
{

	void save(Person person);
}
