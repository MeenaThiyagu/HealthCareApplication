package com.pharmaceutical.app.HealthcareApplication.person;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person,String> {

	//method to get All person
	//method to get given person details
	
	public Person findByFirstName(String name);
	
	@Transactional
	public String deleteByEmailId(String emailId);
	
	//call SP from 
	//JOIN condition execute
	//Custom queries
	//multiple insert in one shot...
}
