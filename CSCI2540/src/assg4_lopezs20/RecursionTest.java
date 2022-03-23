/**
 * @author Steven Lopez 
 * Class: CSCI 2540
 * Date: 02/18/2021
 * Program: Recursive Testing 
 * Description: This program will utilize recursive techniques to 
 * 	make the deleteFirst and deleteAll methods.
 * 
 */
package assg4_lopezs20;

import java.util.*;

public class RecursionTest {
	
	/**
	 * Recursive method that deletes the first occurrence of 
	 * the given character within the given string.
	 * @param str -- the string from user input.
	 * @param ch -- the character from user input.
	 * @return deleteFirst(string, char) -- recursion until arguments have been met. 
	 */
	public static String deleteFirst(String str, char ch) {
		// checks if string is empty or null.
		if (str == null || str == "" ) {
			return str;
			
		} else 
		{	// when string matches the first occurrence of character.
			if(str.charAt(0) == ch) { 
			return	deleteFirst(str.substring(1), (char) str.indexOf(ch));	// delete the first occurrence.
			}
			else
			{
			// the recursive call that loops the iterations.
			return (str.charAt(0) + deleteFirst(str.substring(1), ch));
			}
	}
	}

	/**
	 * Recursive method that deletes all occurrences of 
	 * the given character within the given string.
	 * @param str -- the string from user input.
	 * @param ch -- the character from user input.
	 * @return deleteFirst(string, char) -- recursion until arguments have been met. 
	 */
	public static String deleteAll(String str, char ch) {
		if (str == null || str == "" ) {
			return str;
			
		} else 
		{
			if(str.charAt(0) == ch) {
				return deleteAll(str.substring(1), ch); // deletes all occurrences of character.
			}else 
			{
				return (str.charAt(0) + deleteAll(str.substring(1), ch));
			}
		}
	}
	
	
	/**
	 * Main method that asks for user's string and character inputs.
	 * Calls the recursive methods deleteFirst and deleteAll.
	 */
	public static void main(String[] args) {
		
		
		Scanner input = new Scanner(System.in);
		int answer;
		do {
		System.out.println("1. Test deleteFirst method: ");
		System.out.println("2. Test deleteAll method: ");
		System.out.println("3. Exit");
		
		// get user's decision.
		answer = input.nextInt();
		
		// choice 1 else-if choice 2:
		if( answer == 1) {
			System.out.println("Please write a message (no space): ");
			
			Scanner in = new Scanner(System.in);
			String message;
			message = in.nextLine();
			
			System.out.println("Please write a character for single deletion: ");
			
			char deleteChar = input.next().charAt(0);
			
			System.out.println("Result: "+deleteFirst(message, deleteChar));
			
			
		}
		else if (answer == 2){  
			System.out.println("Please write a message (no spaces): ");
			
			Scanner in = new Scanner(System.in);
			String message;
			message = in.nextLine();
			
			System.out.println("Please write a character for entire deletion: ");
			
			char deleteChar = input.next().charAt(0);
			
			System.out.println("Result: " + deleteAll(message, deleteChar));
			
			
		} 
		} while (answer != 3); // checks when user quits.
		
		
		input.close();
	}

}
