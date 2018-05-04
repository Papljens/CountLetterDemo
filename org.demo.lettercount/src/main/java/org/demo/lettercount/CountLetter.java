package org.demo.lettercount;

/**
 *Counts occurrence of letter in the given Text
 *
 *@author PaplJens
 *@param  list the list to be sorted.
 *@return counted occurrence of letter in text
 */

class CountLetter {
	protected static int count(char letter, String text) {
		//No Nullpointer Check. Method is being used locally and Parameters get checked before		
		int count = 0;		
		for (int i = 0; i < text.length(); i++) {						
			if (letter == text.charAt(i)) {
				count++;
			}
		}
		return count;
	}
}
