/**
 * @author Steven Lopez 
 * Class: CSCI 2540
 * Date Due: 04/15/2021
 * Program: Customer Class  
 * Description:
 * 	This class will implement the structure of the Object Customer.
 * 	Customer would have an ID, phone number, and name from the text file. 
 */
package assg8_lopezs20;

public class Customer extends KeyedItem<String> {
	
	/**
	 * Private Instance variables
	 */
	private String id, phoneNumber, name;
	
	// Default constructor
	public Customer(){
		super("");
		name = "";
		phoneNumber = "";
	}
	
	/**
	 * Customer constructor for all methods and binary tree instances.
	 * All information from customer text file.
	 * @param theID
	 * @param theName
	 * @param thePhone
	 */
	public Customer(String theID, String theName, String thePhone) {
		super(theID);
		id = theID;
		name = theName;
		phoneNumber = thePhone;
	}
	
	/**
	 * Getter for Customer's name
	 * @return name
	 */
	public String getNameOfCustomer() {
		return name;
	}
	/**
	 * Getter for Customer's phone
	 * @return phoneNumber
	 */
	public String getPhone() {
		return phoneNumber;
	}
	/**
	 * Getter for Customer's Id
	 * @return id
	 */
	public String getId() {
		return id;
	}
	/**
	 * toString method for Customers
	 */
	
	public String toString() {
		return (  "\nName: "
				+ getNameOfCustomer() 
				+ "\nPhone: " 
				+ getPhone());
	}
	
	/**
	 * Method for formating info into text file.
	 * (Saving purposes)
	 * @return String format
	 */
	public String writeInfo() {
		return (getId() + "\t" 
				+ getNameOfCustomer() + "\t"
				+ getPhone() + "\n");
	}
	
	/**
	 * Setter for Customer's name
	 * @param setter
	 */
	public void setName(String setter) {
		name = setter;
	}
	/**
	 * Setter for Customer's phone number
	 * @param setter
	 */
	public void setPhone(String setter) {
		phoneNumber = setter;
	}
}

