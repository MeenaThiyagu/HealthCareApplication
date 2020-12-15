package com.pharmaceutical.app.HealthcareApplication.dto;

import com.pharmaceutical.app.HealthcareApplication.person.*;

public class OrderResponse {
	private String emailId;
	private String name;
	@Override
	public String toString() {
		return "OrderResponse [emailId=" + emailId + ", name=" + name + "]";
	}
	public OrderResponse(String emailId, String name) {
		super();
		this.emailId = emailId;
		this.name = name;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
