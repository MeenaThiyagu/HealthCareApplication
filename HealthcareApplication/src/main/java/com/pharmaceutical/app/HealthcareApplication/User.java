package com.pharmaceutical.app.HealthcareApplication;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="User_webapp")
public class User {
@Id
private long userid;
private String username;
private String password;
public long getId() {
	return userid;
}
public void setId(long id) {
	this.userid = id;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
}
