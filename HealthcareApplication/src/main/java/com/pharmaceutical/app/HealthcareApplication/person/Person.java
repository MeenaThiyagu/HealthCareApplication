package com.pharmaceutical.app.HealthcareApplication.person;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Person {
	@Id
	@GeneratedValue
	private int personId;
	private String firstName;
	private String lastName;
	private String location;
	private String emailId;
	public int getId() {
		return personId;
	}
	@Override
	public String toString() {
		return "Person [personId=" + personId + ", firstName=" + firstName + ", lastName=" + lastName + ", location="
				+ location + ", emailId=" + emailId + "]";
	}
	public void setId(int id) {
		this.personId = id;
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
	public Person(int id, String firstName, String lastName, String location, String emailId) {
		super();
		this.personId = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.location = location;
		this.emailId = emailId;
	}	
	
}
