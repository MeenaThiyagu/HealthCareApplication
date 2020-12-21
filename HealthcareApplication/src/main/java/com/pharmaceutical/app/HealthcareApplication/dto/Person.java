package com.pharmaceutical.app.HealthcareApplication.person;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pharmaceutical.app.HealthcareApplication.drug.Drug;
import java.util.*;
@Entity
public class Person {
	@Id
	@GeneratedValue
	private int personId;
	private String firstName;
	private String lastName;
	private String location;
	private String emailId;
	@OneToMany(targetEntity = Drug.class,cascade=CascadeType.ALL)
	@JoinColumn(name="fk_person_drugs", referencedColumnName = "personId")
	private List<Drug> drugsList ;
	@Override
	public String toString() {
		return "Person [personId=" + personId + ", firstName=" + firstName + ", lastName=" + lastName + ", location="
				+ location + ", emailId=" + emailId + ", drugsList=" + drugsList + "]";
	}
	public List<Drug> getDrugsList() {
		return drugsList;
	}
	public void setDrugsList(List<Drug> drugsList) {
		this.drugsList = drugsList;
	}
	public Person(int personId, String firstName, String lastName, String location, String emailId,
			List<Drug> drugsList) {
		super();
		this.personId = personId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.location = location;
		this.emailId = emailId;
		this.drugsList = drugsList;
	}
	public int getPersonId() {
		return personId;
	}
	
	public void setPersonId(int personId) {
		this.personId = personId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public Person() {
		
	}
		
	
}
