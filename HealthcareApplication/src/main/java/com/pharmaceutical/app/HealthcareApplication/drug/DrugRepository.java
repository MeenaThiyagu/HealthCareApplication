package com.pharmaceutical.app.HealthcareApplication.drug;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

public interface DrugRepository extends CrudRepository<Drug,Object> {

	//method to get All drug
	//method to get given drug details
	
	public Drug findByName(String name);
	
	@Transactional
	public String deleteByName(String name);
}
