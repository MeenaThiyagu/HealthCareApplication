package com.pharmaceutical.app.HealthcareApplication.drug;

import javax.persistence.*;

import com.pharmaceutical.app.HealthcareApplication.person.Person;

@Entity
public class Drug {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String manufacturer;
	private String marketingStatus;
	private String expiryAt;
	private String availableAt;
//	private int col_fk_personId;
//	
//	public int getCol_fk_personId() {
//		return col_fk_personId;
//	}
//	public void setCol_fk_personId(int col_fk_personId) {
//		this.col_fk_personId = col_fk_personId;
//	}
	public String getAvailableAt() {
		return availableAt;
	}
	public void setAvailableAt(String availableAt) {
		this.availableAt = availableAt;
	}
	public Drug() {
		
	}
	public Drug( String name, String manufacturer, String marketingStatus, String expiryAt,String availableAt, int id) {
		super();
		this.name = name;
		this.manufacturer = manufacturer;
		this.marketingStatus = marketingStatus;
		this.expiryAt = expiryAt;
		this.availableAt=availableAt;
		this.id=id;
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public String getMarketingStatus() {
		return marketingStatus;
	}
	public void setMarketingStatus(String marketingStatus) {
		this.marketingStatus = marketingStatus;
	}
	public String getExpiryAt() {
		return expiryAt;
	}
	public void setExpiryAt(String expiryAt) {
		this.expiryAt = expiryAt;
	}
	
	
}
