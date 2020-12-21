package com.pharmaceutical.app.HealthcareApplication.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import com.pharmaceutical.app.HealthcareApplication.dto.Drug;

public interface DrugRepository extends  JpaRepository<Drug,Object> {

	//method to get All drug
	//method to get given drug details
	
	public Drug findByName(String name);
	
	@Transactional
	public String deleteByName(String name);
}
