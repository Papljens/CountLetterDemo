package org.demo.lettercount;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *Jersey REST Service Class
 *
 *The class registers its methods for the HTTP GET request using the @GET annotation.
 *Using the @Produces annotation, it defines that it can deliver several MIME types,
 *text, XML and HTML.
 *The browser requests per default the HTML MIME type.
 *
 *@author  PaplJens
 *
 */

//Sets the path to base URL + /demo
@Path("/demo")
public class LetterCountRestService {

	@GET
	@Produces(MediaType.TEXT_HTML)
	public String sayPlainTextHello() {
		 return "<html> " + "<title>" + "Hello Jersey" + "</title>"
			        + "<body><h1>" + "Hello Jersey" + "</body></h1>" + "</html> ";
	}
	
		
	/**
	 *Gets letter and text from demo.html Form
	 *then counts the occurrence of the given letter in the given text (calls CountLetter.count())
	 *
	 */
	@POST	
	//@Path("/result")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public Response getQuantity(@FormParam("letter") char letter, @FormParam("textInput") String text ) {
		 if(letter == ' ' || text.length() == 0) {
		        return Response.serverError().entity("Letter and text cannot be blank").build();}
		
		
		int quantity = CountLetter.count(letter, text);
		
				
		
	   String data = " Quantity: " + quantity +" letter: " + letter + " text:  " + text;
		
		
		return Response
				
				
					
				   .ok()				  
				   .entity(data)
			       .build();

		
		// return "<html> " + "<title>" + "Count successful" + "</title>"
			//        + "<body><h1>" + "Letter: " + letter + "    Count: " + count + "</body></h1>" + "</html> ";
	}
	
	
}
	
	

