package com.pharmaceutical.app.HealthcareApplication.drug;

import javax.persistence.*;

import com.pharmaceutical.app.HealthcareApplication.person.Person;

@Entity
public class Drug {
	@Id
	@GeneratedValue
	private String id;
	private String name;
	private String manufacturer;
	private String expiryDate;
	private String availableAt;
	@ManyToOne(cascade = CascadeType.ALL)
	private Person personObj;
	
	public Person getPersonObj() {
		return personObj;
	}
	public void setPersonObj(Person personObj) {
		this.personObj = personObj;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}
	public String getAvailableAt() {
		return availableAt;
	}
	public void setAvailableAt(String availableAt) {
		this.availableAt = availableAt;
	}
	
	public Drug() {
		
	}
	public Drug( String name, String manufacturer, String expiryDate, String availableAt,int id) {
		super();
		this.name = name;
		this.manufacturer = manufacturer;
		this.expiryDate = expiryDate;
		this.availableAt = availableAt;
		this.personObj=new Person(id,"","","","");
	}
	
	
}
