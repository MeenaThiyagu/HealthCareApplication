package com.pharmaceutical.app.HealthcareApplication.person;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.pharmaceutical.app.HealthcareApplication.exceptions.DataNotFoundException;

@CrossOrigin(origins="http://localhost:4200/")
@Service//spring creates instance . it is a stereotype annotation.
public class PersonService {
	@Autowired
	private PersonRepository personRep;
	private static int id;
	private List<Person> personLists=new ArrayList<>();	
	
	public List<Person> getAllPersons(){
		//return personLists;
		List<Person> personLists=new ArrayList<>();		
		personRep.findAll().forEach(personLists::add);
		System.out.println("Persons are "+personLists);
		return personLists;
	}
	public Person getThisPerson(String name){
		//return personLists.stream().filter( given-> given.getFirstName().equals(firstName)).findFirst().get();
	Person pObj=personRep.findByFirstName(name);
		if(pObj==null) {
			throw new DataNotFoundException("Person with name "+name+ " is not found");
		}
	return pObj;
	}
	public Person addThisPerson(Person personRef) {
		//personLists.add(personRef);//To edit the POST body hence POSTMAN tool is used
		return personRep.save(personRef);
	}
	public Person updateThisPerson(Person personRef,String emailId) {
		//personLists.add(personRef);//To edit the POST body hence POSTMAN tool is used
		if(personRef.getPersonId()==-1) {
			personRef.setPersonId(++id);
			return personRep.save(personRef);
		}
		else 
			this.deleteThisPerson(emailId);
			return addThisPerson(personRef);
	}
	public String deleteThisPerson(String emailId) {
		//personLists.add(personRef);//To edit the POST body hence POSTMAN tool is used
		personRep.deleteByEmailId(emailId);
		return "Person is removed"+emailId;
	}
}
