/**
* @author Steven Lopez 
* Class: CSCI 2540
* Date: 03/23/2021
* Program: Calculator   
* Description:
*	This program evaluates infix expression by converting infix into a postfix form 
*	and then evaluating the postfix expression.
*/
package assg6_lopez20;

import java.util.Stack;

/**
 * The calculator class that performs the infix 
 * to postfix conversions through it's method.
 */
public class Calculator {
	
	// private instance variables
	private boolean checker = false;
	private String inFIX = "";
	private String postFIX = "";
	
	// Default constructor for initializing infix equation.
	public Calculator(String equation) {
		inFIX = equation;
	}
	
	/*
	 * Compares the precedence order of the 
	 * operators for the operands. 
	 * @param character 
	 * @returns integer
	 */
	public int compareOp(char priority) {
		
		if(priority == '+' || priority == '-') {
			return 2;
		}
		else if (priority == '*' || priority == '/') {
			return 1;
		}
		return -1;
	}
	
	/**
	 * Boolean method for converting infixes to postfix
	 * Stores the postfix string conversion in the postfix variable
	 * @return true value
	 */
	private boolean convertPostFix() {
		Stack<Character> symbols = new Stack<Character>();
		char space;
		int eachChar = inFIX.length();
		
		for (int iter = 0; iter < eachChar; iter++) {
			space = this.inFIX.charAt(iter);
			
			if(Character.isDigit(space)) {
				postFIX += space;
			
				  if (iter + 1 >= inFIX.length() || !Character.isDigit(inFIX.charAt(iter + 1))) { 
                      postFIX += ' ';
                  }
			}else 	
			if (space == '(') {
				symbols.push(space);
			} else 
			if(space == ')') {
				while(!symbols.isEmpty() && symbols.peek() != '(') {
					postFIX += " ";
					postFIX += symbols.pop();
				}
			} else
			if (compareOp(space) > 0 ) {
				while ( !symbols.isEmpty() && compareOp(space) <= compareOp(symbols.peek()) ) {
					postFIX += " ";
					postFIX += symbols.pop();
					
				}
				symbols.push(space);
			}
			else {
				postFIX += space;
			}
		}
		
			while (!symbols.isEmpty()) {
				postFIX += symbols.pop();
			}
		checker = true;
		postFIX = postFIX.replace("(", ""); 
		postFIX = postFIX.replace(")", ""); 
		return true;
	}
	
	
	/**
	 * After the postfix has been called and created from 
	 * the infix string values, this method provides
	 * the calculations and answer from the infix.
	 * @return integer result
	 * @throws IllegalStateException
	 */
	public int evaluate() throws IllegalStateException {
		if (checker != true) {
			throw new IllegalStateException();
		}
		else {
		Stack<Integer> out = new Stack<Integer>();
		char space;
		int eachChar = postFIX.length();
		
		for (int iter = 0; iter < eachChar; iter++) {
			space = postFIX.charAt(iter); 
			int track = 0;
	            if(space == ' ') 
	            continue; 
	           
			 if(Character.isDigit(space)) { 
	              while(Character.isDigit(space)) {  
	                track = track*10 + (int)(space-'0'); 
	                iter++; 
	                space = postFIX.charAt(iter);  
	                } 
	              	iter--; out.push(track); 
	            } 
			else {
				
				int uno = out.pop();
				int dos = out.pop();
				
				if (space == '+') {
					out.push(dos+uno);
				}
				else if(space == '*') {
					out.push(dos*uno);
				}
				else if(space == '/') {
					out.push(dos/uno);
				}else if(space == '-')
					out.push(dos-uno);
			}
			
		}
		
		int result = out.pop();
		return result;
	  }
	
	}
	
	
	
	/**
	 * toString method for taking the string literal of infix.
	 * @return infix string
	 */
	@Override
	public String toString() {
		return this.inFIX;
	}
	
	/**
	 * Recieves what is stored in the string variable
	 * postfix after the conversion method has been called.
	 * @return	postfix string
	 * @throws IllegalStateException
	 */
	public String getPostfix() throws IllegalStateException {
		
		convertPostFix();
		
		if (checker != true) {
			throw new IllegalStateException();
		}
		
		return this.postFIX;
	}
}
