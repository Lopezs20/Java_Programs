/**
 * @author Steven Lopez 
 * Class: CSCI 2540
 * Date: 02/02/2021
 * Program: Complex Numbers Demo
 * Description: This program will print the results of the ComplexNums class 
 * and serve as testing (debug) the ComplexNum class's methods. 
 */
package assg1_lopezs20;

public class ComplexNumDemo {

	
	/** 
	 * Main method used to test the constructors
	 * of ComplexNum class.
	 * Includes testing the following methods:
	 *   get/set method
	 * 		 add method
	 * 	subtract method 
	 * 	multiple method
	 * 	negation method
	 *  toString method 
	 *    equals method
	 */
	public static void main(String[] args) {
		
		System.out.print("------ Real/Imaginary Complex Numbers Testing----------");
		System.out.print("\n------          Coded by Steven Lopez            ------");
		System.out.println("\nThe following methods of caculating complex numbers "
						+ "\nwill use hard coded preset variables as follows:");
		
		/**
		 * Testing and assigning values into the ComplexNum 
		 * constructors objects for calculations.
		 */
		ComplexNum test = new ComplexNum();
		ComplexNum z = new ComplexNum();
		ComplexNum x = new ComplexNum(2,4);
		ComplexNum y = new ComplexNum(5,-7);
		ComplexNum v = new ComplexNum(8.2,2.4);
		ComplexNum c = new ComplexNum(3.9);
		ComplexNum w = new ComplexNum(0,4.5);
		ComplexNum q = new ComplexNum(3.5,-2.1);
		
		//These objects will be compared in equals method
		ComplexNum g = new ComplexNum(2,4);
		ComplexNum f = new ComplexNum(5,-7);
		ComplexNum d = new ComplexNum(3.5,-2.1);
		
		
		/**
		 * Testing the getReal and getImaginary methods to print the numbers.
		 * @method getReal()
		 * @method getImaginary()
		 * This also prints the complex number being used. 
		 */
		System.out.println("\n x is " + x.getReal() + "+" + x.getImaginary() + "i" );
		System.out.println("\n y is " + y.getReal() + y.getImaginary() + "i");
		System.out.println("\n v is " + v.getReal() + "+" + v.getImaginary() + "i");
		System.out.println("\n c is " + c.getReal());
		System.out.println("\n w is " + w.getImaginary() + "i");
		System.out.println("\n q is " + q.getReal() + q.getImaginary() + "i");
		System.out.println();
		
		
		System.out.println("this is real part of x " + x.getReal());
		
		 //Testing all possible outcomes for each methods provided.
		System.out.println("********* Test **********");
		System.out.println();
		
		
		 //Testing @method setReal and @method setImaginary to test object.
		test.setReal(1.1); test.setImaginary(3.1);
		System.out.println("Test object using the setMethods-setReal(1.1)-setImaginary(3.1): " 
		+ test.getReal() +  " + " + test.getImaginary());
		
		
		
		//Testing the Add method 
		System.out.println("\nTest: Addition method");
		z = x.add(y);
		System.out.println("The sum for x + y will be stored in z:");
		System.out.println("z = " + z);
		System.out.println();
	
		z = v.add(q);
		System.out.println("The sum for v + q :");
		System.out.println("z = " + z);
		System.out.println();
		
		z = c.add(y);
		System.out.println("The sum for c + y:");
		System.out.println("z = " + z);
		System.out.println();
		
		z = y.add(w);
		System.out.println("The sum for y + w: " );
		System.out.println("z = " + z);
		
		
		
		
		//Testing the Subtraction Method
		System.out.println("\nTest: Subtraction method ");
		z = x.sub(y);
		System.out.println("The difference for x - y will be stored in z:");
		System.out.println("z = " + z);
		System.out.println();
		
		z = v.sub(q);
		System.out.println("The difference for v - q :");
		System.out.println("z = " + z);
		System.out.println();
		
		z = c.sub(y);
		System.out.println("The difference for y - c :");
		System.out.println("z = " + z);
		System.out.println();
		
		z = w.sub(v);
		System.out.println("The difference for w - v :");
		System.out.println("z = " + z);
		System.out.println();
		
		
		
		//Testing the Multiplication method
		System.out.println("\nTest: Multiplication method ");
		z = x.mul(y);
		System.out.println("The multiply for x * y will be stored in z:");
		System.out.println("z = " + z);
		System.out.println();
		
		z = v.mul(q);
		System.out.println("The multiply for v * q :");
		System.out.println("z = " + z);
		System.out.println();
		
		z = y.mul(c);
		System.out.println("The multiply for y * c :");
		System.out.println("z = " + z ); // to show imaginary part is zero
		System.out.println();
		
		z = w.mul(v);
		System.out.println("The multiply for w * v :");
		System.out.println("z = " + z);
		System.out.println();
		
		
		
		//Testing the Negation method 
		System.out.println("\nTest: Negation method ");
		z = x.neg();
		System.out.println("The negation for x :");
		System.out.println("z = " + z);
		System.out.println();
		
		z = y.neg();
		System.out.println("The negation for y :");
		System.out.println("z = " + z);
		System.out.println();
		
		z = c.neg();
		System.out.println("The negation for c :");
		System.out.println("z = " + z);
		System.out.println();
		
		z = v.neg();
		System.out.println("The negation for v :");
		System.out.println("z = " + z);
		System.out.println();
		
		z = w.neg();
		System.out.println("The negation for w :");
		System.out.println("z = " + z);
		System.out.println();
		
		z = q.neg();
		System.out.println("The negation for q :");
		System.out.println("z = " + z);
		System.out.println();
		
		//Testing the toString method
		System.out.println();
		System.out.println("toString Testing :");
		System.out.println("w is :" );
		System.out.println(w.toString());
		System.out.println("x is :");
		System.out.println(x);
		System.out.println("y is :"); 
		System.out.println(y);	
		System.out.println("c is :");
		System.out.println(c);
		System.out.println();
		
		//Testing the Equals method 
		System.out.println("Testing equals method:");
		if (x.equals(y)) {
			System.out.println(" x and y are equal");
			System.out.println("" + x + " = " + y);
		}
		else
			System.out.println(" x and y are not equal");
		
		if (x.equals(c)) {
			System.out.println(" x and c are equal");
		    System.out.println("" + x + " = " + c);
		}
		else
			System.out.println(" x and c are not equal");
		
		if (g.equals(x)) {
			System.out.println(" x and g are equal");
			System.out.println("" + g + " = " + x);
		}
		else
			System.out.println(" x and g are not equal");
		
		if (y.equals(f)) {
			System.out.println(" y and f are equal");
			System.out.println("" + y + " = " + f);
		}
		else
			System.out.println(" x and g are not equal");
		
		if (q.equals(d)) {
			System.out.println(" q and d are equal");
			System.out.println("" + q + " = " + d);
		}
		else
			System.out.println(" x and g are not equal");
		
		System.out.println("\nGrade:  ");
		System.out.println("Comments: ");
	}

	
}
