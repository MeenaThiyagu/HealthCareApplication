package com.pharmaceutical.app.HealthcareApplication;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.*;
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


@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonTest {
	
	private MockMvc mockmvc;
	
	@Autowired
	private WebApplicationContext context;
	
	@Before
	public void setUp() {
		mockmvc=MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	//convert personObj as json/string json
	ObjectMapper om=new ObjectMapper();
	@Test
	 public void addThisPersonTest() throws Exception {
		Person pObj= new Person();
		pObj.setEmailId("random@gmail.com");
		pObj.setFirstName("FName");
		pObj.setLastName("LName");
		pObj.setPersonId(156);
		pObj.setLocation("New Jersey");
		
		String jsonRequest=om.writeValueAsString(pObj);
		//when(personRep.findByFirstName(anyString())).thenReturn(pObj);
		MvcResult result=mockmvc.perform(post("/persons").content(jsonRequest).content(MediaType.APPLICATION_JSON_VALUE)).
				andExpect(status().isOk()).andReturn();
		String resultContent=result.getResponse().getContentAsString();
		Response resp=om.readValue(resultContent, Response.class);//actual response object
		
		Assert.assertTrue(resp.isStatus()==Boolean.TRUE);
		
		
	
		
	}

}


