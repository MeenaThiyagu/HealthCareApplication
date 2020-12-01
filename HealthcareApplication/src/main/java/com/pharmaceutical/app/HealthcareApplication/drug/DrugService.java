package com.pharmaceutical.app.HealthcareApplication.drug;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service//spring creates instance . it is a stereotype annotation.
public class DrugService {
	@Autowired
	private DrugRepository drugRep;
	private List<Drug> drugLists=new ArrayList<>();	
	
	public List<Drug> getAllDrugs(){
		//return drugLists;
		List<Drug> drugLists=new ArrayList<>();		
		drugRep.findAll().forEach(drugLists::add);
		return drugLists;
	}
	public Drug getThisDrug(String drugName){
		return drugLists.stream().filter( given-> given.getName().equals(drugName)).findFirst().get();
	}
	public void addThisDrug(Drug drugRef) {
	//	drugLists.add(drugRef);//To edit the POST body hence POSTMAN tool is used
		drugRep.save(drugRef);
	}
	public void updateThisDrug(String drugName,Drug drugRef) {
		//drugLists.add(drugRef);//To edit the POST body hence POSTMAN tool is used
		drugRep.save(drugRef);
	}
	public void deleteThisDrug(String drugName) {
		drugLists.removeIf(given->given.getName().equals(drugName));//To edit the POST body hence POSTMAN tool is used
		
	}
	public void updateThisDrug(Drug drugRef) {
		// TODO Auto-generated method stub
		drugRep.save(drugRef);
	}
//	public List<Drug> getAllDrugsByPerson(String fname) {
//		List<Drug> drugsList=new ArrayList<>();
//		drugRep.findByPersonFirstName(fname).forEach(drugsList::add);
//		return drugsList;
//	}
	
	
}
