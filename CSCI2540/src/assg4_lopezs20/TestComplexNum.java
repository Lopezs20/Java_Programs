/**
 * @author Steven Lopez 
 * Class: CSCI 2540
 * Date: 02/18/2021
 * Program: JUnit Testing of Complex Numbers 
 * Description: This program will utilize JUnit3 library to test 
 * 	the ComplexNum class which holds the methods and 
 * 	constructors for creating a complex number object, which 
 * 	will be tested using the assertEquals method.
 * 
 */
package assg4_lopezs20;

import junit.framework.TestCase;

public class TestComplexNum extends TestCase {
	
	private ComplexNum test1;
	private ComplexNum test2;
	private ComplexNum test3;
	private ComplexNum test4;
	private ComplexNum test5;
	private ComplexNum test6;
	private ComplexNum empty;
	private ComplexNum test7;
	private ComplexNum test8;
	private ComplexNum test9;
	
	protected void setUp() {
		test1 = new ComplexNum(2,2);
		test2 = new ComplexNum(4);
		test3 = new ComplexNum(-1,-5.2);
		test4 = new ComplexNum(0,4.5);
		test5 = new ComplexNum(2,3);
		test6 = new ComplexNum(4);
		empty = new ComplexNum();
		test7 = new ComplexNum(5,5);
		test8 = new ComplexNum(-3,-7.2);
		test9 = new ComplexNum(2,2);
	}
	
	/**
	 * This method tests the defaults constructor for 
	 * ComplexNum objects. 
	 */
	public void testDefault() {
		assertEquals("default", 0.0 , empty.getReal());
	}
	
	/**
	 * This method tests the single parameter constructor 
	 * for ComplexNum object.
	 */
	public void testRealConstructor() {
		assertEquals("real number only", 4.0 , test2.getReal());
	}
	
	/**
	 * This method tests the double parameter constructor
	 * for ComplexNum
	 */
	public void testTwoParameterConstructor() {
		assertEquals("real and imaginary number", -5.2 , test3.getImaginary());
	}
	
	/**
	 * This method tests the getter method for only 
	 * one parameter of a real number. 
	 */
	public void testGetReal() {
		assertEquals("Get test1's real part: ", 2.0 , test1.getReal() );
		assertEquals("Get test2's real part: ", 4.0 , test2.getReal() );
		assertEquals("Get test3's real part: ", -1.0 , test3.getReal() );
		assertEquals("Get test4's real part: ", 0.0 , test4.getReal() );
	} 
	
	/**
	 * This method tests the getter method of only 
	 * an imaginary number within parameters.
	 */
	public void testGetImaginary() {
		assertEquals("Get test1's imaginary part: ", 2.0 , test1.getImaginary());
		assertEquals("Get test2's imaginary part: ", 0.0 , test2.getImaginary());
		assertEquals("Get test3's imaginary part: ", -5.2 , test3.getImaginary());
	}
	/**
	 * Testing the addition method from 
	 * ComplexNum, adds two ComplexNum objects.
	 */
	public void testAddition() {
		test7 = test7.add(test7);
		assertEquals("test7's imaginary value: ", 10.0 ,test7.getImaginary());
		assertEquals("test7's real value: ", 10.0 ,test7.getReal());
		
		test4 = test4.add(test1);
		assertEquals("test4's imaginary value: ", 6.5 , test4.getImaginary() );
		assertEquals("test4's real value: ", 2.0 , test4.getReal() );
		
		test8 = test8.add(test3);
		assertEquals("test8's imaginary value: ", -12.4 , test8.getImaginary() );
		assertEquals("test8's real value: ", -4.0 , test8.getReal() );
	}
	/**
	 * Testing the subtraction method from 
	 * ComplexNum, subtracts two complex numbers.
	 */
	public void testSubtraction() {
		test1 = test1.sub(test3);
		assertEquals("test1's value: ", -3.0 , test1.getReal());
		assertEquals("test1's value: ", -7.2 , test1.getImaginary());
		
		test4 = test4.sub(test1);
		assertEquals("test4's value: ", -3.0 , test4.getReal() );
		assertEquals("test4's value: ", -11.7 , test4.getImaginary() );
		
		test6 = test6.sub(test4);
		assertEquals("test6's value: ", -7.0 , test6.getReal() );
		assertEquals("test6's value: ", -11.7 , test6.getImaginary() );
	}
	/**
	 * Testing the multiplication method from 
	 * ComplexNum, multiplies two complex numbers
	 */
	public void testMultiplication() {
		test7 = test7.mul(test1);
		assertEquals("test7's value: ", 0.0 , test7.getReal() );
		assertEquals("test7's value: ", 13.0 , test7.getImaginary() );
		
		test1 = test1.mul(test3);
		assertEquals("test1's value: ", 8.4 , test1.getReal() );
		assertEquals("test1's value: ", 5.2 , test1.getImaginary() );
		
		test8 = test8.mul(test9);
		assertEquals("test8's value: ", 8.4 , test8.getReal() );
		assertEquals("test8's value: ", -19.4 , test8.getImaginary() );
	}
	
	/**
	 * Testing the negation method
	 * negates the complex number.
	 */
	public void testNegation() {
		test7 = test7.neg();
		assertEquals("test7's value: ", -5.0 , test7.getReal() );
		assertEquals("test7's value: ", -5.0 , test7.getImaginary() );
		
		test6 = test6.neg();
		assertEquals("test6's value: ", -4.0 , test6.getReal() );
		assertEquals("test6's value: ", -0.0 , test6.getImaginary() );
	}
	/**
	 * Testing the toString method 
	 * turns the complex number into string object.
	 */
	public void testToString() {
		assertEquals("test2's value: ", "4.0" , test2.toString() );
		assertEquals("test7's value: ", "-1.0-5.2i" , test3.toString() );
		assertEquals("empty's value: ", "0.0i" , empty.toString() );
	}
	
	/**
	 * Testing the equals method 
	 * Checks if two complex numbers equal each other
	 * A check variable is made to store the boolean data.
	 */
	public void testEquals() {
		boolean check = test1.equals(test6);
		assertEquals("check if ", false, check);
		
		check = test1.equals(test9);
		assertEquals("check if ", true, check);
	}
	
	/**
	 * This method tests the setter method of only 
	 * an real number within parameters.
	 */
	public void testSetReal() {
		test1.setReal(2.2);
		assertEquals("Set test1's value: ", 2.2, test1.getReal() );
		test2.setReal(-5.2);
		assertEquals("Set test1's value: ", -5.2, test2.getReal() );
	}
	/**
	 * This method tests the setter method of only 
	 * an imaginary number within parameters.
	 */
	public void testSetImaginary() {
		test3.setImaginary(3.5);
		assertEquals("Set test3's value: ", 3.5, test3.getImaginary() );
		test4.setImaginary(-11.4);
		assertEquals("Set test4's value: ", -11.4, test4.getImaginary() );
		test5.setImaginary(2.1);
		assertEquals("Set test5's value: ", 2.1, test5.getImaginary() );
	}
}
