package com.pharmaceutical.app.HealthcareApplication.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pharmaceutical.app.HealthcareApplication.dto.Person;

@Repository
public class StoredProcedurePerson {

	@Autowired
	private EntityManager emObj;
	
	public String getPersonDetailsByPersonId(int person_id) {
		System.out.println("Inside SPPerson dao");
		return   emObj.createNamedStoredProcedureQuery("firstProc")
				.setParameter("in_person_id", person_id).toString();
	}
}
