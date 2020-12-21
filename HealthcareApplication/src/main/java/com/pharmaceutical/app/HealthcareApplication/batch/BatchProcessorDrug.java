package com.pharmaceutical.app.HealthcareApplication.batch;

import com.pharmaceutical.app.HealthcareApplication.dto.*;

import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class BatchProcessorDrug implements ItemProcessor<Drug,Drug> {

	 private static final Map<String, String> marketingStatus_codes =
	            new HashMap<>();

	    public BatchProcessorDrug() {
	    	marketingStatus_codes.put("001", "SELF");
	    	marketingStatus_codes.put("002", "PRESCRIPTION");
	    }
	
	
	@Override
	public Drug process(Drug drugObj) throws Exception {
		// TODO Auto-generated method stub
		String marketingStatusCode=drugObj.getMarketingStatus();
		String marketingStatus=marketingStatus_codes.get(marketingStatusCode);
		drugObj.setMarketingStatus(marketingStatus);
		 System.out.println(String.format("Converted from [%s] to [%s]",marketingStatusCode, marketingStatus));
		return drugObj;
	}

	
	
}
