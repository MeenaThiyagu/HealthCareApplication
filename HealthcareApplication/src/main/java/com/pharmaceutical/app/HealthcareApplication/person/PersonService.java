package com.pharmaceutical.app.HealthcareApplication.person;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins="http://localhost:4200/")
@Service//spring creates instance . it is a stereotype annotation.
public class PersonService {
	@Autowired
	private PersonRepository personRep;
	private static int id;
	private List<Person> personLists=new ArrayList<>(Arrays.asList(			
			new Person(101, "Thomas","Henry", "New Jersey","thomash@gmail.com"),
			new Person(102, "Annie","John", "Florida","anniej@gmail.com"),
			new Person(103, "John","Tim", "Atlanta","johnt@gmail.com")
			));	
	
	public List<Person> getAllPersons(){
		//return personLists;
		List<Person> personLists=new ArrayList<>();		
		personRep.findAll().forEach(personLists::add);
		System.out.println("Persons are "+personLists);
		return personLists;
	}
	public Person getThisPerson(String name){
		//return personLists.stream().filter( given-> given.getFirstName().equals(firstName)).findFirst().get();
	return	personRep.findByFirstName(name);
		
	}
	public Person addThisPerson(Person personRef) {
		//personLists.add(personRef);//To edit the POST body hence POSTMAN tool is used
		return personRep.save(personRef);
	}
	public Person updateThisPerson(Person personRef,String emailId) {
		//personLists.add(personRef);//To edit the POST body hence POSTMAN tool is used
		if(personRef.getId()==-1) {
			personRef.setId(++id);
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
