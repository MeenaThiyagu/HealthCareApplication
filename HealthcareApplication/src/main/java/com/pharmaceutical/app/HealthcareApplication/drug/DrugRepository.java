package com.pharmaceutical.app.HealthcareApplication.drug;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
public interface DrugRepository extends CrudRepository<Drug,String> {

	//method to get All drugs
	//method to get given drug details
	//method to get
	
	//public List<Drug> findByPersonId(String personId);
}
