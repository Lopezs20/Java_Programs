/**
 * @author Steven Lopez 
 * Class: CSCI 2540
 * Date: 02/02/2021
 * Program: Complex Numbers 
 * Description: This program will calculate complex numbers and store it
 * 	for use in the ComplexNumDemo class. 
 * 
 */

package assg1_lopezs20;
	public class ComplexNum {
		
		//global variables:
		double realNum;
		double imagineNum;
	    double obj;
		
		
		//Constructors:
		
		/**
		 * Default constructor 
		 * initializes both real number and
		 * imaginary number parts.
		 * realNum is the real number part.
		 * imagineNum is the imaginary number part.
		 */
		public ComplexNum() {
			realNum = 0.0;
			imagineNum = 0.0;
		}
		
		
		/** 
		 * Constructor that initializes the real part:
		 * @param givenReal --- the real number initialized
		 * Imaginary number initialized to 0.
		 */
		public ComplexNum(double givenReal) {
			realNum = givenReal;
			imagineNum = 0.0;
		}
		
		
		/**
		 * Constructor that initializes both parts: 
		 * @param givenReal - given real number 
		 * @param givenImagine - given imaginary number
		 */
		public ComplexNum(double givenReal, double givenImagine) {
			realNum = givenReal;
			imagineNum = givenImagine;
		}
		
		//Methods:
		
		/**
		 * Used to retrieve the real part
		 * @return realNum - real number
		 */
		public double getReal() {
			return realNum;
		}
		
		/**
		 * Retrieve the imaginary part
		 * @return imagineNum - imaginary number
		 */
		public double getImaginary() {
			return imagineNum;
		}
		
		/**
		 * Used to set or modify a new real number part
		 * @param newReal - new real number
		 */
		public void setReal(double newReal) {
			realNum = newReal; 
		}
		
		/**
		 * Used to set or modify an imaginary number part
		 * @param newImagine - new imaginary number
		 */
		public void setImaginary(double newImagine) {
			imagineNum = newImagine;
		}
		
		
		/**
		 * Adds the parameter of ComplexNum to current this object
		 * @param obj - object 
		 * @return result - return type 
		 */
		public ComplexNum add(ComplexNum obj) {
			
			return new ComplexNum((obj.realNum + this.realNum), (obj.imagineNum + this.imagineNum));
		}
		
		
		/**
		 * Subtracts the parameter of ComplexNum to current this object
		 * @param obj
		 * @return new ComplexNum object with subtraction calculated.
		 */
		public ComplexNum sub(ComplexNum obj) {
			return new ComplexNum((obj.realNum - this.realNum), (obj.imagineNum - this.imagineNum));
		}
		
		
		/**
		 * Multiplies the parameter of ComplexNum to current this object
		 * @param obj
		 * @return new ComplexNum object with m
		 */
		
		public ComplexNum mul(ComplexNum obj) {
			
			return new ComplexNum(((obj.realNum * this.realNum) - 
			(obj.imagineNum * this.imagineNum)) , 
				((obj.realNum * this.imagineNum) - (obj.imagineNum - this.realNum) ));
		}
		
		/**
		 * Negates the parameter of ComplexNum to current this object
		 * @return negation of realNum and imagineNum
		 */
		
		public ComplexNum neg() {
			return new ComplexNum(-realNum , -imagineNum) ;
		}
		
		/**
		 * Returns the string equivalent of the ComplexNum called.
		 * @Overidden toString method  
		 * @return String of ComplexNum equivalent
		 */
		@Override
		public String toString() { 
			if (realNum == 0.0) {
				return "" + Math.round(imagineNum*100.0)/100.0 + "i" ;
			}
			else if(imagineNum == 0.0) {
				return  "" + Math.round(realNum*100.0)/100.0;
			}
			
			else if (imagineNum  < 0.0 )
			{
			return  Math.round(realNum*100.0)/100.0 + "" + Math.round(imagineNum*100.0)/100.0 + "i";
			
			}
			return "" + Math.round(realNum*100.0)/100.0 + "+" + Math.round(imagineNum*100.0)/100.0 + "i" ;
		}
	
		
		/**
		 * Equals method used to compare ComplexNum for equivalence and
		 * checks if ComplexNum is a valid object.
		 * @return true if equal, false otherwise. 
		 */
		@Override
		public boolean equals(Object passThru) {
			ComplexNum ghost = (ComplexNum) passThru;
			if (passThru instanceof ComplexNum ) {
				if ((ghost.realNum == this.realNum) && (ghost.imagineNum == this.imagineNum)) 
				return true;
				
			}else if (passThru == null) {
				return false;
			}
			return false;
			
		
		}
	}
	
	
