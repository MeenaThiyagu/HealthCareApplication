package com.pharmaceutical.app.HealthcareApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.pharmaceutical.app.HealthcareApplication.dto.Person;
import com.pharmaceutical.app.HealthcareApplication.repository.StoredProcedurePerson;

@RestController
public class StoredProcPersonController {
	@Autowired
	private StoredProcedurePerson spPersonObj;
	
	@GetMapping("/storedProcPersonDetails/{in_person_id}")
	public String getPersonDetailsByPersonId(@PathVariable int in_person_id) {
		System.out.println("Value of p_id is "+in_person_id);
		System.out.printf(" returned value is "+spPersonObj.getPersonDetailsByPersonId(in_person_id));
		return spPersonObj.getPersonDetailsByPersonId(in_person_id);
	}
	
	 
}
