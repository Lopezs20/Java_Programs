/**
 * @author Steven Lopez 
 * Class: CSCI 2540
 * Date: 02/09/2021
 * Program: Student Account  
 * Description:
 * 	 This program will be used for deposit, charge, and transfer money 
 * 	 from a student's account. Along with the student's account is the reward account 
 *	 that will demonstrate whether the student can be rewarded based on certain
 *	 pre-requisitions.  
 */

package assgn2_lopezs20;

public class StudentAccount implements Comparable<StudentAccount> {
	
	
	// Variables for Student
	private String stName;  // Student's name
	private long accNum;  // Account number
	private double stBalance; // Student's balance
	
	
	//Function Variables
	private static long stCount = 0; //Student counter
	
	/**
	 * Default constructor consisting of Student's info
	 */
	public StudentAccount() {
		stName = "null";
		stBalance = 0;
		stCount++;
		accNum = stCount;
	}
	
	
	/**
	 * New constructor consisting of Student's info
	 * @param givenName -- name
	 * @param givenBalance -- money balance 
	 */
	public StudentAccount(String givenName, double givenBalance) {
		
		stName = givenName;
		stBalance = givenBalance;
		stCount++;
		accNum = stCount;
		
	}
	
	
	/**
	 * Single double type parameter for new Student Account 
	 * Constructor. 
	 * @param balance -- money balance
	 */
	public StudentAccount(double balance) {
		stBalance = balance;
		stCount++;
		accNum = stCount;

	}
	
	
	/** 
	 * Get method for getting string name
	 * @return stName -- name
	 */
	public String getName() {
		return stName;
	}
	
	/** 
	 * Get method for getting account number
	 * @return accNum -- account number
	 */
	public long getAccNum() {
		return accNum;
	}
	
	
	/** 
	 * Get method for getting balance
	 * @return stBalance -- balance
	 */
	public double getBalNum(){
		return Math.round(stBalance*100.0)/100.0;
	}
	
	
	/** 
	 * Get method for getting counter
	 * @return stCount -- counter
	 */
	public long getCount() {
		return stCount;
	}
	
	
	//Set method for getting new balance
	public void setBal(double newBal) {
		stBalance = newBal;
	}
	
	
	/**
	 * Student Account object Deposit method for depositing
	 * given money to said account.
	 * @param cashAmount
	 * @return new StudentAccount(stBalance)
	 */
	public StudentAccount stDeposit(double cashAmount) {
		
		if (cashAmount <= 0.0) {
			System.out.println("The amount you placed is invalid.");
		}else 
		stBalance += cashAmount;
		return new StudentAccount(stBalance);
	}
	
	/**
	 * Debt method for caculating debt on account
	 * @param debt
	 * @return balance minus debt
	 */
	public double stCharge(double debt) {
		
		if (debt <= 0.0) {
			System.out.println("The debt placed is invalid amount.");
		}
				
		return stBalance -= debt;
		
	}
	
	/**
	 * Transfer Into method to transfer certain amount of money 
	 * into another account.
	 * @param student
	 * @param lend
	 * @return new student object with new balance
	 */
	public StudentAccount transferInto(StudentAccount student, double lend) {
		
		if(lend <= 0.0) {
			System.out.println("Cannot transfer invalid amount of funds");
		}
		else if (student instanceof StudentAccount){
			
			if ( student.stBalance < lend) {
				System.out.println(this.stName + " cannot lend the amount, insufficient funds");
			}
			else
				this.stBalance -= lend;	student.stBalance += lend; 
		}
		return new StudentAccount(stName, stBalance) ;
	}
	
	/**
	 * Transfer Out-to method
	 * To transfer money out from current account into someone else's
	 * @param student
	 * @param take
	 * @return new student object with new balance
	 */
	public StudentAccount transferOutto(StudentAccount student, double take) {
		
		if (take <= 0.0) {
			System.out.println("Cannot transfer invalid amount requested.");
		} 
		else if (student instanceof StudentAccount){
			   if (student.stBalance < take) {
				System.out.println(this.stName + " cannot transfer the amount, insufficient funds");
			}
			else
			student.stBalance -= take; this.stBalance += take;
		}
		return new StudentAccount(stName, stBalance);
	}
	
	/**
	 * String printing info method
	 * to print Account number and current balance.
	 * @return string with account info
	 */
	
	public void printInfo() {
		System.out.println("\nAccount number: " + getAccNum() + 
				"\nCurrent balance: "+ "$"+ getBalNum()); 
		
	}
	
	/**
	 * Returns a string with information from StudentAccount
	 * @return The string with Account number and Balance
	 */
	public String toString() {
		return "Account number: " + getAccNum() + "\nCurrent balance: "+ "$"+ getBalNum();
	}
	
	// compare to method that compares both account sides.
	public int compareTo(StudentAccount side) {
		
		if (this.stBalance > side.stBalance ) {
			return 1;
		} else if (side.stBalance == this.stBalance) {
			return 0;
		}
		return -1;
		
	}
	
	

}
