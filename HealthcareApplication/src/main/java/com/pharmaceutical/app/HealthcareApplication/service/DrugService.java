package com.pharmaceutical.app.HealthcareApplication.drug;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service//spring creates instance . it is a stereotype annotation.
public class DrugService {
	@Autowired
	private DrugRepository drugRep;
	private List<Drug> drugLists=new ArrayList<>();	
	private static int id;
	public List<Drug> getAllDrugs(){
		//return drugLists;
		List<Drug> drugLists=new ArrayList<>();		
		drugRep.findAll().forEach(drugLists::add);
		return drugLists;
	}
	public Drug getThisDrug(String drugName){
		return drugRep.findByName(drugName);
	}
	

	public Drug addThisDrug(Drug drugRef) {
	return drugRep.save(drugRef);
	}
	public void updateThisDrug(String drugName,Drug drugRef) {
		//drugLists.add(drugRef);//To edit the POST body hence POSTMAN tool is used
		drugRep.save(drugRef);
	}
	public void deleteThisDrug(String name) {
		//drugLists.removeIf(given->given.getName().equals(drugName));//To edit the POST body hence POSTMAN tool is used
		drugRep.deleteByName(name);
	}
	public Drug updateThisDrug(Drug drugRef, String name) {
		// TODO Auto-generated method stub
		if(drugRef.getId()==-1) {
			drugRef.setId(++id);
			return drugRep.save(drugRef);
		}
		else 
			this.deleteThisDrug(name);
			return addThisDrug(drugRef);
	}
//	public List<Drug> getAllDrugsByPerson(String fname) {
//		List<Drug> drugsList=new ArrayList<>();
//		drugRep.findByPersonFirstName(fname).forEach(drugsList::add);
//		return drugsList;
//	}
	
	
}
