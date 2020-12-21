package com.pharmaceutical.app.HealthcareApplication.controller;

import java.util.Arrays;
import java.util.List;

import javax.persistence.Version;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pharmaceutical.app.HealthcareApplication.Response;
import com.pharmaceutical.app.HealthcareApplication.dto.Drug;
import com.pharmaceutical.app.HealthcareApplication.dto.Person;
import com.pharmaceutical.app.HealthcareApplication.service.PersonService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class PersonController {
	
	@Autowired//dependency injection
	private PersonService personServiceObj;
	
	
	
	@RequestMapping("/persons")
	public List<Person> getAllPerson(){
		return personServiceObj.getAllPersons();
	}
	
	@RequestMapping("/persons/{fname}")
	public Person getPerson(@PathVariable String fname){
		return personServiceObj.getThisPerson(fname);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/persons")
	public Response addPerson(@RequestBody Person personRef) {
	//	return personServiceObj.addThisPerson(personRef);
		return new Response(personRef.getPersonId()+" inserted ",Boolean.TRUE);
	}
	
	@Version
	@RequestMapping(method=RequestMethod.PUT,value="/persons/{emailId}")
	public void updateThisPerson(@RequestBody Person personRef,@PathVariable String emailId) {
		personServiceObj.updateThisPerson(personRef,emailId);
	}
//	
	@RequestMapping(method=RequestMethod.DELETE,value="/persons/{emailId}")
	public void deleteThisPerson(@PathVariable String emailId) {
		personServiceObj.deleteThisPerson(emailId);
	}
}
