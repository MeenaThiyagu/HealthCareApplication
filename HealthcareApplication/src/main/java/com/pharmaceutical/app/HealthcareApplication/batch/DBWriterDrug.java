package com.pharmaceutical.app.HealthcareApplication.batch;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.pharmaceutical.app.HealthcareApplication.dto.Drug;
import com.pharmaceutical.app.HealthcareApplication.controller.*;
import com.pharmaceutical.app.HealthcareApplication.repository.*;


@Component
public class DBWriterDrug implements ItemWriter<Drug> {

	@Autowired
	private DrugRepository drugRepository;

  
	
	@Override
	public void write(List<? extends Drug> drugItems) throws Exception {
		System.out.println("Data Saved for Drugs: " + drugItems);
		drugRepository.saveAll(drugItems);
		
	}

}
