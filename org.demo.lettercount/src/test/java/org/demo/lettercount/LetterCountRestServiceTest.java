package org.demo.lettercount;


import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.Response;


import org.junit.Test;

public class LetterCountRestServiceTest{
	
	
	
	Client client = ClientBuilder.newClient();
	
	
	
	WebTarget target = client.target("http://localhost:8080/howtodoinjava");
	Form form = new Form().param("customer", "Bill").param("product", "book");
	Response response = target.request().post(Entity.form(form));
	//Order order = response.readEntity(Order.class); 
	
	
	
	
	
	}
	
	
	

