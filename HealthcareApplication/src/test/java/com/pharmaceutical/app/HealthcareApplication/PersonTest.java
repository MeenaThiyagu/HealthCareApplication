package com.pharmaceutical.app.HealthcareApplication;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.*;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.junit.Before;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pharmaceutical.app.HealthcareApplication.person.Person;
import junit.framework.Assert;


@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class PersonTest {
	
	private MockMvc mockmvc ;//provided by Spring framework to integrate the jUnit
	
	@Autowired
	private WebApplicationContext context;//to interact with controller
	
	@BeforeEach//Junit 5 -->If Junit4, then only @Before-> MockMVC should be initialized before class loaded
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		mockmvc=MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	//convert personObj as json/string json
	ObjectMapper om=new ObjectMapper();
	@Test
	 public void addThisPersonTest() throws Exception {
		Person pObj= new Person();
		pObj.setEmailId("randomMail@gmail.com");
		pObj.setFirstName("FirstName");
		pObj.setLastName("LastName");
		pObj.setPersonId(1567);
		pObj.setLocation("New Jersey");
		
		String jsonRequest=om.writeValueAsString(pObj);
		System.out.println("JSON request is "+jsonRequest);
		//when(personRep.findByFirstName(anyString())).thenReturn(pObj);
		MvcResult result=mockmvc.perform(post("/persons").content(jsonRequest).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andReturn();
		System.out.println("Result is "+result.toString());
		String resultContent=result.getResponse().getContentAsString();
		Response resp=om.readValue(resultContent, Response.class);//actual response object
		
		Assert.assertTrue(resp.isStatus()==Boolean.TRUE);
		
		
	
		
	}

}


