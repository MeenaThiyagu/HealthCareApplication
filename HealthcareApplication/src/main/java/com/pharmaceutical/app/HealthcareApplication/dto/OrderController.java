package com.pharmaceutical.app.HealthcareApplication.dto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.pharmaceutical.app.HealthcareApplication.dto.*;
import com.pharmaceutical.app.HealthcareApplication.repository.*;


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
