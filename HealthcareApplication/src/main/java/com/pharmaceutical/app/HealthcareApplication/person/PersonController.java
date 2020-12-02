package com.pharmaceutical.app.HealthcareApplication.person;

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

import com.pharmaceutical.app.HealthcareApplication.drug.Drug;

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
	public void addPerson(@RequestBody Person personRef) {
		personServiceObj.addThisPerson(personRef);
	}
	
	@Version
	@RequestMapping(method=RequestMethod.PUT,value="/persons/")
	public void updateThisPerson(@RequestBody Person personRef) {
		personServiceObj.updateThisPerson(personRef);
	}
//	
	@RequestMapping(method=RequestMethod.DELETE,value="/persons/{id}")
	public void deleteThisPerson(@PathVariable int id) {
		personServiceObj.deleteThisPerson(id);
	}
}
