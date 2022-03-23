/**
 * @author Steven Lopez 
 * Class: CSCI 2540
 * Date: 02/09/2021
 * Program: Student Account  
 * Description:
 * 	 This program will be used for determining whether the parent class 
 *   (Student Account) is eligible for rewards. 
 *   
 */

package assgn2_lopezs20;

public class RewardsAccount extends StudentAccount {

	public double rewardVal;
	
	/**
	 * A default constructor
	 */
	public RewardsAccount() {
		super();  // call the default constructor of Student class
		rewardVal = 0;
	}
	
	/**
	 * Constructor with name, balance, and how much reward was earned.
	 * @param givenName -- current name
	 * @param givenBalance -- current balance
	 * @param rewardsEarned -- rewards earned
	 */
	public RewardsAccount(String givenName, double givenBalance) {
		super(givenName,givenBalance);  // call the parameter constructor of StudentAccount class
		if(givenBalance >= 100) {
				rewardVal += 5.0;
		}
		
	}
	
	/**
	 * Get reward constructor for doing just that
	 * @return rewardVal -- value of current reward
	 */
	public double getReward() {
		return rewardVal;
		
	}
	/**
	 * Setting the reward constructor to do just that
	 * @return reward value stored into given reward
	 */
	public double setReward(double givenReward) {
		return rewardVal = givenReward;
	}
	
	/**
	 * Redeem rewards value which redeems the given account's reward.
	 * @return the balance rounded 2 decimal places.
	 * @return 0 otherwise.
	 */
	public double RedeemRewards() {
		double myBalance = super.getBalNum();
		
		if (rewardVal >= 25.00) {
			myBalance += rewardVal ; 
			rewardVal = 0;  // to reset the reward value after returning the rewards stored in temp.
			
			return myBalance;
			
		} else if( rewardVal < 25.00 ) {
			System.out.println("Cannot return reward, insufficient funds.");
		}
		return 0;
			
	
	}
	
	
	/**
	 * Overridden method of toString from StudentAccount class 
	 * @Override method 
	 * @return modified string object of Student Account string.
	 */
	@Override
	public String toString() {
		return "Account number: " + getAccNum() + "\nCurrent balance: "+"$"+ getBalNum() 
					+ "\nReward balance: " + "$"+ getReward();
	}
	
	
	
	/**
	 * Same as Student Account class's deposit but with reward system
	 * in placed. (above $100 will reward $5 to reward variable)
	 * @param cashAmount
	 * @return the balance with reward and cashAmount.
	 */
	public double deposit(double cashAmount) {
		double myBalance; 
		myBalance = super.getBalNum();
		
		if (cashAmount <= 0.0) {
			System.out.println("The amount you placed is invalid.");
		}else if (cashAmount >= 100) {
		myBalance += 5.0;
		}else {
			return myBalance += cashAmount;
		}
		return myBalance;
	}
	
	
	/**
	 * Overridden printInfo method from the Student Account class. 
	 * @Override method
	 * @return additional print statement of Reward balance.
	 */
	@Override
	public void printInfo() {
		super.printInfo();
			System.out.println("Reward balance: "
					+ "$"+ getReward());
	
	}
	
	
	
	
	
	
}
