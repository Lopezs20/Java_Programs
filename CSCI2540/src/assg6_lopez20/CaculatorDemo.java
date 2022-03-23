/**
* @author Steven Lopez 
* Class: CSCI 2540
* Date: 03/23/2021
* Program: CalculatorDemo  
* Description:
*	This program evaluates infix expression by converting infix into a postfix form 
*	and then evaluating the postfix expression. It will ask the user for the infix
*	and print the postfix before caculations.
*/
package assg6_lopez20;

import java.util.*;

/**
 * Calculator demonstration classthat 
 * provides all methods and user inputs.
 * Program exits once the user enters a single 0.
 */
public class CaculatorDemo {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		Calculator calc = null;
		
		// infinite loop till user quits.
		while(true) {
			System.out.println("********Infix/Postfix Caculator********");
			
			
			System.out.println("Type an equation to be caculated");
			
			String answer = in.nextLine();
			
			if(answer != null) 
				calc = new Calculator(answer);
			
			
			String prin = calc.getPostfix();
			System.out.println(prin.toString());
			
			System.out.println("Your answer is: ");
			System.out.println(calc.evaluate());
			
			System.out.println("To exit type only 0.");
			
			while(in.hasNextInt()) {
				if(in.nextInt() == 0) {
					in.close();
					System.exit(0);
				}
				break;
			}
			
		}
	}

}
