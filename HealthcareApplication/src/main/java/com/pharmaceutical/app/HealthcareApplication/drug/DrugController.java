package com.pharmaceutical.app.HealthcareApplication.drug;

import java.util.Arrays;
import java.util.List;

import javax.persistence.Version;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pharmaceutical.app.HealthcareApplication.drug.Drug;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class DrugController {
	
	@Autowired//dependency injection
	private DrugService drugServiceObj;
	
	@RequestMapping("/drugs")
	public List<Drug> getAllDrug(){
		return drugServiceObj.getAllDrugs();
	}
	
	@RequestMapping("/drugs/{name}")
	public Drug getDrug(@PathVariable String name){
		return drugServiceObj.getThisDrug(name);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/drugs")
	public void addDrug(@RequestBody Drug drugRef) {
		drugServiceObj.addThisDrug(drugRef);
	}
	
	@Version
	@RequestMapping(method=RequestMethod.PUT,value="/drugs/")
	public void updateThisDrug(@RequestBody Drug drugRef) {
		drugServiceObj.updateThisDrug(drugRef);
	}
//	
	@RequestMapping(method=RequestMethod.DELETE,value="/drugs/{name}")
	public void deleteThisDrug(@PathVariable String name) {
		drugServiceObj.deleteThisDrug(name);
	}
}
