/**
 * @author Steven Lopez 
 * Class: CSCI 2540
 * Date: 02/09/2021
 * Program: Student Account  
 * Description:
 * 	 This program will be used for testing the deposit, charge, and transfer methods
 * 	 from a student's account. Along with the student's account is the reward account 
 *	 that will demonstrate whether the student can be rewarded based on certain
 *	 pre-requisitions.  
 */

package assgn2_lopezs20;

public class StudentAccountDemo {
	
	/** 
	 * Main method used to test the constructors
	 * of StudentAccount and rewardAccount class.
	 * Includes testing the following methods:
	 *       get/set method
	 * 	     deposit method
	 * 	      charge method 
	 *  transferInto method
	 * 	transferOuto method
	 *      toString method 
	 *     printInfo method
	 *     compareTo method
	 *    getRewards method
	 * redeemRewards method
	 * 	  Overridden method(s)
	 */

	public static void main(String[] args) {
		
		System.out.print("------ StudentAccount and rewardAccount Testing----------");
		System.out.print("\n------        Coded by Steven Lopez            ----------");
		System.out.println("\nThe following methods of testing both classes "
						+ "\nwill use preset variables as follows:");
		
		/**
		 * Testing and assigning values into the StudentAccount 
		 * constructors objects for calculations.
		 */
		
		StudentAccount A = new StudentAccount();
		StudentAccount B = new StudentAccount("Barry", 200);
		StudentAccount C = new StudentAccount("Anna", 359.32);
		StudentAccount D = new StudentAccount("Donna", 21.43);
		StudentAccount E = new StudentAccount(800);
		StudentAccount F = new StudentAccount("Darby", 50);
		StudentAccount tesla = new StudentAccount("Elon", 90000);
		StudentAccount test = new StudentAccount();
		StudentAccount l = new StudentAccount(50); 
		
		
		/**
		 * Testing the getAccNum, getAccBal, getCount methods to print 
		 * their following attributes accordingly.
		 * @method getAccNum() -- get account number
		 * @method getBalNum() -- get account balance
		 * @method getCount() -- get counter number 
		 */
		
		System.out.println("\nGet method testing:");
		System.out.println();
		
		System.out.println("Student Account B's number is: " + B.getAccNum());
		
		System.out.println("\nStudent Account C's number is: " + C.getAccNum());
		
		System.out.println("\nStudent Account D's balance is: " + "$" + C.getBalNum());
		
		System.out.println("\nStudent Account E's balance is: " + "$" + E.getBalNum());
		
		System.out.println("\nTotal # of Student Accounts: " + B.getCount());
		
		
		
		
		/**
		 * Testing the set balance method
		 * @method setBal() -- to set a different or new balance
		 */
		System.out.println();
		System.out.println("\nSet Balance method testing:");
		
		test.setBal(15.99);
		System.out.println("Set Account test's balance to : " + "$" + test.getBalNum());
		
		test.setBal(0.01);
		System.out.println("Set new balance to : "  + "$" + test.getBalNum());
		
		A.setBal(480);
		System.out.println("Set account A's balance to : " + "$" + A.getBalNum());
		
		
		/**
		 * Testing deposit method using getBalNum to print 
		 * @method stDeposit() -- method for depositing into balance
		 * 
		 */
		System.out.println("\nTest: Deposit method");
		C.stDeposit(100);
		
		System.out.println("Account C deposited a full amount of: $100");
		
		System.out.println("Account C new balance: " + "$" + C.getBalNum());
		
		B.stDeposit(39.3);
		
		System.out.println("Account B deposited a full amount of: $39.30");
		
		System.out.println("Account B new balance: " + "$" + B.getBalNum());
		
		D.stDeposit(63);
		
		System.out.println("Account D deposited a full amount of $63.");
		
		System.out.println("Account D new balance: " + "$" + D.getBalNum());
		
		
		
		
		
		/**
		 * Testing the charge method using getBalNum to print
		 * @method stCharge -- method for charging balances 
		 */
		System.out.println();
		
		System.out.println("\nTest: Charge method");
		
		C.stCharge(90);
		System.out.println("Account C was charged $90. New balance is: " + 
							"$" + C.getBalNum());
		F.stCharge(78.93);
		System.out.println("Account F was charged $78.93. New balance is: " +
							"$" + F.getBalNum());
		D.stCharge(31.02);
		System.out.println("Account D was charged $31.02. New balance is: " 
							+ "$" + D.getBalNum());
		
		
		
		/**
		 * Testing the transferInto method, will display error message 
		 * if there is insufficient funds to transfer. 
		 * @method transferInto() -- allows transferring money from 
		 * another StudentAccount.
		 */
		
		System.out.println("\nTest: transferInto Method:");
		B.transferInto(C, 25);
		
		System.out.println(B.getName() + " lent " + C.getName() +  " $25." + 
				" \n" + C.getName()+ " Balance: " + "$" + C.getBalNum());
		
		System.out.println(B.getName() + " new balance: " + "$" + B.getBalNum());
		
		System.out.println();
		
		F.transferInto(A, 17.40); // will display error message due to insufficiency
		System.out.println("Darby of Account C could not lend Account A $17.40.");
		
		System.out.println();
		
		B.transferInto(D, 39.30);
		System.out.println(B.getName() + " lent "+ D.getName() + " $39.30.");
		
		System.out.println(D.getName() + " Balance: "+ "$"+ D.getBalNum());
		
		System.out.println(B.getName() + " new balance: "+ "$"+ B.getBalNum());
		
		
		
		/**
		 * Testing the transferInto method, will display error message 
		 * if there is insufficient funds to transfer. 
		 * @method transferOutto() -- allows transferring money from 
		 * another StudentAccount.
		 */
		System.out.println("\nTest: Transfer Out-to method");
		B.transferOutto(D, 45);
		
		System.out.println(B.getName()+ " transfered money to "+D.getName());
		
		System.out.println(D.getName()  +" Balance: "+ "$"+ D.getBalNum());
		
		C.transferOutto(tesla, 1000);
		System.out.println(tesla.getName() + " transfered money to "+ C.getName());
		
		System.out.println(C.getName() + " Balance: "+ "$" + C.getBalNum());
		
		System.out.println(tesla.getName() + " Balance: "+ "$"+ tesla.getBalNum());
		
		System.out.println();
		
		
		//Testing the printInfo method for printing account information.
		System.out.println();
		
		System.out.println("Test: PrintInfo method");
		tesla.printInfo();
		B.printInfo();
		C.printInfo();
		
		//Testing toString method for converting account info into String obj.
		System.out.println();
		
		System.out.println("Test: toString method");
		System.out.println(D.toString());
		System.out.println(B);
		System.out.println(F);
		F.setBal(50);
		
		//Testing the compareTo method @compareTo -- Comparison.
		System.out.println();
		System.out.println("Test: compareTo method ");
		
		System.out.println("F compared to B gives out: "+ F.compareTo(B));
		
		System.out.println("C compared to D gives out: " + C.compareTo(D) );
		
		System.out.println("L compared to F gives out: " + l.compareTo(F));
		
		
		//Initializing rewardAccount objects of studentAccount 
		RewardsAccount b = new RewardsAccount("Billy", 120.00);
		RewardsAccount c = new RewardsAccount("James", 241.59);
		RewardsAccount e = new RewardsAccount("Duke", 51.90);
		RewardsAccount f = new RewardsAccount("Chang", 30.51);
		
		//Testing the getRewards methods 
		System.out.println("\n****** Rewards Class *******");
		System.out.println("Test: get Reward-Methods: ");
		System.out.println("Check to see Account b's reward balance: " +"$"+ b.getReward());
		
		System.out.println("Check to see Account c's reward balance: " +"$"+ c.getReward());
		
		System.out.println("Check to see Account e's reward balance: " +"$"+ e.getReward());
		
		
		
		//Testing the redeemRewards method
		System.out.println("\nTest: redeemReward method: ");
		System.out.println("Account f's redemption results:  " +"$"+ f.RedeemRewards());
		
		System.out.println("Account b's redemption results:  " +"$"+ b.RedeemRewards());
		
		c.setReward(45);  // set c's reward up to 50.
		System.out.println("\nAccount c's before balance: " + c.getBalNum());	
		
		System.out.println("Account c's redemption results:  " + c.RedeemRewards()); // redeem c's reward.
		
		System.out.println("\nAccount c's before balance: " + c.getBalNum());
		
		//Testing toString from RewardsAccount method
		System.out.println("\nTest: toString Rewards account: ");
		
		f.setReward(5.0);
		e.setReward(20);
		System.out.println(f.toString());
		System.out.println(e);
		System.out.println(c);
		
		
		//Testing rewards deposit method
		System.out.println();
		System.out.println("\nTest: Deposit override method" );
		
		f.deposit(100);
		System.out.println("Account f's deposit results:  " +"$"+ f.getReward());
		
		e.deposit(100);
		System.out.println("Account e's deposit results:  " +"$"+ e.getReward());
		
		b.deposit(50);
		System.out.println("Account b's deposit results:  " +"$"+ b.getReward());
		
		
		//Testing printInfo override method from Rewards Account
		System.out.println("");
		System.out.println("\nTest: printInfo override");
		f.printInfo();
		e.printInfo();
		
		System.out.println();
	}

}
