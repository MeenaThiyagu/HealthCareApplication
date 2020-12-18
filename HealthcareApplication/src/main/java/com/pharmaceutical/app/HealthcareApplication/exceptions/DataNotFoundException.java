package com.pharmaceutical.app.HealthcareApplication.exceptions;

public class DataNotFoundException extends RuntimeException{

	public DataNotFoundException(String name) {
		super(name);
	}
}
