package com.pharmaceutical.app.HealthcareApplication.drug;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pharmaceutical.app.HealthcareApplication.person.Person;

@RestController
public class DrugController {
	
	@Autowired//dependency injection
	private DrugService drugServiceObj;
	
	@RequestMapping("/drugs")
	public List<Drug> getAllDrugs(){
		return drugServiceObj.getAllDrugs();
	}
	
////	@RequestMapping("/person/{fname}/drugs")
//	public List<Drug> getAllDrugsByPerson(String fname){
//		 return drugServiceObj.getAllDrugsByPerson(fname);
//	}
	
	@RequestMapping("/drugs/{name}")
	public Drug getDrug(@PathVariable String name){
		return drugServiceObj.getThisDrug(name);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/persons/{personId}/drugs")
	public void addDrug(@RequestBody Drug drugRef,@PathVariable int personId) {
		drugRef.setPersonObj(new Person(personId,"","","",""));
		drugServiceObj.addThisDrug(drugRef);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/persons/{personId}/drugs/{drugId}")
	public void updateThisDrug(@RequestBody Drug drugRef,@PathVariable int personId,@PathVariable String drugId) {
		drugRef.setPersonObj(new Person(personId,"","","",""));//just to verify the person
		drugServiceObj.updateThisDrug(drugRef);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/persons/{personId}/drugs/{drugId}")
	public void addDrug(@RequestBody Drug drugRef,@PathVariable int personId,@PathVariable String drugId) {
		drugRef.setPersonObj(new Person(personId,"","","",""));
		drugServiceObj.deleteThisDrug(drugId);
	}
	
}
