package edu.usmp.petshop.repository;

import java.util.List;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.Repository;

import edu.usmp.petshop.model.Person;
import java.lang.Integer;

public interface PersonRepository 
extends Repository<Person,Integer>
{

	@CacheEvict(value="person",allEntries=true)
	void save(Person person);
	
	@Cacheable(value="person")
	List<Person> findAll();
	
	Person findById(Integer id);
	
	void delete(Person person);
}
