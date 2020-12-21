package com.pharmaceutical.app.HealthcareApplication.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.pharmaceutical.app.HealthcareApplication.dto.User;
import com.pharmaceutical.app.HealthcareApplication.dto.UserPrincipal;
import com.pharmaceutical.app.HealthcareApplication.repository.UserRepository;
@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRep;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("Inside Service method to verify username in database "+username);
		User userObj=userRep.findByUsername(username);
		
		if(userObj==null)
			throw new UsernameNotFoundException("User not found");
			return new UserPrincipal(userObj);//since UserDetails is an interface,return object of class implementing
	}

}
