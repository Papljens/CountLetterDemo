package org.demo.lettercount;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

/**
 *Counts occurrence of letter in the given Text
 *@author PaplJens
 */

class CountLetter {
	
	private static final Logger logger = LogManager.getLogger(CountLetter.class);
	
	/**
	 * Counts the occurrence of a given letter in a given text
	 * @param letter
	 * @param text
	 * @return
	 */
	public static int getQuantityOfLetter(char letter, String text) {	
		logger.info("function entered");
		
		if (text == null) {	
			logger.warn("text is null");
		    throw new NullPointerException("text is null");
		}	
		
		if (text.isEmpty() ||  text.length() <= 0) {	
			logger.info("text is empty: {}", text);
		    throw new IllegalArgumentException("text is empty");
		}
		
		if (letter == ' ') {
			logger.info("letter is empty: {}", letter);
			throw new IllegalArgumentException("letter is empty");			
		}	
		
		//If letter is compared to text containing only given letter, the counting function would crash.
		//So the text length is restricted to Integer.MAX_VALUE (2147483647);
		if(text.length() > Integer.MAX_VALUE) {
			logger.info("text is too long");			
			throw new IllegalArgumentException("text is too long");	
		}
								
		int result = 0;			
		logger.info("start counting the occurrence of given letter: {} in given text: {} |END OF TEXT", letter, text);
		
		//This Function iterates each character in the given text and compares it to the given letter
		for (int i = 0; i < text.length(); i++) {						
			if (letter == text.charAt(i)) {
				logger.trace("letter found: {} | result before adding: ", letter, result);
				result++;
			}
		}
		
		logger.info("counting finished. result is: {}", result);
		return result;
	}
}
