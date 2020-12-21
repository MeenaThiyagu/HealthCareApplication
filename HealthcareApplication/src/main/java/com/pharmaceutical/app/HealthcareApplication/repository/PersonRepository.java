package com.pharmaceutical.app.HealthcareApplication.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.pharmaceutical.app.HealthcareApplication.dto.OrderResponse;
import com.pharmaceutical.app.HealthcareApplication.dto.Person;

public interface PersonRepository extends JpaRepository<Person,String> {

	//method to get All person
	//method to get given person details
	
	public Person findByFirstName(String name);
	
	@Transactional
	public String deleteByEmailId(String emailId);
	
	@Query("SELECT new com.pharmaceutical.app.HealthcareApplication.dto.OrderResponse"
			+ "(p.emailId, d.name) FROM Person p JOIN p.drugsList d")
	public List<OrderResponse> getPurchaseDetails();
	
	
	//call SP from 
	//JOIN condition execute
	//Custom queries
	//multiple insert in one shot...
}
