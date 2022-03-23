/**
 * @author Steven Lopez 
 * Class: CSCI 2540
 * Date Due: 02/16/2021
 * Program: Book Class  
 * Description:
 * 	 This class will be the BookNotFoundException that inherits the 
 * 	 checked Exception class. Here the class prints out the error 
 * 	 message and is implemented for handling in main class. 
 */
package assg3_lopezs20;

public class BookNotFoundException extends Exception{
	
	/**
	 * Default constructor for Book Exception
	 */
	public BookNotFoundException() {
		super("Book cannot be found within catalog. Try again. ");
		//System.out.println("Book cannot be found within catalog. Try again. ");
		
		
	}
	/**
	 * An Exception constructor with a single string parameter 
	 * @param str -- the string message
	 */
	public BookNotFoundException(String str) {
		super(str);
		
	}

}
