package com.pharmaceutical.app.HealthcareApplication.dto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.pharmaceutical.app.HealthcareApplication.person.*;
import com.pharmaceutical.app.HealthcareApplication.drug.*;


@RestController
public class OrderController {
	@Autowired
	private PersonRepository personRep;
	@Autowired
	private DrugRepository drugRep;
	
	
	@GetMapping("/getPurchaseDetails")
	public List<OrderResponse> placeOrder() {
		return  personRep.getPurchaseDetails();
	}
}
