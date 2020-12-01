package com.pharmaceutical.app.HealthcareApplication.person;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person,Object> {

	//method to get All person
	//method to get given person details
	
	public Person findByFirstName(String name);
}
