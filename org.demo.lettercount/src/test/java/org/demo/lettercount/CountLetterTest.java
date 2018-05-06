package org.demo.lettercount;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class CountLetterTest {		
				
		String text0 = "";
		char letter0 = ' ';
		
		String textCorrect = "ajknjknjknjknjknjknanjljknjklnjkanjkljkanjknlaaljknljkaaaa";
			
		String text2 = "153453453453";
		char letter2 = '1';
		
		String textNull = null;
		String textEmpty = "";
	
		char letterCorrect = 'a';
		char letterEmpty = ' ';
			

	
	@Test(expected= NullPointerException.class) 
	public void testNullpointerText() {		
		CountLetter.getQuantityOfLetter(letterCorrect, textNull);
	}
	
	@Test(expected= IllegalArgumentException.class) 
	public void testEmptyletter() {		
		CountLetter.getQuantityOfLetter(letterEmpty, textCorrect);
	}
	
	@Test(expected= IllegalArgumentException.class) 
	public void testEmptyText() {		
		CountLetter.getQuantityOfLetter(letterCorrect, textEmpty);
	}
	
	@Test
	public void testIfCountIsExactly10() {	
			
			assertTrue("Test should count 10", 10 == CountLetter.getQuantityOfLetter(letterCorrect, textCorrect));
			assertFalse("", 9 == CountLetter.getQuantityOfLetter(letterCorrect, textCorrect));
			assertFalse("", 11 == CountLetter.getQuantityOfLetter(letterCorrect, textCorrect));
	}
	

}
