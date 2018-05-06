package org.demo.lettercount;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
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
	
	private static final Logger logger = LogManager.getLogger(CountLetter.class);	
		
	/**
	 *Gets letter and text from demo.html Form
	 *then counts the occurrence of the given letter in the given text (calls CountLetter.count())
	 *
	 */
	@POST	//This function reacts to HTTP Post
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)    //Don't use @Consumes in order to consume all MediaTypes
	@Produces(MediaType.TEXT_PLAIN)						//Defines response media type
	/**
	 * Function to process HTTP Post from Client
	 * @param letter
	 * @param text
	 * @return Response with quantity of given letter (e.g. a Number)
	 */
	public Response response(@FormParam("letter") char letter, @FormParam("text") String text ) {		
		logger.info("function entered");
		
		if (letter == ' ') {
			logger.info("letter is empty");
			return Response.serverError().status(400).entity("Please enter a letter").build();
		}
		
		if (text == null) {
			logger.info("text is null");
			return Response.serverError().status(400).entity("Please enter a text").build();
		}
		
		if (text.isEmpty() ||  text.length() <= 0) {	
			logger.info("text is empty: {}", text);
			return Response.serverError().entity("Please enter a text").build();
		}
		
		//If letter is compared to text containing only given letter, the counting function would crash.
		//So the text length is restricted to Integer.MAX_VALUE (2147483647);
		if(text.length() > Integer.MAX_VALUE) {
			logger.info("Text is too big");			
			return Response.serverError().status(400).entity("Text is too big").build();
		}
		
		logger.info("calling CountLetter.getQuantityOfLetter() function with letter: {} | text: {} ||END OF TEXT", letter, text);	
		int result = CountLetter.getQuantityOfLetter(letter, text);
				
		logger.info("result is: {}", result);			
	    String data = " Result: " + result;		
		
	    logger.info("building and sending response with data: {}", data);
		return Response	
				   .ok()				  
				   .entity(data)
			       .build();
	}
}
	
	

